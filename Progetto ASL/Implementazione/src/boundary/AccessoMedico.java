package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class AccessoMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textField_email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoMedico frame = new AccessoMedico();
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
	public AccessoMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccessoMedico.class.getResource("/source/ASL.png")));
		setTitle("Piattaforma Medico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(31, 51, 51, 13);
		contentPane.add(lblNewLabel);
		
		textField_email = new JTextField();
		textField_email.setBounds(115, 49, 140, 19);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JButton btnNewButton = new JButton("   Login");
		btnNewButton.setIcon(new ImageIcon(AccessoMedico.class.getResource("/source/login2.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Controller controller = Controller.getInstance();
				
				int idMedico = controller.effettuaLoginMedico(textField_email.getText(), passwordField.getText()); 
				
				if(idMedico >=1) {
					String [][] data = controller.trovaPrenotazioniMedici(idMedico);
					new VisualizzaPrenotazioni(data).setVisible(true);
					dispose(); 
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Credenziali Errate o Medico non esistente", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				
				

			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(303, 120, 165, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Password\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(31, 81, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 78, 140, 19);
		contentPane.add(passwordField);
	}
}
