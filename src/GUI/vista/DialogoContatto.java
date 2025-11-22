package GUI.vista;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogoContatto {
	private JTextField nome, numTel;
	private JComponent[] inputs;

	public DialogoContatto() {
		nome = new JTextField(20);
		numTel = new JTextField(20);

		inputs = new JComponent[] { 
				new JLabel("Nome: "), nome, 
				new JLabel("Numero Telefonico: "), numTel
		};
	}

	//Aggiungi
	public String[] getInputs(String msg) {
		String[] res = new String[2];

		// Creazione della finestra di dialogo
		// bloccata fino a quando c’e un evento Action (si preme OK o Cancel)
		int result = JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			res[0] = nome.getText();
			res[1] = numTel.getText();
			return res;
		} else {
			return null;
		}
	}
	
	//Cerca
	public String[] getContatto(String msg) {
		String[] res = new String[1];

		int result = JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			res[0] = nome.getText();
			return res;
		} else {
			return null;
		}
	}
	
	
}