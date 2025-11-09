// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package utils;

import imple.Pila;
import java.util.Random;
import tda.PilaTDA;

public class PilaUtils {
   static Random random = new Random();

   public PilaUtils() {
   }

   public static void rellenarPila(PilaTDA pila, int cantidad, int numMaximo) {
      for(int i = 0; i < cantidad; ++i) {
         pila.apilar(random.nextInt(numMaximo));
      }

   }

   public static void imprimirPila(PilaTDA pila) {
      PilaTDA pilaAux = new Pila();
      pilaAux.inicializarPila();

      while(!pila.pilaVacia()) {
         System.out.println(pila.tope());
         pilaAux.apilar(pila.tope());
         pila.desapilar();
      }

      while(!pilaAux.pilaVacia()) {
         pila.apilar(pilaAux.tope());
         pilaAux.desapilar();
      }

   }

   public static void vaciarPila(PilaTDA Pila) {
      while(!Pila.pilaVacia()) {
         Pila.desapilar();
      }

   }

   public static PilaTDA copiarPila(PilaTDA Pila) {
      PilaTDA pilacopiada = new Pila();
      PilaTDA pilaaux = new Pila();
      pilacopiada.inicializarPila();
      pilaaux.inicializarPila();

      while(!Pila.pilaVacia()) {
         pilaaux.apilar(Pila.tope());
         Pila.desapilar();
      }

      while(!pilaaux.pilaVacia()) {
         int tope = pilaaux.tope();
         pilacopiada.apilar(tope);
         Pila.apilar(tope);
         pilaaux.desapilar();
      }

      return pilacopiada;
   }
}
