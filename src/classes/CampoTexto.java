package classes;

public class CampoTexto extends Campo {

    protected String texto;

    public CampoTexto() {
    }

    public CampoTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }

}
