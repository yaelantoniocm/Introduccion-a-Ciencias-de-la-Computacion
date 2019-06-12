package icc.ajedrez;

import java.util.LinkedList;

public abstract class Pieza {
	
	protected Posicion posicion;
	protected boolean color;

	protected Pieza (int renglon, char columna){
		posicion = new Posicion(renglon, columna);
		color = true;
	}
	/**Método que indica las posiciones de todas las casillas 
	* a las cuales se puede mover la pieza.
	*/
	public abstract LinkedList <Posicion> posiblesMovimientos();

	/**Método que indica si es válido mover la pieza a una casilla*/
	public abstract boolean esValida(int renglon, char columna);

	/**Método que devuelve una representación con cadena 
	*de la pieza y su estado actual.
	*/
	public abstract String toString();

	public int setRenglon(int renglon){
		return renglon;
	}
	public char setColumna(char columna){
		return columna;
	}

	public int getRenglon(){
		return posicion.getRenglon();
	}

	public char getColumna(){
		return posicion.getColumna();
	}
}