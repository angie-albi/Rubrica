package GUI.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import GUI.controllo.ControlloRubrica;
import modello.Rubrica;

public class RubricaPanel extends JPanel {

	public RubricaPanel(Rubrica model) {
		setLayout(new BorderLayout());
		
		// Vista e Controllo
		ContentPanel contenutoRubrica = new ContentPanel(model);
		ControlloRubrica controllo = new ControlloRubrica(contenutoRubrica, model);
		
		// Pannello Bottoni 
		OpsPanel operazioniRubrica = new OpsPanel(controllo);
		controllo.setOpsPanel(operazioniRubrica);
		
		add(contenutoRubrica, BorderLayout.CENTER);
		add(operazioniRubrica, BorderLayout.NORTH);
	}

}