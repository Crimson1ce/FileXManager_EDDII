package classes ;

public class CampoTexto extends Campo {

    protected String texto;
    protected int longitud;

    public CampoTexto() {
    }

    public CampoTexto(String nombreCampo) {
        super(nombreCampo);
        this.texto = "";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        
        if(texto.length() > this.longitud) {
            texto = texto.substring(0, longitud);
        } else {
            for (int i = texto.length(); i < longitud; i++) {
                texto += " ";
            }
        }
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return texto;
    }

    @Override
    public int compareTo(Campo o) {
        CampoTexto comparacion = (CampoTexto) o;
        return this.texto.compareTo(comparacion.getTexto());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CampoTexto)) return false;
        
        CampoTexto c = (CampoTexto) obj;
        return this.texto.strip().equals(c.texto.strip());
    }
    
    
}
