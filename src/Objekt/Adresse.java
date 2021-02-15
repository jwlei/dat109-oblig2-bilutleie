package Objekt;
/*
    klasse for adresse
 */
public class Adresse {

    private String gateAdresse;
    private int postNr;
    private String postSted;

    public Adresse(String gateAdresse, int postNr, String postSted) {
        super();
        this.gateAdresse = gateAdresse;
        this.postNr = postNr;
        this.postSted = postSted;
    }

    public String getGateAdresse() {
        return gateAdresse;
    }
    public int getPostNr() {
        return postNr;
    }
    public String getpoststed() {
        return postSted;
    }
}
