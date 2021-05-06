/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiviojava3bit;

/**
 *
 * @author Sara Vacher
 */
public class Articolo { 
    private String nome;
    private String codice;
    private float prezzo;
    private String descrizione;
    private String colore;

    public Articolo(String nome, String codice, float prezzo, String descrizione, String colore) {
        this.nome = nome;
        this.codice = codice;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.colore = colore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
    
    //Metodo che restituisce la stringa che rappresenta l'articolo
    @Override
    public String toString(){
        String s;
        s = codice;
        s += ",";
        s += nome;
        s += ",";
        s += descrizione;
        s += ",";
        s += Float.toString(prezzo);
        s += ",";
        s += colore;
        return s;
    }
    
    
}
