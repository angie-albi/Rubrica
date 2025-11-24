package GUI.vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modello.GestoreRubriche;
import modello.Rubrica;

@SuppressWarnings("serial")
public class ListaRubrichePanel extends JPanel {
	
	private GestoreRubriche model;
	private JList<String> listaVisuale;
	private DefaultListModel<String> listModel;

	public ListaRubrichePanel(GestoreRubriche model) {
		this.model = model;
		setLayout(new BorderLayout());

		// Titolo
		JLabel titolo = new JLabel("Le tue Rubriche");
		titolo.setHorizontalAlignment(JLabel.CENTER);
		add(titolo, BorderLayout.NORTH);
		
		// Lista
		listModel = new DefaultListModel<>();
		listaVisuale = new JList<>(listModel);
		listaVisuale.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		add(new JScrollPane(listaVisuale), BorderLayout.CENTER);
		
		aggiorna();
	}

	public void aggiorna() {
		listModel.clear();
		for(Rubrica r : model.getElenco()) {
			listModel.addElement(r.getNome());
		}
	}
	
	// Metodo utile per il Controller per sapere cosa hai selezionato
	public String getRubricaSelezionata() {
		return listaVisuale.getSelectedValue();
	}
}
