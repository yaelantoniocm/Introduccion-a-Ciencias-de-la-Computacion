/* -*- jde -*- */
/* <BuscadorPorNombre.java> */

package icc.agenda;

import icc.util.*;

/**
 * Clase que busca registros agenda con un nombre dado.
 */
public class BuscadorPorTelefono implements IBuscador {

	/* Nombre que se busca */
	private int telefonoBuscado;

	/**
	 * Construye al buscador con el nombre que
	 * va a buscar.
	 */
	public BuscadorPorTelefono(int telefono) {
		telefonoBuscado = telefono;
	}

	/**
	 * Método que indica si el objeto pasado como parámetro
	 * es el que se está buscando.
	 * @param reg Registro que se desea saber si corresponde
	 *        al nombre buscado.
	 * @returns si <code>reg</code> tiene ese nombre.
	 */
	public boolean esEste(RegistroAgenda reg) {
		 return reg.getTelefono() == telefonoBuscado;
	}

}