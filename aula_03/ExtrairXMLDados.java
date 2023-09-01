package br.com.conectarBancoDadosPoo.aula04;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtrairXMLDados {
    public static void main(String[] args) {
        try {
            File inputFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String idade = element.getElementsByTagName("idade").item(0).getTextContent();
                    System.out.println("Nome do passageiro: " + nome);
                    System.out.println("Idade do passageiro: " + idade);
                    System.out.println("-----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
