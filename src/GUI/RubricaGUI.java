package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.vista.RubricaPanel;
import modello.Rubrica;

public class RubricaGUI extends JFrame{
	
	public RubricaGUI(Rubrica model) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setBounds(100, 100, 550, 350);
			setTitle("Rubrica: " + model.getNome());
			
			JPanel rubricaPanel = (JPanel) new RubricaPanel(model);
			setContentPane(rubricaPanel);
			setVisible(true);
	}
}
