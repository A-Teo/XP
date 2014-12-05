package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorConsultas
{
	//private PostgresConn conector;

	//los metodos de PostgresConn son estaticos
	public ControladorConsultas()
	{
		//conector = new PostgresConn()
	}

	//ejempplo
	/*
	public ArrayList<String> getNombresPersonas()
	{
		ArrayList<String> nombres = new ArrayList<String>();
		ResultSet resultado = PostgresConn.consultar("SELECT nombre FROM persona");
		while(resultado.next)
		{
			String nombre = resultado.getString(1);
			nombres.add(nombre);
		}
		return nombres;
	}
	*/
	public static ResultSet getEstados()
	{
		ResultSet nombres = PostgresConn.consultar("SELECT * FROM estado");
		return nombres;
	}
	//public static ResultSet getRecursosAula()
	//{
	//	return PostgresConn.consultar("");
	//}
	public static boolean registrarCharla(String id, String fecha, String aula, String expositor, String colaborador, String tema, String horario )
	{
		
        String sql="INSERT INTO charla(\"idCharla\", fecha, aula, expositor, colaborador, tema, \"idHorario\")VALUES ("+"\'"+id+"\',\'"+fecha+"\',\'"+aula+"\',\'"+expositor+"\',\'"+colaborador+"\',\'"+tema+"\',\'"+horario+"\')"+";";		
		return PostgresConn.updateDB(sql);
	}
	public static ResultSet getHorarios()
	{
		return PostgresConn.consultar("SELECT * FROM horario");
	}
	public static boolean registrarRecurso(String idRecurso,String nombreRecurso,String estadoRecurso,String disponibilidad,String costoRecurso,String origenRecurso)
	{
		String sql = "INSERT INTO recurso(\"idRecurso\", \"nombreRecurso\", \"estadoRecurso\", disponibilidad,\"costoRecurso\", \"origenRecurso\")VALUES ("+"\'"+idRecurso+"\',\'"+nombreRecurso+"\',\'"+estadoRecurso+"\',\'"+disponibilidad+"\',\'"+costoRecurso+"\',\'"+origenRecurso+"\')"+";";
        return PostgresConn.updateDB(sql);
	}
}