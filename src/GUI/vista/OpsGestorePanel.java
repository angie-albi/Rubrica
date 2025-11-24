package GUI.vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.controllo.ControlloGestore;

public class OpsGestorePanel extends JPanel {

	private JButton resetRicerca;

	public OpsGestorePanel(ControlloGestore controllo) {

		// AGGIUNTA RUBRICA
		JButton addRubrica = new JButton("Aggiungi");
		addRubrica.addActionListener(controllo);
		add(addRubrica);
		
		// SELEZIONA
		JButton openRubrica = new JButton("Apri");
		openRubrica.addActionListener(controllo);
		add(openRubrica);
		
		// MODIFICA NOME RUBRICA
		JButton editRubrica = new JButton("Rinomina");
		editRubrica.addActionListener(controllo);
		add(editRubrica);

		// ELIMINA RUBRICA
		JButton deleteRubrica = new JButton("Elimina");
		deleteRubrica.addActionListener(controllo);
		add(deleteRubrica);

		// ANNULLA RICERCA
		resetRicerca = new JButton("Annulla Ricerca");
		resetRicerca.addActionListener(controllo);
		resetRicerca.setVisible(false); // nascosto all'inizio
		add(resetRicerca);
		
	}

	// Metodo che il Controller userà per far apparire/sparire il bottone
	public void mostraBottoneReset(boolean visibile) {
		resetRicerca.setVisible(visibile);
	}

}
