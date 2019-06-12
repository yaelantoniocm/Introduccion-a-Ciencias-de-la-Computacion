package icc.coinExchange;
import icc.util.*;

/**
 * Clase para todas las posibilidades del cambio de moneadas de 1, 2, 5 y 10 pesos.
 */
public class Cambio {
	
	int x = 0;
	ManejadorDeLista l = new ManejadorDeLista();
	
	Cambio(int x) {
		this.x = x;
	}

	/**
	 * Este método es para sacar el cambio de 1 y 2 pesos.
	 */
	public static String unoDosPesos(int x, String y) {
		
		String aux="";

		if (x % 2 == 0) {
			for (int m = 0; m <= x; m+=2) {
				int n = (x-m)/2;		
				if (n != 0 && m == 0)
					aux = aux + y + n + " x 2 pesos \n";
				if (m != 0 && n == 0)
					aux = aux + y + m + " x 1 peso" + "\n";
				else if (m == 0 || n == 0)
					aux = aux;
				else
					aux = aux + y + n + " x 2 pesos + " + m + " x 1 peso" + "\n";
			}
			return aux;
		} else {
			for (int m = 1; m <= x; m+=2) {
				int n = (x-m)/2;
				if (n == 0)
					aux = aux + y + (x-n*2) + " x 1 peso \n";
				else
					aux = aux + y + n + " x 2 pesos + " + (x-n*2) + " x 1 peso" + "\n";
			}
			return aux;	
		/**  
		* Regresa las formas en las que puede dar el cambio con 1 y 2 pesos.
		*/
		}
			
	}

	/**
	 * Este método es para sacar el cambio de 1, 2 y 5 pesos.
	 */
	
	public static String cincoPesos(int x, String y) {
		
		String aux = "";

		if (x > 5) {
			
			for (int m = 0; m<x; m+=5) {
	
				if (m != 0) {				
					String n = y + m/5 + " x 5 pesos + ";
					aux = aux + unoDosPesos(x-m,n);
				}
				
			}
			return aux;
			
		} else {
			return unoDosPesos(x,y);
		/**  
		* Regresa las formas en las que puede dar el cambio con 1, 2 y 5 pesos.
		*/
		}
	
	}
	
	/**
	 * Este método es para sacar el cambio de 1, 2, 5 y 10 pesos.
	 */
	public static String diezPesos(int x) {
		
		String aux = "";
		
		for (int m = 0; m<=x; m+=10) {

			if (m != 0) {	
				String n = m/10 + " x 10 pesos + ";
				aux = cincoPesos(x-m,n);
			}
		}
		return aux;
	/**  
	* Regresa las formas en las que puede dar el cambio con 1,2,5 y 10 pesos.
	*/
	}
}