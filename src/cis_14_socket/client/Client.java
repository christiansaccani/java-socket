/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis_14_socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Indirizzo del server
        int port = 12345; // Porta su cui il server ascolta

        // Specifica il percorso del file XML
        String filePath = "dati.xml";

        // Crea un'istanza di LeggiFile
        LeggiFile leggiFile = new LeggiFile(filePath);

        // Leggi i conti correnti dal file
        List<ContoCorrente> conti = leggiFile.leggiConti();

        // Converti i conti correnti in una stringa
        StringBuilder sb = new StringBuilder();
        for (ContoCorrente conto : conti) {
            sb.append(conto.toString()).append("\n"); // Aggiungi una nuova riga per ogni conto
        }
        String message = sb.toString(); // La stringa da inviare al server

        try (Socket socket = new Socket(serverAddress, port)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Invio al server: " + message);
            
            out.println(message);

            System.out.println("Ricevuto dal server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}