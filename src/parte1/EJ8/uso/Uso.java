package parte1.EJ8.uso;
import imple.Cola;
import tda.ColaTDA;
/*
### Ejercicio 8
Se define un método que reciba una ColaTDA y devuelva una nueva ColaTDA con los 
elementos de la original, sin ninguna repetición. Se debe dejar el primer representante de 
cada uno de los repetidos, respetando el orden en que aparecen todos los elementos en la 
original.
 */
public class Uso {
    public static ColaTDA eliminarRepetidos(ColaTDA cola) {
        // Complejidad : O(n^2) polinómica

        ColaTDA resultado = new Cola();
        resultado.inicializarCola();
        ColaTDA auxiliar = new Cola();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            if (!pertenece(auxiliar, elemento)) {
                resultado.acolar(elemento);
                auxiliar.acolar(elemento);
            }
        }

        // Restaurar la cola original si es necesario
        while (!auxiliar.colaVacia()) {
            int elemento = auxiliar.primero();
            auxiliar.desacolar();
            cola.acolar(elemento);
        }

        return resultado;
    }

    private static boolean pertenece(ColaTDA cola, int elemento) {
        // Complejidad : O(n) lineal
        ColaTDA auxiliar = new Cola();
        auxiliar.inicializarCola();
        boolean encontrado = false;

        while (!cola.colaVacia()) {
            int actual = cola.primero();
            cola.desacolar();
            if (actual == elemento) {
                encontrado = true;
            }
            auxiliar.acolar(actual);
        }

        // Restaurar la cola original
        while (!auxiliar.colaVacia()) {
            int actual = auxiliar.primero();
            auxiliar.desacolar();
            cola.acolar(actual);
        }

        return encontrado;
    }
}
