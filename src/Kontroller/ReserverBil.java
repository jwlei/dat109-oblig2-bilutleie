package Kontroller;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Objekt.Adresse;
import Objekt.Bil;
import Objekt.Kontor;
import Objekt.Kunde;
import Objekt.Reservasjon;
import Objekt.Selskap;


public class ReserverBil {

    public static void reserverBil(Selskap selskap) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        
    
        List <Kontor> tilgjengeligeKontor = selskap.getKontorer();
        for (Kontor i : tilgjengeligeKontor) {
        	System.out.println(i.toString());
        }
        
        System.out.println("Skriv inn utleiekontor: ");
        String utleiekontor = sc.nextLine();
        
        System.out.println(tilgjengeligeKontor);
        System.out.println("Skriv inn ønsker returkontor: ");
        String returkontor = sc.nextLine();

        System.out.println("Skriv inn dato du ønsker å leie ifra. (dd/MM/yyyy)");
        String stringdato = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dato = LocalDate.parse(stringdato, dtf);

        System.out.println("Skriv inn ønsket klokkeslett for utleie. (HH:mm)");
        String klokke = sc.nextLine();
        dtf = DateTimeFormatter.ofPattern("hh:mm");
        LocalTime tidspunkt = LocalTime.parse(klokke);

        System.out.println("Anngi antall dager du vil leie bilen: ");
        int dager = sc.nextInt();

        List <Kontor> alleKontorer = selskap.getKontorer();
        System.out.println(alleKontorer);

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


        Kunde k1 = new Kunde(fnavn, enavn, tlf, new Adresse(gateadresse, postnr, poststed));
        Reservasjon reservasjon = new Reservasjon(bil, dato, tidspunkt, dager, utleieplass, returplass, k1);
        selskap.leggTilReservasjon(reservasjon);

        Klient.valgMeny();

    }
    
    public String toString()
    {
          return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }

}
