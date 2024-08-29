/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis_14_socket.client;

/**
 *
 * @author pgrec
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerS {
    public static void main(String[] args) {
        int port = 12345; // Porta su cui il server ascolta

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true); // Imposta l'opzione di riuso dell'indirizzo
            serverSocket.bind(new InetSocketAddress(port)); // Associa l'indirizzo e la porta
            System.out.println("Server in ascolto sulla porta " + port);

            // Accetta la connessione dal client
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Connessione accettata da " + clientSocket.getRemoteSocketAddress());

                // Crea i reader e writer per la comunicazione con il client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Riceve la stringa dal client
                String inputLine = in.readLine();
                System.out.println("Ricevuto dal client: " + inputLine);

                // Inverte la stringa
                String reversedString = new StringBuilder(inputLine).reverse().toString();

                // Invia la stringa invertita al client
                out.println(reversedString);
                System.out.println("Inviato al client: " + reversedString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}