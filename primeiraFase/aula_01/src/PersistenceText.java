import java.io.FileWriter;
import java.io.IOException;

public class PersistenceText {
    public static void main(String[] args) {
        String conteudo = "Primeira linha";
        try {
            FileWriter escreva = new FileWriter("arquivo.txt");
            escreva.write(conteudo);
            escreva.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}