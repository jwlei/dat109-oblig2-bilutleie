package Kontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Objekt.Kredittkort;
import Objekt.Kunde;
import Objekt.Reservasjon;
import Objekt.Selskap;
import Objekt.Utlevering;


/* 
 * Klasse for prosess og interface ved utleie av bil */

public class UtleieBil {
    public static void leiUt(Selskap selskap) {
        Scanner sc = new Scanner(System.in);
        LocalDate dagsDato = LocalDate.now();
        
        //Telefon
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
        
        //Kredittkort
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

        Utlevering utlevering = new Utlevering(kunde.getKredittKort(), regNr, kmStand, dagsDato, res.getStartDato().plusDays(res.getAntallDager()));
        selskap.leggTilUtlevertBil(utlevering);
       
        //Utleie gjennomført og kunde får bil.
        System.out.println("Kjør forsiktig!\n");
        
        Klient.valgMeny();
        Klient.valgMeny();

    }
}
