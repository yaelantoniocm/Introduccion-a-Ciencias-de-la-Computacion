package icc.ajedrez;

import java.util.LinkedList;

public class Caballo extends Pieza{

	protected Caballo (int renglon, char columna){
		super(renglon, columna);
	}

	/**Método que calcula las posiciones a las qe se puede mover
	*el caballo.
	*/
	@Override
	public LinkedList <Posicion> posiblesMovimientos(){
		
		LinkedList <Posicion> list = new LinkedList <> ();
		int renglon = posicion.getRenglon();
		char columna = posicion.getColumna();

		if (esValida(renglon + 2, (char)(columna - 1)));
			list.add(new Posicion(renglon + 2, (char)(columna - 1)));
		if (esValida(renglon + 2, (char)(columna + 1)));
			list.add(new Posicion(renglon + 2, (char)(columna + 1)));		
		if (esValida(renglon -2, (char)(columna - 1)));
			list.add(new Posicion(renglon - 2 , (char)(columna -1)));		
		if (esValida(renglon - 2, (char)(columna + 1)));
			list.add(new Posicion(renglon - 2, (char)(columna + 1)));		
		if (esValida(renglon + 1, (char)(columna - 2)));
			list.add(new Posicion(renglon + 1 , (char)(columna - 2)));		
		if (esValida(renglon + 1, (char)(columna + 2)));
			list.add(new Posicion(renglon + 1 , (char)(columna + 2)));		
		if (esValida(renglon - 1, (char)(columna - 2)));
			list.add(new Posicion(renglon - 1 ,(char)(columna - 2)));		
		if (esValida(renglon - 1, (char)(columna + 2)));
			list.add(new Posicion(renglon - 1 , (char)(columna + 2)));
		
		return list;
	}

	/**Método que indica si es válido mover el caballo a una casilla*/
	@Override
	public boolean esValida(int renglon, char columna){
		if (renglon <= 0 || renglon >= 9) return false;
		if (columna <= 96 || columna >= 105) return false;
		return true;

	}

	@Override
	public String toString(){
		return posicion.toString() + ", color: " + (color ? "blanco" : "negro");
	}
}