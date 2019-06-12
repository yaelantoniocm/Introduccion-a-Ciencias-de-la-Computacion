package icc.ajedrez;

public class Posicion{
	/*Atributos del ajedrez*/
	private int renglon;
	private char columna;

	public Posicion (int renglon, char columna){
		/**Constructor que recibe como parámetros la posicion de la pieza
		* y los asigna a sus atributos correpondientes.
		*/
		this.renglon = renglon;
		this.columna = columna;
	}
	
	public int getRenglon() {
		return renglon;
	}

	public char getColumna() {
		return columna;
	}
	public void setRenglon(int renglon) {
		if (renglon  <= 0 || renglon >= 9) throw new IllegalArgumentException ("Renglon inválido, sólo números en [1-8]. ");
		this.renglon = renglon;
	}
	public void setColumna (char columna) {
		if (columna <= 96 || renglon >= 105) throw new IllegalArgumentException ("Columna inválida, sólo carácteres en [a-h]. ");
		this.columna = columna;
	}
	public String toString( ) {
		return "[" + renglon + " , " + columna + "]";
	}
}

