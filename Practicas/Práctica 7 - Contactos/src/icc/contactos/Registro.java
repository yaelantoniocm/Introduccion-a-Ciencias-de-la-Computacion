package icc.contactos;


	public class Registro{
		private String nombre;
		private String direccion;
		private String telefono;
		Registro siguiente = null;
		//Este es mi constructor eñ "isEMpty" es por si el que me pasan es vacion que regrese una cadena vacia.
		public Registro(String nombre, String direccion, String telefono){
			if (nombre.isEmpty()){
				this.nombre = "";	
			}else{
				this.nombre = nombre;
			}
			if (direccion.isEmpty()){
				this.direccion = "";
			}else{
				this.direccion=direccion;
			}
			if (telefono.isEmpty()){
				this.telefono="";
			}else{
				this.telefono=telefono;
			}
			

	//Ya que las variables estan en tipo privado, tengo que llamar con get y los set para asignar valores a esas variables		
	}

	public String getNombre(){
		return nombre;
	}
	public String getDireccion(){
		return direccion;
	}
	public String getTelefono(){
		return telefono;
	}
	public Registro getSiguiente(){
		return siguiente;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
 	public void setSiguiente(Registro siguiente){
 		this.siguiente = siguiente;
 	}
 	public String toString(){
 		return nombre + "\n" + direccion + "\n" + telefono + "\n";
 	}
 	//Este metodo es para que compare el nombre que se escriba y eligaen que posicion deba ir.
 	public int compare (Registro r){
 		if (this.getNombre().compareToIgnoreCase(r.getNombre())>=0) {
 			return 1;
 		}else{
 			return -1;
 		}
 		
 	}
 	

}       
	



