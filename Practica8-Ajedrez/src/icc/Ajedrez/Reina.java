package icc.ajedrez;

import java.util.LinkedList;

public class Reina extends Pieza{

	protected Reina (int renglon, char columna){
		super(renglon, columna);
	}

	/**Método que calcula las posiciones a las qe se puede mover
	*la reina.
	*/
	@Override
	public LinkedList <Posicion> posiblesMovimientos(){
		
		LinkedList <Posicion> list = new LinkedList <> ();
		int renglon = posicion.getRenglon();
		char columna = posicion.getColumna();


		while (esValida(renglon + 1, columna)){
			list.add(new Posicion(renglon + 1, columna));
			renglon = renglon +1;
		} 

		while(esValida(renglon, (char)(columna + 1))){
			list.add(new Posicion(renglon, (char)(columna + 1)));
			columna = (char)(columna +1);
		}

		while (esValida(renglon, (char)(columna - 1))){
			list.add(new Posicion(renglon, (char)(columna - 1)));
			columna = (char)(columna -1);
		}

		while(esValida(renglon - 1, columna)){
			list.add(new Posicion(renglon - 1,columna));
			renglon = renglon -1;
		}

		while(esValida(renglon + 1, (char)(columna + 1))){
			list.add(new Posicion(renglon  + 1, (char)(columna + 1)));
			renglon = renglon +1;
			columna = (char)(columna +1);
		}

		while(esValida(renglon + 1, (char)(columna - 1))){
			list.add(new Posicion(renglon + 1, (char)(columna - 1)));
			renglon = renglon +1;
			columna = (char)(columna -1);
		}

		while(esValida(renglon - 1, (char)(columna + 1))){
			list.add(new Posicion(renglon - 1, (char)(columna + 1)));
			renglon = renglon -1;
			columna = (char)(columna +1);
		}

		while(esValida(renglon - 1, (char)(columna - 1))){
			list.add(new Posicion(renglon - 1, (char)(columna - 1)));
			renglon = renglon -1;
			columna = (char)(columna -1);
		}
		return list;
	}

	/**Método que indica si es válido mover a la reinaa una casilla*/
	@Override
	public boolean esValida(int renglon, char columna){
		if (renglon <= 0 || renglon >= 9) return false;
		if (columna <= 96 || columna >= 105) return false;
		return true;
		
	}

	/**Método que devuelve una representación con cadena 
	*de la reina y su estado actual.
	*/
	@Override
	public String toString(){
		return posicion.toString() + ", color: " + (color ? "blanco" : "negro");
	}
}