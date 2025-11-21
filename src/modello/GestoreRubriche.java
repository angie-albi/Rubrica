package modello;

import java.util.ArrayList;

public class GestoreRubriche {
	private ArrayList<Rubrica> elencoRub;
	
	// COSTRUTTORE
	public GestoreRubriche() {
		this.elencoRub = new ArrayList<Rubrica>();
	}
	
	// FUNZIONI
	// Restituisce l'elenco delle Rubriche
	public ArrayList<Rubrica> getElenco() {
		return elencoRub;
	}
	
	// Crea una nuova Rubrica
	public void createRubrica(String nome, int max_dim) {
		Rubrica r = new Rubrica(nome, max_dim);
		elencoRub.add(r);
	}
	
	// Seleziona una Rubrica
	public Rubrica selezionaRubrica(String nome) {
		
		for (Rubrica r: elencoRub) {
			if(r.getNome().equals(nome)) {
				return r;
			}
		}
		
		return null;
	}
	
	// Elimina Rubrica
	public boolean deleteRubrica(String nome) {
		Rubrica ris = selezionaRubrica(nome);
		
		if(ris == null) {
			return false;
		}
		
		return elencoRub.remove(ris);
	}
	
	// Modifica nome Rubrica

	
	// Numero rubriche presenti
	public int numRub() {
		return elencoRub.size();
	}
	
	// Svuota Elenco
	public void svuotaElencoRub() {
		elencoRub.clear();
	}

}
