package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import control.Controller;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;



public class DisdiciVisitaOnLine extends JFrame {

	private JPanel contentPane;
	private JTextField textField_descrizione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisdiciVisitaOnLine frame = new DisdiciVisitaOnLine();
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
	
	public DisdiciVisitaOnLine() {
		super(); 
	}
	
	
	
	public DisdiciVisitaOnLine(int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DisdiciVisitaOnLine.class.getResource("/source/ASL.png")));
		setTitle("Disdici Visita Online");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblData = new JLabel("Inserisci la Data della Prenotazione da disdire");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(34, 41, 406, 13);
		contentPane.add(lblData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(34, 64, 300, 19);
		contentPane.add(dateChooser);
		
		JLabel lblOrario = new JLabel("Inserisci l'orario della Prenotazione da disdire");
		lblOrario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrario.setBounds(34, 103, 406, 13);
		contentPane.add(lblOrario);
		
		String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
				"16:00", "17:00", "18:00", "19:00", "20:00"};
		JComboBox<String> comboBox = new JComboBox<String>(orari);
		comboBox.setBounds(34, 136, 294, 19);
		contentPane.add(comboBox);
		
		
//		textField_descrizione = new JTextField();
//		textField_descrizione.setBounds(34, 206, 294, 19);
//		contentPane.add(textField_descrizione);
//		textField_descrizione.setColumns(10);
		
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(34, 206, 294, 19);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);

		
		
		JButton disdiciButton = new JButton("  Disdici");
		disdiciButton.setIcon(new ImageIcon(DisdiciVisitaOnLine.class.getResource("/source/Disdici.png")));
		disdiciButton.setFocusPainted(false);
		disdiciButton.setBorderPainted(false);
		disdiciButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		disdiciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret;
				
				Controller controller = Controller.getInstance();
				Date date = new Date(dateChooser.getDate().getTime()); 
				
				System.out.println(comboBox.getSelectedItem().toString());
				Time time = Time.valueOf(LocalTime.parse(comboBox.getSelectedItem().toString())); 
				
				
				String descrizione = comboBox_descrizione.getSelectedItem().toString();
				// System.out.println(descrizione);
				
				try{

						controller.isDescrizioneVisitaValida(descrizione);
						controller.isDescrizioneVisitaValida1(descrizione);

				ret = controller.disdiciVisitaOnLine(id, date, time, descrizione);
				
				// r = -1 Errore della query 
				// r = 0 Visita non trovato
				// r = 1 Inserimento corretto
				
				System.out.println(ret);
				
				if(ret == 1) {
					
					JOptionPane.showMessageDialog(disdiciButton, "Operazione avvenuta con successo", "Avvenuta Disdetta", JOptionPane.PLAIN_MESSAGE);
					
				}
				else if (ret == 0) {JOptionPane.showMessageDialog(disdiciButton, "Prenotazione non esistente", "Errore", JOptionPane.ERROR_MESSAGE);} 
				else {
					JOptionPane.showMessageDialog(disdiciButton, "Errore Operazione", "Errore", JOptionPane.ERROR_MESSAGE);
				}

				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Descrizione non valida : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Descrizione non valida : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}	

			}
			
		});
		disdiciButton.setBounds(456, 275, 145, 48);
		contentPane.add(disdiciButton);
		
		JLabel lblNewLabel = new JLabel("Inserisci la Descrizione della Visita da disdire\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 185, 300, 13);
		contentPane.add(lblNewLabel);
	}
}

