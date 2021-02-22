package Objekt;

/* 
 * Klasse og metode for kunde
 * @param fornavn
 * @param etternavn
 * @param tlfNr
 * @param adresse
 * @param kredittkort
 *  */

public class Kunde {

    private String fornavn;
    private String etternavn;
    private int tlfNr;
    private Adresse adresse;
    private Kredittkort kredittKort;

    public Kunde(String fornavn, String etternavn, int tlfNr, Adresse adresse) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this. tlfNr = tlfNr;
        this.adresse = adresse;
        this.kredittKort = null;

    }

    public Kredittkort getKredittKort() {
        return kredittKort;
    }

    public void setKredittKort(Kredittkort kredittKort) {
        this.kredittKort = kredittKort;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtterNavn(String etternavn)  {
        this.etternavn = etternavn;
    }

    public int getTlfNr() {
        return tlfNr;
    }
    public  Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

}
