import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import StatusThings.*;
import Schneekanone.*;

public class HomeMain {

    static Scanner reader = new Scanner(System.in);
    static char choice;
    static char choice2;
    static char mmenu;
    static String username =" ";
    static String password =" ";
    static int id;
    public static String mitarbeiterPW = "Schnee";
    static Path userDataPath = Paths.get("Files\\UserData.csv");

    public static void main(String[] args) {

        System.out.println("Willkommen");
        System.out.println("Dies ist nur ein Versuch");

        System.out.println("Wollen Sie sich anmelden [a] /registrieren [r] oder als gast [g] fortfahren?");
        choice = reader.next().toLowerCase().charAt(0);
        switch (choice) {
            case 'a':
                System.out.println("Anmelden");
                //Hier wird probiert
                if (anmelden()) {
                    System.out.println("Supper das hat geklappt");
                    System.out.println("Wie wollen Sie nun fortfahren?");
                    System.out.println("M----Mitarbeiterbereich");
                    //Mitarbeiter ID angeben
                    System.out.println("B----Besucherbereich");
                    choice2 = reader.next().toLowerCase().charAt(0);
                    switch (choice2) {
                        case 'm':
                            if (mitarbeiterId()) {
                                System.out.println("\n\n\n\n");
                                System.out.println("_-_-_-_-_-_-Mitarbeiterbereich-_-_-_-_-_-_-_\n\n");
                                System.out.println("Sie können nun auf folgende Funktionen zugreifen");
                                System.out.println("[S] Schneekanonen steuern\n\n");
                                mmenu = reader.next().toLowerCase().charAt(0);
                                switch (mmenu) {
                                    case 's':
                                        System.out.println("Schneekanonen werden geladen....\n");
                                        List <Schneekanone> schneekanones= new ArrayList<>();
                                        schneekanones = FileForSKan.readSKSFromFile();
                                        schneekanones.forEach(a -> System.out.println(a));
                                        schneekanones.add(FileForSKan.inputKanoneData());
                                        FileForSKan.writeSKsToFile(schneekanones);
                                        schneekanones.forEach(a -> System.out.println(a));
                                }

                            }
                            break;
                        case 'b':
                            System.out.println("BEss");

                    }

                } else {
                    System.out.println("Fehler bei der Anmeldung");
                }

                break;
            case 'r':
                System.out.println("Registrieren");
                registrieren(userDataPath);
                break;
            case 'g':
                System.out.println("Gast");
                System.out.println("Geringverdiener");
                break;
        }

    }




    public static boolean anmelden() {
        System.out.println("Anmeldungsbereich");
        System.out.println("[Benutzername:]");
        username = reader.next();
        System.out.println("[Passwort]");
        password = reader.next();

        //     KEY      VALUE
        HashMap<String, String> tempMap = readCsvIntoHashmap(userDataPath);

        for (String i : tempMap.keySet()) {
            System.out.println(i);
        }
        System.out.println("tempMap.get(username): " + tempMap.get(username));
        System.out.println(password);

        if (tempMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean registrieren(Path p) {
        System.out.println("Registrierbereich");
        if (writeToFile(p, userdataInput(readCsvIntoHashmap(p)))) {
            System.out.println("registriert");
            return true;
        }
        return false;
    }

    public static boolean mitarbeiterId() {
        if(checkIfMitarbeiter(userDataPath)) {
            System.out.println("Sie sind ein Mitarbeiter");
            return true;
        }
        System.out.println("Sie sind kein Mitarbeiter!");
        System.out.println("Schlingel!");
        return false;
    }

    public static HashMap<String, String> readCsvIntoHashmap(Path p) {
        List<String> tempStrList = new ArrayList<String>();
        HashMap<String, String> tempmap = new HashMap<String, String>();

        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return null;
        }

        for (int i = 0; i < tempStrList.size(); i++) {
            String[] zuSpalten = tempStrList.get(i).split(";");
            tempmap.put(zuSpalten[0], zuSpalten[1]);

        }
        return tempmap;

    }

    public static boolean checkIfMitarbeiter(Path p){
        List<String> tempStrList = new ArrayList<String>();

        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return false;
        }

        for (int i = 0; i < tempStrList.size(); i++) {
            String[] zuSpalten = tempStrList.get(i).split(";");
            if((zuSpalten[2].equals("0") && (zuSpalten[0].equals(username)))){
                return false;
            }
            if((zuSpalten[2].equals("1")) && (zuSpalten[0].equals(username))){
                return true;
            }
        }
        return false;

    }

    public static List<Integer> IDChecker(Path p){
        List<String> tempStrList = new ArrayList<String>();
        List<Integer> tempIntList = new ArrayList<Integer>();

        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return tempIntList;
        }

        for (int i = 0; i < tempStrList.size(); i++) {
            String[] zuSpalten = tempStrList.get(i).split(";");
            tempIntList.add(Integer.parseInt(zuSpalten[3]));

        }
        return tempIntList;

    }

    public static boolean writeToFile(Path p, String inputData) {
        try {
            Files.writeString(p, inputData, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.out.println("Fehler beim schreiben!\n");
            e.printStackTrace();
            return false;
        }
    }

    public static String userdataInput(HashMap<String, String> userdata) {
        char choice;
        boolean retry = true;

        do {
            System.out.println("neuen Benutzer erstellen\n");

            System.out.println("Was ist der Benutzername?");
            username = reader.next();
            System.out.println("Was ist das Passwort? (wenn neuer Mitarbeiter, hier Mitarbeiterpasswort eingeben:)");
            password = reader.next();

            if(!password.equals(mitarbeiterPW)) {
                if (userdata.containsKey(username)) {
                    System.out.println("Benutzer existiert schon!");
                    System.out.println("erneut versuchen? [j/n]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'n') {
                        retry = false;
                    }

                } else {
                    System.out.println("Daten werden weitergegeben ...");
                    return username + ";" + password + ";" + "0" + "\n" ;
                }
            }
            if (password.equals(mitarbeiterPW)) {
                System.out.println("hallo neuer Mitarbeiter!");
                if (userdata.containsKey(username)) {
                    System.out.println("Benutzer existiert schon!");
                    System.out.println("erneut versuchen? [j/n]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'n') {
                        retry = false;
                    }

                } else {
                    System.out.println("dein persönliches Mitarbeiterpasswort erstellen: ");
                    password=reader.next();
                    System.out.println("Daten werden weitergegeben ...");
                    return username + ";" + password + ";" + "1" + "\n";
                }
            }
        } while (retry);
        return null;

    }
    public static String personDataInput(HashMap<String, String> userdata, Path pathOfPersonData) {
        char choice;
        boolean retry = true;

        do {
            System.out.println("neue Person erstellen\n");
             List<Integer> idList = new ArrayList<Integer>(){};
             int id = 0;
             String firstname;
             String lastname;
             LocalDate birthdate;
             char gender;
            idList = IDChecker(pathOfPersonData);

            // TODO: 08.04.2022 hier weitermachen
             for(int i= 1; i<idList.size(); i++){
                 if(true){

                 }
             }


            System.out.println("Was ist der Benutzername?");
            username = reader.next();
            System.out.println("Was ist das Passwort? (wenn neuer Mitarbeiter, hier Mitarbeiterpasswort eingeben:)");
            password = reader.next();

            if(!password.equals(mitarbeiterPW)) {
                if (userdata.containsKey(username)) {
                    System.out.println("Benutzer existiert schon!");
                    System.out.println("erneut versuchen? [j/n]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'n') {
                        retry = false;
                    }

                } else {
                    System.out.println("Daten werden weitergegeben ...");
                    return username + ";" + password + ";" + "0" + "\n" ;
                }
            }
            if (password.equals(mitarbeiterPW)) {
                System.out.println("hallo neuer Mitarbeiter!");
                if (userdata.containsKey(username)) {
                    System.out.println("Benutzer existiert schon!");
                    System.out.println("erneut versuchen? [j/n]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'n') {
                        retry = false;
                    }

                } else {
                    System.out.println("dein persönliches Mitarbeiterpasswort erstellen: ");
                    password=reader.next();
                    System.out.println("Daten werden weitergegeben ...");
                    return username + ";" + password + ";" + "1" + "\n";
                }
            }
        } while (retry);
        return null;

    }
}
