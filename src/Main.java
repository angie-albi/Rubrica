import GUI.RubricaGUI;
import modello.GestoreRubriche;
import modello.Rubrica;

public class Main {
	private static GestoreRubriche R = new GestoreRubriche();

	public static void main(String[] args) {
		R.createRubrica("Amici", 10);

		try {
			Rubrica Amici = R.selezionaRubrica("Amici");
			Amici.aggiungi("Marco", "+39 1231231234");
			Amici.aggiungi("Giorgio", "2342342345");
			Amici.aggiungi("Giulia", "3453453456");
			Amici.aggiungi("Marta", "4564564567");
			Amici.aggiungi("Ginny", "5675675678");

		} catch (Exception e) {
			System.out.println("RubricaException" + e.getMessage());
		}

		interfacciaGrafica();
//		interfacciaRigaComando();
	}

//	private static void interfacciaRigaComando() {
//
//	}

	private static void interfacciaGrafica() {
		new RubricaGUI(R.selezionaRubrica("Amici"));
	}

}