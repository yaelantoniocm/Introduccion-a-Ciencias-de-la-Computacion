/* -*- jde -*- */
/* <Buscador.java> */

package icc.util;

import icc.agenda.RegistroAgenda;

/**
 * Interfaz para definir objetos que buscan otros que satisfagan cierta condición.
 */
public interface Buscador{

	/**
	 * Método que indica si el registro pasado como parámetro es el que se está buscando.
	 * @param RegistroAgenda: Registro que se está buscando.
	 */
	boolean esEste(RegistroAgenda reg);

}