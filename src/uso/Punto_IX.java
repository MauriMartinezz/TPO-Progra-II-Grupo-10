package uso;

import implementacion.Cola;
import implementacion.Conjunto;
import implementacion.Pila;
import interfaz.ColaTDA;
import interfaz.ConjuntoTDA;
import interfaz.PilaTDA;
import utils.ColaUtils;
import utils.ConjuntoUtils;
import utils.PilaUtils;

//   Definir un método que reciba una `PilaTDA` y una `ColaTDA`, devolviendo un `ConjuntoTDA` con los **elementos comunes**.  
//   → Comparar y guardar intersección.
public class Punto_IX {
    public static ConjuntoTDA devolverElementosComunesPilaCola(PilaTDA pila, ColaTDA cola){
        ConjuntoTDA conjuntoComunes = new Conjunto();
        conjuntoComunes.inicializar();
        
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializar();
        
        ColaTDA colaAux = new Cola();
        colaAux.inicializar();

        while(!pila.estaVacia()){
            pilaAux.apilar(pila.tope());
            
            while(!cola.estaVacia()){
                if(pila.tope() == cola.primero()) conjuntoComunes.agregar(pila.tope());
                colaAux.acolar(cola.primero());
                cola.desacolar();
            }

            while(!colaAux.estaVacia()){
                cola.acolar(colaAux.primero());
                colaAux.desacolar();
            }
            pila.desapilar();
        }

        while(!pilaAux.estaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjuntoComunes;
    }

    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializar();

        ColaTDA cola = new Cola();
        cola.inicializar();

        PilaUtils.rellenarPila(pila, 10, 10);
        ColaUtils.rellenarCola(cola,10,10);

        System.out.println("**************************");
        System.out.println("PILA: ");
        PilaUtils.imprimirPila(pila);
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("COLA: ");
        ColaUtils.imprimirCola(cola);
        System.out.println("**************************");
        
        System.out.println("**************************");
        System.out.println("COMUNES ENTRE COLA Y PILA: ");
        System.out.println("**************************");

        ConjuntoUtils.imprimirConjunto(devolverElementosComunesPilaCola(pila, cola));
}
}
