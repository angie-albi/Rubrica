package GUI.vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modello.Contatto;
import modello.Rubrica;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel {
	private Rubrica model;
	private JTextArea rubrica;

	public ContentPanel(Rubrica model) {
		this.model = model;
		setLayout(new BorderLayout());

		// Area di testo non modificabile dall'utente
		rubrica = new JTextArea(10, 20);
		rubrica.setEditable(false);
		rubrica.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		JLabel label = new JLabel("Contenuto Rubrica " + model.getNome());

		add(label, BorderLayout.NORTH);
		add(rubrica, BorderLayout.CENTER);

		aggiorna();
	}

	public void aggiorna() {
		// Mostra tutti i contatti tramite la ricerca
		ArrayList<Contatto> contatti = model.ricerca("");

		rubrica.setText("NOME\tNUMERO TELEFONICO\n");
		for (Contatto c : contatti) {
			rubrica.append(c.getNome() + "\t" + c.getNumeroTel() + "\n");
//			rubrica.append(c.toString());
		}

	}
}
