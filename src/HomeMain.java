import java.io.IOException;
import java.nio.file.*;
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

    public static void main(String[] args) {

        Path userData = Paths.get("Files\\UserData.csv");


        System.out.println("Willkommen");
        System.out.println("Dies ist nur ein Versuch");

        System.out.println("Wollen Sie sich anmelden [a] /registrieren [r] oder als gast [g] fortfahren?");
        choice = reader.next().toLowerCase().charAt(0);
        switch (choice){
            case 'a':
                System.out.println("Anmelden");
                anmelden();
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
                break;
            case 'g':
                System.out.println("Gast");
                break;
        }


//hallo

    }
    public static boolean anmelden(){
        System.out.println("Anmeldungsbereich");
        System.out.println("[Benutzername:]");

        System.out.println("[Passwort]");
        return true;
    }
    public static boolean mitarbeiterId(){
        System.out.println("Sie sind ein Mitarbeiter");
        return true;
    }
/*
    public static HashMap<String, String> readCsv(Path p){
        HashMap<String,String> tempmap;
        Article tempAr = new Article();
        List<Article> temp = new ArrayList<Article>();

        try{
            tempmap = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
            return null;
        }

        for(int i=0; i< tempmap.size();i++){
            String[] zuSpalten = tempmap.get(i).split(";");
            tempAr.setArticleId(Integer.parseInt(zuSpalten[0]));
            tempAr.setArticleName(zuSpalten[1]);
            tempAr.set_manufacturer(zuSpalten[2]);
            tempAr.set_price(Double.parseDouble(zuSpalten[3]));
            tempAr.set_description(zuSpalten[4]);
            temp.add(tempAr);
        }
        return temp;

    }*/
}
