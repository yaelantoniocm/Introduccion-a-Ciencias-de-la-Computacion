package icc.estadisticas;

public class UsoEstadisticas {
	
	public static void main(String[] args) {
	/**
	* Método main.
	*/
		Estadisticas cifra = new Estadisticas();
		cifra.cargaArreglo("icc/estadisticas/" + args[0]);
		System.out.println("-Varianza: " + cifra.varianza());
		System.out.println("-Media: " + cifra.media());
		

	}

}