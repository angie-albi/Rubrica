package GUI.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import GUI.controllo.ControlloRubrica;
import modello.Rubrica;

public class RubricaPanel extends JPanel {
	
	public RubricaPanel (Rubrica model) {
		// Setting layout
		setLayout(new BorderLayout());
		
		// Creazione dei sottopannelli
		ContentPanel contenutoRubrica = new ContentPanel(model);
		ControlloRubrica controllo = new ControlloRubrica(contenutoRubrica, model);
		OpsPanel operazioniRubrica = new OpsPanel(controllo);
		
		// Aggiunta le componenti al pannello nelle posizioni giuste
		// Lista al centro e bottoni in alto
		add(contenutoRubrica, BorderLayout.CENTER);
		add(operazioniRubrica, BorderLayout.NORTH);
	}
	
}