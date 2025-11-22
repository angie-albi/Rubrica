package GUI.vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.controllo.ControlloRubrica;
import modello.Rubrica;

public class RubricaPanel extends JPanel {

	public RubricaPanel(Rubrica model) {
		// Setting layout
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 15, 15, 15));

		// Creazione dei sottopannelli
		ContentPanel contenutoRubrica = new ContentPanel(model);
		ControlloRubrica controllo = new ControlloRubrica(contenutoRubrica, model);
		OpsPanel operazioniRubrica = new OpsPanel(controllo);

		// Aggiunta le componenti al pannello nelle posizioni giuste
		// bottoni in alto e lista al centro
		JPanel vistaRubrica = new JPanel();
		vistaRubrica.add(contenutoRubrica);
		add(vistaRubrica, BorderLayout.CENTER);
		add(operazioniRubrica, BorderLayout.NORTH);
	}

}