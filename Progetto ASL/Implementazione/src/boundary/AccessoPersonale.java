package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import javax.swing.JPasswordField;

public class AccessoPersonale extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoPersonale frame = new AccessoPersonale();
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
	public AccessoPersonale() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccessoMedico.class.getResource("/source/ASL.png")));
		setTitle("Piattaforma Personale");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnLogin = new JButton("   Login");
		btnLogin.setIcon(new ImageIcon(AccessoMedico.class.getResource("/source/login2.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Controller controller = Controller.getInstance();
				boolean loginCheck = controller.effettuaLoginPersonale(passwordField.getText()); 
				
				if(loginCheck) {
					new FunzioniPersonale().setVisible(true); 
					dispose(); 
				}
				else {
					JOptionPane.showMessageDialog(btnLogin, "Password ASL errata", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(303, 120, 165, 54);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Password\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 54, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 52, 173, 19);
		contentPane.add(passwordField);
		
	
	}
}
