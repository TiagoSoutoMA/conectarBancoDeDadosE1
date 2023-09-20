import java.io.FileWriter;
import java.io.IOException;

public class PersistenceCsv {
    public static void main(String[] args) {
        String[] header = {"Nome", "Idade", "Profissao"};
        String [] line1 = {"Tiago", "21", "Programador"};
        String [] line2 = {"Duck", "6", "Bagunceiro"};

        try {
            FileWriter writer = new FileWriter("arquivo.csv");

            for (String campo : header) {
                writer.append(campo);
                writer.append(";");
            }
            writer.append("\n");

            writer.append(String.join(";", line1));
            writer.append("\n");
            writer.append(String.join(";", line2));
            writer.append("\n");

            writer.flush();
            writer.close();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados! " + e.getMessage());
        }
    }
}
