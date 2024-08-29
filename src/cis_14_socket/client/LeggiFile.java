/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis_14_socket.client;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LeggiFile {

    private String filePath;

    public LeggiFile(String filePath) {
        this.filePath = filePath;
    }

    public List<ContoCorrente> leggiConti() {
        List<ContoCorrente> conti = new ArrayList<>();
        try {
            File file = new File(filePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList contoCorrenteList = document.getElementsByTagName("ContoCorrente");

            for (int i = 0; i < contoCorrenteList.getLength(); i++) {
                Element contoCorrente = (Element) contoCorrenteList.item(i);

                String nome = contoCorrente.getElementsByTagName("nome").item(0).getTextContent();
                String cognome = contoCorrente.getElementsByTagName("cognome").item(0).getTextContent();
                String nc = contoCorrente.getElementsByTagName("numeroConto").item(0).getTextContent();
                String ac = contoCorrente.getElementsByTagName("ammontareConto").item(0).getTextContent();
                int numeroConto = Integer.parseInt(nc);
                int ammontareConto = Integer.parseInt(ac);
                ContoCorrente conto = new ContoCorrente(new Intestatario(nome, cognome), numeroConto, ammontareConto);
                conti.add(conto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conti;
    }
}


