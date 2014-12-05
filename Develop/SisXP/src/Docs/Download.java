/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Docs;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WVasquez
 */
public class Download extends JPanel {

    private List<FileProfile> filesList;
    private JTable table;
    private JScrollPane scrollPane;
    private String currentPath;
    private JButton downloadButton;

    public Download() {
//        super(new BoxLayout(this, 50));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        GridBagConstraints c = new GridBagConstraints();

        GetFiles();
        CreateTable();

        downloadButton = new JButton("Download File");
        downloadButton.setEnabled(false);
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DownloadFile();
            }
        });
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 350, 100);
        scrollPane.revalidate();
        scrollPane.repaint();

        add(scrollPane);
        add(downloadButton);

    }

    private void GetFiles() {
        filesList = new ArrayList<>();
        Scanner sc = new Scanner("C:/destination/");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        if (f.exists()) {
            File[] fs = f.listFiles();
            for (File fa : fs) {
                Date d = new Date(fa.lastModified());
                System.out.println(fa.getName() + "\t" + fa.length() + "\t" + d.toString());
                filesList.add(new FileProfile(fa.getName(), fa.length(), d, fa.getPath()));
            }
        } else {
            System.out.println("Error en la ruta");
            filesList = null;
        }
    }

    private void CreateTable() {
        DefaultTableModel defaultTable = new DefaultTableModel();

        defaultTable.addColumn("File Name");
        defaultTable.addColumn("Size");
        defaultTable.addColumn("Date");

        table = new JTable(defaultTable);

        FillTable();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int rowIndex = table.getSelectedRow();
                currentPath = filesList.get(rowIndex).path;
                downloadButton.setEnabled(true);
                System.out.println(currentPath);
            }
        });
    }

    private void FillTable() {
        for (int i = 0; i < filesList.size(); i++) {
            FileProfile p = filesList.get(i);
            Object[] data = {p.name, p.size, p.date};

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.addRow(data);
        }
    }

    public String getCurrentPath() {
        return currentPath;
    }

    private void DownloadFile() {
        try {
            String nombre = "hhhhh";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                nombre = file.getSelectedFile().getName();
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + "Copia.txt", true);

//                save.write(areaDeTexto.getText());
//                save.write(System.lineSeparator());
//
//                save.close();
//                JOptionPane.showMessageDialog(null,
//                        "El archivo se a guardado Exitosamente",
//                        "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,
					 "Su archivo no se ha guardado",
					 "Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
    }

    public class FileProfile {

        private String name;
        private float size;
        private Date date;
        private String path;

        public FileProfile(String name, float size, Date date, String path) {
            this.name = name;
            this.size = size;
            this.date = date;
            this.path = path;
        }

        public String getName() {
            return name;
        }

        public float getSize() {
            return size;
        }

        public Date getDate() {
            return date;
        }

        public String getPath() {
            return path;
        }
    }
}
