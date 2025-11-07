package parte1.EJ6.uso;

import imple.Pila;
import tda.PilaTDA;

// Ejercicio 6
// Se define un método que reciba una PilaTDA y devuelva un float (número real) con el porcentaje de cantidad de elementos pares de la pila.
public class Punto_VI {
    public static float porcentajeDeParesPila(PilaTDA pila){
        PilaTDA pilaAux = utils.PilaUtils.copiarPila(pila);
        int cantPares = 0;
        int cantidadElementos = 0;
        while(!pilaAux.pilaVacia()){
            cantidadElementos++;
            if (pilaAux.tope() % 2 == 0) cantPares++;
            pilaAux.desapilar();
        }

        return (cantPares*100)/cantidadElementos;
    }
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        utils.PilaUtils.rellenarPila(pila, 10, 50);
        System.out.println("****************************");
        System.out.println("PILA: ");
        utils.PilaUtils.imprimirPila(pila);
        System.out.println("****************************");

        System.out.println("****************************");
        System.out.println("PORCENTAJE DE ELEMENTOS PARES DE LA PILA: ");
        System.out.println(porcentajeDeParesPila(pila) + "%");
        System.out.println("****************************");

    }
}
