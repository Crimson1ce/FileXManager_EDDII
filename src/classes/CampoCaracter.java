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

}
