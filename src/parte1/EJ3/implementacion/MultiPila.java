package parte1.EJ3.implementacion;

import tda.PilaTDA;
import imple.Pila;
import parte1.EJ3.interfaz.MultiPilaTDA;

/*
 ### Ejercicio 3
Se define un nuevo TDA denominado MultiPilaTDA basado en PilaTDA, con la 
particularidad de recibir una PilaTDA por parámetro al apilar (la misma debe apilarse a 
continuación de la multipila), y otra al desapilar (la misma debe chequear que los valores 
tope de la multipila coincidan para desapilar, sino no debe hacer nada). Tanto en el método 
apilar como en el método desapilar, ambas pilas vienen inicializadas y contienen cualquier 
cantidad de elementos (incluso cero). El método tope devuelve una PilaTDA con los 
primeros elementos de la multipila, se recibe por parámetro un número mayor o igual que 
cero, que representa la cantidad de ellos (de recibir un número superior a la cantidad de 
elementos de la multipila, debe devolver todos). Se solicita realizar la presente 
implementación con el TDA ya visto PilaTDA, o en su defecto con estructuras dinámicas (no 
puede realizarse la implementación con estructuras estáticas). Su especificación se muestra 
en el anexo, leer detenidamente los comentarios de cada método.
 */
// PENDIENTE IMPLEMENTAR

public class MultiPila implements MultiPilaTDA {
    private PilaTDA multipila;

    @Override
    public void inicializarPila() {
        // complejidad O(1)
        multipila = new Pila();
        multipila.inicializarPila();
    }

    @Override
    public boolean pilaVacia() {
        // complejidad O(1)
        return multipila.pilaVacia();
    }

    @Override
    public void apilar(PilaTDA valores) {
        // complejidad O(n)
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        while (!valores.pilaVacia()) {
            int x = valores.tope();
            valores.desapilar();
            aux.apilar(x);
        }

        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            multipila.apilar(x);
            valores.apilar(x); // restauramos la pila original
        }
    }

    @Override
    public void desapilar(PilaTDA valores) {
        // complejidad O(n)
        PilaTDA auxMultipila = new Pila();
        PilaTDA auxValores = new Pila();
        auxMultipila.inicializarPila();
        auxValores.inicializarPila();

        copiarPila(multipila, auxMultipila);
        copiarPila(valores, auxValores);

        boolean coincide = true;

        while (!auxValores.pilaVacia() && coincide) {
            if (auxMultipila.pilaVacia()) {
                coincide = false;
                break;
            }
            int v = auxValores.tope();
            int m = auxMultipila.tope();
            if (v == m) {
                auxValores.desapilar();
                auxMultipila.desapilar();
            } else {
                coincide = false;
            }
        }

        if (coincide) {
            int cantidad = contarElementos(valores);
            for (int i = 0; i < cantidad; i++) {
                multipila.desapilar();
            }
        }
    }

    @Override
    public PilaTDA tope(int cantidad) {
        // complejidad O(n)
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        int contador = 0;

        while (!multipila.pilaVacia() && (cantidad == 0 || contador < cantidad)) {
            int x = multipila.tope();
            multipila.desapilar();
            aux.apilar(x);
            contador++;
        }

        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            resultado.apilar(x);
            multipila.apilar(x);
        }

        return resultado;
    }

    // ---- Métodos auxiliares ----
    private void copiarPila(PilaTDA origen, PilaTDA destino) {
        // complejidad O(n)
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        while (!origen.pilaVacia()) {
            int x = origen.tope();
            origen.desapilar();
            aux.apilar(x);
        }
        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            destino.apilar(x);
            origen.apilar(x);
        }
    }

    private int contarElementos(PilaTDA pila) {
        // complejidad O(n)
        int c = 0;
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        while (!pila.pilaVacia()) {
            int x = pila.tope();
            pila.desapilar();
            aux.apilar(x);
            c++;
        }
        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            pila.apilar(x);
        }
        return c;
    }
}
