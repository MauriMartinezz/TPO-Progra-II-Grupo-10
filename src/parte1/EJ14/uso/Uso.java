package parte1.EJ14.uso;

import tda.GrafoTDA;
import tda.ConjuntoTDA;
import imple.Grafo;
import imple.Conjunto;

/* ### Ejercicio 14
Se define un método que reciba un GrafoTDA y dos enteros que representen vértices, 
y devuelva un ConjuntoTDA con todos los vértices puente entre los vértices recibidos por 
parámetro. Se define que un vértice p es puente entre dos vértices o y d, si hay una arista 
que comienza en o y termina en p y otra que comienza en p y termina en d.
*/
public class Uso {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();

        // Agregar vértices 1,2,3,4,5
        for (int i = 1; i <= 5; i++) {
            grafo.agregarVertice(i);
        }

        // Agregar aristas
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(4, 3, 1);
        grafo.agregarArista(3, 5, 1);

        ConjuntoTDA puentes = encontrarVerticesPuente(grafo, 1, 3);
        System.out.println("Vértices puente entre 1 y 3:");
        while (!puentes.conjuntoVacio()) {
            int valor = puentes.elegir();
            System.out.println(valor);
            puentes.sacar(valor);
        }
    }

    public static ConjuntoTDA encontrarVerticesPuente(GrafoTDA g, int origen, int destino) {
        // complejidad O(n*m) donde n es la cantidad de vertices en el grafo
        ConjuntoTDA puentes = new Conjunto();
        puentes.inicializarConjunto();

        ConjuntoTDA vertices = g.vertices(); //creamos un conjunto con todos los vertices del grafo
        while (!vertices.conjuntoVacio()) { // procesamos cada uno de los vertices
            int vertice = vertices.elegir();
            if (g.existeArista(origen, vertice) && g.existeArista(vertice, destino)) { // es puente?
                puentes.agregar(vertice); // agregar al conjunto de puentes
            }
            vertices.sacar(vertice); // sacar el vertice ya procesado
        }

        return puentes; // devolver el conjunto de puentes
    }
}

/*
El grafo se vería así:
     (1)
     / \
   2/   \4
   /     \
 (2)     (4)
   \3   / 
    \ / 6 
    (3)
      \
       \5
       (5)
Vértices puente entre 1 y 3: 2, 4
 */