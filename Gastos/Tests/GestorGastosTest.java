import org.junit.*;
import static org.junit.Assert.*;

public class GestorGastosTest
{
    GestorGastos g;
    
    public GestorGastosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
        g = new GestorGastos();
    }
    
    @After
    public void tearDown()
    {
        g = null;
    }
    
    @Test
    public void testCadenaArreglo()
    {
        String[] res = g.obtenerArreglo("uno|dos|tres|cuatro|cinco|seis|siete|ocho");
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
        String[] esperado = {"1.0", "dos", "tres", "cuatro", "cinco", "seis", "7.0"};
        Assert.assertArrayEquals(res, esperado);
    }
    
    @Test
    public void testNumero()
    {
        double n17 = g.numero("hola gaste diecisiete");
        double n12 = g.numero("doce");
        double n1244 = g.numero("mil doscientos cuarenta y cuatro");
        double n43000c02 = g.numero("cuarenta y tres mil con dos centavos");
        
        assertEquals(n17, 17.0, 0.009);
        assertEquals(n12, 12.0, 0.009);
        assertEquals(n1244, 1244.0, 0.009);
        assertEquals(n43000c02, 43000.02, 0.009);
    }
}
