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
/**
 * La classe ContoCorrente modella un conto corrente bancario.
 * Ogni conto corrente ha un intestatario, un numero di conto, e un ammontare.
 * La classe gestisce inoltre il massimo scoperto consentito per ogni conto.
 */
public class ContoCorrente {

    // Attributi privati della classe
    private Intestatario intestatario;
    private int numeroConto;        // Numero del conto corrente
    private double ammontare;       // Ammontare del conto in euro

    // Attributo statico per il massimo scoperto consentito
    private static double massimoScoperto = 1000.0; // Valore di default per lo scoperto massimo

    /**
     * Costruttore che crea un oggetto ContoCorrente con intestatario e numero di conto specificati.
     * L'ammontare iniziale viene fissato a 0.
     *
     * @param nome Il nome dell'intestatario del conto.
     * @param cognome Il cognome dell'intestatario del conto.
     * @param num Il numero del conto corrente.
     */
    public ContoCorrente(String nome, String cognome, int num) {
        intestatario = new Intestatario(nome, cognome);
        this.numeroConto = num;
        this.ammontare = 0.0;
    }

    public ContoCorrente(Intestatario i, int num){
        this.intestatario = i;
        this.numeroConto = num;
        this.ammontare = 0.0;
    }

    //COSTRUTTORE DI COPIA
    public ContoCorrente(Intestatario i, int num, int ammontare){
        this.intestatario = new Intestatario(i.getNome(),i.getCognome());
        this.numeroConto = num;
        this.ammontare = ammontare;
    }    
    
    /**
     * Costruttore che crea un oggetto ContoCorrente con intestatario, numero di conto,
     * e ammontare iniziale specificati.
     *
     * @param nome Il nome dell'intestatario del conto.
     * @param cognome Il cognome dell'intestatario del conto.
     * @param num Il numero del conto corrente.
     * @param ammontare L'ammontare iniziale del conto.
     */
    public ContoCorrente(String nome, String cognome, int num, double ammontare) {
        intestatario = new Intestatario(nome, cognome);

        this.numeroConto = num;
        this.ammontare = ammontare;
    }

    /**
     * Aggiunge al conto corrente il valore specificato.
     * Il valore puÃ² essere positivo (deposito) o negativo (prelievo).
     *
     * @param valore Il valore da aggiungere al conto corrente.
     */
    public void operazione(double valore) {
        this.ammontare += valore;
    }

    /**
     * Verifica se l'ammontare corrente Ã¨ inferiore allo scoperto massimo consentito.
     *
     * @return true se l'ammontare corrente Ã¨ inferiore allo scoperto massimo, false altrimenti.
     */
    public boolean isScoperto() {

        return this.ammontare < -massimoScoperto;
    }

    /**
    * Restituisce il numero di conto associato a questo ContoCorrente.
    *
    * @return il numero di conto come un intero.
    */
    public int getNumeroConto() {
        return numeroConto;
    }

    /**
    * Restituisce l'ammontare attuale del conto corrente.
    *
    * @return l'ammontare del conto in euro.
    */
    public double getAmmontare() {
        return ammontare;
    }

    public String getNome() {
        return intestatario.getNome();
    }
    
    
    public String getCognome() {
        return intestatario.getCognome();
    }
    
    /**
    * Restituisce il valore massimo di scoperto consentito per tutti i conti correnti.
    *
    * @return il valore massimo di scoperto consentito come un numero reale (double).
    */
    public static double getMassimoScoperto() {
        return massimoScoperto;
    }
    
    

    
    /**
     * Restituisce una descrizione completa del conto corrente sotto forma di stringa.
     *
     * @return Una stringa che descrive l'intestatario, il numero di conto e l'ammontare attuale.
     */
    @Override
    public String toString() {
        return "ContoCorrente{" +
                "Nome:" + intestatario.getNome() +
                " | Cognome:" + intestatario.getCognome() +
                " | Numero Conto:" + numeroConto +
                " | Ammontare:" + ammontare +
                '}';
    }

    /**
     * Reimposta il valore del massimo scoperto con il nuovo valore specificato.
     *
     * @param valore Il nuovo valore per il massimo scoperto consentito.
     */
    public static void setMassimoScoperto(double valore) {
        massimoScoperto = valore;
    }
}
