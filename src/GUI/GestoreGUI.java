package GUI;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import GUI.vista.GestorePanel;
import modello.GestoreRubriche;

public class GestoreGUI extends JFrame{
	
	public GestoreGUI(GestoreRubriche gestore) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		
		setTitle("Gestore Rubriche");
		
		GestorePanel mainPanel = new GestorePanel(gestore);
		setContentPane(mainPanel);
		
		setVisible(true);
	}
}
