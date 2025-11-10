package parte1.EJ10.uso;

import imple.DiccionarioMultiple;
import imple.Pila;
import tda.DiccionarioMultipleTDA;
import tda.PilaTDA;

/* ### Ejercicio 10
Se define un método que reciba una PilaTDA y devuelva un DiccionarioSimpleTDA, 
en el cual se guardarán los elementos de la pila como claves, y la cantidad de apariciones de 
dicho elemento en la pila, como valores.
*/


public class Uso {

    public static DiccionarioMultipleTDA Metodo(PilaTDA pila) {
        // complejidad O(n^2) polinomica

        DiccionarioMultipleTDA dic = new DiccionarioMultiple();
        dic.inicializarDiccionario();
        PilaTDA aux = utils.PilaUtils.copiarPila(pila);

        while (!aux.pilaVacia()) {
            int elemento = aux.tope();
            aux.desapilar();
            int contador = 1;

            PilaTDA aux2 = utils.PilaUtils.copiarPila(aux);
            if (!dic.claves().pertenece(elemento)) {
                while (!aux2.pilaVacia()) {
                    if (aux2.tope() == elemento) {
                        contador++;
                    }
                    aux2.desapilar();
                }

                dic.agregar(elemento, contador);
            }
        }
        return dic;
    }

    public static void main(String[] args) {

        // Crear y rellenar la pila
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        utils.PilaUtils.rellenarPila(pila, 10, 2);

        // Mostrar la pila inicial
        System.out.println("Pila inicial:");
        utils.PilaUtils.imprimirPila(pila);

        // Mostrar el diccionario resultante
        System.out.println("Diccionario Multiple resultante:");
        DiccionarioMultipleTDA dic = Metodo(pila);
        utils.DiccionarioMultipleUtils.mostrarDM(dic); 
    
    }

}
