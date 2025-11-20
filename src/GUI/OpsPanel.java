package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpsPanel extends JPanel {
		public OpsPanel(ControlloRubrica controllo) {
		setLayout(new FlowLayout());
		JButton addContatto = new JButton("Aggiungi "); // aggiungiamo i bottoni
			// . . . . . . . . . . . . . . . . . .
		addContatto.addActionListener(controllo); // aggiungiamo il listener di evento Action
			// . . . . . . . . . . . . . . . . . . . .
		add(addContatto); // aggiungiamo i bottoni al pannello ( da sinistra a destra )
			// . . . . . . . . . . . . . . .
		}
}