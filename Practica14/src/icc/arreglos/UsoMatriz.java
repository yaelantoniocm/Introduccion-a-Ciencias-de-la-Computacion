package icc.arreglos;

public class UsoMatriz {

    public static void main(String[] args) {

        Matriz2D matriz = new Matriz2D(3,3);

        System.out.println("La columna de la matriz, imprimira un 3.");
        System.out.println(matriz.getColumnas());
        System.out.println();
        System.out.println("La fila de la matriz, imprimira un 3.");
        System.out.println(matriz.getFilas());
        System.out.println();
        

        System.out.println("Matriz de solo ceros:");
        System.out.println(matriz);
        System.out.println();

        double arreglo[][] = new double[3][3];
        for (int i = 0; i < arreglo.length; i++)
            for (int j = 0; j < arreglo[i].length; j++)
                arreglo[i][j] = 3;

        
        Matriz2D x = matriz.crearMatriz(arreglo);
        System.out.println("Matriz de puros 3.");
        System.out.println(x);
        System.out.println();

        double arreglo2[][] = new double[3][3];
        for (int i = 0; i < arreglo.length; i++)
            for (int j = 0; j < arreglo[i].length; j++)
                arreglo2[i][j] = 1;

               
        Matriz2D y = matriz.crearMatriz(arreglo2);
        System.out.println("Matriz de puros unos.");
        System.out.println(y);
        System.out.println();
        
        //Se suma la matriz que solo tiene 3 con unos dando como resultado solo cuatros.
        System.out.println("La matriz de puros 3 le sumamos unos dandonos una matriz con solo cuatros.");
        System.out.println(x.sumar(y));
        System.out.println();

        //Se resta la matriz que tiene solo 3 con unos como resultado una matriz con puros dos.
        System.out.println("La matriz de puros 3 le sumamos unos, dandonos una matriz con solo puros 2.");
        System.out.println(x.restar(y));
        System.out.println();

        //Se multiplica la matriz que tiene solo 3 con 20 como resultado una matriz con puros 60.
        System.out.println("Se multiplicó la matriz de puros 3 por un escalar de valor 20, dando como resultado una matriz de puros 60.");
        System.out.println(x.multiplicarEscalar(20));

        //Se multiplica la matriz que solo tiene 3 con unos dando como resultado solo nueves.
        System.out.println("Multiplicamos la matriz de solo 3 con la matriz de 1, dando como resultado una matriz de solo nueves.");
        System.out.println(x.multiplicar(y));
        System.out.println();

        

    }

}