package GUI.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.controllo.ControlloRubrica;

public class OpsPanel extends JPanel {
	
	private JButton resetRicerca;

	public OpsPanel(ControlloRubrica controllo) {
	
		// AGGIUNTA CONTATTO
		JButton addContatto = new JButton("Aggiungi");
		addContatto.addActionListener(controllo);
		add(addContatto);

		// RICERCA CONTATTO
		JButton searchContatto = new JButton("Cerca");
		searchContatto.addActionListener(controllo);
		add(searchContatto);

		// ELIMINA CONTATTO - tramite nome
		JButton deleteContatto = new JButton("Elimina - Nome");
		deleteContatto.addActionListener(controllo);
		add(deleteContatto);
		
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