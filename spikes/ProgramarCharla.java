package spikes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;

public class ProgramarCharla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramarCharla frame = new ProgramarCharla();
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
	public ProgramarCharla() {
		setTitle("Programar Charla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tema");
		lblNewLabel.setBounds(82, 46, 90, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblExpositor = new JLabel("Expositor");
		lblExpositor.setBounds(82, 121, 90, 50);
		contentPane.add(lblExpositor);
		
		JLabel lblAula = new JLabel("Colaborador");
		lblAula.setBounds(82, 198, 90, 50);
		contentPane.add(lblAula);
		
		JLabel lblAula_1 = new JLabel("Fecha");
		lblAula_1.setBounds(506, 46, 90, 50);
		contentPane.add(lblAula_1);
		
		JLabel lblHorario = new JLabel("Aula");
		lblHorario.setBounds(506, 121, 90, 50);
		contentPane.add(lblHorario);
		
		JLabel lblHorario_1 = new JLabel("Horario");
		lblHorario_1.setBounds(506, 198, 90, 50);
		contentPane.add(lblHorario_1);
		
		textField = new JTextField();
		textField.setBounds(206, 56, 210, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(206, 139, 210, 32);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(206, 215, 210, 20);
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(622, 139, 210, 20);
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(622, 215, 210, 20);
		contentPane.add(choice_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(622, 56, 210, 32);
		contentPane.add(dateChooser);
		
		Button button = new Button("New button");
		button.setBounds(206, 280, 210, 50);
		contentPane.add(button);
		
		Button button_1 = new Button("New button");
		button_1.setBounds(492, 280, 210, 50);
		contentPane.add(button_1);
	}
}
