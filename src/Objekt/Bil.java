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
    
   
    
	

    public Bil(String regNr, String bilMerke, String modell, int kmStand, String farge, UtleieGruppeEnum utleiegruppe, boolean ledig) {
    	this.regNr = regNr;
        this.bilMerke = bilMerke;
        this.modell = modell;
        this.farge = farge;
        this.utleiegruppe = utleiegruppe;
        this.ledig = ledig;
        this.kmStand = kmStand;

        
    }
    
    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
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
    
    public String erLedig() {
    	if(getLedig()) {
    		return "Ledig";
    	} else {
    		return "Opptatt";
    	}
    } 
    
    
 
    
    

    @Override
    public String toString() {
        return  "Registreringsnummer: " + regNr + ", Merke: " + bilMerke + ", Modell: " + modell + ", KMStand: " + kmStand +  ", Farge: " + farge +
                ", utleiegruppe: " + utleiegruppe + ", Tilgjengelighet: " + erLedig();
    }


}
