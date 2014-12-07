package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarCharla extends JFrame {

	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField fechaTxt;
	private JTextField aulaTxt;
	private JTextField expositorTxt;
	private JTextField colaboradorTxt;
	private JTextField temaTxt;
	private JTextField horarioTxt;
	private static JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCharla frame = new RegistrarCharla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					mostrarHorarios();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void mostrarHorarios() throws SQLException
	{
		ResultSet rs=ControladorConsultas.getHorarios();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("id");
		modelo.addColumn("hora");
		while(rs.next())
		{
			Object [] fila = new Object[2];
			for(int i=0;i<2;i++)
				fila[i]=rs.getObject(i+1);
			modelo.addRow(fila);
		}
		tabla.setModel(modelo);
	}

	/**
	 * Create the frame.
	 */
	
	public RegistrarCharla() {
		setTitle("Programar Charla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,960, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(52, 99, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(52, 124, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAula = new JLabel("Aula");
		lblAula.setBounds(52, 149, 46, 14);
		contentPane.add(lblAula);
		
		JLabel lblExpositor = new JLabel("Expositor");
		lblExpositor.setBounds(52, 174, 78, 14);
		contentPane.add(lblExpositor);
		
		JLabel lblColaborador = new JLabel("Colaborador");
		lblColaborador.setBounds(52, 199, 94, 14);
		contentPane.add(lblColaborador);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(52, 224, 46, 14);
		contentPane.add(lblTema);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(52, 249, 46, 14);
		contentPane.add(lblHorario);
		
		idTxt = new JTextField();
		idTxt.setBounds(242, 99, 86, 20);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		fechaTxt = new JTextField();
		fechaTxt.setColumns(10);
		fechaTxt.setBounds(242, 124, 86, 20);
		contentPane.add(fechaTxt);
		
		aulaTxt = new JTextField();
		aulaTxt.setColumns(10);
		aulaTxt.setBounds(242, 149, 86, 20);
		contentPane.add(aulaTxt);
		
		expositorTxt = new JTextField();
		expositorTxt.setColumns(10);
		expositorTxt.setBounds(242, 174, 86, 20);
		contentPane.add(expositorTxt);
		
		colaboradorTxt = new JTextField();
		colaboradorTxt.setColumns(10);
		colaboradorTxt.setBounds(242, 199, 86, 20);
		contentPane.add(colaboradorTxt);
		
		temaTxt = new JTextField();
		temaTxt.setColumns(10);
		temaTxt.setBounds(242, 224, 86, 20);
		contentPane.add(temaTxt);
		
		horarioTxt = new JTextField();
		horarioTxt.setColumns(10);
		horarioTxt.setBounds(242, 249, 86, 20);
		contentPane.add(horarioTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(637, 44, 189, 269);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
						
			
			
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
				String id=idTxt.getText();
				String fecha=fechaTxt.getText();
				String aula=aulaTxt.getText();
				String expositor = expositorTxt.getText();
				String colaborador =colaboradorTxt.getText();
				String tema=temaTxt.getText();
				String horario=horarioTxt.getText();
				JLabel lblMsg = new JLabel("");
				lblMsg.setBounds(266, 153, 248, 56);
				contentPane.add(lblMsg);
				boolean r = ControladorConsultas.registrarCharla( id, fecha, aula, expositor, colaborador, tema, horario);
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
		btnNewButton.setBounds(229, 345, 217, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(512, 345, 217, 52);
		contentPane.add(btnNewButton_1);
		
	}
}
