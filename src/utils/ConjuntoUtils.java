package utils;

import implementacion.Conjunto;
import interfaz.ConjuntoTDA;

public class ConjuntoUtils {
    public static void imprimirConjunto(ConjuntoTDA conjunto){
        ConjuntoTDA conjuntoAux = new Conjunto();
        conjuntoAux.inicializar();
        while(!conjunto.estaVacio()){
            int elemento = conjunto.elegir();
            conjuntoAux.agregar(elemento);
            System.out.println(elemento);
            conjunto.sacar(elemento);
        }

          while(!conjuntoAux.estaVacio()){
            int elemento = conjuntoAux.elegir();
            conjunto.agregar(elemento);
            conjuntoAux.sacar(elemento);
        }
    }
}
