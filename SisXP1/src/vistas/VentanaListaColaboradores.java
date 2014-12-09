package vistas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import controladores.*;

public class VentanaListaColaboradores extends JDialog implements ActionListener 
{
	private JPanel panel;
    private JScrollPane scrooltabla;
    private JTable tabla;   
    private DefaultTableModel modelo;
    private JButton btnAceptar;
    ArrayList<Colaborador>lista= new ArrayList<Colaborador>();
	public VentanaListaColaboradores() 
	{
       setBounds(100,50,600,500);             
       getContentPane().setLayout(null);
       setVisible(true);
       
       panel = new JPanel();
       panel.setBounds(0,0,584,462);
       panel.setBackground(getBackground().WHITE);
       panel.setLayout(null);
       getContentPane().add(panel);
       
       String titulo[]={"Nro ", "nombre(s)", "apellido(s)", "correo", "funcion", "DNI", "telefono(s)"};
       String datos[][] = {};
    		         
       modelo = new DefaultTableModel(datos,titulo)
     	{
     		public boolean isCellEditable(int row, int column) 
     		{
     			return false;
     		}
     	};
       tabla = new JTable(modelo);

       scrooltabla = new JScrollPane(tabla); 
       scrooltabla.setBounds(10,80,564,250);
       panel.add(scrooltabla);
       
       JLabel lblListaDeColaboradores = new JLabel("Lista de colaboradores");
       lblListaDeColaboradores.setFont(new Font("Arial Black", Font.PLAIN, 18));
       lblListaDeColaboradores.setBounds(176, 11, 243, 28);
       panel.add(lblListaDeColaboradores);
       
       btnAceptar = new JButton("ACEPTAR");
       btnAceptar.setBounds(97, 371, 100, 25);
       btnAceptar.addActionListener(this);
       panel.add(btnAceptar);
       cargarTabla();
	}
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource().equals(btnAceptar))
    	{
    		setVisible(false);
    		VentanaPrincipal p = new VentanaPrincipal();
    	}
    }
    private void cargarTabla()
    {
    	SqlScript a = new SqlScript();
    	lista = a.obtenerListaColaboradores();
    	 
    	for (Colaborador l : lista)
    	{    		
    		modelo.addRow(l.getColaborador());
		}
    	
    }
}
