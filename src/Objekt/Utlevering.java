package Objekt;

import java.time.LocalDate;

public class Utlevering {

    private Kredittkort kredittkort;
    private String regNr;
    private int kmStand;
    private LocalDate utleieDato;
    private LocalDate returDato;


    public Utlevering(Kredittkort kredittkort, String regNr, int kmStand, LocalDate utleieDato, LocalDate returDato) {
        super();
        this.kredittkort = kredittkort;
        this.regNr = regNr;
        this.kmStand = kmStand;
        this.utleieDato = utleieDato;
        this.returDato = returDato;
    }

    public Kredittkort getKredittkort() {
        return kredittkort;
    }
}
