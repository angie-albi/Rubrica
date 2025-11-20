package modello;

import java.util.ArrayList;

public class Rubrica{
	
	private ArrayList<String> rubrica;
	public final int MAX_DIM; // non si puo cambiare, quindi e final (e pubblica tanto nessuno puo cambiarla)
	private String nome;
	
	private static int numRubriche = 0;
	
	
	// COSTRUTTORE
	public Rubrica(String nome, int max_dim) {
		MAX_DIM = max_dim;
		this.nome = nome;
		rubrica = new ArrayList<String>();	
		numRubriche++;
	}

	// FUNZIONI
	// Restituisce il numero degli elementi presenti nella rubrica
	public int numEl() {
		return rubrica.size();
	}

	// Restiruisce il nome della Rubrica
	public String getNome() {
		return nome;
	}
	
	//Svuota la rubrica
	public void svuota() {
		rubrica.clear();
	}
	
	// Aggiunta di un contatto in rubrica
	public int aggiungi(String contatto) {
		if(rubrica.size() >= MAX_DIM)
			return -1;
		if(rubrica.contains(contatto)) 
			return 0;
		
		rubrica.add(contatto);
		return 1;
	}
	
	// Ricerca nei contatti della rubrica
	public ArrayList<String> ricerca(String prefisso) {
		ArrayList<String> ris = new ArrayList<String>();
		
		for(String next: rubrica) 
			if(next.startsWith(prefisso))
				ris.add(next);
		return ris;		
	}
	
	// Elimina contatto/i
	public boolean elimina(String prefisso) {
		return rubrica.removeAll(ricerca(prefisso));
	}
	
//	// Restituisce tutte l rubriche presenti
//	public ArrayList<String> tutteRubriche() {
//		ArrayList<String> ris = new ArrayList<String>();
//		
//		for(String next: nome)
//		
//	}
	
	
}

