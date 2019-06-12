/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

//import java.io.*;
//import javafx.scene.paint.Color;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.paint.*;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.layout.AnchorPane;
//import static javafx.application.Application.launch;

/**
 * Clase que describe astros que giran alrededor de otro.
 * @author blackzafiro
 */
public class Satelite extends Astro {
	
	// Escala para dibujar a los planetas
	private static final double ESCALA_RADIO = 10.0;
	private static final double ESCALA_ORBITA = 400.0;
	private static final double ESCALA_ORBITA_SATELITE = ESCALA_RADIO * 2;
	private static final double ESCALA_TIEMPO = 15.0;
	private static final double ESCALA_ANGULO = Math.PI/ 180;
	
	/**
	 * Datos de cada planeta y satélite.
	 * Deben ser ficticios, pues de otro modo la simulación no cabe en pantalla.
	 */
	public enum DatosSatelite {

		TIERRA(1.3, 0.4, 0.4, 1.0, 0.0),
		LUNA(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.09399, 0.0),
		MERCURIO(0.4, 0.2, 0.2, 0.4, 0.0),
		VENUS(1.0, 0.3, 0.3, 0.7, 0.0),
		MARTE(0.8, 0.5, 0.5, 1.3, 0.0),
		JUPITER(2.9, 0.70, 0.70, 1.6, 0.0),
		EUROPA(0.31, ESCALA_ORBITA_SATELITE * 0.0048, ESCALA_ORBITA_SATELITE * 0.0048, 0.339, 0.0),
		CALISTO(0.48, ESCALA_ORBITA_SATELITE * 0.0048, ESCALA_ORBITA_SATELITE * 0.0048, 0.739, 0.0),
		IO(0.36, ESCALA_ORBITA_SATELITE * 0.0048, ESCALA_ORBITA_SATELITE * 0.0048, 0.439, 0.0),
		GANIMEDES(0.51, ESCALA_ORBITA_SATELITE * 0.00487, ESCALA_ORBITA_SATELITE * 0.00487, 0.539, 0.0),
		SATURNO(2.5, 0.90, 0.90, 1.9, 0.0),
		URANO(1.9, 1.05, 1.05, 2.2, 0.0),
		NEPTUNO(1.5, 1.15, 1.15, 2.5, 0.0),
		PLUTON(0.6, 1.4, 1.4, 1.35, 17.0);
		//LUNA_LUNA(0.17, (ESCALA_ORBITA_SATELITE * 0.00257)/2.1, (ESCALA_ORBITA_SATELITE * 0.002566)/2.1, 0.036);;
		

		private final double diametroEcuatorial;
		private final double semiejeMayor;
		private final double semiejeMenor;
		private final double periodoOrbital;
		private final double angulo;
		
		
		DatosSatelite(double diametroEcuatorial, double semiejeMayor, double semiejeMenor, double periodoOrbital, double angulo) {
			this.diametroEcuatorial = diametroEcuatorial;
			this.semiejeMayor = semiejeMayor;
			this.semiejeMenor = semiejeMenor;
			this.periodoOrbital = periodoOrbital;
			this.angulo = angulo;
		}

	}

	//public DatosSatelite dS (double diametroEcuatorial, double semiejeMayor, double semiejeMenor, double periodoOrbital, double angulo) {



	
	/// Inician atributos
	
	private final DatosSatelite datos;
	private OrbitaTransition orbita;
	private Astro foco;
	
	
	/// Inician métodos
        
	/**
	 * Astro alrededor del cual gira este satélite.
	 * @return astro alrededor del cual girar este satélite.
	 */
	public Astro getFoco() {
		return foco;
	}
	
	/**
	 * Crea la órbita de este planea y lo pone a girar alrededor del foco.
	 */
	private void creaOrbita(Astro foco) {
		foco.getNodo().getChildren().add(this.nodo);
		this.foco = foco;
		
		orbita = new OrbitaTransition(this,
					      datos.semiejeMayor * ESCALA_ORBITA,
					      datos.semiejeMenor * ESCALA_ORBITA,
					      datos.periodoOrbital * ESCALA_TIEMPO,
					      datos.angulo * ESCALA_ANGULO
		);
		orbita.play();
	}
	
	/**
	 * Constructor.
	 * @param datos información del astro y su órbita.
	 * @param foco astro alrededor del cual gira este satélite.
	 */
	public Satelite(DatosSatelite datos, Astro foco) {
		super(datos.diametroEcuatorial * ESCALA_RADIO);
		this.datos = datos;
		creaOrbita(foco);
	}
	
	/**
	 * Devuelve el nombre de este satélite.
	 * @return nombre
	 */
	public String getNombre() {
		return this.datos.toString();
	}
}
