package parte1.EJ15.uso;
import tda.GrafoTDA;
import imple.Grafo;
import tda.ConjuntoTDA;
/*
### Ejercicio 15
Se define un método que reciba un GrafoTDA y un entero que represente un vértice, 
y devuelva el grado del vértice recibido por parámetro. Se define el grado de un vértice v 
como el entero que es igual a la resta entre la cantidad de aristas que salen de v menos la 
cantidad de aristas que llegan a v. 
 */

public class Uso {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();

        // Agregar vértices
        for (int i = 1; i <= 5; i++) {
            grafo.agregarVertice(i);
        }

        // Agregar aristas
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(4, 3, 1);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(2, 5, 1);

        int vertice = 3;
        int grado = calcularGrado(grafo, vertice);
        System.out.println("El grado del vértice " + vertice + " es: " + grado);
    }

    public static int calcularGrado(GrafoTDA g, int vertice) {
        // complejidad O(n) donde n es la cantidad de vertices en el grafo
        int salientes = 0;
        int entrantes = 0;

        // Contar aristas salientes
        ConjuntoTDA vertices = g.vertices();
        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            if (g.existeArista(vertice, v)) {
                salientes++;
            }
            vertices.sacar(v);
        }

        // Contar aristas entrantes
        vertices = g.vertices();
        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            if (g.existeArista(v, vertice)) {
                entrantes++;
            }
            vertices.sacar(v);
        }

        return salientes - entrantes;
    }
}

/*
El grafo se vería así:
        (1)
        / \
      2/   \4
      /     \
    (2)-----(4)
      \3   / 
       \  /  
        (3)
         \
          \5
          (5)
Grado del vértice 3: -1 (2 aristas entrantes: de 2 y 4; 1 arista saliente: a 5)
 */