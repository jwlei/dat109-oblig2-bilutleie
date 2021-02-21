package Kontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import Objekt.Bil;
import Objekt.Kontor;
import Objekt.Retur;
import Objekt.Selskap;
import Objekt.Kredittkort;
import Objekt.Reservasjon;

/*
Klasse som definerer innlevering av bil
 */

public class InnleveringAvBil {

    /*
    metode for å levere inn en bil
    * @param Bil
     */

    public static void LeverInn(Selskap selskap) {
        //dato for innlevering
        LocalDate currDate = LocalDate.now();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = sc.nextInt();

        List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();

        Reservasjon res = alleReservasjoner.stream()
                .filter(r -> telefonnummer == r.getKunde().getTlfNr()).findAny().orElse(null);

        if(res == null) {
            System.out.println("Finnes ikke en reservasjon med dette nummeret");
            sc.close();
            return;
        }

        //kmstand på bilen ved innlevering
        System.out.println("Hvor mange km viser km-telleren på bilen? ");
        int kmStand = sc.nextInt();

        //Setter ny kmStand på bil og setter bil som ledig
        Bil bil = res.getBil();
        bil.setKmStand(kmStand);
        bil.setLedig(true);

        //Henter returkontor og legger til bil i deres billiste
        Kontor returKontor = res.getReturSted();
        returKontor.leggTilBil(bil);

        System.out.println("Regningen er nå sendt");
        Kredittkort kort = res.getKunde().getKredittKort();

        alleReservasjoner.remove(res);

        Retur retur = new Retur(kort, currDate, bil.getRegNr(), kmStand);
        List<Retur> returListe = selskap.getReturnerteBiler();
        returListe.add(retur);

        Klient.valgMeny();

        System.out.println("Bilen er innlevert");
        System.out.println();
        Klient.valgMeny();
    }

}
