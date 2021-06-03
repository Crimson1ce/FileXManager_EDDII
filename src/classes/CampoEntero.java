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
    
}
