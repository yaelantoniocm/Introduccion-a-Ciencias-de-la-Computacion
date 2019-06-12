package icc.util;

class Nodo {
	
    Nodo siguiente;
    Object tipo;
    /**
     * Constructor del Nodo.
     */
    Nodo(Object tipo, Nodo siguiente) {
        this.tipo = tipo;
        this.siguiente = siguiente;
    }
    
    public Object getData() {
    	return tipo;
    /*
     Regresará lo que está en el nodo señalado.
     */
    }
    
    /**
     * Almacenará en el siguiente nodo.
     */
    public void setNext(Nodo siguiente) {
    	this.siguiente = siguiente;
    }
    
}