package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JSpinner.DateEditor; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import control.Controller;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;



public class PrenotaVisitaOnLine extends JFrame {

	private JPanel contentPane;
	private JTextField textField_descrizione;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotaVisitaOnLine frame = new PrenotaVisitaOnLine();
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
	
	public PrenotaVisitaOnLine() {
		super(); 
	}
	
	public PrenotaVisitaOnLine(int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrenotaVisitaOnLine.class.getResource("/source/ASL.png"))); 
		setTitle("Prenota Visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 757, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(46, 59, 221, 19);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Inserisci la data della prenotazione ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(46, 32, 292, 17);
		contentPane.add(lblNewLabel);
		

		
		
//		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
//		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH");
//		timeSpinner.setEditor(timeEditor);
//		// timeSpinner.setValue(new java.util.Date()); // will only show the current time

		
		JLabel lblNewLabel_1 = new JLabel("Inserisci l'orario della prenotazione");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(46, 131, 258, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci la descrizione della Visita");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(46, 218, 242, 22);
		contentPane.add(lblNewLabel_2);
		
//		textField_descrizione = new JTextField();
//		textField_descrizione.setBounds(46, 250, 221, 19);
//		contentPane.add(textField_descrizione);
//		textField_descrizione.setColumns(10);
		
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(46, 250, 221, 19);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);
		
		String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
				"16:00", "17:00", "18:00", "19:00", "20:00"};
		JComboBox<String> comboBox = new JComboBox<String>(orari);
		comboBox.setBounds(46, 154, 221, 19);
		contentPane.add(comboBox);
		
		JButton prenotaButton = new JButton("  Prenota");
		prenotaButton.setIcon(new ImageIcon(PrenotaVisitaOnLine.class.getResource("/source/Prenota.png")));
		prenotaButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		prenotaButton.setFocusPainted(false);
		prenotaButton.setBorderPainted(false);
		prenotaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret;
				
				Controller controller = Controller.getInstance();
				
				Date date = new Date(dateChooser.getDate().getTime()); 
				
				//System.out.println(comboBox.getSelectedItem().toString());
				Time time = Time.valueOf(LocalTime.parse(comboBox.getSelectedItem().toString())); 
				
				
				String descrizione = comboBox_descrizione.getSelectedItem().toString();
				//System.out.println(descrizione);
				
				try{

					controller.isDescrizioneVisitaValida(descrizione);
					controller.isDescrizioneVisitaValida1(descrizione);

				ret = controller.prenotaVisitaOnLine(id, date, time, descrizione); 
				
				// r = -1 Errore della query 
				// r = 0 Visita non trovata
				// r = 1 Inserimento corretto
				
				System.out.println(ret);
				
				if(ret == 1) {
					
					JOptionPane.showMessageDialog(prenotaButton, "Prenotazione avvenuta con successo", "Avvenuta Prenotazione", JOptionPane.PLAIN_MESSAGE);
					
				}
				else if(ret == 0) {
					
					JOptionPane.showMessageDialog(prenotaButton, "Nessuna visita disponibile", "Errore", JOptionPane.ERROR_MESSAGE);
					
				}
				else {
					JOptionPane.showMessageDialog(prenotaButton, "Errore Prenotazione", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				
				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Descrizione non valida : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Descrizione non valida : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}	

				}
			
		});
		prenotaButton.setBounds(520, 317, 132, 51);
		contentPane.add(prenotaButton);

//		
		
		
	}
}
