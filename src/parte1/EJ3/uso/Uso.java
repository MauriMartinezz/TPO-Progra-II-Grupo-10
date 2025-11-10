package parte1.EJ3.uso;


import imple.Pila;
import parte1.EJ3.implementacion.MultiPila;
import tda.PilaTDA;

public class Uso {
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


        // Crear pila para desapilar: (tope) 5 - 3 (debería fallar porque no coincide con el tope actual que es 9,1)
        PilaTDA desap = new Pila();
        desap.inicializarPila();
        desap.apilar(3);
        desap.apilar(5);
        mp.desapilar(desap);

        System.out.println("Despues de desapilar (fallido):");
        utils.PilaUtils.imprimirPila(mp.tope(5));

        // Crear pila para desapilar: (tope) 9 - 1 - 7 (debería funcionar)
        PilaTDA desap2 = new Pila();
        desap2.inicializarPila();
        desap2.apilar(7);
        desap2.apilar(1);
        desap2.apilar(9);
        mp.desapilar(desap2);
        System.out.println("Despues de desapilar (correcto):");
        utils.PilaUtils.imprimirPila(mp.tope(5));
    }
}
