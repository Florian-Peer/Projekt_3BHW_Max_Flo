import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import Person.Person;
import Repositorys.IRepTicket;
import Repositorys.RepTicket;
import StatusThings.*;
import Schneekanone.*;
import TICKETS.TypeOfTicket;
import TICKETS.allgemeinesTicket;
import TICKETS.saisonTicket;
import TICKETS.tagesTicket;

public class HomeMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static Scanner reader = new Scanner(System.in);
    static char choice;
    static char redo;
    static char choice2;
    static char mmenu;
    static String username = " ";
    static String password = " ";
    static boolean registrationMitarbeiter = false;
    static boolean isMitarbeiter = false;
    public static String mitarbeiterPW = "Schnee";
    static Path userDataPath = Paths.get("Files\\UserData.csv");
    static Path personDataPath = Paths.get("Files\\PersonData.csv");
    static List<Schneekanone> schneekanones = new ArrayList<>();
    static int id;
    // TODO: ERLEDIGT 01.04.2022 NONONO DATEI BEHEBEN
    // TODO: ERLEDIGT 22.04.2022 HASHMAP Verwendung
    // TODO: ERLEDIGT 22.04.2022 CSV DIRKET AM ANFANG AUFRUFEN DAMIT SIE SCHON VORHER GELADEN SIND

    public static void main(String[] args) throws SQLException {
        System.out.println("\n");
        System.out.println(ANSI_BLUE + "_-_-_-_-_-_-_-Willkommen-_-_-_-_-_-_-_" + ANSI_RESET);
        do {
            System.out.println("Wollen Sie sich ...");
            System.out.println(ANSI_BLUE + "[a] anmelden ");
            System.out.println("[r] registrieren ");
            System.out.println();
            choice = reader.next().toLowerCase().charAt(0);
            switch (choice) {
                case 'a':

                    System.out.println(ANSI_YELLOW + "LOGIN " + ANSI_RESET);
                    //Hier wird probiert
                    if (anmelden()) {
                        System.out.println("anmelden POSITIV\n\n");
                        do {

                            //SCHNEEKANONE DIREKT AM ANFANG AUSLESEN
                            schneekanones = FileForSKan.readSKSFromFile();


                            if (mitarbeiterId()) {
                                System.out.println("-_-_-_-_-_-_-Sie sind als Mitarbeiter eingeloggt-_-_-_-_-_-_");
                                System.out.println("Von Hier aus können Sie mit der Eingabe [M] ins Menü gelangen");

                            } else {
                                System.out.println("\n");
                            }

                            //Mitarbeiter ID angeben
                            choice2 = reader.next().toLowerCase().charAt(0);


                            switch (choice2) {
                                case 'm':
                                    do {


                                        if (mitarbeiterId()) {
                                            System.out.println("\n\n\n\n");
                                            System.out.println(ANSI_BLUE+"_-_-_-_-_-_-Mitarbeitermenü-_-_-_-_-_-_-_\n\n"+ANSI_RESET);
                                            System.out.println("Folgende Aktionen sind möglich\n");
                                            System.out.println("[A] alle registrierte User betrachten");
                                            System.out.println("[S] Schneekanonen steuern");
                                            System.out.println("[H] Schneekanone hinzufügen");
                                            System.out.println("[K] Kassabereich");
                                            System.out.println("[R] Zurück zum START");
                                            mmenu = reader.next().toLowerCase().charAt(0);


                                            switch (mmenu) {
                                                case 'a':
                                                    System.out.println("Diese Personen haben bis jetzt das Skigebiet besucht");
                                                    printAllUsers(personDataPath);
                                                    break;
                                                case 's':
                                                    System.out.println("Schneekanonen werden geladen....\n");


                                                    schneekanones.forEach(a -> System.out.println(a));
                                                    System.out.print("\n\n");
                                                    System.out.println("Betriebstatus ändern [true/false]");
                                                    boolean aus;
                                                    aus = reader.nextBoolean();
                                                    if (aus) {
                                                        System.out.println("Statusänderung ber der ID:");
                                                        id = reader.nextInt();
                                                        ChangeStatusSK(id);
                                                        FileForSKan.writeSKsToFile(schneekanones);
                                                    }


                                                    break;
                                                case 'h':
                                                    System.out.println("Sk Hinzufügen");

                                                    schneekanones = FileForSKan.readSKSFromFile();
                                                    schneekanones.add(FileForSKan.inputKanoneData());
                                                    FileForSKan.writeSKsToFile(schneekanones);
                                                    break;
                                                case 'k':
                                                    System.out.println(ANSI_PURPLE + "Kassabereich" + ANSI_RESET);
                                                    System.out.println("Welche Art von Ticket?");
                                                    System.out.println("Auswahlmöglichkeiten: ");



                                                    System.out.print(ANSI_CYAN_BACKGROUND + ANSI_BLACK);
                                                    int i = 0;
                                                    for (TypeOfTicket value : TypeOfTicket.values()) {
                                                        // TODO: 29.04.2022 da war i grad
                                                        System.out.println("   " + String.valueOf(i) + "     " + value);
                                                        i++;
                                                    }
                                                    System.out.print(ANSI_RESET);

                                                    System.out.print("Ihre Wahl?: ");
                                                    choice = reader.next().charAt(0);
                                                    kassa(Integer.parseInt(String.valueOf(choice)));
                                                    switch(choice){
                                                        case '0':
                                                            ausgabeTESTallTickets();
                                                            break;
                                                        case '1':
                                                            tagesTicketTEST();
                                                            break;
                                                        case '2':
                                                            System.out.println("2");
                                                            saisonTicketTEST();
                                                            break;
                                                        case '3':
                                                            System.out.println("3");
                                                            break;
                                                    }

                                                    break;

                                            }


                                        } else {
                                            System.out.println("Wer LESEN kann ...");
                                        }
                                        System.out.println("zurück zum Mitarbeitermenü? [j/n]");
                                        redo = reader.next().toLowerCase().charAt(0);
                                    } while (redo == 'j');

                                    break;


                            }
                        } while (mmenu == 'r');


                    } else {
                        System.out.println("Fehler bei der Anmeldung");
                    }

                    break;
                case 'r':
                    System.out.println(ANSI_PURPLE + "Registrieren" + ANSI_RESET);
                    System.out.println("neuen Mitarbeiter(user) registrieren[u]");
                    System.out.println("Neuer Person/Gast registrieren[g]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'u') {
                        userRegistrieren(userDataPath);
                    } else {
                        personRegistrieren(personDataPath);
                    }
                    break;

            }

            System.out.println("Programm beenden? [j/n]");
            redo = reader.next().toLowerCase().charAt(0);
        } while (redo != 'j');
    }


    public static boolean anmelden() {
        System.out.println(ANSI_PURPLE + "Anmeldebereich" + ANSI_RESET);
        System.out.println("[Benutzername:]");
        username = reader.next();
        System.out.println("[Passwort]");
        password = reader.next();

        //      KEY      VALUE
        HashMap<String, String> tempMap = readCsvIntoHashmap(userDataPath);

        if (tempMap.containsKey(username)) {

            if (tempMap.get(username).equals(password)) {
                return true;
            } else {
                System.out.println("FALSCHE DATEN!");
                return false;
            }
        } else {
            System.out.println("FALSCHE DATEN!");
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

    public static boolean personRegistrieren(Path p) {
        System.out.println("Registrierbereich");
        if (writeToFile(p, personToCSVString(personDataInput(readCsvIntoHashmap(p), personDataPath)))) {
            System.out.println("registriert");
            return true;
        }
        return false;
    }


    public static boolean mitarbeiterId() {
        if (checkIfMitarbeiter(userDataPath)) {

            return true;
        }

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

    public static boolean checkIfMitarbeiter(Path p) {
        List<String> tempStrList = new ArrayList<String>();

        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return false;
        }

        for (int i = 0; i < tempStrList.size(); i++) {
            String[] zuSpalten = tempStrList.get(i).split(";");
            if ((zuSpalten[2].equals("0") && (zuSpalten[0].equals(username)))) {
                return false;
            }
            if ((zuSpalten[2].equals("1")) && (zuSpalten[0].equals(username))) {
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

            System.out.println("DEIN Benutzername:");
            username = reader.next();
            System.out.println("DEIN Passwort / BEI Mitarbeiter Registrierung bitte den KEY Eingeben");
            password = reader.next();

            if (!password.equals(mitarbeiterPW)) {
                if (userdata.containsKey(username)) {
                    System.out.println("Benutzer existiert schon!");
                    System.out.println("erneut versuchen? [j/n]");
                    choice = reader.next().toLowerCase().charAt(0);
                    if (choice == 'n') {
                        retry = false;
                    }

                } else {
                    System.out.println("Daten werden weitergegeben ...");
                    return "\n" + username + ";" + password + ";" + "0";
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
                    password = reader.next();
                    System.out.println("Daten werden weitergegeben ...");
                    return "\n" + username + ";" + password + ";" + "1";
                }
            }
        } while (retry);
        return null;

    }

    public static int idGetter(Path p) {
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
            do {
                String[] zuSpalten = tempStrList.get(i).split(";");
                if (id != Integer.parseInt(zuSpalten[i])) {
                    gotId = false;
                }
                id++;
            } while (gotId);
            i++;
        } while ((id <= tempStrList.size()) && (gotId));
        return id;
    }

    public static String personToCSVString(Person p) {
        String tempStr = " ";
        tempStr = p.getId() + ";" + p.getFirstname() + ";" + p.getLastname() + ";" + p.getBirthdate() + ";" + p.getPassword() + ";" + p.getGender() + "\n";

        return tempStr;
    }

    public static Person personDataInput(HashMap<String, String> userdata, Path pathi) {
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


            p.setId(idGetter(pathi));
            p.setFirstname(fname);
            p.setLastname(lname);
            p.setBirthdate(bdate);
            p.setPasword(password);
            p.setGender(gender);

            if (!password.equals(mitarbeiterPW)) {
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
                    password = reader.next();
                    p.setPasword(password);
                    System.out.println("Daten werden weitergegeben ...");
                    registrationMitarbeiter = true;
                    return p;
                }
            }
        } while (retry);
        return null;

    }

    public static void ChangeStatusSK(int eingebID) {
        for (Schneekanone sc : schneekanones) {
            if (sc.getKid() == eingebID) {
                sc.setBetrieb(!sc.getBetrieb());
            }
        }

    }

    public static void printAllUsers(Path p){
        List<String> tempStrList = new ArrayList<String>();

        try {
            tempStrList = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
        }

        for (int i = 0; i < tempStrList.size(); i++) {
            String[] zuSpalten = tempStrList.get(i).split(";");
            String geschlecht = "not specified";
            if(zuSpalten[5].equals("m")){
                geschlecht="männlich";
            }
            if(zuSpalten[5].equals("w")){
                geschlecht="weiblich";
            }
            System.out.println("ID: "+zuSpalten[0]);
            System.out.println("Vorname: "+zuSpalten[1]);
            System.out.println("Nachname: "+zuSpalten[2]);
            System.out.println("Geburtsdatum: "+zuSpalten[3]);
            System.out.println("Geschlecht: "+ geschlecht +"\n\n"+"-----------------------------"+"\n");

            //jagga
        }
    }

    public static void kassa(int whichTicket){
        int i=0;
        String ticketType ="NULL";
        for (TypeOfTicket value : TypeOfTicket.values()) {
            if(whichTicket==i){
                ticketType= String.valueOf(value);
            }
            i++;
        }
        System.out.println(ticketType);

    }
    public static void ausgabeTESTallTickets(){
        IRepTicket rep = null;
        try{
            rep = new RepTicket();
            rep.open();
            System.out.println("DATEN HIER");
            for(allgemeinesTicket aT : rep.allTickets()){
                System.out.println(ANSI_BLACK);
                System.out.print(ANSI_YELLOW_BACKGROUND);
                System.out.println(aT);
                System.out.print(ANSI_RESET);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("KOA TREIBER LUL");
        } catch (SQLException e) {
            System.out.println("DB FEHLER  wia Cringe");
        }finally {
            try {rep.close();

            } catch (SQLException e) {
                System.out.println("SCHLIASN GABUT");
            }

        }
    }

    public static void tagesTicketTEST() throws SQLException {
        IRepTicket ir = null;
        try {
            ir = new RepTicket();
            ir.open();
            for(tagesTicket tt : ir.alltagesTicket()){
                System.out.println(ANSI_BLACK);
                System.out.print(ANSI_GREEN_BACKGROUND);
                System.out.println(tt);
                System.out.print(ANSI_RESET);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("DRIVER IS NOT THERE WHERE IT SHOULD BE");
        } catch (SQLException e) {
            System.out.println("ERROR IN DB");

        }finally {
            try {
                ir.close();
            }catch (SQLException e){
                System.out.println("DB COULD NOT BE CLOSED");
            }
        }
    }
    public static  void saisonTicketTEST(){
        IRepTicket iR = null;
        try {
            iR = new RepTicket();
            iR.open();
            for(saisonTicket st : iR.allSaisonTicket()){
                System.out.println(ANSI_BLACK);
                System.out.print(ANSI_PURPLE_BACKGROUND);
                System.out.println(st);
                System.out.print(ANSI_RESET);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("DRIVER IS NOT THERE WHERE IT SHOULD BE");
        } catch (SQLException e) {
            System.out.println("ERROR IN DB");

        }finally {
            try {
                iR.close();
            }catch (SQLException e){
                System.out.println("DB COULD NOT BE CLOSED");
            }
        }
    }
    public static void updateDATETagesTicket(){
        /*
        IRepTicket iR = null;
        try {
            iR = new RepTicket();
            iR.open();
            tagesTicket tagesTicket;
            for(tagesTicket tt : iR.updateTagesTicketDate(tagesTicket))
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */

    }



}