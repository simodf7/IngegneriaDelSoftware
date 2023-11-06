package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FunzioniPersonale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunzioniPersonale frame = new FunzioniPersonale();
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
	public FunzioniPersonale() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FunzioniPersonale.class.getResource("/source/ASL.png")));
		setTitle("Piattaforma Personale");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benvenuto nella piattaforma per il Personale ASL.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 52, 377, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton(" Inserisci Dati Medici");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		Image img2 = new ImageIcon(this.getClass().getResource("/source/Add.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new InserisciDatiMedici().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(57, 139, 218, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Modifica Dati Medici");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		Image img = new ImageIcon(this.getClass().getResource("/source/Modify.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ModificaDatiMedici().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(337, 139, 218, 57);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Di seguito troverai le funzionalità riservata al Personale dell'Accettazione");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(25, 64, 569, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnPrenotaVisita = new JButton("  Prenota Visita");
		btnPrenotaVisita.setIcon(new ImageIcon(FunzioniPersonale.class.getResource("/source/Prenota.png")));
		btnPrenotaVisita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PrenotaVisita().setVisible(true);
				
			}
		});
		
		btnPrenotaVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrenotaVisita.setFocusPainted(false);
		btnPrenotaVisita.setBorderPainted(false);
		btnPrenotaVisita.setBounds(57, 226, 218, 57);
		contentPane.add(btnPrenotaVisita);
		
		JButton btnDisdiciVisita = new JButton("  Disdici Visita");
		btnDisdiciVisita.setIcon(new ImageIcon(FunzioniPersonale.class.getResource("/source/Disdici.png")));
		btnDisdiciVisita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DisdiciVisita().setVisible(true);
				
				
			}
		});
		btnDisdiciVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisdiciVisita.setFocusPainted(false);
		btnDisdiciVisita.setBorderPainted(false);
		btnDisdiciVisita.setBounds(337, 226, 218, 57);
		contentPane.add(btnDisdiciVisita);
	}
}
