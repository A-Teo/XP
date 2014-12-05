package convertidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class controladorCambio implements ActionListener {
 private ventanacambio v;
 private funcioncambio fc;
	public controladorCambio(){
		v = new ventanacambio();
		fc = new funcioncambio();
		v.setVisible(true);
	 this.v.convertir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.v.convertir){
			    v.camporesultado.setText(String.valueOf(fc.valor(Double.parseDouble(v.campovalor.getText()),v.combo1.getSelectedItem().toString(),v.combo2.getSelectedItem().toString())));
				v.repaint();
		}
	}
}
