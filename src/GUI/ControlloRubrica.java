package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import rubrica.Rubrica;

public class ControlloRubrica implements ActionListener {
	private Rubrica model ;
	private ContentPanel view ;
	
	public ControlloRubrica(ContentPanel view, Rubrica model) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource(); // il cast !!
		if(source.getText().equals("Aggiungi: ")) { // da quale bottone arriva l ’ azione ?
			String[] inputs = new DialogoContatto().getInputs("Aggiungi Contatto ");
			if(inputs != null) {
				try { 
					model.aggiungi(inputs[0]);
				}
				catch (RubricaException e) { 
					System.out.println(e.getMessage ());
				}
			}
		}
		
		else if(source.getText().equals("Modifica: " )) {
			//............
		}
		else {
			//....
		}
		view.updateUI(); // dopo l ’ operazione la vista mostra la rubrica modificata .
	}
}
