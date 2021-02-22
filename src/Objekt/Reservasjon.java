package Objekt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

import Kontroller.Klient;

/*
Klasse som definerer reservasjon
 */

public class Reservasjon {

    private Bil bil;
    private LocalDate startDato;
    private LocalDate sluttDato;
    private LocalTime startTid;
    private int antallDager;
    private Kontor utleieSted;
    private Kontor returSted;
    private Kunde kunde;
    private int pris;
    private int gebyr = 29;
    
    private static final int prisLitenBil = 100;
   	private static final int prisMellomStorBil = 200;
   	private static final int prisStorBil = 300;
   	private static final int prisStasjonsvogn = 400;


    public Reservasjon(Bil bil, LocalDate startDato, LocalTime startTid, int antallDager, Kontor utleiested, Kontor returSted, Kunde kunde) {
        super();
        this.bil = bil;
        this.startDato = startDato;
        this.startTid = startTid;
        this.antallDager = antallDager;
        this.utleieSted = utleiested;
        this.returSted = returSted;
        this.kunde = kunde;
        

        reserver(bil);
    }

   
    /*
    Setter bil som opptatt.
    @return - boolean
     */

    public void reserver(Bil bil) {
       
        LocalDate dagsDato = LocalDate.now();
        LocalDate sluttDato = startDato.plusDays(antallDager);

        if (dagsDato.isBefore(sluttDato)) {
            bil.setLedig(false);
        }
    }
    
    /* 
     *  Get og setters for Reservasjon
     *  */
    
    public int getGebyr() {
    	return gebyr;
    }
    
    public Bil getBil() {
        return bil;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public int getAntallDager() {
        return antallDager;
    }

    public Kontor getUtleiested() {
        return utleieSted;
    }

    public Kontor getReturSted() {
        return returSted;
    }

    public Kunde getKunde() {
        return kunde;
    }
    
    public int getPris() {
    	return pris;
    }

    public void setPris() {
    	this.pris = pris;
    }
    
    /**
	 * Regner ut leiepris for bil.
	 * @return - pris
	 */
    
    public int prisForLeie() {
 		int pris = 0;
 		int dager = antallDager;
 		UtleieGruppeEnum ug = bil.getUtleiegruppe();
 	
 		if (ug.equals(UtleieGruppeEnum.LITEN_BIL)) {
 		  pris = (int) dager * prisLitenBil;
 		  return pris;
 		} else if (ug.equals(UtleieGruppeEnum.MELLOMSTOR_BIL)) {
 		  pris = (int) dager * prisMellomStorBil;
 		  return pris;
 		} else if (ug.equals(UtleieGruppeEnum.STOR_BIL)) {
 		  pris = (int) dager * prisStorBil;
 		  return pris;
 		} else {
 		  pris = (int) dager * prisStasjonsvogn;
 		  return pris;
 		}
    }
}
