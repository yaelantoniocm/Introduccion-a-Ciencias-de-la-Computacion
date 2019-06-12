/* -*- jde -*- */
/* <BaseDeDatosAgenda.java> */

package icc.agenda;
import icc.util.*;

/**
 * Clase para representar una Base de Datos de agenda.
 *
 * Una base de datos debe ser capaz de obtener registros, y campos
 * de sus registros, y debe ser capaz de reconocer si un campo o registro
 * solicitado no existe, y dar una respuesta coherente.
 */
public class BaseDeDatosAgenda {	

	/**
	 * Este objeto llevará el control de los registros guardados en la lista.
	 */
	private ManejadorDeLista tabla;

	/**
	 * Constructor.
	 * @param datos Una cadena con el formato requerido por esta base
	 *        con los registros de nombres, direcciones y teléfonos.
	 * @param tam_nombre va a ser la longitud del nombre
	 * @param tam_telefono va a ser la longitud del telefono
	 * @param tam_direccion va a ser la longitud de la direccion

	 */
	public BaseDeDatosAgenda(String datos, int tam_nombre, int tam_direccion, int tam_telefono){
				 
		int tam_registro = tam_nombre + tam_direccion + tam_telefono;
		tabla = new ManejadorDeLista();
		
		if(datos.length() % tam_registro !=0) System.out.println("CADENA INVALIDA");
		// TODO: Crear el ManejadorDeLista para almacenar ahí los registros.
		
		int pos = 0;
		String nombre, direccion, varReg;
		int telefono;
		
		while(pos < datos.length()){
			
			varReg = datos.substring(pos, pos + tam_registro);
			nombre = varReg.substring(0, tam_nombre).trim();
			direccion = varReg.substring(tam_nombre, tam_nombre + tam_direccion).trim();
			telefono = Integer.parseInt(varReg.substring(tam_nombre + tam_direccion, varReg.length()).trim());
			RegistroAgenda x = new RegistroAgenda(nombre, direccion, telefono);
			tabla.agrega(x);
			pos += tam_registro; 
		}
	
	}
	public RegistroAgenda dameRegistroPorNombre (String nombre) {
		// TODO: Usa BuscadorPorNombre y el método encuentra de ManejadorDeLista
		// para encontrar el registro correcto dentro de la lista.
		BuscadorPorNombre b = new BuscadorPorNombre(nombre);
		return (RegistroAgenda)this.tabla.encuentra(b);
	}

	public RegistroAgenda dameRegistroPorTelefono (int telefono) {
		// TODO: Crea la clase BuscadorPorTelefono en forma similar a BuscadorPorNombre
		// Usa BuscadorPorTelefono y el método encuentra de ManejadorDeLista
		// para encontrar el registro correcto dentro de la lista.
		BuscadorPorTelefono b = new BuscadorPorTelefono(telefono);
		return (RegistroAgenda)this.tabla.encuentra(b);
	}
}
