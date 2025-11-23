package GUI.vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modello.Contatto;
import modello.Rubrica;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel {
	private Rubrica model;
	private JTextArea areaContatti;

	public ContentPanel(Rubrica model) {
		this.model = model;
		setLayout(new BorderLayout());

		// Area di testo
		areaContatti = new JTextArea(15, 30);
		areaContatti.setEditable(false);
		areaContatti.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		// ScrollPane (Barra laterale)				
		JScrollPane scroll = new JScrollPane(areaContatti);
        
		// Titolo
		JLabel label = new JLabel("Rubrica: " + model.getNome());
		label.setHorizontalAlignment(JLabel.CENTER);
		
		// Aggiunta componenti
		add(label, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		// Carichiamo i contatti
		aggiorna();
	}

	public void aggiorna(String filtro) {
		areaContatti.setText("");
	    
		ArrayList<Contatto> contatti = model.ricerca(filtro);

	    if (contatti.isEmpty()) {
	        areaContatti.setText("\n\t(Nessun contatto trovato)");
	    } else {
	        for(Contatto c : contatti) {
	            areaContatti.append(" " + c.toString() + "\n");
	            areaContatti.append(" -------------------------\n");
	        }
	    }
	}

	public void aggiorna() {
	    aggiorna("");
	}
}
