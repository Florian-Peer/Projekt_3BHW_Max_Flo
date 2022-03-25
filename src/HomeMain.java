import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HomeMain {

    static Scanner reader = new Scanner(System.in);
    static char choice;
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
                break;
            case 'r':
                System.out.println("Registrieren");
                break;
            case 'g':
                System.out.println("Gast");
                break;
        }



    }
    public static boolean anmelden(){
        System.out.println("Anmeldungsbereich");
        System.out.println("[Benutzername:]");

        System.out.println("[Passwort]");
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
