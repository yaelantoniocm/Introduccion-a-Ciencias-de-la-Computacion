package automatas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 *
 * @author blackzafiro
 */
public class Demo extends Application {
    
    static int ren, col, M, G;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Automata");
        
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        
        Automata a = new Automata(root, ren, col, M, G);
        a.start();

        primaryStage.show();
    }

    public static int getInt(String mensaje) {

        boolean valido = true;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        System.out.println(mensaje);
        try {
            i = scan.nextInt();
        }catch(Exception e) {
            valido = false;
        }
        if(i < 1)
            valido = false;
        if(valido)
            return i;
        else
            return getInt(mensaje);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ren = getInt("Ingresa el número de renglones.");
        col = getInt("Ingresa el número de columnas.");
        M = getInt("Ingresa el valor umbral.");

        System.out.println("ren: " + ren);
        System.out.println("col: " + col);
        System.out.println("M: " + M);

        launch(args);
    }
    
}