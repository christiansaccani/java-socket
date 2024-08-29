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
public class Intestatario {
    
    //Attributi
    private String nome;
    private String cognome;

    //Costruttore
    public Intestatario(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    //getter
    public String getNome() {
        return nome;
    }
    //getter
    public String getCognome() {
        return cognome;
    }

    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    //setter
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
}
