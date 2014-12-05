package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorConsultas
{
    //private PostgresConn conector;
//los metodos de PostgresConn son estaticos
	public ControladorConsultas()
	{
		//conector = new PostgresConn()
	}
        
        public boolean existeTipo(String tipo)
        {
            boolean res = idTipo(tipo) != -1;
            return res;
        }
        
        public boolean existeResponsable(String responsable)
        {
            boolean res = idResponsable(responsable) != -1;
            return res;
        }
        
        public int idTipo(String tipo)
        {
            int res = -1;
            ResultSet resultado = PostgresConn.consultar("SELECT idtipogasto FROM tipogasto WHERE tipogasto.tipo = '" + tipo + "'");
            try
            {
            while(resultado.next())
            {
                res = resultado.getInt(1);
            }
            }finally
            {
            return res;
            }
        }
        
        public int idResponsable(String responsable)
        {
            int res = -1;
            ResultSet resultado = PostgresConn.consultar("SELECT idresponsable FROM responsable WHERE responsable.nombre = '" + responsable + "'");
            try
            {
            while(resultado.next())
            {
                res = resultado.getInt(1);
            }
            }finally
            {
            return res;
            }
        }
        
        public void crearTipo(String tipo)
        {
            ResultSet resultado = PostgresConn.consultar("INSERT INTO tipogasto (tipo) VALUES('" + tipo + "')");
        }
        
        public void insertarGasto(int idTipo, String gasto, int idResponsable, String fecha, String detalle, String monto)
        {
            ResultSet resultado = PostgresConn.consultar("INSERT INTO gasto (tipogasto_idtipogasto, responsable_idresponsable, item, moneda, fecha, detalle, monto) VALUES(" + idTipo + ", " + idResponsable + ", '" + gasto + "', 'BOB', '" + fecha + "', '" + detalle + "', " + monto + ")");
        }
        
        /**
     *
     * @return
     */
    public ArrayList<String[]> obtenerGastos()
        {
            ArrayList<String[]> res = new ArrayList<String[]>();
            try
            {
            ResultSet resultado = PostgresConn.consultar("SELECT tipogasto.tipo, gasto.item, responsable.nombre, gasto.fecha, gasto.detalle, gasto.monto FROM gasto, responsable, tipogasto WHERE gasto.tipogasto_idtipogasto = tipogasto.idtipogasto and gasto.responsable_idresponsable = responsable.idresponsable");
            int j = 1;
            while(resultado.next())
            {
                res.add(new String[7]);
                res.get(j - 1)[0] = "" +  j;
                for(int i = 1; i < 7; i++)
                {
                    String dato = resultado.getString(i);
                    res.get(j - 1)[i] = dato;
                }
                j++;
            }
            }finally
            {
            return res;
            }
        }
        
        public ArrayList<String> tiposExistentes()
        {
//            ArrayList<String> list = new ArrayList<>();
//            list.add("comida");
//            list.add("alquiler");
            ArrayList<String> res = new ArrayList();
            ResultSet resultado = PostgresConn.consultar("SELECT tipogasto.tipo FROM tipogasto");
            try
            {
            while(resultado.next())
            {
                res.add(resultado.getString(1));
            }
            }finally
            {
                return res;
            }
//            return list;
        }
        
        public ArrayList<String[]> obtenerGastos(String[] algo)
        {
            ArrayList<String[]> res = new ArrayList<String[]>();
            String condiciones = "";
            for(int i = 0; i < algo.length; i++)
            {
                condiciones = condiciones + " or tipogasto.tipo = '" + algo[i] + "'";
            }
            try
            {
            ResultSet resultado = PostgresConn.consultar("SELECT tipogasto.tipo, gasto.item, responsable.nombre, gasto.fecha, gasto.detalle, gasto.monto FROM gasto, responsable, tipogasto WHERE gasto.tipogasto_idtipogasto = tipogasto.idtipogasto and gasto.responsable_idresponsable = responsable.idresponsable and (tipogasto.tipo = 'ninguno'" + condiciones + ")");
            int j = 1;
            while(resultado.next())
            {
                res.add(new String[7]);
                res.get(j - 1)[0] = "" +  j;
                for(int i = 1; i < 7; i++)
                {
                    String dato = resultado.getString(i);
                    res.get(j - 1)[i] = dato;
                }
                j++;
            }
            }finally
            {
            return res;
            }
        }
        
        
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
}