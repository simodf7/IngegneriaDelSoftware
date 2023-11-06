package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import control.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {

	private JFrame frmAsl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmAsl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame.setIconImage(frame.getToolkit().getImage("/source/icon.png"));
		frmAsl = new JFrame();
		frmAsl.setTitle("ASL");
		frmAsl.getContentPane().setBackground(new Color(135, 206, 250));
		frmAsl.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/source/ASL.png")));
		frmAsl.setBounds(100, 100, 962, 512);
		frmAsl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsl.getContentPane().setLayout(null);
	
		JButton btnMedico = new JButton("Accesso Medico");
		btnMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AccessoMedico().setVisible(true);
				// frmAsl.dispose();
			}
		});
		btnMedico.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMedico.setBounds(508, 232, 218, 58);
		btnMedico.setFocusPainted(false);
		btnMedico.setBorderPainted(false); // se piace
		Image img_Medico = new ImageIcon(this.getClass().getResource("/source/Medico.png")).getImage();
		btnMedico.setIcon(new ImageIcon(MainFrame.class.getResource("/source/Medico.png")));
		btnMedico.setHorizontalAlignment(SwingConstants.LEFT);
		frmAsl.getContentPane().add(btnMedico);
		
		
		// 282 x 273
		JLabel lblASL = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/source/ASL.png")).getImage(); 
		
		lblASL.setIcon(new ImageIcon(img.getScaledInstance(300, 265, Image.SCALE_DEFAULT))); 
		lblASL.setBounds(23, 34, 300, 265);
		frmAsl.getContentPane().add(lblASL);
		
		JButton btnPersonale = new JButton("Accesso Personale");
		btnPersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccessoPersonale().setVisible(true); 
				
			}
		});
		btnPersonale.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPersonale.setFocusPainted(false);
		btnPersonale.setBorderPainted(false);
		Image img_Personale = new ImageIcon(this.getClass().getResource("/source/Personale.png")).getImage();
		btnPersonale.setIcon(new ImageIcon(MainFrame.class.getResource("/source/Personale.png")));
		btnPersonale.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonale.setBounds(384, 154, 218, 58);
		frmAsl.getContentPane().add(btnPersonale);
		
		
		JButton btnCittadino = new JButton("Accesso Cittadino");
		btnCittadino.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCittadino.setFocusPainted(false);
		btnCittadino.setFocusable(false);
		btnCittadino.setBorderPainted(false);
		btnCittadino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccessoCittadino().setVisible(true);
			}
		});
		btnCittadino.setBounds(647, 154, 218, 58);
		Image img_Cittadino = new ImageIcon(this.getClass().getResource("/source/Cittadino.png")).getImage();
		btnCittadino.setIcon(new ImageIcon(MainFrame.class.getResource("/source/Cittadino.png")));
		btnCittadino.setHorizontalAlignment(SwingConstants.LEFT);
		frmAsl.getContentPane().add(btnCittadino);
		
		JLabel lblNewLabel = new JLabel("Benvenuto nella piattaforma per la Gestione ASL. \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(369, 51, 383, 13);
		frmAsl.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("La piattaforma è dedicata ai medici, ai cittadini e al personale dell'accettazione.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(369, 71, 528, 13);
		frmAsl.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sara' possibile accedere alle proprie funzionalita' cliccando nell'apposita casella.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(369, 94, 533, 13);
		frmAsl.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("© 2023 Cocca, Coppola, Di Fraia, Di Guida. All rights reserved. ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 441, 458, 13);
		frmAsl.getContentPane().add(lblNewLabel_3);
		
		
		
		
		
		
	}
}
