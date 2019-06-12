package icc.estadisticas;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


/**
 * Esta calse se encargara en calcular las estadisticas dadas por el archivo texto.
 */
public class Estadisticas {
	double[] cifras;
	
	/**
	 * Es el método que carga en un arreglo los datos de un.txt
	 * 
	 */
	public void cargaArreglo(String path) {
		try {
			BufferedReader mibuffer=new BufferedReader(new FileReader(path));
			int y = Integer.parseInt(mibuffer.readLine());
			
			if (y > 0)
				cifras = new double[y];
			else
				throw new ArrayIndexOutOfBoundsException("Ingrese un número natural el el primero renglón para poder calcular.");

			for(int n = 0; n < cifras.length; n++) {
				cifras[n] = Double.parseDouble(mibuffer.readLine());
			}		
			
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no esta.");
			
		} catch (IOException e) {
			System.out.println("Los numeros no estan.");
		}
		
	}
	
	/**
	 * Este metodo calculara la media que se le pase. 
	 */
	public double media() {
		if (cifras == null)
			return 0;
		/*
		Si el arreglo es null regresara 0.
		*/
		else {
			double x = 0;
			for(int n = 0; n <cifras.length; n++) {
				x += cifras[n];
			}
			return x/cifras.length;
		/*
		Regresa "Media" del arreglo.
		*/
		}
	
	}
	
	/**
	 * Método que calcula la varianza del array que se le pase.
	 */
	public double varianza() {
		
		if (cifras == null)
			return 0;
		/* 
		Si el arreglo es null devuelve un 0
		*/
		else {
			double y = 0;
			double med = media();
			
			for(int n = 0; n < cifras.length; n++) {
				y = y + Math.pow(cifras[n] - med,2);
			}
			return y/cifras.length;
		}
	/* 
	Regresa Varianza del arreglo.
	*/
	}
	
}