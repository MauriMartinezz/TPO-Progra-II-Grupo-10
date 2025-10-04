package utils;

import java.util.Random;

import implementacion.Pila;
import interfaz.PilaTDA;

public class PilaUtils {
    public static void rellenarPila(PilaTDA pila, int cantidad, int numMaximo, Random random){
        for(int i=0; i<cantidad; i++){
            pila.apilar(random.nextInt(numMaximo));
        }
    }

        public static void imprimirPila(PilaTDA pila){
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializar();

        while(!pila.estaVacia()){
            System.out.println(pila.tope());
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!pilaAux.estaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

       public static void rellenarPila(PilaTDA pila, int cantidad, int numMaximo, Random random){
        for(int i=0; i<cantidad; i++){
            pila.apilar(random.nextInt(numMaximo));
        }
    }
}
