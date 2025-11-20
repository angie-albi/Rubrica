package GUI;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rubrica.Rubrica;

public class ContentPanel extends JPanel {
	private Rubrica model;
	private JTextArea rubrica;
	
	public ContentPanel (Rubrica model) {
		this.model = model ;
		setLayout(new BorderLayout());
		rubrica = new JTextArea(10,20);
		rubrica.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		JLabel label = new JLabel("Contenuto Rubrica" + model.getNome());
		add(label, BorderLayout.NORTH);
		add(rubrica, BorderLayout.CENTER);
		//.......
	}
	//..........
}
