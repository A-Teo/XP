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
    
    public DocsView() {
        setTitle("Tabbed Pane");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
//        JPanel jp1 = new JPanel();
        JPanel jp2 = new Upload();
        
        
        
        Download newContentPane = new Download();
        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
        
        
//        JLabel label1 = new JLabel();
//        label1.setText("You are in area of Tab1");
        JLabel label2 = new JLabel();
        label2.setText("Tab2");
        jp2.add(label2);
        jtp.addTab("Download View", newContentPane);
        jtp.addTab("Upload View", jp2);
        
        
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
