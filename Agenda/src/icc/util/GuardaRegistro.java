/* -*- jde -*- */
/* <Buscador.java> */

package icc.util;

import java.io.*;
import icc.agenda.*;

/**
 * Interfaz para definir objetos que buscan otros que satisfagan cierta condición.
 */
public class GuardaRegistro implements Buscador {
	
	public PrintStream pst;

	/**
	*Constructor que recibe un PrintStream y lo guarda en un atributo.
	*/
	public GuardaRegistro(PrintStream s) {
			this.pst = s;
	}

	/**
	 * Método que utiliza al PrintStream para escribir contenido en el Registro.
	 */
	public boolean esEste(RegistroAgenda reg) {
		this.pst.println(reg);
		return false;
	}

}