/* -*- jde -*- */
/* <ListaAgenda.java> */

package icc.util;

import icc.agenda.*;

/**
 * Clase para proveer los servicios de un contenedor tipo Lista.
 */
public class Lista{	

	/**
	 * Objeto almacenado.
	 */
	private RegistroAgenda elemento;

	/**
	 * Lista siguiente.
	 */
	private Lista siguiente;

	/**
	 * Construye una lista con un único elemento.
	 * @param El registro a almacenar.
	 */
	Lista(RegistroAgenda elemento){
		this.elemento = elemento;
	}

	/**
	 * Devuelve el elemento almacenado en esta lista.
	 */
	public RegistroAgenda getRegistro() {
		return this.elemento;
	}

	/**
	 * Devuelve la lista siguiente.
	 */
	public Lista getSiguiente(){
		return siguiente;
	}

	/**
	 * Asigna a la lista que va después de esta.
	 * @param siguiente: otra lista.
	 */
	public void setSiguiente(Lista siguiente){
		this.siguiente = siguiente;
	}
	
}