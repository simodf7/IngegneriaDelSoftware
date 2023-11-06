package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import control.Controller;
import exceptions.CfNonValido;
import exceptions.CfNonValido1;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;
import exceptions.EmailNonValida;
import exceptions.LuogoNascitaNonValido;
import exceptions.LuogoNascitaNonValido1;
import exceptions.LuogoResidenzaNonValido;
import exceptions.LuogoResidenzaNonValido1;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;
import exceptions.TelefonoNonValido;
import exceptions.TelefonoNonValido1;
import exceptions.UsernameNonValido;

import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;



public class PrenotaVisita extends JFrame {

	private JPanel contentPane;
	// private JTextField textField_descrizione; 
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_Cf;
	private JTextField textField_Nascita;
	private JTextField textField_Residenza;
	private JTextField textField_Telefono;
	private JTextField textField_Email;
	private JTextField textField_Username;
	private JPasswordField passwordField;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblcf;
	private JLabel lblData;
	private JLabel lblNascita;
	private JLabel lblResidenza;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblUsername;
	private JLabel lblPassword; 
	private JDateChooser dateChooser_DataNascita;
	private int idVisita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotaVisita frame = new PrenotaVisita();
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
	public PrenotaVisita() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrenotaVisita.class.getResource("/source/ASL.png")));
		setTitle("Prenota Visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1373, 685);
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
		

		

		
		JLabel lblNewLabel_1 = new JLabel("Inserisci l'orario della prenotazione");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(337, 34, 258, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci la descrizione della Visita");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(656, 29, 242, 22);
		contentPane.add(lblNewLabel_2);
		
//		textField_descrizione = new JTextField();
//		textField_descrizione.setBounds(656, 59, 221, 19);
//		contentPane.add(textField_descrizione);
//		textField_descrizione.setColumns(10);
		
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(656, 59, 221, 19);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);
		
		
		String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
				"16:00", "17:00", "18:00", "19:00", "20:00"};
		JComboBox<String> comboBox = new JComboBox<String>(orari);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(337, 59, 221, 19);
		contentPane.add(comboBox);
		
		JButton prenotaButton = new JButton("  Prenota e Registra");
		prenotaButton.setFocusPainted(false);
		prenotaButton.setBorderPainted(false);
		prenotaButton.setIcon(new ImageIcon(PrenotaVisita.class.getResource("/source/Add.png")));
		prenotaButton.setVisible(false);
		prenotaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Controller controller = Controller.getInstance();
				String nome = textField_Nome.getText();
				String cognome = textField_Cognome.getText();
				String cf = textField_Cf.getText();
				Date data = new Date(dateChooser.getDate().getTime());
				String luogoNascita = textField_Nascita.getText(); 
				String luogoResidenza = textField_Residenza.getText();
				String telefono = textField_Telefono.getText();
				String email = textField_Email.getText();
				String username = textField_Username.getText();
				String password = passwordField.getText(); 
				
				
				Date date = new Date(dateChooser.getDate().getTime()); 
				
				//System.out.println(comboBox.getSelectedItem().toString());
				Time time = Time.valueOf(LocalTime.parse(comboBox.getSelectedItem().toString())); 
				
				
				String descrizione = comboBox_descrizione.getSelectedItem().toString(); 
				// Controller controller = Controller.getInstance();
				
				try{

						controller.isNomeValido(nome);
						controller.isNomeValido1(nome);
						controller.isCognomeValido(cognome);
						controller.isCognomeValido1(cognome);
						controller.isCfValido(cf);
						controller.isCfValido1(cf);
						//Controller.isDataNascitaValida(data);
						controller.isLuogoNascitaValido(luogoNascita);
						controller.isLuogoNascitaValido1(luogoNascita);
						controller.isLuogoResidenzaValido(luogoResidenza);
						controller.isLuogoResidenzaValido1(luogoResidenza);
						controller.isTelefonoValido(telefono);
						controller.isTelefonoValido1(telefono);
						controller.isEmailValida(email);
						controller.isUsernameValido(username);
						controller.isPasswordValida(password);
						controller.isPasswordValida1(password);
						controller.isPasswordValida2(password);
						
						
				int ret2 = controller.ricercaCittadino(cf); 
				
				if(ret2 >= 1) {
					
					int ret = controller.prenotaVisita(cf, idVisita, data);
					
					if(ret == 1) {
						JOptionPane.showMessageDialog(prenotaButton, "Prenotazione avvenuta con successo", "Avvenuta Prenotazione", JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(prenotaButton, "Errore Prenotazione", "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else {
					
					int ret1 = controller.effettuaRegistrazione(nome, cognome, cf, data, luogoNascita, luogoResidenza, telefono, email, username, password);
					
					
					
					if(ret1 == 1) {
						
						
						int ret = controller.prenotaVisita(cf, idVisita, date);
						
						if(ret == 1) {
							JOptionPane.showMessageDialog(prenotaButton, "Registrazione e Prenotazione avvenute con successo", "Avvenuta Prenotazione", JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(prenotaButton, "Errore Prenotazione", "Errore", JOptionPane.ERROR_MESSAGE);
						}
						

					}
					else if(ret1 == -2) {
						JOptionPane.showMessageDialog(prenotaButton, "Cittadino gia' registrato", "Errore", JOptionPane.PLAIN_MESSAGE);
					}
					else {
						
						JOptionPane.showMessageDialog(prenotaButton, "Inserimento non e' andato a buon fine", "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}

				
				}catch (NomeNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Nome non valido : troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NomeNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Nome non valido : caratteri non ammessi", "Error",JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Cognome non valido : troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Cognome non valido : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CfNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Cf non valido : dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CfNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Cf non valido : caratteri non ammessi", "Error",JOptionPane.ERROR_MESSAGE);
				}catch (LuogoResidenzaNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Luogo di Residenza : non valido troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (LuogoResidenzaNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Luogo di Residenza : non valido caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (LuogoNascitaNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Luogo di Nascita : non valido troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (LuogoNascitaNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Luogo di Nascita : non valido caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (TelefonoNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Telefono non valido : dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (TelefonoNonValido1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Telefono non valido : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (EmailNonValida ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Email non valida : manca la @", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (UsernameNonValido ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Username non valido : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Password non valida : dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida1 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Password non valida : manca il carattere speciale", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida2 ex) {
					JOptionPane.showMessageDialog(prenotaButton, "Password non valida : manca una lettera minuscola o maiuscola", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		prenotaButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		prenotaButton.setBounds(795, 438, 210, 62);
		contentPane.add(prenotaButton);
		
		
		
		JButton verificaButton = new JButton("  Verifica Disponibilita'");
		verificaButton.setIcon(new ImageIcon(PrenotaVisita.class.getResource("/source/Verifica.png")));
		verificaButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		verificaButton.setFocusPainted(false);
		verificaButton.setBorderPainted(false);
		verificaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
				Controller controller = Controller.getInstance();
				Date date = new Date(dateChooser.getDate().getTime()); 
				
				//System.out.println(comboBox.getSelectedItem().toString());
				Time time = Time.valueOf(LocalTime.parse(comboBox.getSelectedItem().toString())); 
				
				
				String descrizione = comboBox_descrizione.getSelectedItem().toString();
				// System.out.println(descrizione);
				
				try{

					controller.isDescrizioneVisitaValida(descrizione);
					controller.isDescrizioneVisitaValida1(descrizione);

				idVisita = controller.verificaDisponibilita(date, time, descrizione); 
				
				// r = -1 Errore della query 
				// r = 0 Visita non trovato
				// r = 1 Inserimento corretto
				
				// System.out.println("ID VISITA " + idVisita);
				
				if(idVisita >= 1) {
					
					lblNome.setVisible(true);
					textField_Nome.setVisible(true);
					lblCognome.setVisible(true);
					textField_Cognome.setVisible(true);
					lblcf.setVisible(true);
					textField_Cf.setVisible(true);
					lblData.setVisible(true); 
					dateChooser_DataNascita.setVisible(true);
					lblNascita.setVisible(true);
					textField_Nascita.setVisible(true);
					lblResidenza.setVisible(true);
					textField_Residenza.setVisible(true);
					lblTelefono.setVisible(true);
					textField_Telefono.setVisible(true);
					lblEmail.setVisible(true);
					textField_Email.setVisible(true);
					lblUsername.setVisible(true);
					textField_Username.setVisible(true);
					lblPassword.setVisible(true);
					passwordField.setVisible(true);
					prenotaButton.setVisible(true);
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(verificaButton, "Visita non disponibile", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(verificaButton, "Descrizione non valida : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(verificaButton, "Descrizione non valida : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		verificaButton.setBounds(984, 29, 221, 49);
		contentPane.add(verificaButton);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(46, 137, 45, 13);
		lblNome.setVisible(false);
		contentPane.add(lblNome);
		
		textField_Nome = new JTextField();
		textField_Nome.setColumns(10);
		textField_Nome.setVisible(false);
		textField_Nome.setBounds(42, 160, 155, 19);
		contentPane.add(textField_Nome);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setColumns(10);
		textField_Cognome.setVisible(false);
		textField_Cognome.setBounds(312, 160, 155, 19);
		contentPane.add(textField_Cognome);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCognome.setVisible(false);
		lblCognome.setBounds(312, 138, 99, 13);
		contentPane.add(lblCognome);
		
		lblcf = new JLabel("Codice Fiscale");
		lblcf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcf.setBounds(600, 138, 119, 13);
		lblcf.setVisible(false);
		contentPane.add(lblcf);
		
		textField_Cf = new JTextField();
		textField_Cf.setColumns(10);
		textField_Cf.setVisible(false);
		textField_Cf.setBounds(600, 160, 155, 19);
		contentPane.add(textField_Cf);
		
		dateChooser_DataNascita = new JDateChooser();
		dateChooser_DataNascita.setBounds(46, 238, 155, 19);
		dateChooser_DataNascita.setVisible(false);
		contentPane.add(dateChooser_DataNascita);
		
		textField_Nascita = new JTextField();
		textField_Nascita.setColumns(10);
		textField_Nascita.setVisible(false);
		textField_Nascita.setBounds(312, 238, 155, 19);
		contentPane.add(textField_Nascita);
		
		textField_Residenza = new JTextField();
		textField_Residenza.setColumns(10);
		textField_Residenza.setVisible(false);
		textField_Residenza.setBounds(600, 238, 155, 19);
		contentPane.add(textField_Residenza);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setColumns(10);
		textField_Telefono.setVisible(false);
		textField_Telefono.setBounds(46, 315, 155, 19);
		contentPane.add(textField_Telefono);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setVisible(false);
		textField_Email.setBounds(312, 315, 155, 19);
		contentPane.add(textField_Email);
		
		textField_Username = new JTextField();
		textField_Username.setColumns(10);
		textField_Username.setVisible(false);
		textField_Username.setBounds(42, 392, 155, 19);
		contentPane.add(textField_Username);
		
		lblData = new JLabel("Data di Nascita");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setVisible(false); 
		lblData.setBounds(46, 215, 166, 13);
		contentPane.add(lblData);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setVisible(false);
		lblTelefono.setBounds(46, 292, 99, 13);
		contentPane.add(lblTelefono);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setVisible(false);
		lblUsername.setBounds(46, 369, 130, 13);
		contentPane.add(lblUsername);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setVisible(false);
		lblEmail.setBounds(312, 292, 45, 13);
		contentPane.add(lblEmail);
		
		lblNascita = new JLabel("Luogo di Nascita");
		lblNascita.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNascita.setBounds(312, 215, 155, 13);
		lblNascita.setVisible(false);
		contentPane.add(lblNascita);
		
		lblResidenza = new JLabel("Luogo di Residenza");
		lblResidenza.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResidenza.setBounds(600, 216, 166, 13);
		lblResidenza.setVisible(false);
		contentPane.add(lblResidenza);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(312, 369, 166, 13);
		lblPassword.setVisible(false);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(312, 392, 155, 17);
		passwordField.setVisible(false);
		contentPane.add(passwordField);
		
		

//		
		
		
		
		
		
		
		
		
		
		
		
	}
}
