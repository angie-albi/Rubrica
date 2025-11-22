package modello;

import java.util.ArrayList;

public class Rubrica{
	
	private ArrayList<Contatto> contatti;
	public final int MAX_DIM; // non si puo cambiare, quindi e final (e pubblica tanto nessuno puo cambiarla)
	private String nomeRub;
	
	
	// COSTRUTTORE
	public Rubrica(String nome, int max_dim) {
		this.MAX_DIM = max_dim;
		this.nomeRub = nome;
		this.contatti = new ArrayList<Contatto>();	
	}

	// FUNZIONI
	// Restituisce il numero degli elementi presenti nella rubrica
	public int numEl() {
		return contatti.size();
	}

	// Restiruisce il nome della Rubrica
	public String getNome() {
		return nomeRub;
	}
	
	// Modifica nome della Rubrica
	public void setNome(String nuovoNome) {
		nomeRub = nuovoNome;
	}
	
	// Restituisce tutti i contatti
	public ArrayList<Contatto> getContatti() {
		return contatti;
	}
	
	// Svuota la rubrica
	public void svuota() {
		contatti.clear();
	}
	
	// Aggiunta di un contatto
	public int aggiungi(String nome, String numTel) {
		if(contatti.size() >= MAX_DIM) {
			return -1;
		}
		
		for(Contatto c: contatti) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				return 0;
			}
		}
	
		Contatto nuovo = new Contatto(nome, numTel);
		contatti.add(nuovo);
		return 1;
	}
	
	// Ricerca di un contatto
	public ArrayList<Contatto> ricerca(String prefisso) {
		ArrayList<Contatto> ris = new ArrayList<Contatto>();
		
		for(Contatto c: contatti) {
			if(c.getNome().toLowerCase().startsWith(prefisso.toLowerCase())) {
				ris.add(c);
			}
		}
		
		return ris;		
	}
	
	// Elimina contatto/i
	public boolean elimina(String prefisso) {
		ArrayList<Contatto> elimina = ricerca(prefisso);
		
		if(elimina.isEmpty()) {
			return false;
		}
		return contatti.removeAll(elimina);
	}
	
	// Aggiorna un contatto esistente
	public boolean modificaContatto(String vecchioNome, String nuovoNome, String nuovoNumero) {
	    ArrayList<Contatto> trovati = ricerca(vecchioNome);
	    if (trovati.isEmpty()) {
	    	return false;
	    }
	    
	    Contatto c = trovati.get(0); //Assumiamo che sia il primo
	    
	    c.setNome(nuovoNome);
	    c.setNumero(nuovoNumero);
	    return true;
	}
	
}