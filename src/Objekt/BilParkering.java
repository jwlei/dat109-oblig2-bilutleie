package Objekt;

import java.util.ArrayList;
import java.util.List;

public class BilParkering {

    public static List<Bil> leggTilBiler1() {

        List<Bil> biler = new ArrayList<Bil>();

        Bil b1 = new Bil("SU12345", "Opel", "Corsa", "Rød", UtleieGruppeEnum.LITEN_BIL);
        Bil b2 = new Bil("SU8245", "Audi", "a3", "Sølv", UtleieGruppeEnum.MELLOMSTOR_BIL);
        Bil b3 = new Bil("SV99888", "Porche", "Cayenna", "Blå", UtleieGruppeEnum.STOR_BIL);
        Bil b4 = new Bil("SV54321", "Volkswagen", "Passat", "Svart", UtleieGruppeEnum.STASJONSVOGN);

        return biler;
    }

    public static List<Bil> leggTilBiler2() {

        List<Bil> biler = new ArrayList<Bil>();

        Bil b1 = new Bil("SU69420", "Opel", "Corsa", "Rød", UtleieGruppeEnum.LITEN_BIL);
        Bil b2 = new Bil("SU69696", "Audi", "a3", "Sølv", UtleieGruppeEnum.MELLOMSTOR_BIL);
        Bil b3 = new Bil("SV11337", "Porche", "Cayenna", "Blå", UtleieGruppeEnum.STOR_BIL);
        Bil b4 = new Bil("SV66666", "Volkswagen", "Passat", "Svart", UtleieGruppeEnum.STASJONSVOGN);

        return biler;
    }

}