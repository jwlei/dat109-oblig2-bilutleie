package Objekt;
/*
klasse for å definere en bil
 */
public class Bil {
    private String regNr;
    private String bilMerke;
    private String modell;
    private String farge;
    private UtleieGruppeEnum utleiegruppe;
    private boolean ledig;
    private int kmStand;

    public Bil(String regNr, String bilMerke, String modell, String farge, UtleieGruppeEnum utleiegruppe) {
        this.regNr = regNr;
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.utleiegruppe = utleiegruppe;
        this.ledig = true;

        // for å teste slik at vi slipper å gjøre mange endringer før det virker
        this.kmStand = 0;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getBilMerke() {
        return bilMerke;
    }

    public void setBilMerke(String bilMerke) {
        this.bilMerke = bilMerke;
    }

    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }

    public String getmodell(String modell) {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public UtleieGruppeEnum getUtleiegruppe() {
        return utleiegruppe;
    }

    public void setUtleiegruppe(UtleieGruppeEnum utleiegruppe) {
        this.utleiegruppe = utleiegruppe;
    }

    public Boolean getLedig() {
        return ledig;
    }

    public void setLedig(Boolean ledig) {
        this.ledig = ledig;
    }

    @Override
    public String toString() {
        return "Bil [regNr = " + regNr + ", bilMerke = " + bilMerke + ", modell = " + modell + ", farge = " + farge +
                ", utleiegruppe = " + utleiegruppe + ", ledig = " + ledig + "]";
    }


}
