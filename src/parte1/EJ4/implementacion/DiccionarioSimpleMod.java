package parte1.EJ4.implementacion;

/* Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en 
DiccionarioSimpleTDA, con la particularidad de registrar la cantidad de veces que el valor 
se ve modificado (entrada: clave-valor-factorMod). Su especificación se muestra en el anexo, 
leer detenidamente los comentarios de cada método. */

import parte1.EJ4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    
    private class NodoClave { //la célula de la estructura de claves
		int clave; //la clave
		int valor; //el valor
        int modificaciones;
		NodoClave sigClave; //la referencia a la siguiente clave
	}
	
	private NodoClave origen; //la referencia de la estructura
	
    @Override  
    public void inicializarDiccionario(){
        origen = null;
    }; //inicializa el TDA 
    
    @Override  
    public void agregar(int clave, int valor){
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) { //la clave no existe
			nc = new NodoClave();
			nc.clave = clave;
            nc.modificaciones = 0;
			nc.sigClave = origen;
			origen = nc; //nuevo origen
		}
		nc.valor = valor;       
        nc.modificaciones++;
    }; //agrega el par clave-valor al TDA, 
    //conjuntamente con la cantidad de veces que dicho valor se vio 
    //modificado. Si la clave se agrega por primera vez, el factor de 
    //modificaciones será 0. Si la clave se agrega por segunda vez, 
    //modificándose el valor, el factor de 
    //modificaciones será 1. Y así sucesivamente. 
    
    private NodoClave Clave2NodoClave(int clave){
		NodoClave aux = origen; //el nodo viajero
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

    @Override  
    public void eliminar(int clave){
		if (origen != null) {
			if (origen.clave == clave) { //es el primero
				origen = origen.sigClave;
			}
			else { //es algún otro
				NodoClave aux = origen; //el nodo viajero
				while (aux.sigClave != null && aux.sigClave.clave != clave){
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}; //elimina la clave del TDA, con su valor y 
    //factor de modificaciones 
    
    @Override  
    public int recuperar(int clave){
		NodoClave nc = Clave2NodoClave(clave);
		return nc.valor;
    }; //devuelve el valor asociado a la clave, que 
    //se supone existente 
    
    @Override  
    public int recuperarMod(int clave){
		NodoClave nc = Clave2NodoClave(clave);
		return nc.modificaciones;
    }; //devuelve la cantidad de 
    //modificaciones que sufrió el valor relacionado a dicha clave, que se 
    //supone existente 
    
    @Override  
    public ConjuntoTDA claves(){
        ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		NodoClave aux = origen; //el nodo viajero
		while (aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
    }; //devuelve el conjunto de claves 

}
