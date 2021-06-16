package classes;

import java.util.ArrayList;

public class Registro {

    protected ArrayList<Campo> Campos;

    public Registro(int numCampos) {
        Campos = new ArrayList<>(numCampos);
    }

    public ArrayList<Campo> getCampos() {
        return Campos;
    }

    public void setCampos(ArrayList<Campo> Campos) {
        this.Campos = Campos;
    }

    public void añadirCampo(Campo campo) {
        this.Campos.add(campo);
    }
}
