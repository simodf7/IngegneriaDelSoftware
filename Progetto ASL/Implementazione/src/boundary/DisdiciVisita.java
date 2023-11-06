package boundary;

 

import java.awt.Color;
import java.awt.EventQueue;

 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

 

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import control.Controller;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.DescrizioneVisitaNonValida;
import exceptions.DescrizioneVisitaNonValida1;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


 

public class DisdiciVisita extends JFrame {

 

    private JPanel contentPane;
    private JTextField textField_Nome;
    private JTextField textField_Cognome;
    private JTextField textField_Descrizione;

 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisdiciVisita frame = new DisdiciVisita();
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
    public DisdiciVisita() {
        setTitle("Disdici Visita");
        setIconImage(Toolkit.getDefaultToolkit().getImage(DisdiciVisita.class.getResource("/source/ASL.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 954, 406);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

 

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nome del cittadino");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(40, 42, 193, 13);
        contentPane.add(lblNewLabel);

        textField_Nome = new JTextField();
        textField_Nome.setBounds(40, 65, 218, 19);
        contentPane.add(textField_Nome);
        textField_Nome.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Cognome del cittadino");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(40, 94, 193, 13);
        contentPane.add(lblNewLabel_1);

        textField_Cognome = new JTextField();
        textField_Cognome.setBounds(40, 117, 218, 19);
        contentPane.add(textField_Cognome);
        textField_Cognome.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Data Prenotazione");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setBounds(388, 42, 169, 13);
        contentPane.add(lblNewLabel_2);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(388, 65, 210, 19);
        contentPane.add(dateChooser);

        JLabel lblNewLabel_3 = new JLabel("Orario Prenotazione");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3.setBounds(388, 104, 210, 13);
        contentPane.add(lblNewLabel_3);

        String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", 
                "16:00", "17:00", "18:00", "19:00", "20:00"};
        JComboBox<String> comboBox_orari = new JComboBox<String>(orari);
        comboBox_orari.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox_orari.setBounds(388, 127, 210, 21);
        contentPane.add(comboBox_orari);

        JLabel lblNewLabel_4 = new JLabel("Descrizione della Visita");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_4.setBounds(388, 169, 179, 13);
        contentPane.add(lblNewLabel_4);

//        textField_Descrizione = new JTextField();
//        textField_Descrizione.setBounds(388, 190, 210, 19);
//        contentPane.add(textField_Descrizione);
//        textField_Descrizione.setColumns(10);
        
		JComboBox<String> comboBox_descrizione = new JComboBox<String>(); 
		comboBox_descrizione.setBounds(388, 190, 210, 19);
		comboBox_descrizione.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_descrizione.setModel(new DefaultComboBoxModel(new String[] {  "Visita cardiologica", "Visita ortopedica", "Visita neurologica", "Visita gastroenterologica",
				"Visita oculistica", "Visita otorinolaringoiatrica", "Visita urologica", "Visita ginecologica"} ));
		contentPane.add(comboBox_descrizione);

        JButton disdiciButton = new JButton("   Disdici");
        disdiciButton.setIcon(new ImageIcon(DisdiciVisita.class.getResource("/source/Disdici.png")));
        disdiciButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int ret;

                Controller controller = Controller.getInstance();
                String nome = textField_Nome.getText();
                String cognome = textField_Cognome.getText();

                Date date = new Date(dateChooser.getDate().getTime()); 

                // System.out.println(comboBox.getSelectedItem().toString());
                Time time = Time.valueOf(LocalTime.parse(comboBox_orari.getSelectedItem().toString())); 

                String descrizione = comboBox_descrizione.getSelectedItem().toString(); 
                // System.out.println(descrizione);

				try{

						controller.isNomeValido(nome);
						controller.isNomeValido1(nome);
						controller.isCognomeValido(cognome);
						controller.isCognomeValido1(cognome);
						controller.isDescrizioneVisitaValida(descrizione);
						controller.isDescrizioneVisitaValida1(descrizione);

                ret = controller.disdiciVisita(date,time,descrizione,nome,cognome);

                // r = -1 Errore della query 
                // r = 0 Visita non trovato
                // r = 1 Inserimento corretto

                System.out.println(ret);

                if(ret == 1) {

                    JOptionPane.showMessageDialog(disdiciButton, "Operazione avvenuta con successo", "Avvenuta Disdetta", JOptionPane.PLAIN_MESSAGE);

                }
                else if (ret == 0) {
                    JOptionPane.showMessageDialog(disdiciButton, "Prenotazione non presente", "Errore", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(disdiciButton, "Errore Operazione", "Errore", JOptionPane.ERROR_MESSAGE);
                }
			}catch (NomeNonValido ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Nome non valido : troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (NomeNonValido1 ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Nome non valido : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Cognome non valido : troppo lungo", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (CognomeNonValido1 ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Cognome non valido : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Descrizione non valida : troppo lunga", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (DescrizioneVisitaNonValida1 ex) {
					JOptionPane.showMessageDialog(disdiciButton, "Descrizione non valida : caratteri non ammessi", "Error", JOptionPane.ERROR_MESSAGE);
				}

        }});
        disdiciButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        disdiciButton.setBounds(714, 253, 148, 51);
        disdiciButton.setFocusPainted(false);
        disdiciButton.setBorderPainted(false);
        contentPane.add(disdiciButton);
    }
}

