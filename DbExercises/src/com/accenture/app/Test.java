package com.accenture.app;

import java.util.List;
import java.util.Scanner;

import com.accenture.dao.ProductDaoImp;
import com.accenture.entity.Product;

public class Test {
	private static ProductDaoImp sdi;
	
	// Programma principale
	public static void main(String[] args) {
		// creo istanza implementazione DAO
		sdi = new ProductDaoImp();
		for(Product p : sdi.getAll()) {
			System.out.println(p);
		};
		
		sdi.create(new Product("gang", "name", 12.2, 15, "1"));
	
		// richiamo i suoi metodi
		vediStudenti();
		//aggiungiStudente(); //togli il commento se vuoi aggiungere uno studente
		//cercaDaId(); //togli il commento se vuoi vedere dettaglio studente
		//eliminaStudente();  //togli il commento se vuoi eliminare uno studente
		//modificaStudente();
		cercaStudente();
		
		
	}

	private static void cercaStudente() {
		// chiedo di inserire una stringa
		Scanner s = new Scanner(System.in);
		System.out.println("Digita qualcosa: ");
		String str = s.nextLine();
		// passo stringa al metodo del dao 
		List<Product> elenco = sdi.search(str);
		System.out.println("Trovati "+elenco.size()+" studenti");
		System.out.println("Risultato della ricerca:");
		for(Product st : elenco) {
			System.out.println( st );
		}
	}

	private static void modificaStudente() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digita id studente da visualizzare: ");
		int id = Integer.parseInt(s.nextLine());
		System.out.println("Digita cognome nuovo studente: ");
		String c = s.nextLine();
		System.out.println("Digita nome nuovo studente: ");
		String n = s.nextLine();
		sdi.update( new Product(id,c,n) );
	}

	private static void eliminaStudente() {
		// chiedo id all'utente
		Scanner s = new Scanner(System.in);
		System.out.println("Digita id studente da eliminare: ");
		int id = Integer.parseInt(s.nextLine());
		// chiamo metodo deleteById passando id
		if(!sdi.deleteById(id)) {
			System.out.println("Studente non eliminato");
		}
	}

	private static void cercaDaId() {
		// chiedo id all'utente
		Scanner s = new Scanner(System.in);
		System.out.println("Digita id studente da visualizzare: ");
		int id = Integer.parseInt(s.nextLine());
		// chiamo metodo getById passando id
		Product st = sdi.getById(id);
		// mostro i dati studente
		System.out.println("Dati dello studente con id: "+id);
		System.out.println( st );
	}

	private static void aggiungiStudente() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digita cognome nuovo studente: ");
		String c = s.nextLine();
		System.out.println("Digita nome nuovo studente: ");
		String n = s.nextLine();
		sdi.create( new Product(c,n) );
	}

	private static void vediStudenti() {
		List<Product> elenco = sdi.getAll();
		
		System.out.println("Elenco studenti:");
		for(Product s : elenco) {
			System.out.println( s );
		}
	}

}
