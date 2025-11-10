package parte1.EJ12.uso;
import imple.ABB;
import tda.ABBTDA;
/*
### Ejercicio 12
Se define un método que calcule la suma de los elementos con un valor impar de un ABB. 
*/
public class Uso {
    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.inicializarArbol();
        
        // Insertando elementos en el ABB 
        arbol.agregarElem(50);
        arbol.agregarElem(33);
        arbol.agregarElem(70);
        arbol.agregarElem(21);
        arbol.agregarElem(40);
        arbol.agregarElem(65);
        arbol.agregarElem(80);  

        int sumaImpares = sumarImpares(arbol);
        System.out.println("La suma de los elementos impares del ABB es: " + sumaImpares);

    }

    public static int sumarImpares(ABBTDA a) {
        // Se uso recursividad
        if (a.arbolVacio()) {
            return 0; // Caso base: árbol vacío
        } else {
            int sumaIzq = sumarImpares(a.hijoIzq());
            int sumaDer = sumarImpares(a.hijoDer());
            int valorActual = a.raiz();
            if (valorActual % 2 != 0) { // Verificar si es impar
                return valorActual + sumaIzq + sumaDer;
            } else {
                return sumaIzq + sumaDer;
            }
        }
    }

}


/*
 * El arbol se vería así:
 *        50
 *     /    \
 *   33      70
 *  /  \    /  \
 * 21  40  65   80
 * Elementos impares: 33, 21, 65
 * Suma de elementos impares: 119
 */