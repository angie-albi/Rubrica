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

			if (inputs != null && !inputs[0].isEmpty() && !inputs[1].isEmpty()) {
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
			String nomeCerc = JOptionPane.showInputDialog(null, "Nome del contatto da cercare: ", "Cerca ", JOptionPane.QUESTION_MESSAGE);

			if(nomeCerc != null) {
				view.aggiorna(nomeCerc);
				if(opsView != null) {
					opsView.mostraBottoneReset(true);
				}
			}
		}
		// Elimina
		else if (source.getText().equals("Elimina")) {
			String nomeElim = JOptionPane.showInputDialog(null, "Nome del contatto da eliminare: ", "Eliminare", JOptionPane.QUESTION_MESSAGE);

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
		// Modifica
		else if(source.getText().equals("Modifica")) {
			String nomeEdit = JOptionPane.showInputDialog(null, "Nome del contatto da modificare: ", "Modifica ", JOptionPane.QUESTION_MESSAGE);
			
			if (nomeEdit != null && !nomeEdit.isEmpty()) {
				String[] nuoviDati = new DialogoContatto().getInputs("Inserisci i NUOVI dati per " + nomeEdit);
				
				if(nuoviDati != null) {
					try {
						boolean risultato = model.modificaContatto(nomeEdit, nuoviDati[0], nuoviDati[1]);
	
						if (!risultato) {
							JOptionPane.showMessageDialog(null, "Nessun contatto trovato per la modifica");
						}
						else {
							JOptionPane.showMessageDialog(null, "Modifica completata");
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
		}
		// Annulla Ricerca
		else if(source.getText().equals("Annulla Ricerca")) {
			view.aggiorna(); 
			
			if(opsView != null) opsView.mostraBottoneReset(false);
		}
	}
}
