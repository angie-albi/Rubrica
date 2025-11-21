package modello;

public class Contatto {
	
	private String nome;
	private String numTel;
	
	// COSTRUTTORE
	public Contatto(String nome, String numeroTel) {
		this.nome = nome;
		this.numTel = numeroTel;
	}

	// FUNZIONI
	// Restiruisce il nome del contatto
	public String getNome() {
		return nome;
	}

	// Restiruisce il numero del contatto
	public String getNumeroTel() {
		return numTel;
	}
	
	// Modifica Numero Telefonico di un contatto
	
	
	// Modifica Nome di un contatto
	
	
	// Stampa in modo leggibile
	@Override
    public String toString() {
        return nome + " : " + numTel;
    }
	
}
