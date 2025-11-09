package parte1.EJ4.implementacion;

/* Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en 
DiccionarioSimpleTDA, con la particularidad de registrar la cantidad de veces que el valor 
se ve modificado (entrada: clave-valor-factorMod). Su especificación se muestra en el anexo, 
leer detenidamente los comentarios de cada método. */

import parte1.EJ4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    
    private class NodoClave {
		int clave;
		int valor;
        int modificaciones;
		NodoClave sigClave;
	}
	
	private NodoClave origen;
	
    @Override  
    public void inicializarDiccionario(){
		//complejidad O(1)
        origen = null;
    };
    
    @Override  
    public void agregar(int clave, int valor){
		//complejidad O(n)
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
            nc.modificaciones = 0;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;       
        nc.modificaciones++;
    };
    
    private NodoClave Clave2NodoClave(int clave){
		//complejidad O(n)
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

    @Override  
    public void eliminar(int clave){
		//complejidad O(n)
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
	};
    
    @Override  
    public int recuperar(int clave){
		// complejidad O(n)
		NodoClave nc = Clave2NodoClave(clave);
		return nc.valor;
    };
    
    @Override  
    public int recuperarMod(int clave){
		// complejidad O(n)
		NodoClave nc = Clave2NodoClave(clave);
		return nc.modificaciones;
    };
    
    @Override  
    public ConjuntoTDA claves(){
		// complejidad O(n)
        ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
    };

}
