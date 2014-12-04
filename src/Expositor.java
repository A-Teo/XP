import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Expositor {
	private String nombre;
	private String apellido;
	private int ci;
	private String correo;
	
	public Expositor(String n, String a, int c, String corr )
	{
		nombre =n;
		apellido =a;
		ci = c;
		correo = corr;
		
	}
	
	public String getNom()
	{
		return nombre;
	}
	
	public String getApell()
	{
		return apellido;
	}
	
	public int getCi()
	{
		return ci;
	}
	
	public String getCorreo()
	{
		return correo;
	}
	
	public boolean validarNombre (){
		return nombre.matches("[A-Z][a-zA-Z]*");
	}
	
	public boolean validarApellido (){
		return apellido.matches("[A-Z][a-zA-Z]*");
	}
	
	public boolean validarCi (){
		String exp = "[0-9]";
		Pattern p = Pattern.compile(exp);
		Matcher m= p.matcher(String.valueOf(ci));
		
		return m.matches();
	}
}
