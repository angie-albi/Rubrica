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
	public Rubrica createRubrica(String nome, int max_dim) {
		Rubrica r= new Rubrica(nome, max_dim);
		return r;
	}
	
	// Cerca una Rubrica
	public ArrayList<Rubrica> searchRubrica(String prefisso) {
		ArrayList<Rubrica> ris = new ArrayList<Rubrica>();
		
		for (Rubrica r: elencoRub) {
			if(r.getNome().toLowerCase().startsWith(prefisso.toLowerCase())) {
				ris.add(r);
			}
		}
		
		return ris;
	}
	
	// Elimina Rubrica/Rubriche
	public boolean deleteRubrica(String prefisso) {
		ArrayList <Rubrica> ris = searchRubrica(prefisso);
		
		if(ris.isEmpty()) {
			return false;
		}
		
		return elencoRub.removeAll(ris);
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
