package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarRecurso extends JFrame {

	private JPanel contentPane;
	private JTextField idRecursoTxt;
	private JTextField nombreRecursoTxt;
	private JTextField estadoRecursoTxt;
	private JTextField disponibilidadTxt;
	private JTextField costoRecursoTxt;
	private JTextField origenRecursoTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarRecurso frame = new RegistrarRecurso();
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
	public RegistrarRecurso() {
		setTitle("Registrar Recurso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(51, 84, 106, 27);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 150, 106, 27);
		contentPane.add(lblNombre);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(51, 217, 106, 27);
		contentPane.add(lblEstado);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(385, 84, 106, 27);
		contentPane.add(lblDisponibilidad);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(385, 150, 106, 27);
		contentPane.add(lblCosto);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(385, 217, 106, 27);
		contentPane.add(lblOrigen);
		
		idRecursoTxt = new JTextField();
		idRecursoTxt.setBounds(167, 87, 86, 20);
		contentPane.add(idRecursoTxt);
		idRecursoTxt.setColumns(10);
		
		nombreRecursoTxt = new JTextField();
		nombreRecursoTxt.setColumns(10);
		nombreRecursoTxt.setBounds(167, 153, 86, 20);
		contentPane.add(nombreRecursoTxt);
		
		estadoRecursoTxt = new JTextField();
		estadoRecursoTxt.setColumns(10);
		estadoRecursoTxt.setBounds(167, 220, 86, 20);
		contentPane.add(estadoRecursoTxt);
		
		disponibilidadTxt = new JTextField();
		disponibilidadTxt.setColumns(10);
		disponibilidadTxt.setBounds(501, 87, 86, 20);
		contentPane.add(disponibilidadTxt);
		
		costoRecursoTxt = new JTextField();
		costoRecursoTxt.setColumns(10);
		costoRecursoTxt.setBounds(501, 153, 86, 20);
		contentPane.add(costoRecursoTxt);
		
		origenRecursoTxt = new JTextField();
		origenRecursoTxt.setColumns(10);
		origenRecursoTxt.setBounds(501, 220, 86, 20);
		contentPane.add(origenRecursoTxt);
		
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idRecurso=idRecursoTxt.getText();
				String nombreRecurso=nombreRecursoTxt.getText();
				String estadoRecurso=estadoRecursoTxt.getText();
				String disponibilidad=disponibilidadTxt.getText();
				String costoRecurso=costoRecursoTxt.getText();
				String origenRecurso=origenRecursoTxt.getText();
				JLabel lblMsg = new JLabel("");
				lblMsg.setBounds(678, 128, 168, 62);
				contentPane.add(lblMsg);
				boolean r = ControladorConsultas.registrarRecurso(idRecurso,nombreRecurso,estadoRecurso,disponibilidad,costoRecurso,origenRecurso);
				if(r)
				{
					System.exit(0);
				}
				else
				{				
					lblMsg.setText("");
					lblMsg.setText("Datos Incorrectos!");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(185, 311, 217, 52);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(528, 311, 217, 53);
		contentPane.add(btnCancelar);
	}
}