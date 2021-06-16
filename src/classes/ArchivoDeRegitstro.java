package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    protected BTree<Campo, Integer> arbolIndices;
    protected int offsetInicial = 43;

    public ArchivoDeRegitstro() {
    }

    public ArchivoDeRegitstro(File archivo, File archivoArbol) {
        try ( RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {
            this.cabezaAvail = raf.readInt();//4
            this.noRegistros = raf.readInt();//4
            Date fecha = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//21
            try {
                fecha = formato.parse(raf.readUTF());
                this.fechaCreacion = fecha;
            } catch (ParseException ex) {
                Logger.getLogger(ArchivoDeRegitstro.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.llavePrincipal = raf.readInt();//4
            } catch (Exception e) {
                this.llavePrincipal = -1;
            }
            try {
                this.secundarias = new ArrayList<>();
//                String lineaSecundaria = raf.readUTF();
//                String[] llavesSecundarias = lineaSecundaria.split("\\|");
                int auxSecundarias = raf.readInt();//4
                for (int i = 0; i < auxSecundarias; i++) {//Este bloque lo hice asi para no tener que almacernar como objeto binario los campos y tener un identificador de su tipo--Nuila
                    try {
                        this.secundarias.add(raf.readInt());//aun no
                    } catch (NumberFormatException e) {
                    }
                }
                this.offsetInicial += 4 * auxSecundarias;
            } catch (Exception e) {
                //e.printStackTrace();
            }
            try {
                this.camposDelArchivo = new ArrayList<>();
                int cantidadCampos = raf.readInt();//4
                for (int i = 0; i < cantidadCampos; i++) {//Este bloque lo hice asi para no tener que almacernar como objeto binario los campos y tener un identificador de su tipo--Nuila
                    String aux = raf.readUTF();
                    if (aux.endsWith("_int")) {
                        this.camposDelArchivo.add(new CampoEntero(aux));
                    } else if (aux.endsWith("_dec")) {
                        this.camposDelArchivo.add(new CampoDecimal(aux));
                    } else if (aux.endsWith("_str")) {
                        CampoTexto campoNuevo = new CampoTexto(aux);
                        this.offsetInicial += 4;
                        campoNuevo.setLongitud(raf.readInt());
                        this.camposDelArchivo.add(campoNuevo);
                    } else if (aux.endsWith("_car")) {
                        this.camposDelArchivo.add(new CampoCaracter(aux));
                    }
                }
                this.offsetInicial += 29 * cantidadCampos;
            } catch (Exception e) {
                //e.printStackTrace();
            }
            FileInputStream indices = new FileInputStream(archivoArbol);
            ObjectInputStream os = new ObjectInputStream(indices);
            BTree<Campo, Integer> arbolAux = null;
            arbolAux = (BTree<Campo, Integer>)os.readObject();

        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoDeRegitstro.class.getName()).log(Level.SEVERE, null, ex);
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
        return offsetInicial;
    }

}
