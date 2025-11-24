package GUI.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import GUI.controllo.ControlloGestore;
import modello.GestoreRubriche;

public class GestorePanel extends JPanel {
	
	public GestorePanel(GestoreRubriche model) {
		setLayout(new BorderLayout());
		
		// 1. Creiamo la vista centrale (Lista)
		ListaRubrichePanel listaPanel = new ListaRubrichePanel(model);
		
		// 2. Creiamo il controllo (Logica), passandogli Modello e Vista
		ControlloGestore controllo = new ControlloGestore(listaPanel, model);
		
		// 3. Creiamo i bottoni collegandoli al controllo
		OpsGestorePanel bottoniPanel = new OpsGestorePanel(controllo);
		
		// 4. Assembliamo tutto
		add(listaPanel, BorderLayout.CENTER);
		add(bottoniPanel, BorderLayout.NORTH); 
	}
}
