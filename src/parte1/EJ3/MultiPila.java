package parte1.EJ3;

import tda.PilaTDA;
import imple.Pila;

public class MultiPila implements MultiPilaTDA {
    private PilaTDA multipila;

    @Override
    public void inicializarPila() {
        multipila = new Pila();
        multipila.inicializarPila();
    }

    @Override
    public boolean pilaVacia() {
        return multipila.pilaVacia();
    }

    @Override
    public void apilar(PilaTDA valores) {
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
