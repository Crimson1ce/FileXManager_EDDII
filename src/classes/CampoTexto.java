package classes;

public class CampoTexto extends Campo {

    protected String texto;
    protected int longitud;

    public CampoTexto() {
    }

    public CampoTexto(String nombreCampo) {
        super(nombreCampo);
        this.texto = "";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    
    @Override
    public String toString() {
        return texto;
    }

}
