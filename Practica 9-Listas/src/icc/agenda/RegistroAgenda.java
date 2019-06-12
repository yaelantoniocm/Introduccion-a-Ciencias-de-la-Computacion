/* -*- jde -*- */
/* <RegistroAgenda.java> */

package icc.agenda;


/**
 * Registro para una Agenda
 */
public class RegistroAgenda {	

	// TODO: Declara aquí los atributos para almacenar
	// nombre, dirección y teléfono.
	private String nombre;
	private String direccion;
	private int telefono;
	/**
	 * Constructor.
	 */

	public RegistroAgenda(String nombre, String direccion, int telefono){
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono; 
	}
	/**
	 * Agrega los getters necesarios para leer la información en el registro.
	 */
	/**
	Regresa nombre del registro y despues la direccion y el telefono
	**/
	public String getNombre(){
		return this.nombre;
	}
	public String getDirección(){
		return this.direccion;
	}
	public int getTelefono(){
		return this.telefono;
	}
	/**
	 * Agrega los setters que permitan actualizar los datos de tu contacto.
	 */
	public void setNombre(String nombre){
		nombre = nombre;
	}
	public void setDireccion(String direccion){
		direccion = direccion;
	}
	public void setTelefono(int telefono){
		telefono = telefono;
	}
	

	/**
	 * Devuelve una cadena con los datos en el registro en un formato agradable.
	 */
	@Override
	public String toString(){
		return nombre + " | " +  direccion + " | " + telefono;
	}
}
