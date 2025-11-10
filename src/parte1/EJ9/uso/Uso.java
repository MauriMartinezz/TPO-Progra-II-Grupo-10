package parte1.EJ9.uso;

import imple.Cola;
import imple.Conjunto;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;
import utils.ColaUtils;
import utils.ConjuntoUtils;
import utils.PilaUtils;

/* ### Ejercicio 9
Se define un método que reciba una PilaTDA y una ColaTDA y devuelva un ConjuntoTDA con los elementos comunes de la pila y de la cola.
*/
public class Uso {
    public static ConjuntoTDA devolverElementosComunesPilaCola(PilaTDA pila, ColaTDA cola){
        // complejidad O(n*m) polinomica donde n es la cantidad de elementos en la pila y m en la cola
        ConjuntoTDA conjuntoComunes = new Conjunto();
        conjuntoComunes.inicializarConjunto();
        
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();

        while(!pila.pilaVacia()){
            pilaAux.apilar(pila.tope());
            
            while(!cola.colaVacia()){
                if(pila.tope() == cola.primero()) conjuntoComunes.agregar(pila.tope());
                colaAux.acolar(cola.primero());
                cola.desacolar();
            }

            while(!colaAux.colaVacia()){
                cola.acolar(colaAux.primero());
                colaAux.desacolar();
            }
            pila.desapilar();
        }

        while(!pilaAux.pilaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjuntoComunes;
    }

    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();

        ColaTDA cola = new Cola();
        cola.inicializarCola();

        PilaUtils.rellenarPila(pila, 5, 10);
        ColaUtils.rellenarCola(cola,5,10);

        System.out.println("**************************");
        System.out.println("PILA: ");
        PilaUtils.imprimirPila(pila);
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("COLA: ");
        ColaUtils.imprimirCola(cola);
        
        System.out.println("**************************");
        System.out.println("COMUNES ENTRE COLA Y PILA: ");
        System.out.println("**************************");

        ConjuntoUtils.imprimirConjunto(devolverElementosComunesPilaCola(pila, cola));
}
}
