package Objekt;

import java.time.LocalDate;
import java.time.LocalTime;

/*
klasse for å definere reservasjon
 */

public class Reservasjon {

    private Bil bil;
    private LocalDate startDato;
    private LocalTime startTid;
    private int antallDager;
    private Kontor utleieSted;
    private Kontor returSted;
    private Kunde kunde;


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


}
