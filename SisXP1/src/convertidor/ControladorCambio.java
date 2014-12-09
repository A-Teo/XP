package convertidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import convertidor.FuncionCambio;
import convertidor.VentanaCambio;



public class ControladorCambio implements ActionListener, KeyListener {
 private VentanaCambio v;
 private FuncionCambio fc;
	public ControladorCambio()
        {
		v = new VentanaCambio();
		fc = new FuncionCambio();
		v.setVisible(true);
	 this.v.convertir.addActionListener(this);
	 this.v.campovalor.addKeyListener(this);

        }
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
        {
		if (arg0.getSource() == this.v.convertir)
                {
			    v.camporesultado.setText(String.valueOf(fc.valor(Double.parseDouble(v.campovalor.getText()),v.combo1.getSelectedItem().toString(),v.combo2.getSelectedItem().toString())));
                            v.repaint();
		}
	}

    @Override
    public void keyTyped(KeyEvent ke) 
    {
        char c=ke.getKeyChar(); 
         if(Character.isLetter(c)) {
             ke.consume(); 
             JOptionPane.showMessageDialog(null,"Ingrese solo numeros");

    }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       
    }

}
