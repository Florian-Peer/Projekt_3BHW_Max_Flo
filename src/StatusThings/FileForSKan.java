package StatusThings;

import Schneekanone.Schneekanone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileForSKan {
    public static void main(String[] args) {

        List<Schneekanone> skList = new ArrayList<>();


        for (Schneekanone s : skList) {
            System.out.println(s);
        }


        Path pathCSV = Paths.get();
        List<Schneekanone> skanoneList = new ArrayList<>();


        //Alle Artikel ausgeben bevor der Eingabe um zu sehen was schon drin ist
        try {
            printArticles(pathCSV);
        } catch (IOException e) {
            System.out.println("print error");
        }


        // input to article
        try {

            List<String> listString = Files.readAllLines(pathCSV);

            for (String s : listString) {
                String[] arrS = s.split(";", 6);

                Article a = new Article();
                a.setArtId(Integer.parseInt(arrS[0]));
                a.setArtName(arrS[1]);
                a.setArtBrand(arrS[2]);
                a.setArtPrce(Double.parseDouble(arrS[3]));
                a.setArtDescription(arrS[4]);
                artList.add(a);
            }
        } catch (IOException e) {
            System.out.println("split error and co");
        }

        //input article
        Article art = inputArticleData();
        artList.add(art);

        try {
            String compile = "";
            for (Article X : artList) {
                String y = X.toCSV() + "\n";
                compile = compile + y;
            }
            Files.write(pathCSV, compile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Ausgabe der Artikel am Ende um zu sehen ob der Eintrag hinzugefügt wurde
        try {
            printArticles(pathCSV);
        } catch (IOException e) {
            System.out.println("print error");
        }



    }


    public static Article inputArticleData() {
        System.out.println("ID:");
        int id = reader.nextInt();

        System.out.println("Name: ");
        String b1 = reader.nextLine();
        String name = reader.nextLine();

        System.out.println("Brand: ");
        //String b2 = reader.nextLine();
        String brand = reader.nextLine();

        System.out.println("Description: ");
        String description = reader.nextLine();

        System.out.println("Price: ");
        double price = reader.nextDouble();


        return new Article(id, name, brand, price, description);
    }


    public static void printArticles(Path path) throws IOException {
        // output file contents
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
}

}
