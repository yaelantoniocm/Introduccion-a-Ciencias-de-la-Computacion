/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import static javafx.application.Application.launch;
//import javafx.scene.paint.Paint;
//import javafx.scene.paint.Color;




/**
 * Simulación del sistema solar utilizando JavaFX
 * https://docs.oracle.com/javase/8/javafx/api/index.html
 * @author blackzafiro
 */
public class SistemaSolar extends Application {
	
	private final static int ANCHO_VENTANA_INICIAL = 1200;
	private final static int ALTO_VENTANA_INICIAL = 800;
	private final static int RADIO_SOL = 30;
	
	private Astro sol;
	private Satelite tierra;
	private Satelite luna;
	private Satelite mercurio;
	private Satelite venus;
	private Satelite marte;
	private Satelite jupiter;
	private Satelite saturno;
	private Satelite urano;
	private Satelite neptuno;
	private Satelite pluton;
	private Satelite europa;
	private Satelite calisto;
	private Satelite io;
	private Satelite ganimedes;




	public static int getSolCentroX() {
		return ANCHO_VENTANA_INICIAL/2;
	}
	
	public static int getSolCentroY() {
		return ALTO_VENTANA_INICIAL/2;
	}
	
	/* private static Paint getTextFillColor(int value) {
        String color;
        switch (value) {
            case -1: color = "#79CEE3"; break;
            case 1: color = "#000000"; break;
            default: color = "white"; break;
        }
        return Paint.valueOf(color);
    }	*/
	/**
	 * Crea al sol, los planteas y sus satélites, asignando quien gira
	 * alrededor de quien.
	 */
	private void creaAstros() {

		Image sl = new Image("/sistemasolar/sol.gif" , 73, 73, false, false);
		ImageView viewSol = new ImageView();
		viewSol.setImage(sl);
		Image tr = new Image ("/sistemasolar/tierra.jpg", 30, 30, false, false);
		ImageView viewTierra = new ImageView();
		viewTierra.setImage(tr);
		Image mer = new Image ("/sistemasolar/mercurio.jpg", 20, 20, false, false);
		ImageView viewMercurio = new ImageView();
		viewMercurio.setImage(mer);
		Image ve = new Image("/sistemasolar/venus.jpg", 20,20, false, false);
		ImageView viewVenus = new ImageView();
		viewVenus.setImage(ve);
		Image mar = new Image("/sistemasolar/marte.jpg",20, 20, false, false);
		ImageView viewMarte =new ImageView();
		viewMarte.setImage(mar);
		Image ju = new Image("/sistemasolar/jupiter.jpg", 65, 65, false, false);
		ImageView viewJupiter = new ImageView();
		viewJupiter.setImage(ju);
		Image sa = new Image("/sistemasolar/saturno.jpg", 75, 50, false, false);
		ImageView viewJSaturno = new ImageView();
		viewJSaturno.setImage(sa);
		Image ur = new Image("/sistemasolar/urano.jpg", 40, 40, false, false);
		ImageView viewUrano = new ImageView();
		viewUrano.setImage(ur);
		Image nep = new Image("/sistemasolar/neptuno.jpg", 30, 30, false, false);
		ImageView viewNeptuno = new ImageView();
		viewNeptuno.setImage(nep);
		Image plu = new Image("/sistemasolar/pluton.jpg", 20, 20, false, false);
		ImageView viewPLuton = new ImageView();
		viewPLuton.setImage(plu);

		sol = new Astro(RADIO_SOL);
		sol.nodo.getChildren().add(viewSol);
		tierra = new Satelite(Satelite.DatosSatelite.TIERRA, sol);
		tierra.nodo.getChildren().add(viewTierra);
		luna = new Satelite(Satelite.DatosSatelite.LUNA, tierra);
		mercurio = new Satelite(Satelite.DatosSatelite.MERCURIO, sol);
		mercurio.nodo.getChildren().add(viewMercurio);
		venus = new Satelite(Satelite.DatosSatelite.VENUS, sol);
		venus.nodo.getChildren().add(viewVenus);
		marte = new Satelite(Satelite.DatosSatelite.MARTE, sol);
		marte.nodo.getChildren().add(viewMarte);
		jupiter = new Satelite(Satelite.DatosSatelite.JUPITER, sol);
		jupiter.nodo.getChildren().add(viewJupiter);
		saturno = new Satelite(Satelite.DatosSatelite.SATURNO, sol);
		saturno.nodo.getChildren().add(viewJSaturno);
		urano = new Satelite(Satelite.DatosSatelite.URANO, sol);
		urano.nodo.getChildren().add(viewUrano);
		neptuno = new Satelite(Satelite.DatosSatelite.NEPTUNO, sol);
		neptuno.nodo.getChildren().add(viewNeptuno);
		pluton = new Satelite(Satelite.DatosSatelite.PLUTON, sol);
		pluton.nodo.getChildren().add(viewPLuton);
		europa = new Satelite(Satelite.DatosSatelite.EUROPA, jupiter);
		calisto = new Satelite(Satelite.DatosSatelite.CALISTO, jupiter);
		io = new Satelite(Satelite.DatosSatelite.IO, jupiter);
		ganimedes = new Satelite(Satelite.DatosSatelite.GANIMEDES, jupiter);

		//new Satelite(Satelite.DatosSatelite.LUNA_LUNA, luna);
		
		//sol.setPht("src/sol.jpg");
		//tierra.setPht("src/tierra.jpg");
		//luna.setPht("src/luna.jpg");
		//mercurio.setPht("src/mercurio.jpg");
		//venus.setPht("src/venus.jpg");
		//marte.setPht("src/marte.jpg");
		//jupiter.setPht("src/jupiter.jpg");
		//saturno.setPht("src/saturno.jpg");
		//urano.setPht("src/urano.jpg");
		//neptuno.setPht("src/neptuno.jpg");
		//pluton.setPht("src/pluton.jpg");
		//europa.setPht("src/europa.jpg");
		//calisto.setPht("src/calisto.jpg");
		//io.setPht("src/io.jpg");
		//ganimedes.setPht("src/images.jpeg");

	}
	
	/**
	 * Crea la escena y agrega los primeros nodos, sobre los cuales
	 * se han agregado a los demás astros.
	 * @return la escena con el sol, planetas y satélites.
	 */
	private Scene montaNodos() {
		AnchorPane root = new AnchorPane();
		root.setLayoutX(getSolCentroX() - RADIO_SOL);
		root.setLayoutY(getSolCentroY() - RADIO_SOL);
		
		root.getChildren().add(sol.getNodo());
		
		Scene scene = new Scene(root, ANCHO_VENTANA_INICIAL, ALTO_VENTANA_INICIAL, Paint.valueOf("#000000"));
		return scene;
	}
	
	/**
	 * Acomoda los elementos en la intefaz e inicia la animación.
	 * @param primaryStage
	 * @throws Exception 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		creaAstros();
		
		Scene scene = montaNodos();
		primaryStage.setTitle("Sistema solar");
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		scene.setFill(Color.BLACK);
		primaryStage.show();
	}
	
	/**
	 * Inicia la simulación.
	 * @param args 
	 */
	public static void main(String[] args) {
		launch(args);
	}


}

