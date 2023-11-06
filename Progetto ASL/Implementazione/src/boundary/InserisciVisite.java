package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Controller;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class InserisciVisite extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciVisite frame = new InserisciVisite();
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

	public InserisciVisite() {
	// TODO Auto-generated constructor stub
	super();
}
	
	
	
	public InserisciVisite(int id) {
		setTitle("Inserisci Visite");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciVisite.class.getResource("/source/ASL.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 933, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox_giorni = new JComboBox<String>();
		comboBox_giorni.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_giorni.setModel(new DefaultComboBoxModel(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi","Sabato"}));
		comboBox_giorni.setBounds(39, 57, 254, 21);
		contentPane.add(comboBox_giorni);
		
		String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
				"16:00", "17:00", "18:00", "19:00", "20:00"};
		JComboBox<String> comboBox_orari = new JComboBox<String>(orari);
		comboBox_orari.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_orari.setBounds(39, 132, 254, 21);
		contentPane.add(comboBox_orari);
		
		JLabel lblNewLabel = new JLabel("Inserisci il giorno della Visita da inserire per il nuovo medico");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(39, 34, 394, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblInserisciLorarioDella = new JLabel("Inserisci l'orario della Visita da inserire per il nuovo medico");
		lblInserisciLorarioDella.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInserisciLorarioDella.setBounds(39, 109, 416, 13);
		contentPane.add(lblInserisciLorarioDella);
		
		JLabel lblInserisciLaDescrizione = new JLabel("Inserisci la descrizione della Visita");
		lblInserisciLaDescrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInserisciLaDescrizione.setBounds(39, 180, 233, 13);
		contentPane.add(lblInserisciLaDescrizione);

		JComboBox<String> comboBox_descrizione = new JComboBox<String>();
		comboBox_descrizione.setBounds(39, 203, 254, 27);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] { "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);
		
		
		//DefaultTableModel model = new DefaultTableModel(null, new String[] {"Giorno", "Ora", "Descrizione"}); 

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 307, 631, 208);
		contentPane.add(scrollPane);
		
		// String[][] data = Controller.cercaDatiVisite(id);
	
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},new String[] {"Giorno", "Ora", "Descrizione"}); 
		table.setModel(model);
		
		JButton aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setIcon(new ImageIcon(InserisciVisite.class.getResource("/source/AddVisita.png")));
		aggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		aggiungiButton.setFocusPainted(false);
		aggiungiButton.setBorderPainted(false);
		aggiungiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int ret;
				
				Controller controller = Controller.getInstance();
				String giorno = comboBox_giorni.getSelectedItem().toString();
				String ora = comboBox_orari.getSelectedItem().toString();
				Time orario = Time.valueOf(LocalTime.parse(ora)); 
				String descrizione = comboBox_descrizione.getSelectedItem().toString();
				
				try {
				
					controller.isDescrizioneVisitaValida(descrizione);
					controller.isDescrizioneVisitaValida1(descrizione);
				
					ret = controller.inserisciVisita(giorno,orario,descrizione,id);
					
					
					if(ret == 1) {
						
						JOptionPane.showMessageDialog(aggiungiButton, "Inserimento avvenuto con successo", "Avvenuto Inserimento", JOptionPane.PLAIN_MESSAGE);
						model.addRow(new Object[] {giorno,ora,descrizione}); 
					}
					else {
						
						JOptionPane.showMessageDialog(aggiungiButton, "Inserimento non e' andato a buon fine", "Errore", JOptionPane.ERROR_MESSAGE);
	
					}
				
				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(aggiungiButton, "Descrizione non valida: troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(aggiungiButton, "Descrizione non valida: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
		});
		aggiungiButton.setBounds(412, 183, 149, 47);
		contentPane.add(aggiungiButton);
		
		JLabel lblNewLabel_1 = new JLabel("Quando aggiugi una nuova visita, potrai visualizzarla nella tabella sottostante");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(39, 284, 617, 13);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
