package GUI.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.controllo.ControlloRubrica;

public class OpsPanel extends JPanel {
	
		public OpsPanel(ControlloRubrica controllo) {
			setLayout(new FlowLayout());
			
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
		}
		
}