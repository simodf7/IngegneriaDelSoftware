package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.EmailNonValida;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;
import exceptions.SpecializzazioneNonValida;
import exceptions.SpecializzazioneNonValida1;
import exceptions.UsernameNonValido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class InserisciDatiMedici extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cognome;
	private JTextField textField_specializzazione;
	private JTextField textField_email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciDatiMedici frame = new InserisciDatiMedici();
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
	public InserisciDatiMedici() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciDatiMedici.class.getResource("/source/ASL.png")));
		setTitle("Inserisci Dati Medici");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserisci il nome del nuovo medico");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(28, 31, 328, 13);
		contentPane.add(lblNewLabel);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(28, 54, 229, 19);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il cognome del nuovo medico");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 98, 288, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_cognome = new JTextField();
		textField_cognome.setBounds(28, 121, 229, 19);
		contentPane.add(textField_cognome);
		textField_cognome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci la specializzazione del nuovo medico");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(28, 159, 307, 13);
		contentPane.add(lblNewLabel_2);
		
//		textField_specializzazione = new JTextField();
//		textField_specializzazione.setBounds(28, 205, 229, 19);
//		contentPane.add(textField_specializzazione);
//		textField_specializzazione.setColumns(10);
		
		
		JComboBox<String> comboBox_specializzazione = new JComboBox<String>(); 
		comboBox_specializzazione.setBounds(28, 182, 229, 19);
		comboBox_specializzazione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_specializzazione.setModel(new DefaultComboBoxModel(new String[] {  "Cardiologia", "Ortopedia", "Neurologia", "Gastroenterologia", "Oculistica",
			"Otorinolaringoiatria", "Urologia", "Ginecologia"} ));
		contentPane.add(comboBox_specializzazione);
		
		
		 
		
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.setIcon(new ImageIcon(InserisciDatiMedici.class.getResource("/source/Add.png")));
		inserisciButton.setFocusPainted(false);
		inserisciButton.setBorderPainted(false);
		inserisciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Controller controller = Controller.getInstance();
				
				int ret;
				
				String nome = textField_nome.getText();
				String cognome = textField_cognome.getText();
				String specializzazione = comboBox_specializzazione.getSelectedItem().toString();
				String email = textField_email.getText();
				String password = passwordField.getText();
				
				try {
				
					controller.isNomeValido(nome);
					controller.isNomeValido1(nome);
					controller.isCognomeValido(cognome);
					controller.isCognomeValido1(cognome);
					controller.isSpecializzazioneValida(specializzazione);
					controller.isSpecializzazioneValida1(specializzazione);
					controller.isEmailValida(email);
					controller.isPasswordValida(password);
					controller.isPasswordValida1(password);
					controller.isPasswordValida2(password);
					
					
					ret = controller.inserisciDatiMedici(nome, cognome, specializzazione, email, password);
					
					System.out.println(ret);
					
					if(ret >= 1) { 
						
						// ret >= 1 idmedico
						// ret == 0 medico gia presente 
						// ret == -1 errore inserimento
						
						JOptionPane.showMessageDialog(inserisciButton, "Inserimento avvenuto con successo", "Avvenuto Inserimento", JOptionPane.PLAIN_MESSAGE);
						new InserisciVisite(ret).setVisible(true); 
	
					}
					else if (ret == 0 ){ JOptionPane.showMessageDialog(inserisciButton, "Medico già presente", "Errore", JOptionPane.ERROR_MESSAGE);} 
					else {
						
						JOptionPane.showMessageDialog(inserisciButton, "Inserimento non e' andato a buon fine", "Errore", JOptionPane.ERROR_MESSAGE);
					}
				
				}catch (NomeNonValido ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Nome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NomeNonValido1 ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Nome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Cognome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido1 ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Cognome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (SpecializzazioneNonValida ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Specializzazione non valida: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (SpecializzazioneNonValida1 ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Specializzazione non valida: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (EmailNonValida ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Email non valida: manca la @", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Password non valida: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida1 ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Password non valida: manca il carattere speciale", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida2 ex) {
					JOptionPane.showMessageDialog(inserisciButton, "Password non valida: manca una lettera minuscola o maiuscola", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
			
		});
		inserisciButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		inserisciButton.setBounds(441, 256, 138, 47);
		contentPane.add(inserisciButton);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(332, 31, 270, 13);
		contentPane.add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(332, 54, 229, 19);
		contentPane.add(textField_email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(332, 98, 270, 13);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(332, 121, 223, 19);
		contentPane.add(passwordField);
	}
}
