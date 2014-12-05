package controladores;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import vistas.*;

public class GestorGastos
{
    ControladorConsultas consultor;
	/*private final int NUMERO = hasofohisfh;
	private final int TIPO = 1;
	private final int GASTO = 2;
	private final int RESPONSABLE = 3;
	private final int FECHA = 4;
	private final int DETALLE = 5;
	private final int MONTO = 6;*/
	public GestorGastos()
	{
            consultor = new ControladorConsultas();
        }
        
        public ArrayList<String> tiposExistentes()
        {
            ArrayList<String> res = consultor.tiposExistentes();
            return res;
        }
        
        public void formulario()
        {
            FormularioGastos f = new FormularioGastos();
            f.setVisible(true);
        }
        
        public void refresh()
        {
            //null;
        }
        
        public ArrayList<String[]> getGastos()
        {
            ArrayList<String[]> res = consultor.obtenerGastos();
            return res;
        }
        public ArrayList<String[]> getGastos(String[] algo)
        {
            ArrayList<String[]> res = consultor.obtenerGastos(algo);
            return res;
        }

	public String[] obtenerArreglo(String cadena)
	{
		String[] res = new String[7];
		for(int i = 0; i < 7; i++)
		{
			res[i] = "";
		}
		int j = 0;
		for(int i = 0; i < cadena.length() && j < 7; i++)
		{
			char caracter = cadena.charAt(i);
			if(caracter == '|')
			{
				j++;
			}else
			{
				res[j] = res[j] + caracter;
			}
		}
                
                res[0] = "" + numero(res[0]);
                res[6] = "" + numero(res[6]);
		return res;
	}
        
        public void llenar(String[] cosas)
        {
            //haces cosas
            /*
            verificar tipo (si existe enlazar este tipo al nuevo gasto
                            sino crear el nuevo tipo)
            verificar existencia de usuarios si no existen problema
            enlazar al gasto
            
            insert gasto
            
            */
            String tipo = cosas[0];
            String gasto = cosas[1];
            String responsable = cosas[2];
            String fecha = cosas[3];
            String detalle = cosas[4];
            String monto = cosas[5];
            boolean existeTipo = consultor.existeTipo(tipo);
            if(!existeTipo)
            {
                consultor.crearTipo(tipo);
            }
            int idTipo = consultor.idTipo(tipo);
            boolean existeResponsable = consultor.existeResponsable(responsable);
            if(existeResponsable)
            {
                int idResponsable = consultor.idResponsable(responsable);
                consultor.insertarGasto(idTipo, gasto, idResponsable, fecha, detalle, monto);
            }else
            {
                System.out.println("no existe ese responsable");
            }
        }
        
        public double numero(String numeroLiteral)
    { 
        String[] palabras = {"UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE",
        "DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE",
        "VEINTE","VEINTIUNO","VEINTIDOS","VEINTITRES","VEINTICUATRO","VEINTICINCO","VEINTISEIS","VEINTISIETE","VEINTIOCHO","VEINTINUEVE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA",
        "CIEN", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS"};
        
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9,
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
        20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 40, 50, 60, 70, 80, 90,
        100, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        
        List lstLetras = java.util.Arrays.asList(palabras);
        
        double res = 0.00;
        numeroLiteral = numeroLiteral.toUpperCase();
        if(!numeroLiteral.equals(""))
        {
           String[]dividido = numeroLiteral.split("CON ");
           String enteros = dividido[0];
           String decimales = "";
           if(dividido.length > 1){
               decimales = dividido[1];
           }else{}
           Double numero = 0.0;
           /*String[] aux = enteros.split(" ");
           if(aux[0].equals("MIL")){ 
               numero = 1.0;
           }*/
           StringTokenizer st = new StringTokenizer(enteros); 
           while (st.hasMoreTokens()) {
                String t = st.nextToken();
                if (t.equals("MIL"))
                {
                    if(numero == 0.00)
                    {
                        numero = 1.00;
                    }else{}
                    numero *= 1000;
                }else{}
                int i = lstLetras.indexOf(t);
                if (i > -1)
                {
                    numero = numero + valores[i];
                }
           }
           res = numero + (numero(decimales)/100);
        }else{}
        return res;        
    }
}