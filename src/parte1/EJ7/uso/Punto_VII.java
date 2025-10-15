package parte1.EJ7.uso;

import imple.Conjunto;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;
import utils.ConjuntoUtils;
import utils.PilaUtils;
//     - **Ejercicio 7 (uso)**  
//     Definir un método que reciba una `PilaTDA` y devuelva un `ConjuntoTDA` con los **elementos repetidos**.  
//   → Detectar duplicados y agregarlos al conjunto.

public class Punto_VII {

    public static ConjuntoTDA devolverRepetidosPila(PilaTDA pila){
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();

        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();


        while(!pila.pilaVacia()){
            conjunto.agregar(pila.tope());
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!pilaAux.pilaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjunto;
    }

    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        PilaUtils.rellenarPila(pila, 10, 10);
        
        System.out.println("***********************");
        System.out.println("Elementos de la PILA:");
        System.out.println("_______________________");
        PilaUtils.imprimirPila(pila);
        System.out.println("***********************");
        
        ConjuntoTDA conjuntoPilaSinRepetidos = devolverRepetidosPila(pila);

        System.out.println("***********************");
        System.out.println("Elementos de la PILA SIN REPETIDOS:");
        System.out.println("_______________________");
        ConjuntoUtils.imprimirConjunto(conjuntoPilaSinRepetidos);
        System.out.println("***********************");


    }

}
