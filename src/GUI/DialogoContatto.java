package GUI;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogoContatto {
	
	private JTextField nome ,email ;
	private JComponent [] inputs ;
	
	public DialogoContatto() {
	// sicerano le componenti grafiche che andranno nella finestra di dialogo
	nome = new JTextField(20);
	email =new JTextField(20);
	inputs = new JComponent[]{
		new JLabel("Email "), email, new JLabel("Nome "), nome};
	}

	public String[] getInputs(String msg) {
		String[] res = new String[2];
		// si crea la finestra di dialogo
		int result = JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);// bloccato fino a quando c ’e ’ un evento Action ( ad esempio si preme OK o Cancel )
		if (result == JOptionPane.OK_OPTION) { 	// se si e ’ premuto OK
		// mettiamo le stringhe nei 2 JTextField nell ’ array che viene ritornata
		res[0] = email.getText(); 
		res[1]= nome.getText(); 
		return res;
		} else { 
			return null; 
		}
	}
}
