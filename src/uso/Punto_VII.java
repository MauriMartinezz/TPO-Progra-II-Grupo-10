package uso;

import implementacion.Conjunto;
import implementacion.Pila;
import interfaz.ConjuntoTDA;
import interfaz.PilaTDA;
import java.util.Random;
import utils.ConjuntoUtils;
import utils.PilaUtils;
//     - **Ejercicio 7 (uso)**  
//     Definir un método que reciba una `PilaTDA` y devuelva un `ConjuntoTDA` con los **elementos repetidos**.  
//   → Detectar duplicados y agregarlos al conjunto.

public class Punto_VII {

    public static ConjuntoTDA devolverRepetidosPila(PilaTDA pila){
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializar();

        PilaTDA pilaAux = new Pila();
        pilaAux.inicializar();


        while(!pila.estaVacia()){
            conjunto.agregar(pila.tope());
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!pilaAux.estaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjunto;
    }

    public static void main(String[] args) {
        Random random = new Random();
        PilaTDA pila = new Pila();
        pila.inicializar();
        PilaUtils.rellenarPila(pila, 10, 10, random);
        
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
