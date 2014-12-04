import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import database.SqlScript;

public class winExpositor {

	private JFrame frame;
	private JTextField textCi;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winExpositor window = new winExpositor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public winExpositor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 86, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblCi = new JLabel("Ci");
		lblCi.setBounds(44, 53, 46, 14);
		frame.getContentPane().add(lblCi);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(44, 161, 46, 14);
		frame.getContentPane().add(lblCorreo);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(44, 122, 46, 14);
		frame.getContentPane().add(lblApellidos);
		
		textCi = new JTextField();
		textCi.setBounds(112, 50, 119, 20);
		frame.getContentPane().add(textCi);
		textCi.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(111, 83, 182, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(111, 119, 182, 20);
		frame.getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(109, 158, 184, 20);
		frame.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ci=textCi.getText();
				String nom=textNombre.getText();
				String apell=textApellidos.getText();
				String corr=textCorreo.getText();
				String sql = "INSERT INTO Expositor VALUES(" + ci + ", "
		               + nom + ", " + apell + ", " + corr +"');";
		        PostgresConn.updateDB(sql); 
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnGuardar.setBounds(142, 209, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}
}
