package classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ArchivoDeRegitstro {

    protected int llavePrincipal;
    protected Date fechaCreacion;
    protected Character delimitador;
    protected int noRegistros;
    protected String userCreador;
    protected long RRN;
    protected ArrayList<Campo> camposDelArchivo;
    protected LinkedList<Registro> registros;

    public ArchivoDeRegitstro() {
    }

    public ArchivoDeRegitstro(File archivo) {
        try {
            Scanner sc = new Scanner(archivo);
            this.noRegistros = 0;
            if (sc.hasNext()) {
                this.camposDelArchivo = new ArrayList<>();
                this.registros = new LinkedList<>();
                String line = sc.nextLine();
                String[] data = line.split("\\?");
                if (data[0].equals("")) {
                    this.RRN = 0;
                } else {
                    this.RRN = Integer.parseInt(data[0]);
                }
                this.noRegistros = Integer.parseInt(data[1]);
                String[] dataColumn = data[2].split("\\|");
                for (int i = 0; i < dataColumn.length; i++) {//Este bloque lo hice asi para no tener que almacernar como objeto binario los campos y tener un identificador de su tipo--Nuila
                    String aux = dataColumn[i];
                    if (aux.contains("_int")) {
                        aux = aux.replace("_int", "");
                        this.camposDelArchivo.add(new CampoEntero(aux));
                    } else if (aux.contains("_dec")) {
                        aux = aux.replace("_dec", "");
                        this.camposDelArchivo.add(new CampoDecimal(aux));
                    } else if (aux.contains("_string")) {
                        aux = aux.replace("_string", "");
                        this.camposDelArchivo.add(new CampoTexto(aux));
                    } else if (aux.contains("_char")) {
                        aux = aux.replace("_char", "");
                        this.camposDelArchivo.add(new CampoCaracter(aux));
                    }
                }
                this.delimitador = data[3].charAt(0);
                Date fecha = null;
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    fecha = formato.parse(data[4]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.fechaCreacion = fecha;
                this.userCreador = data[5];
                if (data.length < 7) {
                    this.llavePrincipal = -1;
                } else {
                    this.llavePrincipal = Integer.parseInt(data[6]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArchivoDeRegitstro(int llavePrincipal, Date fechaCreacion, Character delimitador, int noRegistros, String userCreador, long RRN, ArrayList<Campo> camposDelArchivo, LinkedList<Registro> registros) {
        this.llavePrincipal = -1;
        this.fechaCreacion = fechaCreacion;
        this.delimitador = delimitador;
        this.noRegistros = noRegistros;
        this.userCreador = userCreador;
        this.RRN = RRN;
        this.camposDelArchivo = camposDelArchivo;
        this.registros = registros;
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

    public Character getDelimitador() {
        return delimitador;
    }

    public void setDelimitador(Character delimitador) {
        this.delimitador = delimitador;
    }

    public int getNoRegistros() {
        return noRegistros;
    }

    public void setNoRegistros(int noRegistros) {
        this.noRegistros = noRegistros;
    }

    public String getUserCreador() {
        return userCreador;
    }

    public void setUserCreador(String userCreador) {
        this.userCreador = userCreador;
    }

    public long getRRN() {
        return RRN;
    }

    public void setRRN(long RRN) {
        this.RRN = RRN;
    }

    public ArrayList<Campo> getCamposDelArchivo() {
        return camposDelArchivo;
    }

    public void setCamposDelArchivo(ArrayList<Campo> camposDelArchivo) {
        this.camposDelArchivo = camposDelArchivo;
    }

    public LinkedList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(LinkedList<Registro> registros) {
        this.registros = registros;
    }

}
