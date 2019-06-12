package icc.ajedrez;

import java.util.LinkedList;

public class Rey extends Pieza{

	protected Rey (int renglon, char columna){
		super(renglon, columna);
	}

	/**Método que calcula las posiciones a las qe se puede mover
	*el rey.
	*/
	@Override
	public LinkedList <Posicion> posiblesMovimientos(){
		
		LinkedList <Posicion> list = new LinkedList <> ();
		int renglon = posicion.getRenglon();
		char columna = posicion.getColumna();

		if (esValida(renglon, (char)(columna + 1)));
			list.add(new Posicion(renglon, (char)(columna + 1)));
		if (esValida(renglon, (char)(columna - 1)));
			list.add(new Posicion(renglon, (char)(columna -1)));
		if (esValida(renglon + 1, columna));
			list.add(new Posicion(renglon +1 ,columna));
		if (esValida(renglon - 1, columna));
			list.add(new Posicion(renglon - 1, columna));
		if (esValida(renglon + 1, (char)(columna + 1)));
			list.add(new Posicion(renglon + 1 , (char)(columna +1)));
		if (esValida(renglon + 1, (char)(columna - 1)));
			list.add(new Posicion(renglon + 1 , (char)(columna -1)));
		if (esValida(renglon - 1, (char)(columna + 1)));
			list.add(new Posicion(renglon - 1 ,(char)(columna + 1)));
		if (esValida(renglon - 1, (char)(columna - 1)));
			list.add(new Posicion(renglon - 1 , (char)(columna - 1)));

		return list;
	}

	/**Método que indica si es válido mover al rey a una casilla*/
	@Override
	public boolean esValida(int renglon, char columna){
		if (renglon <= 0 || renglon >= 9) return false;
		if (columna <= 96 || columna >= 105) return false;
		return true;
	}

	/**Método que devuelve una representación con cadena 
	*del rey y su estado actual.
	*/
	@Override
	public String toString(){
		return posicion.toString() + ", color: " + (color ? "blanco" : "negro");
	}
}