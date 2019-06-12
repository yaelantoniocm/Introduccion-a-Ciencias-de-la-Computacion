package icc.ajedrez;

import java.util.Scanner;


public class UsoAjedrez {
	private Scanner scanner;
    
    
    public UsoAjedrez() {
        scanner = new Scanner(System.in);
    }
	
	
    private int leeEntero(String mensaje) {
        System.out.println(mensaje);
        boolean error = false;
        int num = -1;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num <= 0) {
                error = true;
                System.out.println("El valor más chico posible es uno.");
            }
        } catch (NumberFormatException nfe) {
            error = true;
            System.out.println("Por favor ingresa un número válido.");
        }
        if (error) {
            num = leeEntero(mensaje);
        }
        return num;
    }
     private char leeChar(String mensaje) {
        System.out.println(mensaje);
        boolean error = false;
        char num = (char)-1;
        try {
            num = scanner.nextLine().charAt(0);
        } catch (Exception nfe) {
            error = true;
            System.out.println("Por favor ingresa un valor válido.");
        }
        if (error) {
            num = leeChar(mensaje);
        }
        return num;
    }
    
    /**
     * Método auxiliar para imprimir el menú para el usuario.
     */
    private void imprimeMenu() {
        System.out.println("Opciones:");
        System.out.println("1) Tomar Reina");
        System.out.println("2) Tomar Caballo");
        System.out.println("3) Tomar Rey");
        System.out.println("4) Salir");
    }

     /**
     * Método auxiliar para imprimir el menú para el usuario.
     */
    private void imprimePiezaMenu() {
        System.out.println("Opciones:");
        System.out.println("1) Validar Posición");
        System.out.println("2) Lista de posiciones");
        System.out.println("3) Salir");
    }
    
    public void corre() {
        System.out.println(" *** Piezas de Ajedrez *** ");
        boolean continuar = true;
        int renglon;
        char columna;
        Pieza pieza;
        Reina reina = new Reina( 5, 'b');
        Caballo caballo = new Caballo (3 ,'c');
        Rey rey = new Rey (4,'d');
        int opc;
        boolean esValida;
        while(continuar) {
            imprimeMenu();
            int opcion = leeEntero("Selecciona una opción:");
            switch(opcion) {
                case 1:
                case 2:
                case 3:
                    if(opcion == 1){
                        pieza = reina;
                    }else if (opcion == 2){
                        pieza = caballo;
                    }else {
                        pieza = rey;
                    }
                    System.out.println(pieza.toString());
                    imprimePiezaMenu();
                    opc = leeEntero("Selecciona una opción:");
                    switch(opc) {                    
                        case 1:
                            renglon = leeEntero("Selecciona una renglón [1-8]");
                            columna = leeChar("Selecciona una columna [a-h]");
                            esValida = pieza.esValida(renglon, columna);
                            System.out.print("La posición nueva de la pieza ");
                            if(esValida){
                                System.out.print("SI ");
                            }else{
                                pieza.setColumna(columna);
                                pieza.setRenglon(renglon);
                            }
                            System.out.println("es válida. ");
                            break;
                        case 2:
                            System.out.println(pieza.posiblesMovimientos().toString());
                            break;
                        case 3:
                            System.out.println("Regresando al menú anterior.");
                        default:
                           System.out.println("Opción inválida.");
                            break;                          
                    }
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Esa no es una opción válida");
            }                    
        }
    }
    public static void main (String [] args) {
        UsoAjedrez interfaz = new UsoAjedrez();
        interfaz.corre();
    }
}