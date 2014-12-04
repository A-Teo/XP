import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestExpositor {

	private Expositor e; 
	
	@Before
	public void setUp() throws Exception {
		e = new Expositor ("Daniel","Perez",657800,"daniel@gmail.com");
	}

	@Test
	public void testValidarNombre() {
		
		assertTrue(e.validarNombre());
		
	}
	
	public void testValidarApellido() {
		
		assertTrue(e.validarApellido());
		
	}
	
	public void testValidarCi() {
		
		assertTrue(e.validarCi());
	}

}
