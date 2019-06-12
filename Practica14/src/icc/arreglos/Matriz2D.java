package icc.arreglos;

public class Matriz2D {

    double[][] matriz;
    int filas;
    int columna;
    
    //Creamos el constructor
    Matriz2D(int filas, int columna) {
        
        this.filas = filas;
        this.columna = columna;
        matriz = new double[filas][columna];
        
    }
    
    public String toString() {
        
        String aux = "";
        
        for (int x=0; x < matriz.length; x++) {
            aux += "|";
            for (int y=0; y < matriz[x].length; y++) {
                  aux += matriz[x][y];
                  if (y!=matriz[x].length-1) 
                      aux += "\t";
            }
            aux += "| \n";
        }
        return aux;
    //Regresa la representacion de la matriz en forma de cadena.
    }


    public int getFilas() {
        return filas;
    //regresa el numero de filas de la matriz señalada.
    }
    
    public int getColumnas() {
        return columna;
    //regresa el numero de columnas de la matriz señalada.
    }
    
   
    public static Matriz2D crearMatriz(double array1[][]) {
        Matriz2D matriz = new Matriz2D(array1.length, array1[0].length);
        matriz.matriz = array1;
        return matriz;
    //regresa la matriz con los valores señalados a través de un arreglo.
    }

    //Suma matrices
    public Matriz2D sumar(Matriz2D x) {

        if(getFilas() == x.getFilas() && getColumnas() == x.getColumnas()) {

        Matriz2D res = new Matriz2D(x.getFilas(),x.getColumnas());

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                res.matriz[i][j] = matriz[i][j] + x.matriz[i][j];
        
        return res;

        }else {
            System.out.println("No se pueden sumar las matrices dadas.");
            return null;
        //regresa la suma de las matrices
        }
    }

    // Resta dos matrices
    public Matriz2D restar(Matriz2D x) {

        if(getFilas() == x.getFilas() && getColumnas() == x.getColumnas()) {

        Matriz2D res = new Matriz2D(x.getFilas(),x.getColumnas());

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                res.matriz[i][j] = matriz[i][j] - x.matriz[i][j];
        return res;

        }else {
            System.out.println("La resta de las matrices es invalida");
            return null;
        //regresa la resta de las matrices
        }
    }

    //Multiplica un numero a la matriz.
    public Matriz2D multiplicarEscalar(double x) {

        Matriz2D res = new Matriz2D(getFilas(),getColumnas());

        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                res.matriz[i][j] = matriz[i][j] * x;
        return res;
        //regresa la multiplicacion de las matrices por un número.
    }

    //Multiplica dos Matrices2D.
    public Matriz2D multiplicar(Matriz2D x) {

        if(columna == x.getFilas()) {

        Matriz2D res = new Matriz2D(getFilas(),x.getColumnas());

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < x.matriz[0].length; j++) {
                for (int k = 0; k < matriz[0].length; k++)
                    res.matriz[i][j] += matriz[i][k] * x.matriz[k][j];
            }
        }
        return res;

        }else {
            System.out.println("La multiplicacion de las matrices es invalida");
            return null;
        }
        //regresa la multiplicacion de las matrices.
    }
}