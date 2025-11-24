package GUI.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.controllo.ControlloRubrica;
import modello.Rubrica;

public class RubricaPanel extends JPanel {

	public RubricaPanel(Rubrica model) {
		// Set Layout
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 15, 15, 15));
		
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