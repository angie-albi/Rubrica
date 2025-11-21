import GUI.RubricaGUI;
import modello.Rubrica;

public class Main {
	private static Rubrica rubrica;
//	private static Rubrica rubrica1;
	
    public static void main(String[] args) {
    	rubrica = new Rubrica("Amici", 6);
 

    	try {
    		
    		rubrica.aggiungi("Marco", "+39 1231231234");
    		rubrica.aggiungi("Giorgio", "2342342345");
    		rubrica.aggiungi("Giulia", "3453453456");
    		rubrica.aggiungi("Marta", "4564564567");
    		rubrica.aggiungi("Ginny", "5675675678");
    		
    	} catch (Exception e) {
    		System.out.println("RubricaException" + e.getMessage());
    	}
    	
    	interfacciaGrafica();
		interfacciaRigaComando();
    }
    	
	private static void interfacciaRigaComando() {

	}

	private static void interfacciaGrafica() {
		new RubricaGUI(rubrica);
	}
    
}