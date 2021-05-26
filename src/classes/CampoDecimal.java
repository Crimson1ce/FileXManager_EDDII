package classes;

public class CampoDecimal extends Campo {

    protected Float valor;
    
    public CampoDecimal() {
    }

    public CampoDecimal(Float valor) {
        this.valor = valor;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

    
    
    
}
