package br.com.conectarBancoDadosPoo.aula05;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Aplication {
    public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);

        // Deserialize
        String jsonInput = "[" +
                "{\n" +
                "    \"id\": 2,\n" +
                "    \"nome\": \"Felype\",\n" +
                "    \"idade\": 28,\n" +
                "    \"sexo\": \"M\",\n" +
                "    \"curso\": \"S.I\",\n" +
                "    \"periodo\": 3\n" +
                "}," +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"nome\": \"Adelmo\",\n" +
                "        \"idade\": 24,\n" +
                "        \"sexo\": \"F\",\n" +
                "        \"curso\": \"S.I\",\n" +
                "        \"periodo\": 3\n" +
                "    }," +
                "{\n" +
                "        \"id\": 3,\n" +
                "        \"nome\": \"Rodrigo\",\n" +
                "        \"idade\": 28,\n" +
                "        \"sexo\": \"M\",\n" +
                "        \"curso\": \"S.I\",\n" +
                "        \"periodo\": 3\n" +
                "    }," +
                "{\n" +
                "        \"id\": 4,\n" +
                "        \"nome\": \"Tiago\",\n" +
                "        \"idade\": 22,\n" +
                "        \"sexo\": \"M\",\n" +
                "        \"curso\": \"S.I\",\n" +
                "        \"periodo\": 3\n" +
                "    }" +
                "]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p);

    }
    private static List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        return pessoas;
    }
}
