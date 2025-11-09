package parte1.EJ2.implementacion;

/* Se define un nuevo TDA denominado ConjuntoMamushkaTDA basado en 
ConjuntoTDA, con la particularidad de que se permite más de una acepción de cada 
elemento agregado. Tal cual como en ConjuntoTDA, no existe orden alguno. Su 
especificación se muestra en el anexo, leer detenidamente los comentarios de cada método. */

import parte1.EJ2.interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

    private class Nodo { //la célula de la estructura
		int info; //el valor almacenado
		Nodo sig; //la referencia al siguiente nodo
	}
	
	private Nodo c; //la referencia de la estructura
   
    @Override
    public void inicializar(){
        //complejidad O(1)
        c = null;
    }; //inicializa el TDA 
    
    @Override
    public void guardar(int dato){  
        //complejidad O(1)
        Nodo nuevo = new Nodo(); //el nuevo nodo que se agregará
		nuevo.info = dato;
		nuevo.sig = c;
		c = nuevo;
    }; //agrega el elemento dato al TDA 
    
    @Override
    public void sacar(int dato){ 
        //complejidad O(n)
        if (c != null) {
			if (c.info == dato) { //es el primero
				c = c.sig;
			} else { //es algún otro; lo buscamos
				Nodo aux = c;
				while (aux.sig != null && aux.sig.info != dato)
					aux = aux.sig;
				if (aux.sig != null) //encontrado
					aux.sig = aux.sig.sig;
			}
		}
    }; //elimina del TDA una acepción del elemento dato 
    
    @Override
    public int elegir(){
        //complejidad O(1)
        return c.info;
    }; //muestra un elemento agregado al TDA (arbitrario) 
    
    @Override
    public int perteneceCant(int dato){
        //complejidad O(n)
        Nodo aux = c;
        int cant = 0;
		while (aux != null){
            if (aux.info == dato) {
                cant++;
            };
			aux = aux.sig;
        };
		return cant;
    }; //devuelve la cantidad de veces que se encuentra el elemento dato en el TDA 
    
    @Override
    public boolean estaVacio( ){
        //complejidad O(1)
        return (c == null);
    }; //devuelve un boolean que informa si el TDA está vacío 

}