package convertidor;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ventanacambio extends JFrame{
	
	public JTextField campovalor,camporesultado;
	public JLabel valor,de,a,resultado;
	public JComboBox combo1,combo2;
	public JButton convertir;
    
	public ventanacambio(){
		super("conversor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		campovalor = new JTextField(50);
    camporesultado = new JTextField(50);
             valor = new JLabel("INGRESE VALOR : ");
                de = new JLabel("DE : ");
                 a = new JLabel(" A : ");
         resultado = new JLabel("RESULTADO : ");       
                 String [] valor1 = {"USD","BOB","EUR","BRL","ARS"};
                 combo1 = new JComboBox(valor1);
                 combo2 = new JComboBox(valor1);
                 
                 convertir = new JButton("Convertir");
                 
                 valor.setBounds(70,0,250,50);
                 campovalor.setBounds(200,10,100,25);
                 de.setBounds(160,40,150,50);
                 combo1.setBounds(200,50,100,25);
                 a.setBounds(165,80,150,50);
                 combo2.setBounds(200,90,100,25);
                 resultado.setBounds(95,115,150,50);
            camporesultado.setBounds(200,130,250,25);
            convertir.setBounds(200,170,100,25);
            add(valor);
            add(campovalor);
            add(de);
            add(combo1);
            add(a);
            add(combo2);
            add(resultado);
            add(camporesultado);
            add(convertir);
            
            setSize(500,250);
            setLocationRelativeTo(null);
                 
	}
}	