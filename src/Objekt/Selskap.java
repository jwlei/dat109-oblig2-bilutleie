package Objekt;

import java.util.ArrayList;
import java.util.List;

/*
klasse for å definere selskap
 */

public class Selskap {
    private String navn;
    private Adresse firmaAdr;
    private String tlfNr;
    private List<Reservasjon> reservasjoner;
    private List<Kontor> kontorer;
    private List<Utlevering> utleverteBiler;
    private List<Retur> returnerteBiler;

    public Selskap(String navn, Adresse firmaAdr, String tlfNr) {
        this.navn = navn;
        this.firmaAdr = firmaAdr;
        this.tlfNr = tlfNr;
        this.reservasjoner = new ArrayList<Reservasjon>();
        this.kontorer = new ArrayList<Kontor>();
        this.utleverteBiler = new ArrayList<Utlevering>();
        this.returnerteBiler = new ArrayList<Retur>();

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Adresse getFirmaAdr() {
        return firmaAdr;
    }

    public void setFirmaAdr(Adresse firmaAdr) {
        this.firmaAdr = firmaAdr;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public List<Reservasjon> getReservasjoner() {
        return this.reservasjoner;
    }

    /*
    metode for å legge til en reservasjon
     */


    public void leggTilReservasjon(Reservasjon res) {
        reservasjoner.add(res);
    }

    public List<Kontor> getKontorer() {
        return this.kontorer;
    }

    public void leggTilUtlevertBil(Utlevering utlevering) {
        utleverteBiler.add(utlevering);
    }
    public void leggTilKontor(Kontor kontor) {
        kontorer.add(kontor);
    }

    public void leggTilReturnertBil(Retur retur) {
        returnerteBiler.add(retur);
    }

    public List<Utlevering> getUtleverteBiler() {
        return utleverteBiler;
    }

    public List<Retur> getReturnerteBiler() {
        return returnerteBiler;
    }

}
