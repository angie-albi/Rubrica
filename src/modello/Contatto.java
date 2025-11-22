package modello;

public class Contatto {
	
	private String nome;
	private String numTel;
	
	// COSTRUTTORE
	public Contatto(String nome, String numeroTel) {
		this.nome = nome;
		this.numTel = numeroTel;
	}

	// METODI
	// Restiruisce il nome del contatto
	public String getNome() {
		return nome;
	}

	// Restiruisce il numero del contatto
	public String getNumeroTel() {
		return numTel;
	}
	
	// Modifica Nome di un contatto
	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}
	
	// Modifica Numero Telefonico di un contatto
	public void setNumero(String nuovoNumero) {
		numTel = nuovoNumero;
	}
	
	// Stampa in modo leggibile
	@Override
    public String toString() {
        return nome + ": " + numTel;
    }
	
}
