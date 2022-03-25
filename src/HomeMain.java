import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HomeMain {

    static Scanner reader = new Scanner(System.in);
    static char choice;
    static char choice2;
    static char mmenu;
    static String username;
    static String password;
    static Path userData = Paths.get("Files\\UserData.csv");

    public static void main(String[] args) {




        System.out.println("Willkommen");
        System.out.println("Dies ist nur ein Versuch");

        System.out.println("Wollen Sie sich anmelden [a] /registrieren [r] oder als gast [g] fortfahren?");
        choice = reader.next().toLowerCase().charAt(0);
        switch (choice){
            case 'a':
                System.out.println("Anmelden");
                if(anmelden()){
                    System.out.println("Anmelden erfolgreich!");
                }
                else {
                    System.out.println("Anmelden fehlgeschlagen!");
                }
                //Hier wird probiert
                if(anmelden()){
                    System.out.println("Supper das hat geklappt");
                    System.out.println("Wie wollen Sie nun fortfahren?");
                    System.out.println("M----Mitarbeiterbereich");
                    //Mitarbeiter ID angeben
                    System.out.println("B----Besucherbereich");
                    choice2 = reader.next().toLowerCase().charAt(0);
                    switch(choice2){
                        case 'm':
                            if(mitarbeiterId()){
                                System.out.println("\n\n\n\n");
                                System.out.println("_-_-_-_-_-_-Mitarbeiterbereich-_-_-_-_-_-_-_\n\n");
                                System.out.println("Sie können nun auf folgende Funktionen zugreifen");
                                System.out.println("[S] Schneekanonen steuern\n\n");
                                mmenu = reader.next().toLowerCase().charAt(0);
                                switch (mmenu){
                                    case 's':
                                        System.out.println("Schneekanonen werden geladen....\n");
                                        //
                                        System.out.println();
                                }

                            }
                            break;
                        case 'b':
                            System.out.println("BEss");

                    }

                }
                else{
                    System.out.println("Fehler bei der Anmeldung");
                }

                break;
            case 'r':
                System.out.println("Registrieren");
                registrieren(userData);
                break;
            case 'g':
                System.out.println("Gast");
                break;
        }


//hallo

    }

    // TODO: 25.03.2022 anmelden lösen 
    public static boolean anmelden(){
        System.out.println("Anmeldungsbereich");
        System.out.println("[Benutzername:]");
        username = reader.next();
        System.out.println("[Passwort]");
        password=reader.next();

        HashMap<String,String> tempMap = readCsvIntoHashmap(userData);

        for (String i : tempMap.keySet()) {
            System.out.println(i);
        }

        if(tempMap.get(username) == password){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean registrieren(Path p){
        System.out.println("Registrierbereich");
        if(writeToFile(p,inputHashmap(readCsvIntoHashmap(p)))){
            System.out.println("registriert");
            return true;
        }
        return false;
    }
    public static boolean mitarbeiterId(){
        System.out.println("Sie sind ein Mitarbeiter");
        return true;
    }

    public static HashMap<String, String> readCsvIntoHashmap(Path p){
        List<String> tempStr = new ArrayList<String>();
        HashMap<String,String> tempmap = new HashMap<String,String>();

        try{
            tempStr = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return null;
        }

        for(int i=0; i< tempStr.size();i++){
            String[] zuSpalten = tempStr.get(i).split(";");
            tempmap.put(zuSpalten[0],zuSpalten[1]);
        }
        return tempmap;

    }

    public static boolean writeToFile(Path p, String inputData){
        try {
            Files.writeString(p, inputData, StandardOpenOption.APPEND);
            return true;
        }catch(IOException e) {
            System.out.println("Fehler beim schreiben!\n");
            e.printStackTrace();
            return false;
        }
    }

    public static String inputHashmap(HashMap<String,String> userdata){

        System.out.println("neuen Benutzer erstellen\n");

        System.out.println("Was ist der Benutzername?");
        username = reader.next();
        System.out.println("Was ist das Passwort?");
        password = reader.next();

        if(userdata.containsValue(username)){
            System.out.println("Benutzer existiert schon!");
        }
        else {
            System.out.println("Daten werden weitergegeben ...");
            return username + ";" + password +"\n";

        }

        return null;
    }
}
