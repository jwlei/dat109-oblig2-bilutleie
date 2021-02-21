package Objekt;

import java.time.LocalDate;

public class Retur {

    private Kredittkort kredittkort;
    private LocalDate returDato;
    private String regNr;
    private int kmStand;

    public Retur(Kredittkort kredittkort, LocalDate returDato, String regNr, int kmStand) {
        super();
        this.kredittkort = kredittkort;
        this.returDato = returDato;
        this.regNr = regNr;
        this.kmStand = kmStand;
    }

}
