package utils;

import java.util.Random;

import imple.Cola;
import tda.ColaTDA;

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

    public static Cola copiarCola(ColaTDA cola) {
        Cola Colaaux = new Cola();
        Cola Colacopia = new Cola();
        Colaaux.inicializarCola();
        Colacopia.inicializarCola();

        int elemento; // declarar una vez y asignar dentro del bucle

        while (!cola.colaVacia()) {
            elemento = cola.primero();
            Colaaux.acolar(elemento);
            Colacopia.acolar(elemento);
            cola.desacolar();
        }

        while (!Colaaux.colaVacia()) {
            cola.acolar(Colaaux.primero());
            Colaaux.desacolar();
        }

        return Colacopia;
    }

        public static boolean existeElementoEnCola(ColaTDA cola, int elemento){
        boolean existe = false;
        ColaTDA colaAux = utils.ColaUtils.copiarCola(cola);

        // recorrer mientras queden elementos y no se haya encontrado el elemento
        while(!colaAux.colaVacia() && !existe){
            if(colaAux.primero() == elemento) existe = true;
            colaAux.desacolar();
        }

        return existe;
    }
}
