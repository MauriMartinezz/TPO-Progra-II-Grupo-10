package parte1.EJ6.uso;

import imple.Pila;
import tda.PilaTDA;
import utils.PilaUtils;

<<<<<<< HEAD:src/parte1/EJ6/uso/Punto_VI.java
/* ### Ejercicio 6
Se define un método que reciba una PilaTDA y devuelva un float (número real) con el porcentaje de cantidad de elementos pares de la pila.
*/
public class Punto_VI {
=======
// Ejercicio 6
// Se define un método que reciba una PilaTDA y devuelva un float (número real) con el porcentaje de cantidad de elementos pares de la pila.
public class Uso {
>>>>>>> bd1e3a784c165e321862cdb006c595cf473a77ec:src/parte1/EJ6/uso/Uso.java
    public static float porcentajeDeParesPila(PilaTDA pila){
        // complejidad O(n)
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
        PilaUtils.rellenarPila(pila, 10, 50);
        System.out.println("****************************");
        System.out.println("PILA: ");
        PilaUtils.imprimirPila(pila);
        System.out.println("****************************");

        System.out.println("****************************");
        System.out.println("PORCENTAJE DE ELEMENTOS PARES DE LA PILA: ");
        System.out.println(porcentajeDeParesPila(pila) + "%");
        System.out.println("****************************");

    }
}
