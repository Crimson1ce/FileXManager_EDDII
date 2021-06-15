package classes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoDeRegitstro {
    
    protected int llavePrincipal;
    protected ArrayList<Integer> secundarias;
    protected Date fechaCreacion;
    protected int noRegistros;
    protected int cabezaAvail;
    protected ArrayList<Campo> camposDelArchivo;
    protected LinkedList<Integer> AvailList;
    
    public ArchivoDeRegitstro() {
    }
    
    public ArchivoDeRegitstro(File archivo) {
        try ( RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {
            this.cabezaAvail = raf.readInt();
            this.noRegistros = raf.readInt();
            Date fecha = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                fecha = formato.parse(raf.readUTF());
                this.fechaCreacion = fecha;
            } catch (ParseException ex) {
                Logger.getLogger(ArchivoDeRegitstro.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.llavePrincipal = raf.readInt();
            } catch (Exception e) {
                this.llavePrincipal = -1;
            }
            try {
                this.secundarias = new ArrayList<>();
//                String lineaSecundaria = raf.readUTF();
//                String[] llavesSecundarias = lineaSecundaria.split("\\|");
                int auxSecundarias = raf.readInt();
                for (int i = 0; i < auxSecundarias; i++) {//Este bloque lo hice asi para no tener que almacernar como objeto binario los campos y tener un identificador de su tipo--Nuila
                    try {
                        this.secundarias.add(raf.readInt());
                    } catch (NumberFormatException e) {
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
            try {
                this.camposDelArchivo = new ArrayList<>();
                int cantidadCampos = raf.readInt();
                for (int i = 0; i < cantidadCampos; i++) {//Este bloque lo hice asi para no tener que almacernar como objeto binario los campos y tener un identificador de su tipo--Nuila
                    String aux = raf.readUTF();
                    if (aux.endsWith("_int")) {
                        this.camposDelArchivo.add(new CampoEntero(aux));
                    } else if (aux.endsWith("_dec")) {
                        this.camposDelArchivo.add(new CampoDecimal(aux));
                    } else if (aux.endsWith("_str")) {
                        CampoTexto campoNuevo = new CampoTexto(aux);
                        campoNuevo.setLongitud(raf.readInt());
                        this.camposDelArchivo.add(campoNuevo);
                    } else if (aux.endsWith("_car")) {
                        this.camposDelArchivo.add(new CampoCaracter(aux));
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    public ArchivoDeRegitstro(int llavePrincipal, Date fechaCreacion, int noRegistros, int cabezaAvail, ArrayList<Campo> camposDelArchivo) {
        this.llavePrincipal = -1;
        this.fechaCreacion = fechaCreacion;
        this.noRegistros = noRegistros;
        this.cabezaAvail = cabezaAvail;
        this.camposDelArchivo = camposDelArchivo;
    }
    
    public int getLlavePrincipal() {
        return llavePrincipal;
    }
    
    public void setLlavePrincipal(int llavePrincipal) {
        this.llavePrincipal = llavePrincipal;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public int getNoRegistros() {
        return noRegistros;
    }
    
    public void setNoRegistros(int noRegistros) {
        this.noRegistros = noRegistros;
    }
    
    public int getCabezaAvail() {
        return cabezaAvail;
    }
    
    public void setCabezaAvail(int cabezaAvail) {
        this.cabezaAvail = cabezaAvail;
    }
    
    public LinkedList<Integer> getAvailList() {
        return AvailList;
    }
    
    public void setAvailList(LinkedList<Integer> AvailList) {
        this.AvailList = AvailList;
    }
    
    public ArrayList<Campo> getCamposDelArchivo() {
        return camposDelArchivo;
    }
    
    public void setCamposDelArchivo(ArrayList<Campo> camposDelArchivo) {
        this.camposDelArchivo = camposDelArchivo;
    }
    
    public ArrayList<Integer> getSecundarias() {
        return secundarias;
    }
    
    public void setSecundarias(ArrayList<Integer> secundarias) {
        this.secundarias = secundarias;
    }
    
    public int tamanioMetadata() {
        int bytes = 48;
        return bytes;
    }
    
    public int tamanioMetadataConPrincipal() {
        int bytes = 52;
        return bytes;
    }
    
    public int tamanioMetadataconPrincipalySecundarias() {
        int bytes = 48;
        bytes += secundarias.size();
        return bytes;
    }
}
