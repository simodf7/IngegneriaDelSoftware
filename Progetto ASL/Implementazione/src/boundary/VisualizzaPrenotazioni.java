package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class VisualizzaPrenotazioni extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//private JTable table;
	//private JTable table; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaPrenotazioni frame = new VisualizzaPrenotazioni();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizzaPrenotazioni() {
		super();
	}
	
	
	
	public VisualizzaPrenotazioni(String [][] data) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaPrenotazioni.class.getResource("/source/ASL.png")));
		setTitle("Visualizza Prenotazioni");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 965, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 42, 864, 372);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"Data Prenotazione", "Orario Prenotazione", "Descrizione Visita", "Piano", "Stanza", "Nome paziente", "Cognome Paziente"
			}
		));

		
		
		
	
		
		
	}
}
