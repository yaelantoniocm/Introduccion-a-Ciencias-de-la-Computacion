package automatas;

import java.util.Random;

public class Epidemia extends Celula {

	int G;

	public Epidemia (int renglones, int columnas, int M, int G) {
		super(renglones, columnas, M);
		this.G = G;
		super.next();
	}

	/**
	*Método para indicar si iun individuo esta infectado.
	*/
	public boolean infectada(int val) {
		return 0 < val && val <= M;
	}

	/**
	*Método para indicar si iun individuo es inmune.
	*/
	public boolean inmune(int val) {
		return val > M;
	}

	/**
	*Método para indicar si iun individuo es suceptible.
	*/
	public boolean suceptible(int val) {
		return 0 == val;
	}

	public void next() {

		int caso;
		int aux;

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				caso = array[i][j];
				if(caso == 0){
					aux = val(i + 1, j);
					if(infectada(aux))
						array[i][j] += 1;
					else{
						aux = val(i, j + 1);
						if(infectada(aux))
							array[i][j] += 1;
						else{
							aux = val(i - 1, j);
							if(infectada(aux))
								array[i][j] += 1;
							else{
								aux = val(i, j-1);
								if(infectada(aux))
									array[i][j] += 1;
							}
						}
					}
				}else if(caso <= M)
					array[i][j] += 1;
				else
					array[i][j] = (array[i][j] + 1) % (M + G + 1);
			}
		}

	}
}