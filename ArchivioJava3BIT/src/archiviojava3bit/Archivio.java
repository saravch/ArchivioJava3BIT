package archiviojava3bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author Sara Vacher
 */
public class Archivio {
  // TO DO
  // Aggiungere costante per il nome del file

  private ArrayList<Articolo> archivio;

  public Archivio() {
    archivio = leggiDaFile();
  }

  // Metodo che restituisce l'elenco degli articoli
  public ArrayList<Articolo> elencoArticoli() {
    return archivio;
  }

  public boolean aggiungi(Articolo articolo) {
    // controllo che non ci sia già un articolo con lo stesso 
    // codice
    if (Archivio.this.cercaArticolo(articolo.getCodice()) != null) {
      return false;
    }

    archivio.add(articolo);
    salvaSuFile();
    return true;
  }

  private Articolo cercaArticolo(String codice) {
    for (int i = 0; i < archivio.size(); i++) {
      if (archivio.get(i).getCodice().equals(codice)) {
        return archivio.get(i);
      }
    }
    return null;
  }

  public boolean elimina(String codice) {
    Articolo articolo;
    // Ricerco l'articolo
    articolo = Archivio.this.cercaArticolo(codice);

    // Se l'articolo c'è lo cancello
    if (articolo != null) {
      // Cancello l'articolo dall'array list
      archivio.remove(articolo);
      //Salvo tutto nel file
      salvaSuFile();
      return true;
    }
    return false;
  }

  public boolean modificaArticolo(String nome, String codice, float prezzo, String descrizione, String colore) {

    // Cerco l'articolo in base codice.
    Articolo articolo;
    articolo = Archivio.this.cercaArticolo(codice);
    // Se è presente nell'archivio modifico le sue caratteristiche
    if (articolo != null) {
      articolo.setNome(nome);
      articolo.setPrezzo(prezzo);
      articolo.setDescrizione(descrizione);
      articolo.setColore(colore);

      // Salvo l'archivio su file
      salvaSuFile();
      return true;
    } else {
      return false;
    }
  }

  public ArrayList<Articolo> cercaArticolo(float prezzoMinimo, float prezzoMassimo) {

    // Parto con l'array list delle articolo trovate VUOTO
    ArrayList<Articolo> articoliTrovati = new ArrayList(0);

    for (int i = 0; i < archivio.size(); i++) {
      if (archivio.get(i).getPrezzo() >= prezzoMinimo
              && archivio.get(i).getPrezzo() <= prezzoMassimo) {
        // Aggiungo l'articolo in posizione i nell'array list degli articoli trovati
        articoliTrovati.add(archivio.get(i));
      }
    }
    return articoliTrovati;
  }

  // Metodo per cercare le articolo in base al modello
  public ArrayList<Articolo> cercaArticoloPerDescrizione(String descrizione) {

    // Parto con l'array list degli articoli trovati VUOTO
    ArrayList<Articolo> articoliTrovati = new ArrayList(0);

    // Converto la descrizione da cercare in minuscolo
    String descrizioneDaCercareMinuscolo = descrizione.toLowerCase();

    for (int i = 0; i < archivio.size(); i++) {
      // Converto la descrizione dell'articolo in posizione i in minucolo
      String descrizioneMinuscolo = archivio.get(i).getDescrizione().toLowerCase();

      if (descrizioneMinuscolo.contains(descrizioneDaCercareMinuscolo)) {
        // Aggiungo l'rticolo in posizione i nell'ArrayList degli
        // articoli trovati.
        articoliTrovati.add(archivio.get(i));
      }
    }

    // Restituisco l'ArrayList delle articolo trovate.
    return articoliTrovati;
  }

  // Metodo che converte tutto l'arra list delle articolo in una stringa
  public String toString() {
    String s = "";

    for (int i = 0; i < archivio.size(); i++) {
      Articolo articolo;
      // estraggo la articolo in posizione i
      articolo = archivio.get(i);

      // aggiungo la articolo alla stringa
      s += articolo.toString();

      // dopo aver aggiunto un articolo dobbiamo inserire un ritorno a capo
      s += "\r\n";
    }
    return s;
  }

  // Metodo che salva i dati nel file archivio.txt
  public void salvaSuFile() {
    FileWriter out;
    try {
      out = new FileWriter("archivio.txt");

      // Ci facciamo dare dal metodo toString la stringa che rappresenta tutto
      //l'archivio
      String sArchivio;
      sArchivio = toString();

      // Scrivo nel file la stringa ricevuta
      out.write(sArchivio);

      // Chiudo il file
      out.close();

    } catch (IOException ex) {
      Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private ArrayList<Articolo> leggiDaFile() {
    //creo un array list di articoli vuoto
    ArrayList<Articolo> articoli;
    articoli = new ArrayList(0);

    FileReader fileReader;
    try {
      fileReader = new FileReader("archivio.txt");

      // Creo un oggetto BufferedReader, in quanto contiene il metodo
      // readLine(), passandogli l'oggetto FileReader creato prima
      BufferedReader in;
      in = new BufferedReader(fileReader);

      String linea;
      String campi[];
      while ((linea = in.readLine()) != null) {
        campi = linea.split(",");
        System.out.println(campi.length);
        for(int i=0; i<campi.length; i++){
            System.out.println(campi[i]);
        }
        //campi[0] --> nome
        //campi[1] --> codice
        //campi[2] --> prezzo 
        //campi[3] --> descrizione
        //campi[4] --> colore
        float prezzo = Float.parseFloat(campi[3]);

        // Adesso ho i dati necessari per costruite un oggetto
        // Articolo
        Articolo articolo = new Articolo(campi[1], campi[0], prezzo, campi[2], campi[4]);

        // aggiungo l'articolo all'ArrayList
        articoli.add(articolo);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
    }
    return articoli;
  }
}
