package controladores;

public class Colaborador 
{
 private String nombre,apellidos,correo,funcion;
 private int nro,dni,telefono;

	public Colaborador(String n,String ap,String c,String f,int d,int t,int nro) 
	{
		this.nombre=n;
		this.apellidos=ap;
		this.correo=c;
		this.funcion=f;
		this.dni=d;
		this.telefono=t;
		this.nro=nro;
	}
	public String[] getColaborador()
	{
		//"Nro ", "nombre(s)", "apellido(s)", "correo", "funcion", "DNI", "telefono(s)"
		String[] respuesta = {""+nro,nombre,apellidos,correo,funcion,""+dni,""+telefono};		
		return respuesta;
	}
}
