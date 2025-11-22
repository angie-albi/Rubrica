package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.vista.RubricaPanel;
import modello.Rubrica;

public class RubricaGUI extends JFrame{
	
	public RubricaGUI(Rubrica model) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setBounds(100, 100, 450, 300);
			setTitle("Rubrica");
			
			JPanel rubricaPanel = (JPanel) new RubricaPanel(model);
			setContentPane(rubricaPanel);
			setVisible(true);
	}
}
