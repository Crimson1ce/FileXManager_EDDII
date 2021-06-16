package classes;

public class CampoDecimal extends Campo {

    protected Double valor;

    public CampoDecimal() {
    }

    public CampoDecimal(String nombreCampo) {
        super(nombreCampo);
        this.valor = 0.0;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
@Override
    public int compareTo(Campo o) {
        CampoDecimal comparacion = (CampoDecimal) o;
        return this.valor.compareTo(comparacion.getValor());
    }
}
