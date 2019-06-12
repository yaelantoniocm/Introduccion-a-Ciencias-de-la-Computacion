/* -*- jde -*- */
/* <UsoBaseDeDatosAgenda.java> */

package icc.agenda;
import java.io.*;
import java.util.Scanner;

/**
 * Clase de uso donde se pueden crear un par de bases de datos y
 * realizar consultas.
 */
public class UsoBaseDeDatosAgenda {

	/*Atributos.*/
	private static Scanner scanner;
	private BaseDeDatosAgenda bus;

	public UsoBaseDeDatosAgenda(){
		scanner = new Scanner(System.in);
		bus = new BaseDeDatosAgenda();
	}

	/*
	 * Método que crea un nuevo registro de agenda.
	 * @returns Registro Agenda con los nuevos datos.
	 */
	private RegistroAgenda solicitaDatosDeContacto() {
		System.out.println("Dame los datos del nuevo contacto...");
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Direccion: ");
		String direccion= scanner.nextLine();
		System.out.println("Telefono: ");
		int telefono = scanner.nextInt();

		RegistroAgenda nuevo = new RegistroAgenda(nombre, direccion, telefono);
		return nuevo;
    }

	/**
	*Método que imprime el menú de las opciones posibles que puede
	*ingresar el usuario.
	*/
	private void imprimeMenu() {
		System.out.println("Opciones: ");
		System.out.println("1) Crear una base de datos");
		System.out.println("2) Cargar de disco");
		System.out.println("3) Guardar la Agenda");
		System.out.println("4) Agregar un registro");
		System.out.println("5) Buscar por nombre");
		System.out.println("6) Buscar un teléfono");
		System.out.println("7) Imprimirla toda");
		System.out.println("8) Salir");
	}

	/*
	 * Lee el número que el usuario haya escogido.
	 */
	private int leeEntero(String mensaje) {
         System.out.println(mensaje);
         boolean error = false;
         int num = -1;
         try {
             num = Integer.parseInt(scanner.nextLine());
             if (num <= 0) {
                 error = true;
                 System.out.println("El valor más chico posible es uno.");
             }
         } catch (NumberFormatException nfe) {
             error = true;
             System.out.println("Por favor ingresa un número válido.");
         }
         if (error) {
             num = leeEntero(mensaje);
         }
         return num;
     }


	/**
	*Método que corre el programa.
	*/
	public void corre() {
		System.out.println("**MENÚ**");
		boolean continuar = true;
		while(continuar) {
			imprimeMenu();
			int opcion = leeEntero("Selecciona una opción: ");
			switch(opcion) {
			
				case 1:
					System.out.println("Ingresa el nombre que deseas que tenga la Base de Datos: ");
					bus.creaBaseDeDatos(scanner.nextLine());
					break;

				case 2:
					System.out.println("Ingresa el nombre de la Base de Datos que deseas cargar: ");
					bus.carga(scanner.nextLine());
					break;

				case 3:
					System.out.println("Ingresa el nombre del archivo en el que guardarás la Agenda: ");
					bus.guardaAgenda(scanner.nextLine());
					break;

				case 4:
					RegistroAgenda rg= solicitaDatosDeContacto();
					bus.inserta(rg);
					break;

				case 5:
					System.out.println("Escribe el nombre del Registro que buscas:");
					String pista = scanner.nextLine();
					RegistroAgenda reg = bus.dameRegistroPorNombre(pista);
					if(reg == null)
						System.out.println("No se encontró ningún registro con nombre " + pista);
					else
						System.out.println("Se encontró a: " + reg.toString());
					break;


				case 6:
					System.out.println("Escribe el número del Registro que buscas:");
					int number = scanner.nextInt();
					RegistroAgenda regi = bus.dameRegistroPorTelefono(number);
					if(regi == null) {
						System.out.println("No se encontró ningún registro con tel+efono " + number);
					} else {
						System.out.println("Se encontró a: " + regi.toString());
					}
					break;

				case 7:
					bus.imprimeTodos();
					break;
					
				case 8:
					continuar = false;
					break;

				default:
						System.out.println("Esa no es una opción válida del menú.");
			}
		}


	}

	public static void main(String[] args) {
	UsoBaseDeDatosAgenda impresion = new UsoBaseDeDatosAgenda();
	impresion.corre();
	}
	
}