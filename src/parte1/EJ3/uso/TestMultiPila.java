package parte1.EJ3.uso;


import imple.Pila;
import parte1.EJ3.implementacion.MultiPila;
import tda.PilaTDA;

public class TestMultiPila {
    public static void main(String[] args) {
        MultiPila mp = new MultiPila();
        mp.inicializarPila();

        // Crear pila A: (tope) 1 - 9
        PilaTDA A = new Pila();
        A.inicializarPila();
        A.apilar(9);
        A.apilar(1);

        // Crear pila B: (tope) 3 - 5 - 7
        PilaTDA B = new Pila();
        B.inicializarPila();
        B.apilar(7);
        B.apilar(5);
        B.apilar(3);

        // Apilar B primero
        mp.apilar(B);
        // Luego A
        mp.apilar(A);

        System.out.println("Tope(5) -> ");
        imprimirPila(mp.tope(5));

        // Crear pila para desapilar: (tope) 1 - 9
        PilaTDA desap = new Pila();
        desap.inicializarPila();
        desap.apilar(9);
        desap.apilar(1);

        mp.desapilar(desap);

        System.out.println("Despues de desapilar:");
        imprimirPila(mp.tope(5));
    }

    private static void imprimirPila(PilaTDA p) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        copiar(p, aux);
        while (!aux.pilaVacia()) {
            System.out.print(aux.tope() + " ");
            aux.desapilar();
        }
        System.out.println();
    }

    private static void copiar(PilaTDA origen, PilaTDA destino) {
        PilaTDA temp = new Pila();
        temp.inicializarPila();
        while (!origen.pilaVacia()) {
            int x = origen.tope();
            origen.desapilar();
            temp.apilar(x);
        }
        while (!temp.pilaVacia()) {
            int x = temp.tope();
            temp.desapilar();
            destino.apilar(x);
            origen.apilar(x);
        }
    }
}
