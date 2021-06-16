package classes;

import java.io.Serializable;

public abstract class Campo implements Comparable<Campo>, Serializable {

    private static final long serialVersionUID = 777L;

    protected String nombreCampo;

    public Campo() {
    }

    public Campo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public abstract String toString();
}
