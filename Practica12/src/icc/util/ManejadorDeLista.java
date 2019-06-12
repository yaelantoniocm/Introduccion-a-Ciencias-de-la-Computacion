package icc.util;

/**
 * Clase para el uso de la clase Nodo.
 */
public class ManejadorDeLista {

	private static Nodo cabeza;
	private Nodo cola;

	public void agrega(Object y) {
		Nodo n = new Nodo(y,null);
		if (cabeza == null) {
			cola = n;
			cabeza = cola;
		}else {
			cola.setNext(n);
			cola = n;
		}
		
	}
	
	/**
	 * Este metodo se encargar de imprimir en la consola lo que hay en la lista.
	 */
	public void imprime() {
    	
    	Nodo temp = cabeza;
    	while(temp != null) {
    		System.out.println(temp.getData());
    		temp = temp.siguiente;
    	}
    	
    }
	
}
