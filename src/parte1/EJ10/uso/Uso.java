package parte1.EJ10.uso;


import imple.DiccionarioSimple;
import imple.Pila;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

/* ### Ejercicio 10
Se define un método que reciba una PilaTDA y devuelva un DiccionarioSimpleTDA, 
en el cual se guardarán los elementos de la pila como claves, y la cantidad de apariciones de 
dicho elemento en la pila, como valores.
*/


public class Uso {

    public static DiccionarioSimpleTDA Metodo(PilaTDA pila) {
        // complejidad O(n*m) polinomica

        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();
        PilaTDA aux = utils.PilaUtils.copiarPila(pila);
       
        while (!aux.pilaVacia()) { // recorrer la pila
            int elemento = aux.tope(); // obtener el elemento
            aux.desapilar(); 
            int contador = 1; 

            PilaTDA aux2 = utils.PilaUtils.copiarPila(aux); // copiar la pila para contar apariciones
            if (!dic.claves().pertenece(elemento)) { // si el elemento no está en el diccionario
                while (!aux2.pilaVacia()) { // contar apariciones del elemento
                    if (aux2.tope() == elemento) {
                        contador++;
                    }
                    
                    aux2.desapilar();
                }

                dic.agregar(elemento, contador); // agregar al diccionario el valor y su contador
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
        System.out.println("Diccionario Simple resultante:");
        DiccionarioSimpleTDA dic = Metodo(pila);
        utils.DiccionarioSimpleUtils.mostrarDS(dic);
    }
}
