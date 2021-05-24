package classes;



public class Nodo<T> {

    private T data;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo() {
        this.anterior = null;
        this.siguiente = null;
        this.data = null;
    }

    public Nodo(T data) {
        this.siguiente = null;
        this.anterior = null;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}