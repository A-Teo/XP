import javax.print.attribute.standard.Severity;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame 
{
  private JPanel panel;
  private JLabel mensaje;
  private JButton registrarColaborador; 
	public VentanaPrincipal () 
	{
		setBounds(100,50,700,400);
		setVisible(true);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0,0,700,400);
		add(panel);
		
		mensaje = new JLabel("registrar \n colaborador");
		mensaje.setBounds(200,50,150,50);
		panel.add(mensaje);

	}

}
