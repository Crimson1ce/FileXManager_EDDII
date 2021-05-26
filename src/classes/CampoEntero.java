package classes;

public class CampoEntero extends Campo {
    
    protected Integer valor;
    
    public CampoEntero() {
    }
    
    public CampoEntero(Integer valor) {
        this.valor = valor;
    }
    
    public Integer getValor() {
        return valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
    
}
