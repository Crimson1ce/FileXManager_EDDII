package classes;

import java.util.ArrayList;
import java.util.Date;

public class ArchivoDeRegitstro {
    
    protected int llavePrincipal;
    protected Date fechaMod;
    protected Date fechaCreacion;
    protected Character delimitador;
    protected int noRegistros;
    protected String userCreador;
    protected long RRN;
    protected ArrayList<Campo>camposDelArchivo;
    protected ArrayList<Registro> registros;

    public ArchivoDeRegitstro() {
    }

    public ArchivoDeRegitstro(int llavePrincipal, Date fechaMod, Date fechaCreacion, Character delimitador, int noRegistros, String userCreador, long RRN, ArrayList<Campo> camposDelArchivo, ArrayList<Registro> registros) {
        this.llavePrincipal = llavePrincipal;
        this.fechaMod = fechaMod;
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

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
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

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
    
    
}
