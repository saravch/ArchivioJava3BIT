package archiviojava3bit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Si occupa dell'interfaccia utente con un menu. Qui si può usare println
 *
 * @author INSERISCI_NOME
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creo il archivio
        Archivio archivio;
        archivio = new Archivio();

        // Menu
        // System.in è la tasiera
        Scanner tastiera;
        tastiera = new Scanner(System.in);

        int scelta = 0;

        do {
            System.out.println("--- Gestione articoli per karate ---");
            System.out.println("1) Visualizza elenco articoli");
            System.out.println("2) Inserisci articolo");
            System.out.println("3) Elimina articolo");
            System.out.println("4) Cerca articolo in base al prezzo");
            System.out.println("5) Cerca articolo in base alla descrizione");
            System.out.println("6) Modifica articolo");
            System.out.println("7) Esci");
            System.out.print("Scegli l'operazione (1-7): ");

            // Aspetto la scelta dell'utente
            scelta = Integer.parseInt(tastiera.nextLine()); //bloccante

            switch (scelta) {
                case 1:
                    // Chiedo al archivio l'elenco di tutte le articolo
                    ArrayList<Articolo> elencoArticoli;
                    elencoArticoli = archivio.elencoArticoli();

                    visualizzaElencoArticoli(elencoArticoli);
                    break;

                case 2:
                    // Inserisci articolo
                    // 1. Chiedo all'utente i dati del nuovo articolo da inserire         
                    System.out.print("Inserisci il nome: ");
                    String nome = tastiera.nextLine();
                    System.out.print("Inserisci la codice: ");
                    String codice = tastiera.nextLine();
                    System.out.print("Inserisci la prezzo: ");
                    float prezzo = Float.parseFloat(tastiera.nextLine());
                    System.out.print("Inserisci la descrizione: ");
                    String descrizione = tastiera.nextLine();
                    System.out.print("Inserisci la colore: ");
                    String colore = tastiera.nextLine();

                    // 2. Creo un oggetto articolo con i dati forniti dall'utente
                    Articolo articolo = new Articolo(nome, codice, prezzo, descrizione, colore);

                    // 3. Aggiungo larticolo nel archivio
                    if (archivio.aggiungi(articolo)) {
                        System.out.print("Articolo inserito correttamente");
                    } else {
                        System.out.print("Esiste gia un articolo con lo stesso codice !");
                    }
                    break;

                case 3:
                    // 1. Chiedo all'utente il codice dell'articolo da eliminare         
                    System.out.print("Inserisci il codice: ");
                    codice = tastiera.nextLine();

                    // 2. Elimino la articolo dal archivio         
                    if (archivio.elimina(codice)) {
                        System.out.println("Articolo eliminato correttamente.");
                    } else {
                        System.out.println("Eliminazione non riuscita.");
                    }
                    break;

                case 4:
                    System.out.print("Inserisci il prezzo minimo: ");
                    float prezzoMinimo = Float.parseFloat(tastiera.nextLine());
                    System.out.print("Inserisci il prezzo massimo: ");
                    float prezzoMassimo = Float.parseFloat(tastiera.nextLine());

                    elencoArticoli = archivio.cercaArticolo(prezzoMinimo, prezzoMassimo);

                    visualizzaElencoArticoli(elencoArticoli);

                    break;

                case 5:
                    System.out.print("Inserisci la descrizione: ");
                    descrizione = tastiera.nextLine();

                    elencoArticoli = archivio.cercaArticoloPerDescrizione(descrizione);

                    visualizzaElencoArticoli(elencoArticoli);
                    break;
                case 6:
                    System.out.print("Inserisci il codice: ");
                    codice = tastiera.nextLine();
                    System.out.print("Inserisci la nome: ");
                    nome = tastiera.nextLine();
                    System.out.print("Inserisci la prezzo: ");
                    prezzo = Integer.parseInt(tastiera.nextLine());
                    System.out.print("Inserisci la descrizione: ");
                    descrizione = tastiera.nextLine();
                    System.out.print("Inserisci il colore: ");
                    colore = tastiera.nextLine();

                    if (archivio.modificaArticolo(nome, codice, prezzo, descrizione, colore)) {
                        System.out.println("Modifica moto avvenuta correttamente.");
                    } else {
                        System.out.println("Non è stato possibile modificare la moto.");
                    }
                    break;
            }

        } while (scelta != 7);

    }

    private static void visualizzaElencoArticoli(ArrayList<Articolo> elencoArticoli) {
        System.out.println("N°\tNome\tCodice\tPrezzo\tDescrizione\t\t\tColore");
        for (int i = 0; i < elencoArticoli.size(); i++) {
            System.out.print(i + 1);
            System.out.print("\t" + elencoArticoli.get(i).getNome());
            System.out.print("\t" + elencoArticoli.get(i).getCodice());
            System.out.println("\t\t" + elencoArticoli.get(i).getPrezzo());
            System.out.print("\t" + elencoArticoli.get(i).getDescrizione());
            System.out.print("\t\t\t" + elencoArticoli.get(i).getColore());
        }

        System.out.println("\n");

    }
}
