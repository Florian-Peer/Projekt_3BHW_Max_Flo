import java.util.Scanner;

public class HomeMain {

    static Scanner reader = new Scanner(System.in);
    static char choice;
    static String username;
    static String password;

    public static void main(String[] args) {
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
}
