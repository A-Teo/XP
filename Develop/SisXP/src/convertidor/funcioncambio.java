package convertidor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;

/*
 * el algoritmo recibe 3 parametros :
 * 1 el monto es de tipo double y vendria a ser el monto a convertir
 * 2 monedaInternacional es de tipo String y es el tipo de moneda del monto a convertir
 * 3 monedaLocal es de tipo String y es el tipo de moneda a convertir
 * nota:
 *     para mandar el tipo de moneda es necesario considerar lo siguiente se manda su abreviacion
 *     para Bolivianos  -> BOB
 *     para Dolares USA -> USD
 *     para Euros Espa�a  -> EUR
 *     para Pesos Argentinos -> ARS
 *     para reales Brasile�os  -> BRL
 *     
 *     solo dando estas abreviaciones se hara la conversion caso contrario no
 */
public class funcioncambio {

    public funcioncambio() {
    }

    public double valor(double monto, String monedaInternacional, String monedaLocal) {
        double res = 0;
        if (RangoNumero(monto) == false || EstaMoneda(monedaInternacional) == false || EstaMoneda(monedaLocal) == false || monedaInternacional.equals(null) || monedaLocal.equals(null)) {
            res = 0; // retorna 0.0 si supera rango o no esta en el tipo de entrada de tipo moneda
            JOptionPane.showMessageDialog(null, "Ingreso un monto fuera del rango o " + '\n' + "tipo de moneda Incorrecto");
        } else {
            if (esDistinto(monedaInternacional, monedaLocal)) {
                res = monto; // retorna el mismo valor si es el mismo tipo de moneda
                JOptionPane.showMessageDialog(null, "Ingreso el mismo tipo de moneda a convertir");
            } else {
                URL url;
                try {
                    url = new URL("http://es.exchange-rates.org/converter/" + monedaInternacional + "/" + monedaLocal + "/" + monto + "/Y");
                    URLConnection con = url.openConnection();
                    InputStream s = con.getInputStream();
                    List<String> listas = IOUtils.readLines(s);// convertimos html a un lista de strings
                    String line = listas.get(259); // obtenemos linea exacta
                    String[] cadena = line.split(">"); // dividimos linea 
                    res = redondear(Double.parseDouble(extraer(cadena[1], 0))); //redondea a 2 decimales el resultado
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

    private String extraer(String cadena, int pos) {
        String res = "";
        if (cadena.charAt(pos) == '<') {
            res = "";
        } else {
            if (cadena.charAt(pos) == ',') {
                res = '.' + extraer(cadena, pos + 1);
            } else {
                res = cadena.charAt(pos) + extraer(cadena, pos + 1);
            }
        }
        return res;
    }

    private boolean RangoNumero(double numero) {
        return (numero > 0 && numero < 1000000);
    }

    private boolean esDistinto(String tipo, String tipo2) {
        return (tipo.equals(tipo2));
    }

    private double redondear(double valor) {
        int cifras = (int) Math.pow(10, 2);
        return (Math.rint(valor * cifras) / cifras);

    }

    private boolean EstaMoneda(String tipo) {
        return (tipo.equals("BOB") || tipo.equals("EUR") || tipo.equals("USD") || tipo.equals("ARL") || tipo.equals("BRL"));
    }
}
