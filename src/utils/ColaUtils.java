package utils;

import java.util.Random;

import tda.ColaTDA;
import imple.Cola;

public class ColaUtils {

    static Random random = new Random();
    public static void rellenarCola(ColaTDA cola, int cantidad, int numMaximo){
        for(int i=0; i<cantidad; i++){
            cola.acolar(random.nextInt(numMaximo));
        }
    }


    public static void imprimirCola(ColaTDA cola){
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        while(!cola.colaVacia()){
            System.out.println(cola.primero());
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }

        while(!colaAux.colaVacia()){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
    }

}
