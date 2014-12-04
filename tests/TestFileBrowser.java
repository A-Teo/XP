package fb;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFileBrowser {

	@Test
    public void testFileBrowser(){
        FileBrowser fb = new FileBrowser("/home/antonio/test");
        assertEquals("carpeta   -   2014-11-21\narchivo.txt 10  2014-11-21\n", fb.ls());
        assertTrue(fb.newPath("/home/antonio/test/carpeta"));
        assertEquals("..\n", fb.ls());
    }

}
