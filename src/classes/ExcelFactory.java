package classes;

import java.awt.Component;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Josue
 */
public class ExcelFactory {

    private File file;
    private ArchivoDeRegitstro archivo;
    private Component parent;
    
    private final String EXTENSION = "xls";

    public ExcelFactory(File file, ArchivoDeRegitstro archivo, Component parent) {
        this.file = file;
        this.archivo = archivo;
        this.parent = parent;
    }

    public void exportExcel() {
        JFileChooser jfc = new JFileChooser("./Files");

        // Agregar una extension que filtre
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Hoja de cálculo de Microsoft Excel",
                EXTENSION);
        jfc.setFileFilter(filtro);

        File fichero;

        int seleccion = jfc.showSaveDialog(parent); // muestre la ventana
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            fichero = jfc.getSelectedFile();

        } else {
            JOptionPane.showMessageDialog(parent, "No se pudo exportar el archivo.",
                    "Exportación cancelada.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        writeExcel(fichero);
    }

    private void writeExcel(File fichero) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        createHeaderRow(sheet, archivo.getCamposDelArchivo());

        byte[] types = new byte[archivo.getCamposDelArchivo().size()];

        for (int i = 0; i < types.length; i++) {
            String nom = archivo.getCamposDelArchivo().get(i).getNombreCampo();
            if (nom.endsWith("int")) {
                types[i] = 1;
            } else if (nom.endsWith("dec")) {
                types[i] = 2;
            } else if (nom.endsWith("car")) {
                types[i] = 3;
            } else {
                types[i] = 4;
            }
        }

        int largo = archivo.longitudRegistro();
        int numReg = archivo.getNoRegistros();
        int position = archivo.tamanioMetadata();

        try ( RandomAccessFile raf = new RandomAccessFile(file, "r")) {

            for (int rowCount = 1; rowCount <= numReg; rowCount++) {

                raf.seek(position);

                if (raf.readChar() == '*') {
                    rowCount--;
                    position += largo;
                    continue;
                }

                Row row = sheet.createRow(rowCount);

                Registro record = new Registro(types.length);

                for (int i = 0; i < types.length; i++) {
                    switch (types[i]) {
                        case 1: {
                            CampoEntero c = new CampoEntero();
                            c.setValor(raf.readInt());
                            record.añadirCampo(c);
                            break;
                        }
                        case 2: {
                            CampoDecimal c = new CampoDecimal();
                            c.setValor(raf.readDouble());
                            record.añadirCampo(c);
                            break;
                        }
                        case 3: {
                            CampoCaracter c = new CampoCaracter(raf.readChar());
                            record.añadirCampo(c);
                            break;
                        }
                        case 4: {
                            CampoTexto c = new CampoTexto();

                            c.setLongitud(((CampoTexto) archivo.getCamposDelArchivo().get(i)).getLongitud());

                            c.setTexto(raf.readUTF());
                            record.añadirCampo(c);
                            break;
                        }
                    }
                }

                position += largo;
                writeRecord(row, record, types);
            }
        } catch (EOFException e) {
        } catch (Exception e) {
        }
        
        try (FileOutputStream out = new FileOutputStream(fichero.getPath() + "." + EXTENSION)) {
            
            workbook.write(out);
            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
    }

    private void writeRecord(Row row, Registro record, byte[] types) {

        for (int i = 0; i < types.length; i++) {
            Cell cell = row.createCell(i);

            Campo c = record.getCampos().get(i);

            switch (types[i]) {
                case 1: {
                    cell.setCellValue(((CampoEntero)c).getValor());
                    break;
                }
                case 2: {
                    cell.setCellValue(((CampoDecimal)c).getValor());
                    break;
                }
                case 3: {
                    cell.setCellValue(((CampoCaracter)c).getValor().toString());
                    break;
                }
                case 4: {
                    cell.setCellValue(((CampoTexto)c).getTexto());
                    break;
                }
            }
        }
    }

    private void createHeaderRow(Sheet sheet, ArrayList<Campo> campos) {

        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
//        cellStyle.setFillBackgroundColor((short) 0);

        Row row = sheet.createRow(0);

        for (int i = 0; i < campos.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(campos.get(i).getNombreCampo().substring(0, 25).strip());
        }
    }

}
