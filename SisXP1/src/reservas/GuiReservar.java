
package reservas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author limbert ,marcial
 */
public class GuiReservar extends JFrame{          
    
    pgFunctions id = new pgFunctions();
    String idP = "";
    String estadoR = id.getEstado("2"); 
    Reservar pd = new Reservar(estadoR);
            
    public GuiReservar(){
	super("Título de la ventana");
        setLayout(new FlowLayout());
        //cuando necesitamos el cuadro de dialogo
    
        if(JOptionPane.showConfirmDialog(this, pd, "Introduzca datos",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
        }
        
        int seleccionada = JOptionPane.showConfirmDialog(this, "Lo aceptas?", "Aviso",
        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        switch(seleccionada) {
            case JOptionPane.YES_OPTION: 
                idP = id.getId("2");
                System.out.println(pd.getFechaActual());
                pd.GuardarReserva(idP,"reserv", pd.getFechaActual());
                
                break;
            case JOptionPane.NO_OPTION: JOptionPane.showMessageDialog(this, // La ventana padre.
        " Presionaste no!", //El mensaje.
        "Error", // El título de la ventana de diálogo.
        JOptionPane.ERROR_MESSAGE);
            break;//case JOptionP   ane.CLOSED_OPTION: .. // tratar ventana cerrada
        }        
    }
    
    public static void main(String[] args){
            GuiReservar f = new GuiReservar();        
    }          
}
