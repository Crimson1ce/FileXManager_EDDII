package classes;

public class CampoCaracter extends Campo {

    protected Character valor;

    public CampoCaracter(String nombreCampo) {
        super(nombreCampo);
        this.valor = ' ';
    }

    public CampoCaracter(Character valor) {
        this.valor = valor;
    }

    public Character getValor() {
        return valor;
    }

    public void setValor(Character valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public int compareTo(Campo o) {
        CampoCaracter comparacion = (CampoCaracter) o;
        return this.valor.compareTo(comparacion.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CampoCaracter)) return false;
        
        CampoCaracter c = (CampoCaracter) obj;
        return this.valor.equals(c.valor);
    }

}
