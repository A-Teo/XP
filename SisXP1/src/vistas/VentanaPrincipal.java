package vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Severity;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controladores.*;

import org.jvnet.substance.SubstanceLookAndFeel;


public class VentanaPrincipal extends JFrame implements ActionListener 
{
  private JPanel panel;
  private JLabel mensaje;  
  private JButton registrarColaborador,listaColaboradores,salir; 
	public VentanaPrincipal () 
	{
		setBounds(200,100,700,400);
		setVisible(true);
		setLayout(null);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");
		
		panel = new JPanel();
		panel.setBounds(0,0,700,400);
		panel.setLayout(null);
		panel.setBackground(getBackground().WHITE);
		add(panel);
		
		mensaje = new JLabel(" MENU PRINCIPAL ");		
		mensaje.setBounds(200,20,180,50);
		panel.add(mensaje);
		
		registrarColaborador = new JButton("REGISTRAR COLABORADOR");
		registrarColaborador.setBounds(400,50,250,50);
		registrarColaborador.addActionListener(this);
		panel.add(registrarColaborador);
		
		listaColaboradores = new JButton("LISTA DE COLABORADORES");
		listaColaboradores.setBounds(400,120,250,50);
		listaColaboradores.addActionListener(this);
		panel.add(listaColaboradores);

		salir = new JButton("SALIR");
		salir.setBounds(400,300,200,50);
	    salir.addActionListener(this);
		panel.add(salir);
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(salir))
		{
			System.exit(0);
		}
		if(e.getSource().equals(registrarColaborador))
		{
			setVisible(false);
			VentanaRegistrarColaborador v =new VentanaRegistrarColaborador();			
		}
		if(e.getSource().equals(listaColaboradores))
		{
			setVisible(false);
			VentanaListaColaboradores v =new VentanaListaColaboradores();			
		}
	}

}
