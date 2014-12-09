package vistas;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import convertidor.FuncionCambio;

import controladores.*;


public class FormularioGastos extends JFrame{
    JLabel labelTipo,labelGasto,labelResponsable,labelFecha,labelDetalle,labelMonto;
    JTextField campoTipo,campoGasto,campoResponsable, campoMonto;
    JTextArea areaDetalle;
    JDateChooser fecha;
    JButton aceptar, cancelar;
    String fechaReal;
    JComboBox tipoMoneda;
    
    GestorGastos gastos;
    
    public FormularioGastos()
    {
        super("Formulario para llenar Gastos");
        gastos = new GestorGastos();
        
        String[] monedas = {"BOB", "USD", "EUR","ARS","BRL"};
        tipoMoneda = new JComboBox(monedas);
        
        labelTipo = new JLabel("Tipo Gasto: ");
        labelGasto = new JLabel("Gasto: ");
        labelResponsable = new JLabel("Responsable: ");
        labelFecha = new JLabel("Fecha: ");
        labelDetalle = new JLabel("Detalle: ");
        labelMonto = new JLabel("Monto: ");
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        fecha = new JDateChooser();
        campoTipo = new JTextField(50);
        campoGasto = new JTextField(50);
        campoResponsable = new JTextField(50);
        campoMonto = new JTextField(10);
        areaDetalle = new JTextArea(250,80);
        Accion a = new Accion();
        soloNumero(campoMonto);
        
        labelTipo.setBounds(100,50,250,30);
        labelGasto.setBounds(100,100,250,30);
        labelResponsable.setBounds(100,150,250,30);
        labelFecha.setBounds(500,50,250,30);
        labelDetalle.setBounds(500,100,250,30);
        labelMonto.setBounds(500,190,250,30);
        
        campoTipo.setBounds(200,50,250,30);
        campoGasto.setBounds(200,100,250,30);
        campoResponsable.setBounds(200,150,250,30);
        areaDetalle.setBounds(600,100,250,80);
        campoMonto.setBounds(600,190,250,30);
        fecha.setBounds(600,50,150,25);
        aceptar.setBounds(300,300,80,30);
        cancelar.setBounds(500,300,90,30);
        tipoMoneda.setBounds(600, 220, 100, 25);
        
        aceptar.addActionListener(a);
        cancelar.addActionListener(a);
        
        setLayout(null);
        
        add(fecha);
        add(labelTipo);
        add(labelGasto);
        add(labelResponsable);
        add(labelFecha);
        add(labelDetalle);
        add(labelMonto);
        add(campoTipo);
        add(campoGasto);
        add(campoResponsable);
        add(areaDetalle);
        add(campoMonto);
        add(aceptar);
        add(cancelar);
        add(tipoMoneda);
        
         addWindowListener(new WindowAdapter() {
            @Override
         public void windowClosing(WindowEvent e) {
              System.exit(0);
                }
        });
        setSize(960, 400);
        setLocationRelativeTo(null);
        //setVisible(true);
        
    }
    public String getTipoGasto()
    {
        return campoTipo.getText();
    }
    public String getGasto()
    {
        return campoGasto.getText();
    }
    public String getResponsable()
    {
        return campoResponsable.getText();
    }
    public String getFecha()
    {   
        String res="";
        if(!fechaReal.equals("")) res = fechaReal;
        return res;
    }
    public String getDetalle()
    {
        return areaDetalle.getText();
    }
    public double getMonto()
    {
        double res = 0.0;
        if(!campoMonto.getText().equals(""))
        {
            res = Double.parseDouble(campoMonto.getText());
            res = new FuncionCambio().valor(res, getMoneda(), "BOB");
        }else{}
        return res;
    }
    public String getMoneda()
    {
        String res = "";
        int indice = tipoMoneda.getSelectedIndex();
        switch(indice)
        {
            case 0:
                res = "BOB";
                break;
            case 1:
                res = "USD";
                break;
            case 2:
                res = "EUR";
            case 3:
                res = "ARS";
            case 4:
                res = "BRL";
        }
        return res;
    }
    private void soloNumero(JTextField c)
    {
        c.addKeyListener(new KeyAdapter(){
            @Override
             public void keyTyped(KeyEvent e){
                 char car = e.getKeyChar();
                 if(!Character.isDigit(car))
                 {
                     getToolkit().beep();
                     e.consume();
                 }}
        });
    }
    public class Accion implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == aceptar)
            {
                if(fecha.getDate()!=null)
                {
                     String [] f=fecha.getDate().toString().split(" ");
                     fechaReal = f[1]+"/"+f[2]+"/"+f[5];
                     System.out.println(fechaReal);
                     
                }
                else System.out.println("Seleccione una fecha");
                String[] datos = {getTipoGasto(), getGasto(), getResponsable(), fechaReal, getDetalle(), "" + getMonto()};
                gastos.llenar(datos);
                setVisible(false);
            }
            if(e.getSource()==cancelar)
            {
               setVisible(false);              
            }
        }
        
    }
    public static void main(String[]args)
    {
        FormularioGastos fg = new FormularioGastos();
        fg.setVisible(true);
    }
}
