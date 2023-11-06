package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;
import exceptions.UsernameNonValido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccessoCittadino extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JLabel lblNewLabel_1;
	private JButton btnLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoCittadino frame = new AccessoCittadino();
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
	public AccessoCittadino() {
		setTitle("Accesso Cittadino");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccessoCittadino.class.getResource("/source/ASL.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 777, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		//contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(37, 53, 90, 19);
		contentPane.add(lblNewLabel);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(37, 82, 173, 19);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(37, 132, 87, 13);
		contentPane.add(lblNewLabel_1);
		
		btnLogin = new JButton("     Login");
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		Image img3 = new ImageIcon(AccessoCittadino.class.getResource("/source/login.png")).getImage();
		btnLogin.setIcon(new ImageIcon(AccessoCittadino.class.getResource("/source/login.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret;
				
				Controller controller = Controller.getInstance();
				String username = textField_Username.getText();
				String password = passwordField.getText(); 
				
				
				try {
					
					controller.isUsernameValido(username);
					controller.isPasswordValida(password);
					controller.isPasswordValida1(password);
					controller.isPasswordValida2(password);
				
					ret = controller.effettuaLoginCittadino(username, password); 
					
					// r = -1 Errore della query 
					// r = 0 Cittadino non trovato
					// r >= 1 Login corretto con id
					
					System.out.println(ret);
					
					if(ret >= 1) {
						
						JOptionPane.showMessageDialog(btnLogin, "Login avvenuto con successo", "Avvenuto Login", JOptionPane.PLAIN_MESSAGE);
						new FunzioniCittadinoRegistrato(ret).setVisible(true);
						dispose();
						
						
					}
					else {
						
						JOptionPane.showMessageDialog(btnLogin, "Credenziali Errate o Utente non esistente", "Errore", JOptionPane.ERROR_MESSAGE);
					}
				
					
				}catch (UsernameNonValido ex) {
					JOptionPane.showMessageDialog(btnLogin, "Username non valido : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida ex) {
					JOptionPane.showMessageDialog(btnLogin, "Password non valida : dimensione scorretta", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida1 ex) {
					JOptionPane.showMessageDialog(btnLogin, "Password non valida : manca il carattere speciale", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (PasswordNonValida2 ex) {
					JOptionPane.showMessageDialog(btnLogin, "Password non valida : manca una lettera minuscola o maiuscola", "Error", JOptionPane.ERROR_MESSAGE);
				}
		  }
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(37, 202, 183, 46);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Non sei Registrato?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(302, 56, 173, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("    Crea un nuovo Account");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(AccessoCittadino.class.getResource("/source/Add2.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EffettuaRegistrazione().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(302, 80, 250, 48);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 155, 173, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Puoi anche ricercare delle Visite senza effettuare Login ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(302, 174, 379, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnRicerca = new JButton("  Ricerca");
		btnRicerca.setIcon(new ImageIcon(AccessoCittadino.class.getResource("/source/Ricerca.png")));
		btnRicerca.setFocusPainted(false);
		btnRicerca.setBorderPainted(false);
		btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RicercaVisite().setVisible(true);
				
			}
		});
		btnRicerca.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRicerca.setBounds(302, 206, 153, 42);
		contentPane.add(btnRicerca);
	}
}
