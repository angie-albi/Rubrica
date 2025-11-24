import GUI.GestoreGUI;       
import modello.GestoreRubriche;
import modello.Rubrica;

public class Main {

	public static void main(String[] args) {
		// Inizializzazione del gestore 
		GestoreRubriche gestore = new GestoreRubriche();
		
		// Creiamo le rubriche.
		gestore.createRubrica("Amici", 10);
		gestore.createRubrica("Famiglia", 15);
		gestore.createRubrica("Colleghi", 6);
		

		// 3. Popoliamo la rubrica "Amici"
		try {
			Rubrica amici = gestore.selezionaRubrica("Amici"); 
			
			if (amici != null) {
				amici.aggiungi("Marco", "+39 1231231234");
				amici.aggiungi("Giorgio", "2342342345");
				amici.aggiungi("Giulia", "3453453456");
				amici.aggiungi("Marta", "4564564567");
				amici.aggiungi("Ginny", "5675675678");
			}
			
			Rubrica colleghi = gestore.selezionaRubrica("Colleghi"); 
			
			if (colleghi != null) {
				colleghi.aggiungi("Tim", "1231231234");
				colleghi.aggiungi("Dapp", "2342342345");
				colleghi.aggiungi("Ricky", "3453453456");
				colleghi.aggiungi("Luca", "4564564567");
				colleghi.aggiungi("Teo", "5675675678");
			}


		} catch (Exception e) {
			System.out.println("RubricaException: " + e.getMessage());
		}

		// Lancio del'interfaccia grafica
		interfacciaGrafica(gestore);
//		interfacciaRigaComando();

	}

//	private static void interfacciaRigaComando() {
//	
//	}

	private static void interfacciaGrafica(GestoreRubriche gestore) {
		new GestoreGUI(gestore);
	}

}