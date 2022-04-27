import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

import Person.Person;
import StatusThings.*;
import Schneekanone.*;

public class HomeMain {

    static Scanner reader = new Scanner(System.in);
    static char choice;
    static char choice2;
    static char mmenu;
    static String username =" ";
    static String password =" ";
    static boolean registrationMitarbeiter = false;
    static boolean isMitarbeiter = false;
    public static String mitarbeiterPW = "Schnee";
    static Path userDataPath = Paths.get("Files\\UserData.csv");
    static List <Schneekanone> schneekanones= new ArrayList<>();
    static int id;
    // TODO: 01.04.2022 Path Schneekanone erstellen
    // TODO: ERLEDIGT 01.04.2022 NONONO DATEI BEHEBEN
    // TODO: 22.04.2022 HASHMAP Verwendung
    // TODO: ERLEDIGT 22.04.2022 CSV DIRKET AM ANFANG AUFRUFEN DAMIT SIE SCHON VORHER GELADEN SIND

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
                    //SCHNEEKANONE DIREKT AM ANFANG AUSLESEN
                    schneekanones = FileForSKan.readSKSFromFile();
                    System.out.println("Supper das hat geklappt");
                    do {
                        
                    }while(choice2=='r');
                    System.out.println("Wie wollen Sie nun fortfahren?");
                    System.out.println("M----Mitarbeiterbereich");
                    //Mitarbeiter ID angeben
                    System.out.println("B----Besucherbereich");
                    choice2 = reader.next().toLowerCase().charAt(0);
                    do{
                        switch (choice2) {
                            case 'm':
                                System.out.println(isMitarbeiter);
                                if (mitarbeiterId()) {
                                    System.out.println("\n\n\n\n");
                                    System.out.println("_-_-_-_-_-_-Mitarbeiterbereich-_-_-_-_-_-_-_\n\n");
                                    System.out.println("Sie können nun auf folgende Funktionen zugreifen");
                                    System.out.println("[A] alle registrierte User betrachten");
                                    System.out.println("[S] Schneekanonen steuern");
                                    System.out.println("[H] Schneekanone hinzufügen");
                                    System.out.println("[R] Zurück zum START");
                                    mmenu = reader.next().toLowerCase().charAt(0);


                                    switch (mmenu) {
                                        case 'a':
                                            System.out.println("Diese Personen haben bis jetzt das Skigebiet besucht");

                                        case 's':
                                            System.out.println("Schneekanonen werden geladen....\n");


                                            schneekanones.forEach(a -> System.out.println(a));
                                            System.out.print("\n\n");
                                            System.out.println("Betriebstatus ändern [true/false]");
                                            boolean aus;
                                            aus = reader.nextBoolean();
                                            if(aus){
                                                System.out.println("Statusänderung ber der ID:");
                                                id = reader.nextInt();
                                                ChangeStatusSK(id);
                                            }



                                            break;
                                        case 'h':
                                            System.out.println("Sk Hinzufügen");

                                            schneekanones = FileForSKan.readSKSFromFile();
                                            schneekanones.add(FileForSKan.inputKanoneData());
                                            FileForSKan.writeSKsToFile(schneekanones);
                                            break;


                                    }



                                }

                                break;
                            case 'b':
                                System.out.println("BEss");

                        }
                    }while(mmenu !='r');


                } else {
                    System.out.println("Fehler bei der Anmeldung");
                }

                break;
            case 'r':
                System.out.println("Registrieren");
                System.out.print("Sind Sie bereits als Person registriert? [j/n]: ");
                choice = reader.next().toLowerCase().charAt(0);
                if(choice=='j') {
                    userRegistrieren(userDataPath);
                }else{

                }
                break;
            case 'g':
                System.out.println("Gast");
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



        if (tempMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean userRegistrieren(Path p) {
        System.out.println("Registrierbereich");
        if (writeToFile(p, userdataInput(readCsvIntoHashmap(p)))) {
            System.out.println("registriert");
            return true;
        }
        return false;
    }
/*
    public static boolean personRegistrieren(Path p) {
        System.out.println("Registrierbereich");
        if (writeToFile(p, personDataInput(readCsvIntoHashmap(p)))) {
            System.out.println("registriert");
            return true;
        }
        return false;
    }
*/


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

    public static int idGetter(Path p){
        // TODO: 22.04.2022 idGetter fertig machen:
        // TODO: 22.04.2022 bei id's 1,2,4 nicht 3 verwenden, sondern 5
        List<String> tempStrList = new ArrayList<String>();
        int tempInt = 0;
        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return 0;
        }



        int id = 1;
        int i = 0;
        boolean gotId = false;
        do {
            do{
                String[] zuSpalten = tempStrList.get(i).split(";");
                if(id != Integer.parseInt(zuSpalten[i])){
gotId =false;
                }
                    id++;
            }while(gotId);
            i++;
        }while((id<=tempStrList.size()) && (gotId));
        return id;
    }

    public static Person personDataInput(HashMap<String, String> userdata) {
        Person p = new Person();
        char choice;
        boolean retry = true;

        String fname;
        String lname;
        LocalDate bdate;
        char gender;


        do {
            System.out.println("neuen Benutzer erstellen\n");

            System.out.println("Was ist der Vorname?");
            fname = reader.next();
            System.out.println("Was ist der Nachname?");
            lname = reader.next();
            System.out.println("Was ist das Passwort? (wenn neuer Mitarbeiter, hier Mitarbeiterpasswort eingeben:)");
            password = reader.next();
            System.out.println("wann haben Sie geburtstag?");
            System.out.println("Im Format  [YEAR-MONTH-DAY] z.B. 1989-08-21");
            bdate = LocalDate.parse(reader.next());
            System.out.println("Welches Geschlecht haben Sie? [m/w/n]");
            gender = reader.next().toLowerCase().charAt(0);


            p.setFirstname(fname);
            p.setLastname(lname);
            p.setBirthdate(bdate);
            p.setPasword(password);
            p.setGender(gender);

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
                    registrationMitarbeiter = false;
                    return p;
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
                    p.setPasword(password);
                    System.out.println("Daten werden weitergegeben ...");
                    registrationMitarbeiter = true;
                    return p;
                }
            }
        } while (retry);
        return null;

    }

    public static void ChangeStatusSK(int eingebID){
        for(Schneekanone sc : schneekanones){
            if(sc.getKid()==eingebID){
                sc.setBetrieb(!sc.getBetrieb());
            }
        }

    }
}
