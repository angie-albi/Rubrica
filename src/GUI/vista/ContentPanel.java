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

		// Area di testo non modificabile dall'utente
		areaContatti = new JTextArea(10, 20);
		areaContatti.setEditable(false);
		areaContatti.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		// Scorrimento 
		JScrollPane scrollPane = new JScrollPane(areaContatti);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        // Titolo
		JLabel label = new JLabel("Rubrica " + model.getNome());
		add(areaContatti, BorderLayout.CENTER);
		
		add(label, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		// Corichiamo i contatti
		aggiorna();
	}

	public void aggiorna() {
		// Mostra tutti i contatti tramite la ricerca
		ArrayList<Contatto> contatti = model.ricerca("");

		if (contatti.isEmpty()) {
            areaContatti.setText("\n  (Nessun contatto presente)");
        } else {
            // Ciclo for-each: per ogni Contatto 'c' nella lista
            for(Contatto c : contatti) {
                // c.toString() restituisce "Nome: Numero" (definito nel Modello)
                areaContatti.append(" " + c.toString() + "\n");
                areaContatti.append(" -------------------------\n"); // Separatore estetico
            }
        }
		
//		areaContatti.setText("NOME\tNUMERO TELEFONICO\n");
//		for (Contatto c : contatti) {
//			areaContatti.append(c.getNome() + "\t" + c.getNumeroTel() + "\n");
//		}

	}
}
