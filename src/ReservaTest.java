/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tddxp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class ReservaTest {
    
    public ReservaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Reserva.
     */
    @Test
    public void testUserLoginCheck() {
        System.out.println("UserLoginCheck");
        Reserva test = new Reserva();
        boolean logueado = test.userLoginCheck();
        System.out.println("logueado?: " + logueado);
        assertTrue(logueado);
    }
    
    /**
     * Test of main method, of class Reserva.
     */
    @Test
    public void testVerificarCupo() {
        System.out.println("Verificar Cupo En Conferencia");
        Reserva test = new Reserva();
        boolean cupo = test.verificarCupo(new Conferencia());
        System.out.println("Hay Cupo?: " + cupo);
        assertTrue(cupo);
    }
    
    /**
     * Test of main method, of class Reserva.
     */
    @Test
    public void testGuardarReserva() {
        System.out.println("Guardar la reserva en la BD");
        Reserva test = new Reserva();
        boolean reserva = test.guardarReserva(4, 5, "29/11/2014", "Reservado");
        System.out.println("Se realizo la reserva correctamente?: " + reserva);
        assertTrue(reserva);
    }
    
    /**
     * Test of main method, of class Reserva.
     */
    @Test
    public void testEnviarEmail() {
        System.out.println("Enviar Email");
        Reserva test = new Reserva();
        boolean mailenviado = test.enviarEmail("goomaku@gmail.com", "Mail de"
                + " Confirmacion", test.crearEmail());
        System.out.println("Se realizo correctamente el envio del email?: " + mailenviado);
        assertTrue(mailenviado);
    }
    
    /**
     * Test of main method, of class Reserva.
     */
    @Test
    public void testString() {
        System.out.println("TEST STRING");
        Reserva test = new Reserva();
        String reserva = test.getString();
        System.out.println("String: " + reserva);
        assertEquals(reserva, "Hola");
    }
    
}
