package boundary;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import control.Controller;
import exceptions.CfNonValido;
import exceptions.CfNonValido1;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
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

import java.awt.Font;
import java.awt.Toolkit;



public class EffettuaRegistrazione extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cognome;
	private JTextField textField_LuogoNascita;
	private JTextField textField_LuogoResidenza;
	private JTextField textField_Telefono;
	private JTextField textField_Username;
	private JPasswordField passwordField; 
	private JTextField textField_Email;
	private JTextField textField_cf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EffettuaRegistrazione frame = new EffettuaRegistrazione();
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
	public EffettuaRegistrazione() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EffettuaRegistrazione.class.getResource("/source/ASL.png")));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 975, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		//contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Registrazione");
		
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(52, 39, 45, 13);
		getContentPane().add(lblNewLabel);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(51, 62, 155, 19);
		getContentPane().add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(262, 39, 81, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField_cognome = new JTextField();
		textField_cognome.setBounds(262, 62, 155, 19);
		getContentPane().add(textField_cognome);
		textField_cognome.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(51, 145, 155, 19);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Data di Nascita");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(51, 122, 115, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Luogo di Nascita");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(262, 122, 115, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Luogo di Residenza");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(461, 122, 146, 13);
		getContentPane().add(lblNewLabel_4);
		
		textField_LuogoNascita = new JTextField();
		textField_LuogoNascita.setBounds(262, 145, 155, 19);
		getContentPane().add(textField_LuogoNascita);
		textField_LuogoNascita.setColumns(10);
		
		textField_LuogoResidenza = new JTextField();
		textField_LuogoResidenza.setBounds(461, 145, 161, 19);
		getContentPane().add(textField_LuogoResidenza);
		textField_LuogoResidenza.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(51, 206, 115, 13);
		getContentPane().add(lblNewLabel_5);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setBounds(51, 229, 155, 19);
		getContentPane().add(textField_Telefono);
		textField_Telefono.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(262, 206, 115, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(51, 281, 81, 13);
		getContentPane().add(lblNewLabel_7);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(51, 304, 155, 19);
		getContentPane().add(textField_Username);
		textField_Username.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(262, 281, 92, 13);
		getContentPane().add(lblNewLabel_8);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 304, 155, 19);
		getContentPane().add(passwordField);
	
		
		JButton okButton = new JButton("Registrati");
		okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		okButton.setFocusPainted(false);
		okButton.setBorderPainted(false);
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret;
				
				Controller controller = Controller.getInstance();
				String nome = textField_nome.getText();
				String cognome = textField_cognome.getText();
				String cf = textField_cf.getText();
				Date data = new Date(dateChooser.getDate().getTime());
				String luogoNascita = textField_LuogoNascita.getText(); 
				String luogoResidenza = textField_LuogoResidenza.getText();
				String telefono = textField_Telefono.getText();
				String email = textField_Email.getText();
				String username = textField_Username.getText();
				String password = passwordField.getText(); 
				
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

					ret = controller.effettuaRegistrazione(nome, cognome, cf, data, luogoNascita, luogoResidenza, telefono, email, username, password); 
			
					// r = -2 Cittadino gia presente
					// r = -1 Errore della query 
					// r = 1 Inserimento 
					
					System.out.println(ret);
					
					if(ret == 1) {
						JOptionPane.showMessageDialog(okButton, "Registrazione avvenuta con successo", "Avvenuta Registrazione", JOptionPane.PLAIN_MESSAGE);
					}
					else if(ret == -2) {
						JOptionPane.showMessageDialog(okButton, "Cittadino gia' registrato", "Errore", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(okButton, "Inserimento non e' andato a buon fine", "Errore", JOptionPane.ERROR_MESSAGE);
					}
		
					}catch (NomeNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Nome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (NomeNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Nome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (CognomeNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Cognome non valido: troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (CognomeNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Cognome non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (CfNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Cf non valido: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (CfNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Cf non valido: formato non ammesso", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (LuogoResidenzaNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Luogo di Residenza: non valido troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (LuogoResidenzaNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Luogo di Residenza: non valido caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (LuogoNascitaNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Luogo di Nascita: non valido troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (LuogoNascitaNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Luogo di Nascita: non valido caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (TelefonoNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Telefono non valido: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (TelefonoNonValido1 ex) {
						JOptionPane.showMessageDialog(okButton, "Telefono non valido: caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (EmailNonValida ex) {
						JOptionPane.showMessageDialog(okButton, "Email non valida: manca la @", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (UsernameNonValido ex) {
						JOptionPane.showMessageDialog(okButton, "Username non valido: troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (PasswordNonValida ex) {
						JOptionPane.showMessageDialog(okButton, "Password non valida: dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (PasswordNonValida1 ex) {
						JOptionPane.showMessageDialog(okButton, "Password non valida: manca il carattere speciale", "Error", JOptionPane.ERROR_MESSAGE);
					}catch (PasswordNonValida2 ex) {
						JOptionPane.showMessageDialog(okButton, "Password non valida: manca una lettera minuscola o maiuscola", "Error", JOptionPane.ERROR_MESSAGE);
					}
				
				
			}
		});
		
		
		okButton.setBounds(760, 322, 130, 43);
		getContentPane().add(okButton);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(262, 229, 155, 19);
		getContentPane().add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Codice Fiscale");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(461, 39, 124, 13);
		getContentPane().add(lblNewLabel_9);
		
		textField_cf = new JTextField();
		textField_cf.setBounds(461, 62, 161, 19);
		getContentPane().add(textField_cf);
		textField_cf.setColumns(10);
		
	}

}
