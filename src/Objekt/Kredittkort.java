package Objekt;

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

    public boolean validerKort() {
        boolean ok = false;

        if (String.valueOf(kortNummer).length() == 5) {
            ok = true;
        }

        return ok;
    }
}
