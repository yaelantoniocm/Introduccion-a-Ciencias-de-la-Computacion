package icc.clases;

public class Ciudadano{

	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String cumpleaños; 

 		public Ciudadano(String nombre, String apellidoPaterno, String apellidoMaterno, String cumpleaños){
 			this.nombre = nombre;
 			this.apellidoMaterno = apellidoMaterno;
 			this.apellidoPaterno = apellidoPaterno;
 			this.cumpleaños = cumpleaños;



 		}  

 		public String calculaRFC(){
 			apellidoPaterno = this.apellidoPaterno.substring(0,2).toUpperCase(); 
 			apellidoMaterno = this.apellidoMaterno.substring(0,1).toUpperCase(); 
 			nombre = this.nombre.substring(0,1).toUpperCase();
 			cumpleaños = this.cumpleaños.substring(8,10) + this.cumpleaños.substring(3,5) + this.cumpleaños.substring(0,2);
 			return apellidoPaterno + apellidoMaterno + nombre + cumpleaños; 

 			
 		}

}
