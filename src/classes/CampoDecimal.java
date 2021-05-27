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
        return String.valueOf(valor);
    }

}
