package GUI.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.RubricaGUI;
import GUI.vista.ContentPanel;
import GUI.vista.DialogoContatto;
import GUI.vista.ListaRubrichePanel;
import GUI.vista.OpsGestorePanel;
import GUI.vista.OpsPanel;
import modello.GestoreRubriche;
import modello.Rubrica;

public class ControlloGestore implements ActionListener{

	private GestoreRubriche model;
	private ListaRubrichePanel view;
	private OpsGestorePanel opsView;

	public ControlloGestore(ListaRubrichePanel view, GestoreRubriche model) {
		this.model = model;
		this.view = view;
	}
	
	// Metodo Setter per collegare l'OpsPanel DOPO che è stato creato
	public void setOpsPanel(OpsGestorePanel opsView) {
		this.opsView = opsView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		// Aggiungi
		if (source.getText().equals("Aggiungi")) {
			String nome= JOptionPane.showInputDialog(null, "Nome della Rubrica: ", "Aggiungi ", JOptionPane.QUESTION_MESSAGE);
			if (nome != null && !nome.isEmpty()) {
				// Creiamo rubrica dimensione 20 di default
				model.createRubrica(nome, 20); 
				view.aggiorna();
				
				if(opsView != null) 
					opsView.mostraBottoneReset(false);
			}
		}
		// Seleziona
		else if (source.getText().equals("Apri")) {
			String nomeSelezionato = view.getRubricaSelezionata();
			
			if (nomeSelezionato != null) {
				Rubrica r = model.selezionaRubrica(nomeSelezionato);
				// Apriamo la Rubrica
				new RubricaGUI(r);
			} else {
				JOptionPane.showMessageDialog(null, "Seleziona una rubrica dalla lista!");
			}
		}
		// Elimina
		else if (source.getText().equals("Elimina")) {
			String nomeSelezionato = view.getRubricaSelezionata();
			
			if (nomeSelezionato != null) {
				int conferma = JOptionPane.showConfirmDialog(null, "Vuoi davvero eliminare la rubrica " + nomeSelezionato + "?");
				
				if(conferma == JOptionPane.YES_OPTION) {
					model.deleteRubrica(nomeSelezionato);
					view.aggiorna();
					
					if(opsView != null) 
						opsView.mostraBottoneReset(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Seleziona una rubrica da eliminare!");
			}
		}
		// Modifica
		else if(source.getText().equals("Rinomina")) {
			String nomeSelezionato = view.getRubricaSelezionata();
			
			if (nomeSelezionato != null) {
				String nuovoNome= JOptionPane.showInputDialog(null, "Nuovo nome della rubrica: ", "Rinomina ", JOptionPane.QUESTION_MESSAGE);
				model.rinominaRubrica(nomeSelezionato, nuovoNome);
				view.aggiorna();
				
				if(opsView != null) 
					opsView.mostraBottoneReset(false);
			} else {
				JOptionPane.showMessageDialog(null, "Seleziona una rubrica da modificare!");
			}
		}
		// Annulla Ricerca
		else if(source.getText().equals("Annulla Ricerca")) {
			view.aggiorna(); 
			
			if(opsView != null) 
				opsView.mostraBottoneReset(false);
		}
	}
}
