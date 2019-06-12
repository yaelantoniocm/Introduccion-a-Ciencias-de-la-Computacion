/* -*- jde -*- */
/* <ManejadorDeLista.java> */

package icc.util;

import icc.agenda.*;

/**
 * Clase para proveer los servicios de un contenedor tipo Lista.
 */
public class ManejadorDeLista {


	/**
	 * Primer elemento de la lista.
	 */
	private Lista cabeza;

	/**
	 * Número de elementos en la lista.
	 */
	private int longitud;

	/**
	 * Agrega un registro agenda al final de la lista.
	 */
	public void agrega(RegistroAgenda elemento) {

		Lista nuevo = new Lista(elemento);
		longitud++;

		if (cabeza == null) {
			cabeza = nuevo;
			return;
		}

		Lista anterior = cabeza;
		while(anterior.getSiguiente() != null) {
			anterior = anterior.getSiguiente();
		}
		anterior.setSiguiente(nuevo);
	}

	/**
	 * Devuelve el número de elementos en esta lista.
	 */
	public int longitud() {
		return longitud;
	}

	/**
	 * Búsqueda en la base de datos.
	 */
	public RegistroAgenda encuentra(Buscador buscador) {

		Lista tmp = this.cabeza;

		while (tmp != null) {
			if (buscador.esEste(tmp.getRegistro()))
				return tmp.getRegistro();

			tmp = tmp.getSiguiente();
		}
		return null;
	}
	
	/*
	 * Método que accede a la cabeza de la lista.
	 * @return Cabeza de la lista.
	 */
	public Lista getCabeza(){
		return this.cabeza;
	}

}