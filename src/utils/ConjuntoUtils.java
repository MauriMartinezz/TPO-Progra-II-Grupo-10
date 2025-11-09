package utils;

import imple.Conjunto;
import tda.ConjuntoTDA;

public class ConjuntoUtils {
   public ConjuntoUtils() {
   }

   public static void llenarConjunto(ConjuntoTDA C) {

      for(int i = 0; i < 3; ++i) {
         int elemento = (int)(Math.random() * 11.0);
         if (!C.pertenece(elemento)) {
            C.agregar(elemento);
         } else {
            --i;
         }
      }

   }

   public static void vaciarConjunto(ConjuntoTDA C) {

      while(!C.conjuntoVacio()) {
         int elemento = C.elegir();
         C.sacar(elemento);
      }

   }

   public static ConjuntoTDA copiarConjunto(ConjuntoTDA C) {
      ConjuntoTDA CCopia = new Conjunto();
      ConjuntoTDA CAux = new Conjunto();
      CCopia.inicializarConjunto();
      CAux.inicializarConjunto();

      int elemento;
      while(!C.conjuntoVacio()) {
         elemento = C.elegir();
         CCopia.agregar(elemento);
         CAux.agregar(elemento);
         C.sacar(elemento);
      }

      while(!CAux.conjuntoVacio()) {
         elemento = CAux.elegir();
         C.agregar(elemento);
         CAux.sacar(elemento);
      }

      return CCopia;
   }

   public static void imprimirConjunto(ConjuntoTDA conjunto) {
      ConjuntoTDA conjuntoAux = new Conjunto();
      conjuntoAux.inicializarConjunto();

      int elemento;
      while(!conjunto.conjuntoVacio()) {
         elemento = conjunto.elegir();
         conjuntoAux.agregar(elemento);
         System.out.println(elemento);
         conjunto.sacar(elemento);
      }

      while(!conjuntoAux.conjuntoVacio()) {
         elemento = conjuntoAux.elegir();
         conjunto.agregar(elemento);
         conjuntoAux.sacar(elemento);
      }

   }
}
