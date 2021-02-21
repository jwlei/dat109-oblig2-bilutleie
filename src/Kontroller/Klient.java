package Kontroller;

import java.util.Scanner;

import Objekt.Adresse;
import Objekt.BilParkering;
import Objekt.Kontor;
import Objekt.Selskap;

public class Klient {

    private static Selskap KardiCar = new Selskap("KardiCar", new Adresse("Kardemommeveien 1", 1337, "Kardemommeby"), "42069420");
    private static Kontor Mumidalen = new Kontor("Mumidalen", new Adresse("Mumidalen 3", 4123, "Mumien"), KardiCar);
    private static Kontor LadaStreet = new Kontor("LadaStreet", new Adresse("LadaStreet 44", 6353, "Ladaen"), KardiCar);

    public static void main(String[] args) {
        Mumidalen.setBiler(BilParkering.leggTilBiler1());
        LadaStreet.setBiler(BilParkering.leggTilBiler2());

        KardiCar.leggTilKontor(Mumidalen);
        KardiCar.leggTilKontor(LadaStreet);

        valgMeny();

    }

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
        }

    }

}
