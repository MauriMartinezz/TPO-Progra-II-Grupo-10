package parte1.EJ13.uso;
import imple.ABB;
import tda.ABBTDA;
/*
### Ejercicio 13
Se define un método que calcule la cantidad de hojas con un valor par de un ABB.
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
        
        int sumaImpares = sumarPares(arbol);
        System.out.println("La cantidad de hojas pares del ABB es: " + sumaImpares);
    }

    public static int sumarPares(ABBTDA a) {
        if (a.arbolVacio()) {
            return 0; // Caso base: árbol vacío
        } else {
            if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) { // Es hoja?
                if (a.raiz() % 2 == 0) { // Verificar si es par
                    return 1;
                } else {
                    return 0;
                }
            } else {
                int sumaIzq = sumarPares(a.hijoIzq());
                int sumaDer = sumarPares(a.hijoDer());
                return sumaIzq + sumaDer;
            }
        }
    }
}

/*
 * El arbol se vería así:
 *         50
 *      /    \
 *    33      70
 *   /  \    /  \
 * 21  40  65   80
 * 
 * Hojas pares: 40, 80
 * Cantidad de hojas pares: 2
 */