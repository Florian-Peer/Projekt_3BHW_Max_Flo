package StatusThings;

import Schneekanone.Schneekanone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileForSKan {
    static Path SKDataPath = Paths.get("Files\\SKData.csv");
    static Scanner reader  = new Scanner(System.in);

    public static void main(String[] args) {
        List <Schneekanone> schneekanones= new ArrayList<>();
        schneekanones = readSKSFromFile(SKDataPath);
        schneekanones.forEach(a -> System.out.println(a));
        schneekanones.add(inputKanoneData());
        writeSKsToFile(schneekanones);
        schneekanones.forEach(a -> System.out.println(a));







    }
    public static void writeSKsToFile(List<Schneekanone> schneekanones){
        try{
            Files.writeString(SKDataPath,createStringListfromSkList(schneekanones));
        }
        catch (IOException e){
            System.out.println("ERROR: SCHREIBEN");
        }
    }
    public static String createStringListfromSkList (List<Schneekanone>schneekanones){
        String e ="";
        for(Schneekanone s : schneekanones){
            e+=createStringFromSK(s) +"\n";
        }
        return e;
    }
    public static String createStringFromSK(Schneekanone schneekanone){
        String c = schneekanone.getKid()+";";
        c+=schneekanone.getKanoneName()+";";
        c+=schneekanone.getBrand()+";";
        c+=schneekanone.getBetrieb()+";";
        return c;
    }

    public static Schneekanone inputKanoneData() {
        System.out.println("ID:");
        int id = reader.nextInt();
        reader = new Scanner(System.in);

        System.out.println("Name: ");
        String name = reader.nextLine();
        reader = new Scanner(System.in);
        System.out.println("Brand: ");
        String brand = reader.nextLine();
        reader = new Scanner(System.in);
        System.out.println("Status: ");
        boolean status = reader.nextBoolean();
        reader = new Scanner(System.in);

        return new Schneekanone(id, name, brand,status);
    }
    public static List<Schneekanone> readSKSFromFile(Path p){
        List <Schneekanone> sk = new ArrayList<>();
        if(Files.exists(p)){
            try{
                return convertCSVStringListtoSKList(Files.readAllLines(p));
            }
            catch (IOException e){
                System.out.println("Es trat ein Problem beim lesen auf");
            }
        }
        else{
            System.out.println("NO NO NO Datei");
        }
        return null;

    }
    public static Schneekanone convertCSVStringtoSK(String csvString){
        String[] data = new String[4];
        data = csvString.split(";");
        Schneekanone s = new Schneekanone();
        s.setKid(Integer.parseInt(data[0]));
        s.setKanoneName(data[1]);
        s.setBrand(data[2]);
        s.setBetrieb(Boolean.parseBoolean(data[3]));
        return s;
    }
    public static List <Schneekanone> convertCSVStringListtoSKList(List<String> csvStringList){
        List <Schneekanone> schneekanones = new ArrayList<>();
        for(String s : csvStringList){
            schneekanones.add(convertCSVStringtoSK(s));
        }
        return schneekanones;
    }




}
