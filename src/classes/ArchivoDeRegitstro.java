package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                        campoNuevo.setLongitud(raf.readInt());
                        this.camposDelArchivo.add(campoNuevo);
                    } else if (aux.endsWith("_car")) {
                        this.camposDelArchivo.add(new CampoCaracter(aux));
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
            FileInputStream indices = new FileInputStream(archivoArbol);
            ObjectInputStream os = new ObjectInputStream(indices);

            BTree<Campo, Integer> arbolAux = (BTree<Campo, Integer>) os.readObject();

            this.arbolIndices = arbolAux;

            reconstruirAvailList(archivo);

        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ArchivoDeRegitstro.class.getName()).log(Level.SEVERE, null, ex);
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

    private int getCabezaAvail() {
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
        int total = 43 + (4 * secundarias.size()) + (31 * camposDelArchivo.size());

        for (int i = 0; i < camposDelArchivo.size(); i++) {
            if (camposDelArchivo.get(i) instanceof CampoTexto) {
                total += 4;
            }
        }

        return total;
    }

    public int longitudRegistro() {
        int ret = 0;

        for (int i = 0; i < this.camposDelArchivo.size(); i++) {
            Campo c = camposDelArchivo.get(i);
            if (c instanceof CampoEntero) {
                ret += 4;
            } else if (c instanceof CampoDecimal) {
                ret += 8;
            } else if (c instanceof CampoCaracter) {
                ret += 2;
            } else {
                ret += 2 + ((CampoTexto) c).getLongitud();
            }
        }

        return ret + 4; //Sumamos 2 por la escritura del newline con el writeChars() method
    }

    public BTree<Campo, Integer> getArbolIndices() {
        return arbolIndices;
    }

    public File updateTree(File fileIndices) {

//        String path = fileIndices.getPath();
//        fileIndices.delete();
//        
//        fileIndices = new File(path);
        try ( FileOutputStream fs = new FileOutputStream(fileIndices, false);  ObjectOutputStream os = new ObjectOutputStream(fs)) {

            os.writeObject(this.arbolIndices);
            os.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileIndices;
    }

    private void reconstruirAvailList(File file) {

        try ( RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            int pos = this.cabezaAvail;
            this.AvailList = new LinkedList<>();

            while (pos != -1) {
                this.AvailList.insertarAlFinal(pos);
                raf.seek(pos);

                raf.readChar();
                pos = raf.readInt();
            }

        } catch (Exception e) {
        }

    }

    public void updateSecondaryKeys(int removed) {
        for (int i = 0; i < secundarias.size(); i++) {
            int val = secundarias.get(i);

            if (val > removed) {
                secundarias.set(i, val - 1);
            } else if (val == removed) {
                Integer old = secundarias.remove(i--);
            }
        }
    }

}
