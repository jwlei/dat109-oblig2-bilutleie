package Objekt;

/* 
 * Klasse for kredittkort
 * @param kortNummer
 *  */

public class Kredittkort {
    private long kortNummer;

    public Kredittkort(long nummer) {
        this.kortNummer = nummer;
    }

    public long getKortNummer() {
        return kortNummer;
    }

    public void setKortNummer(long kortNummer) {
        this.kortNummer = kortNummer;

    }

    /* 
     * Metode for å validere korrekt kortnummer.
     * @return boolean
     *  */
    public boolean validerKort() {
        boolean erLovlig = false;

        if (String.valueOf(kortNummer).length() == 5) {
            erLovlig = true;
        }

        return erLovlig;
    }
}
