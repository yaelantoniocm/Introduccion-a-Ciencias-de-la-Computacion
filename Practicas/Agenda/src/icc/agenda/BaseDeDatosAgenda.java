/* -*- jde -*- */
/* <BaseDeDatosAgenda.java> */

package icc.agenda;

import java.io.*;
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
	 * Constructor por defecto, crea una nueva tabla. 
	 */
	public BaseDeDatosAgenda(){
		this.tabla = new ManejadorDeLista();
	}

	/**
	 * Constructor.
	 * @param datos Una cadena con el formato requerido por esta base
	 *        con los registros de nombres, direcciones y teléfonos.
	 * @param tam_nombre Longitud del nombre.
	 * @param tam_direccion Longitud de la dirección.
	 * @param tam_telefono Longitud del teléfono.
	 */
	public BaseDeDatosAgenda(String datos, int tam_nombre, int tam_direccion, int tam_telefono) {
		
		int tam_registro;
		tam_registro = tam_nombre + tam_direccion + tam_telefono;

		this.tabla = new ManejadorDeLista();
		
		int index = 0;

		while (index < datos.length()) {
			
			String tmpReg = datos.substring(index, index + tam_registro);

			String nombre = tmpReg.substring(0, tam_nombre).trim();
			String direccion = tmpReg.substring(tam_nombre, tam_nombre + tam_direccion).trim();
			int telefono = Integer.parseInt(tmpReg.substring(tam_nombre + tam_direccion, tmpReg.length()).trim());

			RegistroAgenda r = new RegistroAgenda(nombre, direccion, telefono);

			this.tabla.agrega(r);

			index += tam_registro;
			
		}
	}

	/**
	 * Inserta registros.
	 * @param Registro que se quiere insertar. 
	 */
	public void inserta(RegistroAgenda rg){
			tabla.agrega(rg);
	}

	/**
	 * Guarda los registros en una base de datos.
	 * @param Nombre de la base de datos en donde se desea guardar los registros.
	 */
	public void guardaAgenda(String nombreArchivo){
		
		try (PrintStream nuevaAg = new PrintStream(nombreArchivo)) {
			GuardaRegistro gr = new GuardaRegistro(nuevaAg);
			this.tabla.encuentra(gr);
		} catch(FileNotFoundException fnfe) {
			System.err.println("No se encontró el archivo " + nombreArchivo + " y no pudo ser creado.");
		} catch(SecurityException se){
			System.err.println("No se tiene permiso de escribir en el archivo.");
		}
		
	}
	
	/**
	 * Crea una base de datos.
	 * @param Nombre de la base de datos.
	 */
	public void creaBaseDeDatos(String nombreArchivo) {
		
		try {
			PrintStream nuevaAg = new PrintStream(nombreArchivo);
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo crear el archivo.");
		}
		
	}
	
	/**
	 * Devuelve el registro que tiene el nombre que se le pasó por parámetro.
	 * @param  nombre: Nombre que se quiere buscar en el registro.
	 * @return registro que tiene el nombre que se le pasó por parámetro.
	 */
	public RegistroAgenda dameRegistroPorNombre(String nombre) {
		
		BuscadorPorNombre b = new BuscadorPorNombre(nombre);
		return this.tabla.encuentra(b);
		
	}

	/**
	 * Devuelve el registro que tiene el telefono que se le pasó por parámetro.
	 * @param  telefono: Telefono que se quiere buscar en el registro.
	 * @return registro que tiene el telefono que se le pasó por parámetro.
	 */
	public RegistroAgenda dameRegistroPorTelefono(int tel) {

		BuscadorPorTelefono b = new BuscadorPorTelefono(tel);
		return this.tabla.encuentra(b);
		
	}
	
	/**
	 * Imprime todos los registros de la base de datos. 
	*/
	public void imprimeTodos() {
		Lista aux = this.tabla.getCabeza();
		while (aux != null) {
			System.out.println(aux.getRegistro().toString());
			aux = aux.getSiguiente();
		}
	}
	
	/**
	 * Carga una base de datos
	 * @param Nombre del archivo de la base de datos.
	 */
	public void carga(String nombreArchivo) {
		
		try {
			
			BufferedReader cargar = new BufferedReader(new FileReader(nombreArchivo));
		
			String linea = "";
			
			while(linea!=null) {

				if(linea!=null)
					linea = cargar.readLine();
				
			}
		
		} catch (IOException e) {
			System.out.println("No se pudo cargar el archivo " + nombreArchivo);
		}
		
	}
	
}