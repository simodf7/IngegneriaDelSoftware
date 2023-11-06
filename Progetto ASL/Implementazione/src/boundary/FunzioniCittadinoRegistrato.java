package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FunzioniCittadinoRegistrato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunzioniCittadinoRegistrato frame = new FunzioniCittadinoRegistrato();
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
	
	public FunzioniCittadinoRegistrato() {
		super(); 
	}
	
	public FunzioniCittadinoRegistrato(int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FunzioniCittadinoRegistrato.class.getResource("/source/ASL.png")));
		setTitle("Piattaforma Cittadino");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("  Prenota Visita");
		btnNewButton.setIcon(new ImageIcon(FunzioniCittadinoRegistrato.class.getResource("/source/Prenota.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PrenotaVisitaOnLine(id).setVisible(true); 
			}
		});
		btnNewButton.setBounds(436, 62, 184, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Disdici Visita");
		btnNewButton_1.setIcon(new ImageIcon(FunzioniCittadinoRegistrato.class.getResource("/source/Disdici.png")));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DisdiciVisitaOnLine(id).setVisible(true); 
			}
		});
		btnNewButton_1.setBounds(436, 132, 184, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Benvenuto nella piattaforma riservata ai cittadini. \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(22, 79, 350, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Di fianco sono riportate le funzionalita' disponibili.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 78, 404, 61);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("  Ricerca Visite");
		btnNewButton_2.setIcon(new ImageIcon(FunzioniCittadinoRegistrato.class.getResource("/source/Ricerca.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RicercaVisite().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(436, 198, 184, 47);
		contentPane.add(btnNewButton_2);
	}
}
