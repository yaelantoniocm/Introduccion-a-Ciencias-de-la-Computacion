/* -*- jde -*- */
/* <RegistroAgenda.java> */
package icc.agenda;

import java.io.*;
import java.util.Scanner;

/**
 * Registro para una Agenda
 */
public class RegistroAgenda {

	private String nombre;
	private String direccion;
	private int telefono;
	private RegistroAgenda aa;
	private Scanner scanner;

	/**
	 * Constructor.
	 */
	 public RegistroAgenda(){
		 aa = new RegistroAgenda();
	 }
	 public RegistroAgenda(String nombre, String direccion, int telefono){
		 this.nombre = nombre;
		 this.direccion = direccion;
		 this.telefono = telefono;
	 }
	 
	 /**
     * Devuelve el nombre del registro.
     * @return Nombre del registro.
     */
	 public String getNombre(){
		 return this.nombre;
	 }

	 /**
	 * Devuelve la dirección del registro.
	 * @return Dirección del registro.
	 */
	 public String getDireccion(){
		 return this.direccion;
	 }
   
	/**
	* Devuelve el telefono del registro.
	* @return Telefono del registro.
	*/
	 public int getTelefono(){
		 return this.telefono;
	 }

	/**
	* Agrega el nombre al registro.
	* @param Nombre que se le quiere poner al registro.
	*/
	 public void setNombre(String n){
		 this.nombre = n;
	 }

	 /**
	 * Agrega la dirección al registro.
	 * @param Dirección que se le quiere poner al registro.
	 */
	 public void setDireccion(String d){
		 this.direccion = d;
	 }

	 /**
	 * Agrega el telefono al registro.
	 * @param Telefono que se le quiere poner al registro.
	 */
	 public void setTelefono(int t){
		 this.telefono = t;
	 }

    /**
    * Devuelve una cadena con los datos en el registro en un formato agradable.
    * @return Cadena con los datos del registro.
    */
	public String toString() {
		return this.nombre + " | " + this.direccion + " | " + this.telefono;
	}

	/**
	 * Escribe un registro en la base de datos.
	 * @param Registro que se desea poner en la base de datos.
	*/
	public void escribe(PrintStream pst){
		String nombreArchivo = scanner.nextLine();
		try (PrintStream ps = new PrintStream(nombreArchivo)) {
			ps.print("Nombre: "+ aa.getNombre());
			ps.println("Dirección: " + aa.getDireccion());
			ps.println("Teléfono: " + aa.getTelefono());
			} catch(FileNotFoundException fnfe) {
			System.err.println("No se encontró el archivo " + nombreArchivo + " y no pudo ser creado.");
		} catch(SecurityException se){
			System.err.println("No se tiene permiso de escribir en el archivo.");
		}

	}
}