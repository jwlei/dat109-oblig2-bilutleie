package Objekt;

import java.util.ArrayList;
import java.util.List;

public class BilParkering {

    public static List<Bil> leggTilBiler1() {

        List<Bil> biler = new ArrayList<Bil>();

        Bil b1 = new Bil("SU12345", "Opel", "Corsa", 10000, "Rød", UtleieGruppeEnum.LITEN_BIL);
        biler.add(b1);
        Bil b2 = new Bil("SU8245", "Audi", "A3",  951000, "Sølv",  UtleieGruppeEnum.MELLOMSTOR_BIL);
        biler.add(b2);
        Bil b3 = new Bil("SV99888", "Porche", "Cayenne Pepper", 12345, "Blå", UtleieGruppeEnum.STOR_BIL);
        biler.add(b3);
        Bil b4 = new Bil("SV54321", "Volkswagen", "Passat", 231451, "Svart", UtleieGruppeEnum.STASJONSVOGN);
        biler.add(b4);

        return biler;
    }

    public static List<Bil> leggTilBiler2() {

        List<Bil> biler = new ArrayList<Bil>();

        Bil b1 = new Bil("SU12345", "Opel", "Corsa", 10000, "Rød", UtleieGruppeEnum.LITEN_BIL);
        biler.add(b1);
        Bil b2 = new Bil("SU8245", "Audi", "A3",  951000, "Sølv",  UtleieGruppeEnum.MELLOMSTOR_BIL);
        biler.add(b2);
        Bil b3 = new Bil("SV99888", "Porche", "Cayenne Pepper", 12345, "Blå", UtleieGruppeEnum.STOR_BIL);
        biler.add(b3);
        Bil b4 = new Bil("SV54321", "Volkswagen", "Passat", 231451, "Svart", UtleieGruppeEnum.STASJONSVOGN);
        biler.add(b4);

        return biler;
    }

}
