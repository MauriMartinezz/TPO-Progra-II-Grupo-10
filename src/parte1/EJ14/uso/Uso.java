package parte1.EJ14.uso;

/* ### Ejercicio 14
Se define un método que reciba un GrafoTDA y dos enteros que representen vértices, 
y devuelva un ConjuntoTDA con todos los vértices puente entre los vértices recibidos por 
parámetro. Se define que un vértice p es puente entre dos vértices o y d, si hay una arista 
que comienza en o y termina en p y otra que comienza en p y termina en d. */

public class Uso {

    public static tda.ConjuntoTDA Metodo(tda.GrafoTDA grafo, int origen, int destino) {
        tda.ConjuntoTDA conjuntoPuentes = new imple.Conjunto();
        conjuntoPuentes.inicializarConjunto();

        return conjuntoPuentes;
    }
    
    public static void main(String[] args) {

    }
}
