package Objekt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

/*
klasse for å definere reservasjon
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
        this. returSted = returSted;
        this.kunde = kunde;

        reserver(bil);
    }

    public Reservasjon() {
        // TODO Auto-generate constructor stub
    }
    /*
    metode for å sett en bil som reservert
     */

    public void reserver(Bil bil) {
        LocalDate currDate = LocalDate.now();
        LocalDate sluttDato = startDato.plusDays(antallDager);

        while (currDate.isAfter(startDato) && currDate.isBefore(sluttDato)) {
            bil.setLedig(false);
        }
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

    /**
	 * Finner leiepris for en bil.
	 * @return - pris
	 */
	public int prisForLeie() {
		int pris = 0;
		long antallDager = startTid.until(sluttDato, ChronoUnit.DAYS) + 1;
		UtleieGruppeEnum ug = bil.getUtleiegruppe();
	
		if (ug.equals(UtleieGruppeEnum.LITEN_BIL)) {
		  pris = (int) antallDager * prisLitenBil;
		  return pris;
		} else if (ug.equals(UtleieGruppeEnum.MELLOMSTOR_BIL)) {
		  pris = (int) antallDager * prisMellomStorBil;
		  return pris;
		} else if (ug.equals(UtleieGruppeEnum.STOR_BIL)) {
		  pris = (int) antallDager * prisStorBil;
		  return pris;
		} else {
		  pris = (int) antallDager * prisStasjonsvogn;
		  return pris;
		}
	 
	  }

}
