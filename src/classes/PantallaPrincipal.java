/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Krista
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listCamposPantalla = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_campos = new javax.swing.JList<>();
        jButton_agregar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jLabel_Title_Campos = new javax.swing.JLabel();
        jLabel_BG_campos = new javax.swing.JLabel();
        jPanel_BackGround = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Display = new javax.swing.JTable();
        jLabelPrincipal = new javax.swing.JLabel();
        jLabel_current = new javax.swing.JLabel();
        jLabel_Title = new javax.swing.JLabel();
        jLabel_BG = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        closeFile = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Campos = new javax.swing.JMenu();
        jMenuItem_listarCampos = new javax.swing.JMenuItem();
        Registros = new javax.swing.JMenu();
        introRegistros = new javax.swing.JMenuItem();
        modRegistros = new javax.swing.JMenuItem();
        searchRegistros = new javax.swing.JMenuItem();
        deleteRegistros = new javax.swing.JMenuItem();
        listRegistros = new javax.swing.JMenuItem();
        Indices = new javax.swing.JMenu();
        newIndex = new javax.swing.JMenuItem();
        reindexFile = new javax.swing.JMenuItem();
        Estandarizacion = new javax.swing.JMenu();
        exportExcel = new javax.swing.JMenuItem();
        exportXML = new javax.swing.JMenuItem();

        listCamposPantalla.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList_campos.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jList_campos);

        listCamposPantalla.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 197, 234));

        jButton_agregar.setBackground(new java.awt.Color(65, 67, 106));
        jButton_agregar.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(255, 204, 0));
        jButton_agregar.setText("Agregar");
        jButton_agregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.yellow, null, null));
        jButton_agregar.setBorderPainted(false);
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        listCamposPantalla.getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 100, -1));

        jButton_modificar.setBackground(new java.awt.Color(65, 67, 106));
        jButton_modificar.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        jButton_modificar.setForeground(new java.awt.Color(255, 204, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.yellow, null, null));
        jButton_modificar.setBorderPainted(false);
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });
        listCamposPantalla.getContentPane().add(jButton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 100, -1));

        jButton_eliminar.setBackground(new java.awt.Color(65, 67, 106));
        jButton_eliminar.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 204, 0));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.yellow, null, null));
        jButton_eliminar.setBorderPainted(false);
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        listCamposPantalla.getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 100, -1));

        jLabel_Title_Campos.setFont(new java.awt.Font("BankGothic Lt BT", 3, 36)); // NOI18N
        jLabel_Title_Campos.setForeground(new java.awt.Color(65, 67, 106));
        jLabel_Title_Campos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Title_Campos.setText("Campos");
        jLabel_Title_Campos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 67, 106), 3));
        listCamposPantalla.getContentPane().add(jLabel_Title_Campos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, -1));

        jLabel_BG_campos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Degradado 2.png"))); // NOI18N
        listCamposPantalla.getContentPane().add(jLabel_BG_campos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 350));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon("./src/recursos/x.png").getImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Display.setGridColor(new java.awt.Color(153, 0, 204));
        jTable_Display.setRowSelectionAllowed(false);
        jTable_Display.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(jTable_Display);

        jPanel_BackGround.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 950, 330));

        jLabelPrincipal.setText("Llave Principal: ");
        jPanel_BackGround.add(jLabelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 30));

        jLabel_current.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_current.setForeground(new java.awt.Color(255, 150, 119));
        jLabel_current.setText("Current File: ");
        jPanel_BackGround.add(jLabel_current, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 370, -1));

        jLabel_Title.setFont(new java.awt.Font("BankGothic Md BT", 3, 36)); // NOI18N
        jLabel_Title.setForeground(new java.awt.Color(255, 150, 119));
        jLabel_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Title.setText("File X Manager");
        jLabel_Title.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_BackGround.add(jLabel_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 370, -1));

        jLabel_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Degradado.png"))); // NOI18N
        jPanel_BackGround.add(jLabel_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 530));

        getContentPane().add(jPanel_BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        newFile.setText("Nuevo Archivo");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        Archivo.add(newFile);

        openFile.setText("Abrir Archivo");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        Archivo.add(openFile);

        saveFile.setText("Guardar Archivo");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        Archivo.add(saveFile);

        closeFile.setText("Cerrar Archivo");
        closeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileActionPerformed(evt);
            }
        });
        Archivo.add(closeFile);

        Exit.setText("Salir");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Archivo.add(Exit);

        MenuPrincipal.add(Archivo);

        Campos.setText("Campos");
        Campos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_listarCampos.setText("Listar Campos");
        jMenuItem_listarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_listarCamposActionPerformed(evt);
            }
        });
        Campos.add(jMenuItem_listarCampos);

        MenuPrincipal.add(Campos);

        Registros.setText("Registros");
        Registros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        introRegistros.setText("Introducir Registros");
        Registros.add(introRegistros);

        modRegistros.setText("Modificar Registros");
        Registros.add(modRegistros);

        searchRegistros.setText("Buscar Registros");
        Registros.add(searchRegistros);

        deleteRegistros.setText("Borrar Registros");
        Registros.add(deleteRegistros);

        listRegistros.setText("Listar Registros");
        Registros.add(listRegistros);

        MenuPrincipal.add(Registros);

        Indices.setText("Indices");
        Indices.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        newIndex.setText("Crear Indices");
        Indices.add(newIndex);

        reindexFile.setText("Re-indexar Archivos");
        Indices.add(reindexFile);

        MenuPrincipal.add(Indices);

        Estandarizacion.setText("Estandarizacion");
        Estandarizacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        exportExcel.setText("Exportar en archivo Excel");
        Estandarizacion.add(exportExcel);

        exportXML.setText("Exportar en XML con Schema");
        Estandarizacion.add(exportXML);

        MenuPrincipal.add(Estandarizacion);

        setJMenuBar(MenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        if (archivoCargado != null) {
            closeFileActionPerformed(evt); //Al correr el programa y abrir el primer archivo hace una corrida de esta linea, la cual no deberia pasar
            // porque por default no hay archivo cargado
        }

        JFileChooser jfc = new JFileChooser("./Files");//instanciar

        //y agregar una extension que filtre
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto", "txt");
        jfc.setFileFilter(filtro);
        int seleccion = jfc.showSaveDialog(this);//muestre la ventana 

        PrintWriter pw = null;

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File fichero = null; //instancia es null porque hay que ponerlo en una extension
                if (jfc.getFileFilter().getDescription().equals("Archivos de Texto")) { //si el filtro es archivo de texto
                    fichero = new File(jfc.getSelectedFile().getPath() + ".txt");//agarre el archivo y concatene la extension

                } else {
                    int replace = JOptionPane.showConfirmDialog(this, "¿Desea "
                            + "reemplazar el archivo existente?", "Reemplazar archivo.",
                            JOptionPane.YES_NO_OPTION);
                    if (replace != JOptionPane.YES_OPTION) {
                        return;
                    }
                    fichero = jfc.getSelectedFile();//capture el selected file
                }
                pw = new PrintWriter(fichero);//apunta al archivo
                pw.write(InsertMetadata());
                pw.write("");
                pw.flush();//pasar a rom
                JOptionPane.showMessageDialog(this, "Archivo creado exitosamente.");

                archivoCargado = fichero;
                jLabel_current.setText("Current file: " + archivoCargado.getName());
                jTable_Display.setModel(new DefaultTableModel(0, 0));
                saved = true;

                campos = new ArrayList<>();
                jList_campos.setModel(new DefaultListModel());

                pw.close();

            } catch (HeadlessException | FileNotFoundException e) {
            }
        }
    }//GEN-LAST:event_newFileActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        try {
            if (archivoCargado != null) {
                closeFileActionPerformed(evt); //Al correr el programa y abrir el primer archivo hace una corrida de esta linea, la cual no deberia pasar
                // porque por default no hay archivo cargado
            }
            JFileChooser jfc = new JFileChooser("./Files"); //donde deseamos que aparezca

            //crear los filtros
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto", "txt");
//            FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Imagenes", "jpg", "png", "bmp");

            //setear los filtros
            jfc.setFileFilter(filtro);//forma 1: marcado como seleccionado
//            jfc.addChoosableFileFilter(filtro2);//forma 2: agregarlo a la lista]
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION && jfc.getSelectedFile().isFile()) {
                loadFile(jfc.getSelectedFile());

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        if (!verifyOpen()) {
            return;
        }

        if (saved) {
            return;
        }

        try ( Scanner sc = new Scanner(archivoCargado)) {

            // Read the first line
            String line = sc.nextLine();

            // Divide the metadata fields
            String[] metadata = line.split("\\?");

            String aux = "";
            for (String temp : campos) {
                aux += temp + "|";
            }

            metadata[2] = aux;
            String aux2 = Arrays.toString(metadata);

            // Cut off the surrounding brackets
            aux2 = aux2.substring(1, aux2.length() - 1);

            //Replace the commas with ?
            aux2 = aux2.replaceAll(", ", "?");

            // Replace multiple spaces with single spaces
            aux2 = aux2.replaceAll(" +", " ");

            FileWriter fw = new FileWriter(archivoCargado, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(aux2);
            bw.flush();
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(this, "El archivo se ha guardado "
                    + "correctamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
            saved = true;
        } catch (IOException ex) {
            Logger.getLogger(classes.PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void closeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileActionPerformed
        if (!saved) {
            int save = JOptionPane.showConfirmDialog(this, "¿Desea guardar el "
                    + "archivo antes de cerrar?", "Guardar y cerrar.",
                    JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_OPTION) {
                saveFileActionPerformed(evt);
            }
            saved = true;
        }
        jLabel_current.setText("Current File:");
        archivoCargado = null;
        jTable_Display.setModel(new DefaultTableModel(0, 0));
        campos = new ArrayList<String>();
        jLabelPrincipal.setText("Llave principal: ");
    }//GEN-LAST:event_closeFileActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        if (!saved) {
            int save = JOptionPane.showConfirmDialog(this, "¿Desea guardar el "
                    + "archivo antes de salir?", "Guardar y cerrar.", JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_OPTION) {
                saveFileActionPerformed(evt);
            }
        }
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        String campo = JOptionPane.showInputDialog("Ingrese el nuevo campo a "
                + "anexar en los registros:");

        if (campo == null) {
            return;
        }

        campo = campo.strip().toUpperCase();

        if (campo.equals("")) {
            JOptionPane.showMessageDialog(listCamposPantalla, "El campo ingresado no es válido.", "No se"
                    + " puede añadir el campo", JOptionPane.ERROR_MESSAGE);
        } else if (campos.contains(campo)) {
            JOptionPane.showMessageDialog(listCamposPantalla, "El campo ingresado ya existe.", "No se"
                    + " puede añadir el campo", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel m = (DefaultTableModel) jTable_Display.getModel();
            m.addColumn(campo);
            jTable_Display.setModel(m);
            JOptionPane.showMessageDialog(listCamposPantalla, "Campo agregado exitosamente.");

            campos.add(campo);
            if (!tieneLlavePrincipal) {
                int opc = JOptionPane.showConfirmDialog(listCamposPantalla, "¿Desea hacer este campo su llave principal?");
                if (opc == JOptionPane.YES_OPTION) {
                    jLabelPrincipal.setText("Llave principal: " + campo);
                    //archivoEnUso.setLlavePrincipal(campos.indexOf(campo));
                    tieneLlavePrincipal = true;
                }
            }
            DefaultListModel mod = (DefaultListModel) jList_campos.getModel();
            mod.addElement(campo);
            jList_campos.setModel(mod);

            saved = false;
        }
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        try {
            int selection = jList_campos.getSelectedIndex();
            DefaultListModel mod = (DefaultListModel) jList_campos.getModel();

            // No hay nada seleccionado
            if (selection == -1) {
                return;
            }

            String modificacion = JOptionPane.showInputDialog(jList_campos, "Ingrese el "
                    + " nuevo nombre del campo:", mod.get(selection));

            if (modificacion == null || modificacion.strip().equals("")) {
                return;
            }

            modificacion = modificacion.strip().toUpperCase();

            if (modificacion.equals(mod.getElementAt(selection))) {
                JOptionPane.showMessageDialog(listCamposPantalla, "El nuevo campo es igual al antiguo.",
                        "Campos iguales.", JOptionPane.INFORMATION_MESSAGE);
                int opc = JOptionPane.showConfirmDialog(this, "¿Desea hacer este campo su llave principal?");
                if (opc == JOptionPane.YES_OPTION) {
                    jLabelPrincipal.setText("Llave principal: " + modificacion);
                    //archivoEnUso.setLlavePrincipal(campos.indexOf(campo));
                }
                return;
            } else if (campos.contains(modificacion)) {
                JOptionPane.showMessageDialog(listCamposPantalla, "El campo ingresado ya existe.", "No se"
                        + " puede modificar el campo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cambiamos el campo en el arreglo, que tiene 
            // los campos en el mismo orden que la lista
            campos.set(selection, modificacion);

            // Cambiamos el campo en la lista
            mod.set(selection, modificacion);

            jList_campos.setModel(mod);

            JOptionPane.showMessageDialog(listCamposPantalla, "Campo modificado con exito",
                    "REALIZADO", JOptionPane.INFORMATION_MESSAGE);

            // Modificamos el campo en la tabla.
            DefaultTableModel model = (DefaultTableModel) jTable_Display.getModel();
            model.setColumnIdentifiers(campos.toArray());

            saved = false;
        } catch (Exception E) {
            E.printStackTrace();
        }
    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        int selection = jList_campos.getSelectedIndex();

        // No hay nada seleccionado
        if (selection == -1) {
            return;
        }

        DefaultListModel mod = (DefaultListModel) jList_campos.getModel();

        int remove = JOptionPane.showConfirmDialog(listCamposPantalla, "¿Desea eliminar el "
                + "campo " + ((String) mod.get(selection)) + "?", "Eliminar campo.",
                JOptionPane.YES_NO_OPTION);
        if (remove != JOptionPane.YES_OPTION) {
            return;
        }

        mod.remove(selection);

        campos.remove(selection);

        DefaultTableModel model = (DefaultTableModel) jTable_Display.getModel();
        model.setColumnIdentifiers(campos.toArray());

        JOptionPane.showMessageDialog(listCamposPantalla, "Campo eliminado con éxito.",
                "REALIZADO", JOptionPane.INFORMATION_MESSAGE);

        saved = false;
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jMenuItem_listarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_listarCamposActionPerformed
        if (!verifyOpen()) {
            return;
        }
        listCamposPantalla.pack();
        listCamposPantalla.setLocationRelativeTo(this);
        listCamposPantalla.setModal(true);
        listCamposPantalla.setVisible(true);
    }//GEN-LAST:event_jMenuItem_listarCamposActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Campos;
    private javax.swing.JMenu Estandarizacion;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu Indices;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenu Registros;
    private javax.swing.JMenuItem closeFile;
    private javax.swing.JMenuItem deleteRegistros;
    private javax.swing.JMenuItem exportExcel;
    private javax.swing.JMenuItem exportXML;
    private javax.swing.JMenuItem introRegistros;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JLabel jLabelPrincipal;
    private javax.swing.JLabel jLabel_BG;
    private javax.swing.JLabel jLabel_BG_campos;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_Title_Campos;
    private javax.swing.JLabel jLabel_current;
    private javax.swing.JList<String> jList_campos;
    private javax.swing.JMenuItem jMenuItem_listarCampos;
    private javax.swing.JPanel jPanel_BackGround;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_Display;
    private javax.swing.JDialog listCamposPantalla;
    private javax.swing.JMenuItem listRegistros;
    private javax.swing.JMenuItem modRegistros;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem newIndex;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem reindexFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenuItem searchRegistros;
    // End of variables declaration//GEN-END:variables

    public String InsertMetadata() {
        /*
        RRN,Delimeter,#Registros,Campos,Version,Modified by,Last time modified,Date created
         */
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd hh:mm:ss");
        String strDateCreated = dateFormat.format(date) + "?";
        String campos = "" + "?";
        String delimeter = "|" + "?";
        String RRN = "" + "?";
        String numRegistros = "0" + "?";
        String lastestMod = System.getProperty("user.name");
        String Final = RRN + numRegistros + campos + delimeter + strDateCreated + lastestMod;
        return Final;

    }

    public String InsertMetadataWithLlavePrincipal(String Llave) {
        /*
        RRN,Delimeter,#Registros,Campos,Version,Modified by,Last time modified,Date created
         */
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd hh:mm:ss");
        String strDateCreated = dateFormat.format(date) + "?";
        String campos = "" + "?";
        String delimeter = "|" + "?";
        String RRN = "" + "?";
        String numRegistros = "0" + "?";
        String lastestMod = System.getProperty("user.name");
        String Final = RRN + numRegistros + campos + Llave + "?" + delimeter + strDateCreated + lastestMod;
        return Final;

    }

    private boolean verifyOpen() {
        if (archivoCargado == null) {
            JOptionPane.showMessageDialog(this, "Debe abrir un archivo para "
                    + "realizar esa operación.", "No hay un archivo abierto",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void loadFile(File file) {
        if (file == null) {
            return;
        }
        Scanner sc = null;
        archivoCargado = file;
        jLabel_current.setText("Current file: " + archivoCargado.getName());
        jTable_Display.setModel(new DefaultTableModel(0, 0));

        DefaultListModel list_model = new DefaultListModel();

        try ( FileReader fr = new FileReader(archivoCargado);  BufferedReader br = new BufferedReader(fr)) {

            try {
                sc = new Scanner(archivoCargado);
//                sc.useDelimiter(";");

                if (sc.hasNext()) {
                    String line = sc.nextLine();
//                    System.out.println("line+" + line);
                    String[] data = line.split("\\?");
                    String[] dataColumn = data[2].split("\\|");
//                    for (int i = 0; i < dataColumn.length; i++) {
//                        System.out.println("datacol" + dataColumn[i]);
//                    }
                    for (int i = 0; i < dataColumn.length; i++) {//Para cargar los registros en memoria una vez se abre el archivo
                        list_model.addElement(dataColumn[i]);
                        campos.add(dataColumn[i]);
                    }
                    jLabelPrincipal.setText("Llave Principal: " + data[3]);
                    //Modify the newly created table model
                    DefaultTableModel model = (DefaultTableModel) jTable_Display.getModel();
                    model.setColumnIdentifiers(dataColumn);

                    //Replace the jList model
                    jList_campos.setModel(list_model);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LinkedList registros = new LinkedList();

    private ArrayList<String> campos = new ArrayList<String>();
    private File archivoCargado;
    private boolean saved = true; //Debe incicializarse en true porque por default no hay un archivo abierto. Al crear un archivo se hace false.
    private boolean tieneLlavePrincipal = false;
    private ArchivoDeRegitstro archivoEnUso;
}
