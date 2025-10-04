package utils;

import java.util.Random;

import interfaz.ColaTDA;
import implementacion.Cola;

public class ColaUtils {

    static Random random = new Random();
    public static void rellenarCola(ColaTDA cola, int cantidad, int numMaximo){
        for(int i=0; i<cantidad; i++){
            cola.acolar(random.nextInt(numMaximo));
        }
    }


    public static void imprimirCola(ColaTDA cola){
        ColaTDA colaAux = new Cola();
        colaAux.inicializar();
        while(!cola.estaVacia()){
            System.out.println(cola.primero());
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }

        while(!colaAux.estaVacia()){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
    }

}
