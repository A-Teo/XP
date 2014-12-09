package vistas;

import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controladores.*;

import controladores.SqlScript;

import java.awt.Font;

public class VentanaRegistrarColaborador extends JDialog implements ActionListener 
{
    private database.PostgresConn coneccion;
	private JLabel no, ap, dn, co ,te, fu;
	private JPanel principal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JButton btnAceptar,btnAtras;
	private JComboBox cmbFuncion;
	
	public VentanaRegistrarColaborador() 
	{

         setBounds(50,100,400,500);
         getContentPane().setLayout(null);
         setVisible(true);
         
        
         principal = new JPanel();
         principal.setBounds(0, 0, 384, 451);
         principal.setBackground(getBackground().WHITE);
         principal.setLayout(null);
         getContentPane().add(principal);
         
         no = new JLabel("ingrese nombres: ");
         no.setBounds(30, 67, 150, 30);
         principal.add(no);
         
         
         ap =new JLabel("ingrese apellidos: ");
         ap.setBounds(30, 117, 150, 30);
         principal.add(ap);
         
         dn =new JLabel("ingrese dni: ");
         dn.setBounds(30, 169, 150, 30);
         principal.add(dn);
         
         co =new JLabel("ingrese correo: ");
         co.setBounds(30, 218, 150, 30);
         principal.add(co);
         
         te =new JLabel("ingrese telefono: ");
         te.setBounds(30, 271, 150, 30);
         principal.add(te);
         
         fu =new JLabel("Elija la funcion: ");
         fu.setBounds(30, 317, 150, 30);
         principal.add(fu);
         
         txtNombre = new JTextField();
         txtNombre.setBounds(160, 72, 183, 20);
         principal.add(txtNombre);
         txtNombre.setColumns(10);
         
         txtApellido = new JTextField();
         txtApellido.setColumns(10);
         txtApellido.setBounds(160, 122, 183, 20);
         principal.add(txtApellido);
         
         txtDni = new JTextField();
         txtDni.setColumns(10);
         txtDni.setBounds(160, 174, 183, 20);
         principal.add(txtDni);
         
         txtCorreo = new JTextField();
         txtCorreo.setColumns(10);
         txtCorreo.setBounds(160, 223, 183, 20);
         principal.add(txtCorreo);
         
         txtTelefono = new JTextField();
         txtTelefono.setColumns(10);
         txtTelefono.setBounds(160, 276, 183, 20);
         principal.add(txtTelefono);
         
         cmbFuncion = new JComboBox();
         cmbFuncion.setBounds(160, 322, 184, 20);
         cmbFuncion.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Alimentacion", "Administrativo", "Transporte", "Auxiliar" }));
         principal.add(cmbFuncion);
         
         
         btnAtras = new JButton("ATRAS");
         btnAtras.setBounds(61, 381, 89, 23);
         btnAtras.addActionListener(this);
         principal.add(btnAtras);
         
         btnAceptar = new JButton("ACEPTAR");
         btnAceptar.setBounds(180, 381, 95, 23);
         principal.add(btnAceptar);
         
         JLabel lblRegistrarColoborador = new JLabel("REGISTRAR COLOBORADOR");
         lblRegistrarColoborador.setFont(new Font("Arial Black", Font.PLAIN, 14));
         lblRegistrarColoborador.setBounds(82, 11, 223, 27);
         principal.add(lblRegistrarColoborador);
         
         btnAceptar.addActionListener(this);
         
         coneccion.createConnection();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	  if(e.getSource().equals(btnAceptar))
	  {
		  String funcion="";
		  switch (cmbFuncion.getSelectedIndex()) 
		  {
		      case 0:
			  funcion = "Alimentacion";
			  break;
		      case 1:
		      funcion = "Administracion";
			  break;
		      case 2:
		      funcion = "Transporte";
			  break;
		      case 3:
		      funcion = "Auxiliar";
			  break;		      
		      default:
			  break;
		}				  
		  SqlScript script = new SqlScript();

		  script.registrarColaborador(txtNombre.getText(),txtApellido.getText(),txtCorreo.getText(), funcion, Integer.parseInt(txtDni.getText()),Integer.parseInt(txtTelefono.getText()));
          setVisible(false);
	  }
	  if(e.getSource().equals(btnAtras))
	  {
		  setVisible(false);
		  VentanaPrincipal n = new VentanaPrincipal();
	  }
		
	}
}
