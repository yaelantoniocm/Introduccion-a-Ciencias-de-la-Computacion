package icc.primitivos;

public class Prueba{

	public static void main(String args[]) {
		ImpresoraBinario ib= new ImpresoraBinario();
		int max= Integer.MAX_VALUE;
		double nan = Double.NaN;
		double minf = Double.NEGATIVE_INFINITY;
		double pinf = Double.POSITIVE_INFINITY;
		double cero = 0.0;
		double mcero = -0.0;

        
		System.out.println(max);
		ib.imprime (max);

		System.out.println(nan);
		ib.imprime (nan);

		System.out.println(minf);
		ib.imprime (minf);
		
		System.out.println(cero);
		ib.imprime (cero);

		System.out.println(mcero);
		ib.imprime (mcero);

        
		short permisos;
		permisos = 0754;
		System.out.println(permisos);
		ib.imprime(permisos);

		
		
		int resultado1 = permisos >>3;
		System.out.println(resultado1);
		ib.imprime(resultado1);


		int resultado2 = permisos >>>3;
		System.out.println(resultado2);
		ib.imprime(resultado2);
		
		int resultado3 = permisos <<1;
		System.out.println(resultado3);
		ib.imprime(resultado3);
		

		int resultado4 = permisos >>1;
		System.out.println(resultado4);
		ib.imprime(resultado4);
		
		int resultado5 = permisos >>>1;
		System.out.println(resultado5);
		ib.imprime(resultado5);

		int resultado6 =permisos <<3;
		System.out.println(resultado6);
		ib.imprime(resultado6);


		int a1 = 456;
		System.out.println(a1);
		ib.imprime(a1);
		
		long a2 = 456;
		System.out.println(a2);
		ib.imprime(a2);

		float a3 = 456;
		System.out.println(a3);
		ib.imprime(a3);

		double a4 = 456;
		System.out.println(a4);
		ib.imprime(a4);



		int b1 = -456;
		System.out.println(b1);
		ib.imprime(b1);
		
		long b2 = -456;
		System.out.println(b2);
		ib.imprime(b2);

		float b3 = -456;
		System.out.println(b3);
		ib.imprime(b3);

		double b4 = -456;
		System.out.println(b4);
		ib.imprime(b4);

		int c = (int) -456.601;
		System.out.println(c);
		ib.imprime(c);

		int mascara = 147;
		int resultadomsc = mascara <<3;
		System.out.println(resultadomsc);
		ib.imprime(resultadomsc);
		


		int numvar = 1408;
		int resultadovar = resultadomsc & numvar;	
		System.out.println(resultadovar);
		ib.imprime(resultadovar);


		
		}

}