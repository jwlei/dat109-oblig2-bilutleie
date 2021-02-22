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
 * Klasse som definerer innlevering av lånt bil.
 *  */

public class InnleveringAvBil {

    /*
    Metode for innlevering av bil.
    * @param Bil
     */

    public static void LeverInn(Selskap selskap) {
        //Dato for innlevering
        LocalDate dagsDato = LocalDate.now();
        
        Scanner sc = new Scanner(System.in);
        
        //Bruker finner sin reservasjon fra telefonnummer.
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

        //Bruker registrerer ny KMstand.
        Bil bil = res.getBil();
        System.out.println("Hvor mange km viser km-telleren på bilen? \n"
        				 + "Ved utlevering var KM stand: " + bil.getKmStand()+ ".");
        				   
        int kmStand = sc.nextInt();

        //Setter ny kmStand på bil og setter bil som ledig
        bil.setKmStand(kmStand);
        bil.setLedig(true);

        Kontor returKontor = res.getReturSted();
        
        //Gir brukeren pris for deres leie av bil.
        if(res.getReturSted() != res.getUtleiested()) {
        	int totalpris = res.prisForLeie()+res.getGebyr();
        	 System.out.println("Din regning er: " + totalpris + ",-\n" 
        		   + "Hvor 29,- kroner er gebyr for annet leveringskontor.\n"
  				   + "Takk for at du benyttet deg av KardiCar utleie.");
        } else {
        	System.out.println("Din regning er: " + res.prisForLeie() + ",-\n" 
   				   + "Takk for at du benyttet deg av KardiCar utleie.");
        }
        //Henter returkontor og legger til bil i deres bilparkering.
        returKontor.leggTilBil(bil);
        Kredittkort kort = res.getKunde().getKredittKort();
        
        //Fjerner reservasjon fra bruker.
        alleReservasjoner.remove(res);

        Retur retur = new Retur(kort, dagsDato, bil.getRegNr(), kmStand);
        List<Retur> returListe = selskap.getReturnerteBiler();
        returListe.add(retur);

        Klient.valgMeny();

        System.out.println("Bilen er innlevert.");
        System.out.println();
        Klient.valgMeny();
    }

}
