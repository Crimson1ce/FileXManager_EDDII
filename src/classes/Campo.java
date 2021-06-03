package classes;

public abstract class Campo {

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
