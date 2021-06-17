package classes;

public class CampoEntero extends Campo {

    protected Integer valor;

    public CampoEntero() {
    }

    public CampoEntero(String nombreCampo) {
        super(nombreCampo);
        this.valor = 0;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public int compareTo(Campo o) {
        CampoEntero comparacion = (CampoEntero) o;
        return this.valor.compareTo(comparacion.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CampoEntero)) return false;
        
        CampoEntero c = (CampoEntero) obj;
        return this.valor.equals(c.valor);
    }
}
