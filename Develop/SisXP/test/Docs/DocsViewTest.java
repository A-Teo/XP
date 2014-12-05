/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Docs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author WVasquez
 */
public class DocsViewTest {
    
    public DocsViewTest() {
    }

    @Test
    public void testUploadFile() throws IOException {
        DocsView docs = new DocsView();
        
        int randomNum =  + (int)(Math.random()*10000); 
        Path newFilePath = Paths.get("test/resources/download/newFile"+randomNum+"_jdk7.txt");
        Files.createFile(newFilePath);
        
        File file = new File(newFilePath.toUri());
        
        Upload upload = (Upload)docs.getUploadPanel();
        upload.setFile(file);
        assertTrue(upload.guardarArchivo());
    }
    
    @Test
    public void testDownloadFile() throws IOException {
        DocsView docs = new DocsView();
        
        int randomNum =  + (int)(Math.random()*100); 
        Path newFilePath = Paths.get("C:/destination/newFile_jdk7.txt");
        
        Download download = docs.getDownloadPanel();
        download.setCurrentPath(newFilePath.toString());
        assertTrue(download.DownloadFile(true));
    }
}
