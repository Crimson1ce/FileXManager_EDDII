package classes;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public abstract boolean equals(Object obj);
    
    
}
