package icc.contactos;

public class Contactos{
    private Registro reg = null;
    
   
    
    public void insertaContacto(Registro r){
           Registro aux;
        if (reg == null){
            reg = r;
        }else if (reg.getSiguiente() == null){
            if (reg.compare(r) >=0){
                aux = reg;
                reg = r;
                reg.siguiente = aux;
            }else
                reg.siguiente = r;
        } else{
            if (reg.compare(r) >=0){
                aux = reg;
                reg = r;
                reg.siguiente = aux;
            }else{
                aux = reg;
                while(aux != null){
                    if(aux.getSiguiente().compare(r) >= 0){
                        r.siguiente = aux.siguiente;
                        aux.siguiente = r;
                        break;
                    }
                        aux = aux.getSiguiente();
                        if(aux.siguiente == null){
                            aux.siguiente = r;
                            break;
                    }
                }
            }
        }
     
    }        
    public void imprimeContactos(){
        Registro aux = reg;
        while(aux != null){
            System.out.println(aux.toString());
            aux = aux.getSiguiente();
        }
    }

    
    public Registro consultar (String query){
        Registro aux= reg;
      while (aux != null){
            String nombreMay = aux.getNombre().toUpperCase();
            String direccionMay =aux.getDireccion().toUpperCase();
            String telefonoMay =aux.getTelefono().toUpperCase();
            String queryMay = query.toUpperCase();
            if(nombreMay.contains(queryMay)){
                return aux;
            
            }    
            if(direccionMay.contains(queryMay)){
                return aux;
                
                
            }      
            if(telefonoMay.contains(queryMay)){
                return aux;
            }    
            aux = aux.siguiente;
        }        
            return null;       
    }
}


   