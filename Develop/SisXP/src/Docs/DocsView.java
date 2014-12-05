/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Docs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 *
 * @author WVasquez
 */
public class DocsView extends JFrame {
    
    private Download downloadPanel;
    private JPanel uploadPanel;
    
    public DocsView() {
        setTitle("Tabbed Pane");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        
        
        downloadPanel = new Download();
        uploadPanel = new Upload(downloadPanel);
       
        jtp.addTab("Download View", downloadPanel);
        jtp.addTab("Upload View", uploadPanel);
        
        
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Download getDownloadPanel() {
        return downloadPanel;
    }

    public JPanel getUploadPanel() {
        return uploadPanel;
    }
}
