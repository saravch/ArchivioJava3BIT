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
}
