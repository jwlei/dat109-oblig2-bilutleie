package Kontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import Objekt.Bil;
import Objekt.Kredittkort;
import Objekt.Kunde;
import Objekt.Reservasjon;
import Objekt.Selskap;
import Objekt.Utlevering;


/*
Klasse som definerer utleie av bil
 */

public class UtleieBil {
    /*
    Metode for å leie ut bil
     */

    public static void leiUt(Selskap selskap) {
        Scanner sc = new Scanner(System.in);

        LocalDate currDate = LocalDate.now();

        System.out.println("Skriv inn telefon nummer: ");
        int telefonNummer = sc.nextInt();

        List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();

        Reservasjon res = alleReservasjoner.stream()
                .filter(r -> telefonNummer == r.getKunde().getTlfNr())
                .findAny()
                .orElse(null);

        if(res == null) {
            System.out.println("Finnes ikke en reservasjon med dette nummeret");
            sc.close();
            return;
        }

        Kunde kunde = res.getKunde();

        System.out.println("Skriv inn kredittkort nummer (5 siffer): ");
        long kortNummer = sc.nextLong();

        Kredittkort kort = new Kredittkort(kortNummer);
        Boolean gyldigKort = kort.validerKort();

        while (!gyldigKort) {
            System.out.println("Kortnummeret ikke gyldig, må ha en lengde på 5 siffer. prøv igjen: ");
            int nyttKortNummer = sc.nextInt();

            kort.setKortNummer(nyttKortNummer);
            gyldigKort = kort.validerKort();

        }

        kunde.setKredittKort(kort);
        String regNr = res.getBil().getRegNr();
        int kmStand = res.getBil().getKmStand();

        Utlevering utlevering = new Utlevering(kunde.getKredittKort(), regNr, kmStand, currDate, res.getStartDato().plusDays(res.getAntallDager()));
        selskap.leggTilUtlevertBil(utlevering);
        System.out.println();
        System.out.println("Kjør forsiktig!");
        Klient.valgMeny();

        Klient.valgMeny();

    }
}
