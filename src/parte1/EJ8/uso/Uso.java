package parte1.EJ8.uso;

import imple.Cola;
import tda.ColaTDA;
import utils.ColaUtils;

/* ### Ejercicio 8
Se define un método que reciba una ColaTDA y devuelva una nueva ColaTDA con los
elementos de la original, sin ninguna repetición. Se debe dejar el primer representante de
cada uno de los repetidos, respetando el orden en que aparecen todos los elementos en la
original.
*/

public class Uso {

    public static ColaTDA colaSinRepetir(ColaTDA cola){
        //complejidad O(n*m)

        ColaTDA colaAux = ColaUtils.copiarCola(cola);
        ColaTDA colaSinRepetidos = new Cola();
        colaSinRepetidos.inicializarCola();

        while(!colaAux.colaVacia()){
            // comprobar si el elemento ya fue añadido a la cola resultado
            if(!ColaUtils.existeElementoEnCola(colaSinRepetidos, colaAux.primero())){
                colaSinRepetidos.acolar(colaAux.primero());
            }
            colaAux.desacolar();
        }
        return colaSinRepetidos;
    }
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        System.out.println("**********************");
        System.out.println("COLA ORIGINAL: ");
        utils.ColaUtils.rellenarCola(cola,10, 10);
        utils.ColaUtils.imprimirCola(cola);
        System.out.println("**********************");
        
        System.out.println("COLA SIN REPETIDOS: ");
        ColaTDA colaSinRepetidos = colaSinRepetir(cola);
        utils.ColaUtils.imprimirCola(colaSinRepetidos);
        System.out.println("**********************");
    }
}
