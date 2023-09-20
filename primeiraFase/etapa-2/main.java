import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
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

        String url = "jdbc:postgresql://localhost/5432";
        String user = "postgres";
        String password = "Tsma251837!";
        Connection connection = DriverManager.getConnection(url, user, password);

        String insertQuery = "INSERT INTO racas (nome) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        preparedStatement.setString(1, doc.getElementById("h-akita").text());
        preparedStatement.addBatch();
        preparedStatement.setString(1, doc.getElementById("h-australian-cattle-dog").text());
        preparedStatement.addBatch();
        preparedStatement.setString(1, doc.getElementById("h-basset-hound").text());
        preparedStatement.addBatch();
        preparedStatement.setString(1, doc.getElementById("h-bernese-boiadeiro-bern-s").text());
        preparedStatement.addBatch();

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
