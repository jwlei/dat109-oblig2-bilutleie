package Kontroller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Objekt.Adresse;
import Objekt.Bil;
import Objekt.Kontor;
import Objekt.Kunde;
import Objekt.Reservasjon;
import Objekt.Selskap;

/* 
 * Klasse og metode for å gjennomføre reservasjon av bil.
 *  */
public class ReserverBil {

    public static void reserverBil(Selskap selskap) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        
        List <Kontor> tilgjengeligeKontor = selskap.getKontorer();
        String list = tilgjengeligeKontor.toString();
       
        //Velger utleiekontor
        System.out.println(list);
        System.out.println("Skriv inn ditt ønskede utleiekontor: ");
        String utleiekontor = sc.nextLine();
       
        //Velger returkontor
        System.out.println(list);
        System.out.println("Skriv inn ditt ønskede returkontor: ");
        String returkontor = sc.nextLine();

        //Velger startDato
        System.out.println("Skriv inn dato du ønsker å leie ifra. (dd/MM/yyyy)");
        String stringdato = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dato = LocalDate.parse(stringdato, dtf);   
        
        //Velger start klokkeslett
        System.out.println("Skriv klokkeslett du ønsker å leie bilen fra: (HH:mm)");
        String klokke = sc.nextLine();
        dtf = DateTimeFormatter.ofPattern("hh:mm");
        LocalTime startTid = LocalTime.parse(klokke);
        
        //Velger antall dager for leieperiode.
        System.out.println("Anngi antall dager du vil leie bilen: ");
        int dager = sc.nextInt();
        
        //Finner tilgjengelige biler for valgt kontor
        List <Kontor> alleKontorer = selskap.getKontorer();
        Kontor utleieplass = alleKontorer.stream()
                .filter(k -> utleiekontor.equals(k.getNavn()))
                .findAny()
                .orElse(null);

        Kontor returplass = alleKontorer.stream()
                .filter(k -> returkontor.equals(k.getNavn()))
                .findAny()
                .orElse(null);

        
        System.out.println(utleieplass.getNavn());
        List<Bil> alleBiler = utleieplass.getBiler();

        List<Bil> tilgjBiler = alleBiler.stream()
                .filter(b -> b.getLedig() == true)
                .collect(Collectors.toList());

        
        System.out.println("Tilgjengelige biler: ");
        tilgjBiler.stream().forEach(System.out :: println);

        //Velger ønsket bil fra liste over tilgjengelige biler.
        System.out.println("Skriv inn registreringsnummer for ønsket bil: ");
        sc.nextLine();
        String regNr = sc.nextLine();

        Bil bil = tilgjBiler.stream()
                .filter(b -> regNr.equals(b.getRegNr()))
                .findAny()
                .orElse(null);

        if(bil == null) {
            System.out.println("Det finnes ikke en bil med dette registreringsnummeret.");
            sc.close();
            return;

        }
        //Registrering av personalia til reservasjon.
        System.out.println("Skriv inn ditt fornavn: ");
        String fnavn = sc.nextLine();

        System.out.println("Skriv inn ditt etternavn: ");
        String enavn = sc.nextLine();

        System.out.println("Skriv inn ditt telefon nummer: ");
        int tlf = sc.nextInt();

        System.out.println("Skriv inn din gateadresse: ");
        sc.nextLine();
        String gateadresse = sc.nextLine();

        System.out.println("Skriv inn ditt postnummer: (fire siffer) ");
        int postnr = sc.nextInt();

        System.out.println("Skriv inn ditt poststed: ");
        sc.nextLine();
        String poststed = sc.nextLine();

        System.out.println("Reservasjon er fullført");
        System.out.println();


        /* 
         * Legger inn data fra scanner inn i en ny reservasjon.
         *  */
        Kunde nyKunde = new Kunde(fnavn, enavn, tlf, new Adresse(gateadresse, postnr, poststed));
        Reservasjon reservasjon = new Reservasjon(bil, dato, startTid, dager, utleieplass, returplass, nyKunde);
        selskap.leggTilReservasjon(reservasjon);

        Klient.valgMeny();
        Klient.valgMeny();
    }
}
