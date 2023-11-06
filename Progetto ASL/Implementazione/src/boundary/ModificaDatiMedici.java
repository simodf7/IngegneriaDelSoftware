package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Controller;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.SpecializzazioneNonValida;
import exceptions.SpecializzazioneNonValida1;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.LocalTime;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ModificaDatiMedici extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cognome;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBox_giorni;
	private JComboBox comboBox_orari;
	private JLabel lblInserisciLorarioDella;
	private JLabel lblInserisciLaDescrizione;
	private JTextField textField_descrizione;
	private JButton modificaButton;
	private JLabel lblNewLabel_3;
	private JTextField textField_specializzazione;
	private JTable table;
	private int ret; 
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaDatiMedici frame = new ModificaDatiMedici();
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
	public ModificaDatiMedici() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaDatiMedici.class.getResource("/source/ASL.png")));
		setTitle("Modifica Dati Medici");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 733);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		JLabel lblNewLabel = new JLabel("Inserisci il nome del medico che vuoi modificare");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(42, 22, 426, 13);
		contentPane.add(lblNewLabel);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(42, 44, 290, 19);
		textField_nome.setEditable(true);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il cognome del medico che vuoi modificare");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(42, 73, 347, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_cognome = new JTextField();
		textField_cognome.setBounds(42, 90, 290, 19);
		contentPane.add(textField_cognome);
		textField_cognome.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Inserisci il giorno della Visita");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(44, 227, 201, 19);
		contentPane.add(lblNewLabel_2);
		
		
		String[] giorni = {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
		comboBox_giorni = new JComboBox<String>(giorni);
		comboBox_giorni.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_giorni.setBounds(41, 256, 254, 21);
		contentPane.add(comboBox_giorni);
		
		String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
				"16:00", "17:00", "18:00", "19:00", "20:00"};
		comboBox_orari = new JComboBox<String>(orari);
		comboBox_orari.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_orari.setBounds(330, 256, 254, 21);
		contentPane.add(comboBox_orari);
		
		lblInserisciLorarioDella = new JLabel("Inserisci l'orario della Visita");
		lblInserisciLorarioDella.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInserisciLorarioDella.setBounds(330, 230, 195, 13);
		contentPane.add(lblInserisciLorarioDella);
		
		lblInserisciLaDescrizione = new JLabel("Inserisci la descrizione della Visita");
		lblInserisciLaDescrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInserisciLaDescrizione.setBounds(653, 230, 233, 13);
		contentPane.add(lblInserisciLaDescrizione);
		
//		textField_descrizione = new JTextField();
//		textField_descrizione.setColumns(10);
//		textField_descrizione.setBounds(653, 257, 254, 21);
//		contentPane.add(textField_descrizione);
		
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(653, 257, 254, 21);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);

		
		
		DefaultTableModel model = new DefaultTableModel( new Object[][] {}, new String[] {"ID", "Giorno", "Ora", "Descrizione"});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 327, 1029, 316);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		modificaButton = new JButton("  Modifica");
		modificaButton.setIcon(new ImageIcon(ModificaDatiMedici.class.getResource("/source/Modify.png")));
		modificaButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		modificaButton.setFocusPainted(false);
		modificaButton.setBorderPainted(false);
		modificaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					int ret; 
					Controller controller = Controller.getInstance();
					String giorno = comboBox_giorni.getSelectedItem().toString(); 
					String orario = comboBox_orari.getSelectedItem().toString();
					String descrizione = comboBox_descrizione.getSelectedItem().toString();
					
					try {
							
							controller.isDescrizioneVisitaValida(descrizione);
							controller.isDescrizioneVisitaValida1(descrizione);
					
							int idVisita = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()); 
							
							model.setValueAt(giorno, table.getSelectedRow(),1);
							model.setValueAt(orario, table.getSelectedRow(),2);
							model.setValueAt(descrizione, table.getSelectedRow(),3);
							
							ret = controller.modificaVisita(idVisita, giorno, Time.valueOf(LocalTime.parse(orario)), descrizione);
							
							System.out.println(ret);
							
							if(ret == 1) {
								JOptionPane.showMessageDialog(modificaButton, "Modifica avvenuta con successo", "Avvenuto Login", JOptionPane.PLAIN_MESSAGE);
								
							}
							else {
								JOptionPane.showMessageDialog(modificaButton, "Errore modifica", "Errore", JOptionPane.ERROR_MESSAGE);
							}	
				
					}catch (DescrizioneVisitaNonValida ex) {
						JOptionPane.showMessageDialog(modificaButton, "Descrizione non valida: troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (DescrizioneVisitaNonValida1 ex) {
						JOptionPane.showMessageDialog(modificaButton, "Descrizione non valida: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		modificaButton.setBounds(977, 226, 143, 51);
		contentPane.add(modificaButton);
		
		lblNewLabel_3 = new JLabel("Inserisci la specializzazione del medico che vuoi modificare");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(42, 127, 393, 13);
		contentPane.add(lblNewLabel_3);
		
//		textField_specializzazione = new JTextField();
//		textField_specializzazione.setBounds(42, 150, 281, 19);
//		contentPane.add(textField_specializzazione);
//		textField_specializzazione.setColumns(10);
		
		JComboBox<String> comboBox_specializzazione = new JComboBox<String>(); 
		comboBox_specializzazione.setBounds(42, 150, 281, 19);
		comboBox_specializzazione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_specializzazione.setModel(new DefaultComboBoxModel(new String[] {  "Cardiologia", "Ortopedia", "Neurologia", "Gastroenterologia", "Oculistica",
				"Otorinolaringoiatria", "Urologia", "Ginecologia"} ));
		contentPane.add(comboBox_specializzazione);
		
		

		
		JButton btnCerca = new JButton(" Cerca");
		btnCerca.setIcon(new ImageIcon(ModificaDatiMedici.class.getResource("/source/CercaMedico.png")));
		btnCerca.setFocusPainted(false);
		btnCerca.setBorderPainted(false);
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Controller controller = Controller.getInstance();
				String nome = textField_nome.getText();
				String cognome = textField_cognome.getText();
				String specializzazione = comboBox_specializzazione.getSelectedItem().toString();
				
				
				try {
					
					controller.isNomeValido(nome);
					controller.isNomeValido1(nome);
					controller.isCognomeValido(cognome);
					controller.isCognomeValido1(cognome);
					controller.isSpecializzazioneValida(specializzazione);
					controller.isSpecializzazioneValida1(specializzazione);
					
			
							
						String[][] data = controller.cercaDatiVisite(nome,cognome,specializzazione);
						System.out.println(data.length);
						for(int i=0; i<data.length; i++) {
							model.addRow(data[i]);
						}
						
	
						
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								
								String giorno = table.getModel().getValueAt(table.getSelectedRow(), 1).toString(); 
								String orario = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().substring(0, 5);
								String descrizione = table.getValueAt(table.getSelectedRow(),3).toString();
								
								comboBox_giorni.setSelectedItem(giorno);
								comboBox_orari.setSelectedItem(orario);
								comboBox_descrizione.setSelectedItem(descrizione);
								
								
								
								
							}
						});
			
				
				}catch (NomeNonValido ex) {
					JOptionPane.showMessageDialog(btnCerca, "Nome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NomeNonValido1 ex) {
					JOptionPane.showMessageDialog(btnCerca, "Nome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido ex) {
					JOptionPane.showMessageDialog(btnCerca, "Cognome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido1 ex) {
					JOptionPane.showMessageDialog(btnCerca, "Cognome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (SpecializzazioneNonValida ex) {
					JOptionPane.showMessageDialog(btnCerca, "Specializzazione non valida: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (SpecializzazioneNonValida1 ex) {
					JOptionPane.showMessageDialog(btnCerca, "Specializzazione non valida: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnCerca.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerca.setBounds(507, 127, 133, 42);
		contentPane.add(btnCerca);
		
		
	
		
		
	}
}
