package icc.coinExchange;

import java.util.Scanner;
import icc.util.*;

/**
 * Clase para el uso de la clase Cambio.
 */
public class MaquinaDeCambio {
	
	/**
	 * Método que ejecuta el programa.
	 */
	public static void corre() {
		
		Scanner scanner = new Scanner(System.in);
		ManejadorDeLista l = new ManejadorDeLista();
		
		System.out.println("Introduce la cantidad de dinero:");
		try {
			
			int x = Integer.parseInt(scanner.nextLine());
			
			if (x <= 0)
				System.out.println("Introducir un valor mayor a cero.");
			
			Cambio micambio = new Cambio(x);
			
			if (x % 5 == 0)
				l.agrega(x/5 + " x 5 pesos.");
			
			if (x % 10 == 0)
				l.agrega(x/10 + " x 10 pesos.");
			
			if (x > 5)
				l.agrega(micambio.cincoPesos(x,""));
				
			if (x != 5)
				l.agrega(micambio.unoDosPesos(x,""));
			
			if (x > 9)
				l.agrega(micambio.diezPesos(x));
			
			l.imprime();
			System.exit(1);
			
		} catch(NumberFormatException e) {
			System.out.println("¡SE NECESITA QUE INGRESES NÚMEROS UNICAMENTE!.");
		}
		
	}

	/**
	 * El metodo main.
	 */
	public static void main(String[] args) {
		
		while(true) {
		corre();
		}
		
	}
	
}