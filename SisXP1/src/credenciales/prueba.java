package credencial_sis2;
/**
 * @author Leonardo
 */

import java.sql.*;
import javax.swing.JOptionPane;
public class prueba{
    private Connection conexion = null;
    public void estableceConexion()
    {
        if (conexion != null)
            return;
        String url = "Jdbc:postgresql://localhost:5432/";
        try
        {
           Class.forName("org.postgresql.Driver");
           //Establecemos el Usuario y la contraseña
           //Usuario= postgres
           //Contraseña= sistemas
           conexion = DriverManager.getConnection(url,"postgres","sistemas");
           if (conexion !=null){
               System.out.println("Conexión a base de datos ... Ok");
           }
        } catch (Exception e) {
            System.out.println("Problema al establecer la Conexión a la base de datos 1 ");
        }
    }
         public ResultSet dameNombre()
    {
        ResultSet rs = null;
        Statement s = null;
        try
        {
            s = conexion.createStatement();
          
            rs = s.executeQuery("SELECT * FROM  charla WHERE tema");
        }catch (Exception e)
        {
            System.out.println("Problema al consultar la base de datos ");
        }
        return rs;
    }
public void cierraConexion()
    {
        try
        {
            conexion.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }

   

}
