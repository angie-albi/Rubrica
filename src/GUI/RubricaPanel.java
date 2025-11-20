package GUI;

import javax.swing.JPanel;

import rubrica.Rubrica;

public class RubricaPanel extends JPanel {
	public RubricaPanel (Rubrica model) {
		// settate il layout a BorderLayout
		ContentPanel contenutoRubrica = new ContentPanel (model);
		ControlloRubrica controllo = new ControlloRubrica (contenutoRubrica, model);
		OpsPanel operazioniRubrica = new OpsPanel (controllo);
		
		// Aggiungere le componenti al pannello nelle posizioni giuste
		
	}
}