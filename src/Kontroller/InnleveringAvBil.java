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
        Bil bil = res.getBil();
        System.out.println("Hvor mange km viser km-telleren på bilen? \n"
        				 + "Ved utlevering var KM stand: " + bil.getKmStand());
        				   
        int kmStand = sc.nextInt();

        //Setter ny kmStand på bil og setter bil som ledig
       
        bil.setKmStand(kmStand);
        bil.setLedig(true);

        //Henter returkontor og legger til bil i deres billiste
        Kontor returKontor = res.getReturSted();
        
        if(res.getReturSted() != res.getUtleiested()) {
        	int totalpris = res.prisForLeie()+res.getGebyr();
        	 System.out.println("Din regning er: " + totalpris + "\n" 
        		   + "Hvor 29 kroner er gebyr for annet leveringskontor.\n"
  				   + "Takk for at du benyttet deg av KardiCar utleie.");
        } else {
        	System.out.println("Din regning er: " + res.prisForLeie() + "\n" 
   				   + "Takk for at du benyttet deg av KardiCar utleie.");
        }
        returKontor.leggTilBil(bil);
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
