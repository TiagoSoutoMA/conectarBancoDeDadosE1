import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://caes-e-cia.com.br/guia-de-racas/").get();

        FileWriter escritor = new FileWriter("arquivo.csv");

        escritor.append("Racas");
        escritor.write("\n");
        escritor.write(Objects.requireNonNull(doc.getElementById("h-akita")).text());
        escritor.write("\n");
        escritor.write(Objects.requireNonNull(doc.getElementById("h-australian-cattle-dog")).text());
        escritor.write("\n");
        escritor.write(Objects.requireNonNull(doc.getElementById("h-basset-hound")).text());
        escritor.write("\n");
        escritor.write(Objects.requireNonNull(doc.getElementById("h-bernese-boiadeiro-bern-s")).text());

        escritor.close();
    }
}
