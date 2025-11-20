package GUI.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.vista.ContentPanel;
import GUI.vista.DialogoContatto;
import modello.Rubrica;

import javax.swing.JButton;

public class ControlloRubrica implements ActionListener {
	private Rubrica model;
	private ContentPanel view;
	
	
	public ControlloRubrica(ContentPanel view, Rubrica model) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if(source.getText().equals("Aggiungi")) {
			String[] inputs = new DialogoContatto().getInputs("Inserisci dati del contatto: ");
			
			if(inputs != null) {
				// Restituisce [0]=nome e [1]=numero telefonico
				// La Rubrica vuole una stringa. Formattiamo come "Nome = Numero Telefonico"
				String nuovoContatto = inputs[0] + " = " + inputs[1];
				
				try { 
					int risultato = model.aggiungi(nuovoContatto);
					
					if (risultato == 0) {
                        JOptionPane.showMessageDialog(null, "Contatto duplicato");
                    } else if (risultato == -1) {
                        JOptionPane.showMessageDialog(null, "Rubrica piena");
                    }
				}
				catch (Exception ex) { 
					ex.printStackTrace();
				}
			}
		} 
		else if(source.getText().equals("Cerca")) {
			String[] inputs = new DialogoContatto().getInputs("Inserisci il nome del contatto da cercare: ");
			
			if(inputs != null) {
				String nomeCerc = inputs[0];
			
				try { 
					ArrayList<String> risultato = model.ricerca(nomeCerc);
					
					if(!risultato.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nessun contatto trovato");
					}
				}
				catch (Exception ex) { 
					ex.printStackTrace();
				}
			}
		}  
		else if(source.getText().equals("Elimina - Nome")) {
			String[] inputs = new DialogoContatto().getInputs("Inserisci il nome del contatto da eliminare: ");
			
			if(inputs != null) {
				String nomeDelete = inputs[0];
				
				try { 
					boolean risultato = model.elimina(nomeDelete);
					
					if(!risultato) {
						JOptionPane.showMessageDialog(null, "Nessun contatto trovato per l'eliminazione");
					}
				}
				catch (Exception ex) { 
					ex.printStackTrace();
				}
			}
		}
		
		// Aggiornamento della GUI
		view.aggiorna();
	}
}
