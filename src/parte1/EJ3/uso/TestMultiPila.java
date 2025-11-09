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
        utils.PilaUtils.imprimirPila(mp.tope(5));
        System.out.println("Tope(10) -> ");
        utils.PilaUtils.imprimirPila(mp.tope(10));


        // Crear pila para desapilar: (tope) 1 - 9 (debería fallar porque no coincide con el tope actual que es 3,5)
        PilaTDA desap = new Pila();
        desap.inicializarPila();
        desap.apilar(9);
        desap.apilar(1);
        mp.desapilar(desap);

        System.out.println("Despues de desapilar:");
        utils.PilaUtils.imprimirPila(mp.tope(5));

        // Crear pila para desapilar: (tope) 3 - 5 - 7 (debería funcionar)
        PilaTDA desap2 = new Pila();
        desap2.inicializarPila();
        desap2.apilar(3);
        desap2.apilar(5);
        desap2.apilar(7);
        mp.desapilar(desap2);
        System.out.println("Despues de desapilar:");
        utils.PilaUtils.imprimirPila(mp.tope(5));
    }
}
