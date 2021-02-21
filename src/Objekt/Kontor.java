package Objekt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *  klasse for å definere kontor
 */
public class Kontor {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String navn;
    private Adresse adresse;
    private Selskap selskap;
    private List<Bil> biler;

    public Kontor(String navn, Adresse adresse, Selskap selskap) {
        super();
        this.id = count.incrementAndGet();
        this.navn = navn;
        this.adresse = adresse;
        this.selskap = selskap;
        this.biler = new ArrayList<Bil>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    /*
    metode for å lage en reservasjon
     */


    public Reservasjon lagreservasjon(Bil bil, LocalDate startDato, LocalTime startTid, int antDager, Kontor utleieKontor, Kontor returKontor, Kunde kunde) {
        Reservasjon res = new Reservasjon(bil, startDato, startTid, antDager, utleieKontor, returKontor, kunde);

        return res;
    }

    /**
     * Metode for å lagre en reservasjon
     */

    public void lagreReservasjon(Reservasjon res) {
        selskap.leggTilReservasjon(res);
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setSelskap(Selskap selskap) {
        this.selskap = selskap;
    }

    public void leggTilBil(Bil bil) {
        biler.add(bil);
    }

    public void setBiler(List<Bil> biler) {
        this.biler = biler;
    }

    public List<Bil> getBiler() {
        return biler;
    }
    @Override
    public String toString() {
    	return this.navn;
    }
    
}
