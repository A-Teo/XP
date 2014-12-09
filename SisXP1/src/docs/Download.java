package docs;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
    private DefaultTableModel defaultTable;

    public Download() {
//        super(new BoxLayout(this, 50));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        GridBagConstraints c = new GridBagConstraints();

        CreateTable();

        downloadButton = new JButton("Download File");
        downloadButton.setEnabled(false);
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DownloadFile(false);
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
        FolderValidation();
        Scanner sc = new Scanner("C:/destination/");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        if (f.exists()) {
            File[] fs = f.listFiles();
            for (File fa : fs) {
                Date d = new Date(fa.lastModified());
                filesList.add(new FileProfile(fa.getName(), fa.length(), d, fa.getPath()));
            }
        } else {
            System.out.println("Error en la ruta");
            filesList = null;
        }

        System.out.println("filesList:      " + filesList.size());
    }

    private void CreateTable() {



//        table = new JTable(defaultTable);

        UpdateTable();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int rowIndex = table.getSelectedRow();
                currentPath = filesList.get(rowIndex).path;
                downloadButton.setEnabled(true);
            }
        });
    }

    public void UpdateTable() {
        defaultTable = new DefaultTableModel();
        defaultTable.addColumn("File Name");
        defaultTable.addColumn("Size");
        defaultTable.addColumn("Date");
        table = new JTable(defaultTable);
        GetFiles();


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

    public void setCurrentPath(String newPath) {
        this.currentPath = newPath;
    }

    public boolean DownloadFile(boolean test) {
        try {
            File file = new File(currentPath);
            if (file.exists() || test) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File(file.getName()));
                String PATH;

                if (!test) {
                    fileChooser.showSaveDialog(null);

                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();

                } else {
                    PATH = "test/resources/upload/newFile_jdk7.txt";
                }

                Files.copy(file.toPath(),
                        (new File(PATH)).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null,
                        "El archivo se a descargado Exitosamente",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                currentPath = null;
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha descargado",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha descargado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void FolderValidation() {
        File file = new File("C:/destination/");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
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
