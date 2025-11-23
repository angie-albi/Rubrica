package GUI.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.vista.ContentPanel;
import GUI.vista.DialogoContatto;
import GUI.vista.OpsPanel;
import modello.Contatto;
import modello.Rubrica;

import javax.swing.JButton;

public class ControlloRubrica implements ActionListener {
	private Rubrica model;
	private ContentPanel view;
	private OpsPanel opsView;

	public ControlloRubrica(ContentPanel view, Rubrica model) {
		this.model = model;
		this.view = view;
	}
	
	// Metodo Setter per collegare l'OpsPanel DOPO che è stato creato
	public void setOpsPanel(OpsPanel opsView) {
		this.opsView = opsView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		// Aggiungi
		if (source.getText().equals("Aggiungi")) {
			String[] inputs = new DialogoContatto().getInputs("Inserisci dati del contatto ");

			if (inputs != null && !inputs[0].isEmpty()) {
				try {
					// [0]=nome e [1]=numero telefonico
					int risultato = model.aggiungi(inputs[0], inputs[1]);

					if (risultato == 0) {
						JOptionPane.showMessageDialog(null, "Contatto duplicato");
					} else if (risultato == -1) {
						JOptionPane.showMessageDialog(null, "Rubrica piena");
					}

					view.aggiorna();
					if(opsView != null) {
						opsView.mostraBottoneReset(false);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		// Cerca
		else if (source.getText().equals("Cerca")) {
			String nomeCerc = JOptionPane.showInputDialog(null, "Nome: ", "Inserisci il contatto da cercare ", JOptionPane.QUESTION_MESSAGE);

			if(nomeCerc != null) {
				view.aggiorna(nomeCerc);
				if(opsView != null) {
					opsView.mostraBottoneReset(true);
				}
			}
		}
		// Elimina - nome
		else if (source.getText().equals("Elimina - Nome")) {
			String nomeElim = JOptionPane.showInputDialog(null, "Nome: ", "Inserisci il contatto da eliminare ", JOptionPane.QUESTION_MESSAGE);

			if (nomeElim != null && !nomeElim.isEmpty()) {

				try {
					boolean risultato = model.elimina(nomeElim);

					if (!risultato) {
						JOptionPane.showMessageDialog(null, "Nessun contatto trovato per l'eliminazione");
					}
					else {
						JOptionPane.showMessageDialog(null, "Eliminazione completata");
						view.aggiorna();
						if(opsView != null) {
							opsView.mostraBottoneReset(false);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		// Annulla Ricerca
		else if(source.getText().equals("Annulla Ricerca")) {
			view.aggiorna(); 
			
			if(opsView != null) opsView.mostraBottoneReset(false);
		}
	}
}
