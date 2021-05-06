package archiviojava3bit;

import java.util.ArrayList;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author INSERISCI_NOME
 */
public class Archivio {
    private ArrayList<Articolo> archivio;
    
    //Costruttore 
    public Archivio(){
        //Creo l'ArrayList vuoto
        archivio = new ArrayList(0);
    }
    
    //Metodo per inserire un Articolo
    public void inserisci(Articolo articolo){
        //Aggiungo l'oggetto ricevuto nell'ArrayList
        archivio.add(articolo);
    }
    
    //Metodo per la ricerca in base al codice
    public Articolo ricerca(String codice){
        for(int i = 0; i < archivio.size(); i++){
            //Prendiamo l'oggetto in posizione i
            Articolo articolo = archivio.get(i);
            if(articolo.getCodice()==codice){
                return articolo;
            }
        }
        //Se arrivo qui significa che l'articolo non c'è
        return null;
    }
    
    //Metodo che restituisce la stringa che rappresenta tutto l'archivio
    public String toString(){
        String s = "";
        for(int i = 0; i < archivio.size(); i++){
            Articolo articolo = archivio.get(i);
            s += articolo.toString();
            if(i < archivio.size() - 1){
                s += "\r\n";
            }
        }
        return s;
    }
    
    //Metodo che restitiusce l'elenco degli articoli
    public ArrayList<Articolo> elencoArticoli(){
        return archivio;
    }
    
    //Metodo per eliminare un articolo dall'archivio
    public boolean elimina(String codice){
        Articolo articolo;
        articolo = ricerca(codice);
        if(articolo != null){
            //Cancello l'articolo dall'arraylist
            archivio.remove(articolo);
            return true;
        }
        return false;
    }
}
