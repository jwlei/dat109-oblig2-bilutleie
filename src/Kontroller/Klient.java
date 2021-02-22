package Kontroller;

import java.util.Scanner;

import Objekt.Adresse;
import Objekt.BilParkering;
import Objekt.Kontor;
import Objekt.Selskap;

/* 
 * Main klassen for klient hvor vi starter interfacet.
 *  */

public class Klient {

    private static Selskap KardiCar = new Selskap("KardiCar", new Adresse("Kardemommeveien 1", 1337, "Kardemommeby"), "94959697");
    private static Kontor Gardermoen = new Kontor("Gardermoen", new Adresse("Flyplassveien 1", 4123, "Oslo"), KardiCar);
    private static Kontor Oslo = new Kontor("Oslo", new Adresse("Osloveien 44", 6353, "Oslo"), KardiCar);

    public static void main(String[] args) {
        Gardermoen.setBiler(BilParkering.leggTilBiler1());
        Oslo.setBiler(BilParkering.leggTilBiler2());

        KardiCar.leggTilKontor(Gardermoen);
        KardiCar.leggTilKontor(Oslo);

        valgMeny();

    }
    //Hovedmeny for interface.
    public static void valgMeny() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Velkommen til KardiCar. \nMeny: ");
        System.out.println("1. Reservasjon");
        System.out.println("2. Utlevering av bil");
        System.out.println("3. Innlevering av bil");
        System.out.println("4. Avslutt");
        System.out.println("\nSkriv inn tallet for ønsket valg:\n");

        int valg = sc.nextInt();

        switch (valg) {
            case 1:
                ReserverBil.reserverBil(KardiCar);
                break;
            case 2:
                UtleieBil.leiUt(KardiCar);
                break;
            case 3:
                InnleveringAvBil.LeverInn(KardiCar);
                break;
            case 4:
                System.out.println("\nProgrammet er avsluttet.");
            default:
                System.out.println("Noe gikk galt.");
                Klient.valgMeny();
        }
        
    }

}
