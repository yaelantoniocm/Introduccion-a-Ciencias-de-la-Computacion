/* -*- jde -*- */
/* <BuscadorPorNombre.java> */

package icc.agenda;

import icc.util.*;

/**
 * Clase que busca registros agenda con un nombre dado.
 */
public class BuscadorPorNombre implements Buscador {

	/* Nombre que se busca */
	private String nombreBuscado;

	/**
	 * Construye al buscador con el nombre que se va a buscar.
	 * @param Nombre que se va a buscar.
	 */
	public BuscadorPorNombre(String nombre) {
		nombreBuscado = nombre;
	}

	/**
	 * Método que indica si el objeto pasado como parámetro es el que se está buscando.
	 * @param reg Registro que se desea saber si corresponde al nombre buscado.
	 * @return true si <code>reg</code> tiene ese nombre y false si no es así.
	 */
	public boolean esEste(RegistroAgenda reg) {
		 return reg.getNombre().equals(nombreBuscado);
	}

}