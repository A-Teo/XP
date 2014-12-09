
package reservas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author limbert : marcial
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pgFunctions {

  /* DATOS PARA LA CONEXION */
  /** Nombre de la base de datos */
  private String db = "conferencia";
  /** Usuario postgreSQL */
  private String user = "sis2";
  /** Contraseña postgreSQL */
  private String password = "conferencia";
  /** Cadena de conexión */
  private String url = "jdbc:postgresql://localhost:5432/"+db;
  /** Conexion a base de datos */
  private Connection conn = null;
  /** Para obtener los resultados de las consultas SQL de la base de datos */
  private ResultSet resultSet = null;
  /** Para enviar comandos SQL a la base de datos */
  private Statement statement = null;

  /** Constructor de la clase
 * Realiza una conexión a la base de datos de PostgreSQL
 * @exception SQLException Los datos son incorrectos
 * @exception ClassNotFoundException No existe libreria JDBC:Postgresql
 */
  public pgFunctions(){
   this.url = "jdbc:postgresql://localhost:5432/"+db;
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(this.url, this.user , this.password );
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }catch(ClassNotFoundException e){
         System.err.println( e.getMessage() );
      }
  }

/**
 * Ejecuta la instruccion SQL para llamar a la función en postgreSQL
 * @param id_participante String que es el identificador de la reserva
 * @return String el resultado de la función
 */
public String getId( String id_participante )
{
    String res="";
    try {
      statement = conn.createStatement();
//      resultSet = statement.executeQuery("SELECT reserva('"+id_participante+"'); ");
      resultSet = statement.executeQuery("select id_participante from reserva where id_participante = '"+id_participante+"'");
      while (resultSet.next())
      {
        res=resultSet.getString(1);
      }
     }
   catch (SQLException ex) {
        System.err.println( ex.getMessage() );
   }
   return res;
}

public String getEstado( String id_participante )
{
    String res="";
    try {
      statement = conn.createStatement();
//      resultSet = statement.executeQuery("SELECT reserva('"+id_participante+"'); ");
      resultSet = statement.executeQuery("select estado from reserva where id_participante = '"+id_participante+"'");
      while (resultSet.next())
      {
        res=resultSet.getString(1);
      }
     }
   catch (SQLException ex) {
        System.err.println( ex.getMessage() );
   }
   return res;
}

}


