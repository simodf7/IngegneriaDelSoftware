package boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Controller;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class RicercaVisite extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicercaVisite frame = new RicercaVisite();
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
	public RicercaVisite() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RicercaVisite.class.getResource("/source/ASL.png")));
		setTitle("Ricerca Visite");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Immetti il tipo di Visita di cui vuoi conoscere gli orari e gli specialisti");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(32, 26, 446, 13);
		contentPane.add(lblNewLabel);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},new String[] {"Nome Medico", "Cognome Medico", "Giorno", "Ora"}); 
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 109, 657, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
//		textField = new JTextField();
//		textField.setBounds(32, 49, 318, 19);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(32, 49, 318, 19);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);

		
		
		
		JButton btnCerca = new JButton("  Cerca\r\n");
		btnCerca.setIcon(new ImageIcon(RicercaVisite.class.getResource("/source/Ricerca.png")));
		btnCerca.setFocusPainted(false);
		btnCerca.setBorderPainted(false);
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				model.setRowCount(0);
	
				Controller controller = Controller.getInstance();
				String descrizione = comboBox_descrizione.getSelectedItem().toString();
				
				try{

					controller.isDescrizioneVisitaValida(descrizione);
					controller.isDescrizioneVisitaValida1(descrizione);

				String [][] data = controller.cercaDatiVisiteConMedico(descrizione);
				
				// System.out.println(data.length);
					for(int i=0; i<data.length; i++) {
						model.addRow(data[i]);
					}
			
				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(btnCerca, "Descrizione non valida : troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(btnCerca, "Descrizione non valida : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		
		btnCerca.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerca.setBounds(558, 26, 122, 42);
		contentPane.add(btnCerca);
	}
}
