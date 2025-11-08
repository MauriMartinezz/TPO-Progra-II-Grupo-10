package parte1.EJ8.uso;

import imple.Cola;
import tda.ColaTDA;

// Se define un método que reciba una ColaTDA y devuelva una nueva ColaTDA con los 
// elementos de la original, sin ninguna repetición. Se debe dejar el primer representante de 
// cada uno de los repetidos, respetando el orden en que aparecen todos los elementos en la 
// original.

public class Punto_VIII {
    public static ColaTDA colaSinRepetir(ColaTDA cola){
        ColaTDA colaAux = utils.ColaUtils.copiarCola(cola);
        ColaTDA colaSinRepetidos = new Cola();
        colaSinRepetidos.inicializarCola();

        while(!colaAux.colaVacia()){
            if(colaAux.)
            colaAux.desacolar();
        }
        return colaSinRepetidos;
    }
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();

        utils.ColaUtils.rellenarCola(cola, 10, 10);

    }
}
