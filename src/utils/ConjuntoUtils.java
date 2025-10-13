package utils;

import imple.Conjunto;
import tda.ConjuntoTDA;

public class ConjuntoUtils {
    public static void imprimirConjunto(ConjuntoTDA conjunto){
        ConjuntoTDA conjuntoAux = new Conjunto();
        conjuntoAux.inicializarConjunto();
        while(!conjunto.conjuntoVacio()){
            int elemento = conjunto.elegir();
            conjuntoAux.agregar(elemento);
            System.out.println(elemento);
            conjunto.sacar(elemento);
        }
          while(!conjuntoAux.conjuntoVacio()){
            int elemento = conjuntoAux.elegir();
            conjunto.agregar(elemento);
            conjuntoAux.sacar(elemento);
        }
    }
}
