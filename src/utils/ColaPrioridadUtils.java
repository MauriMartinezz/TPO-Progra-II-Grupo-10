// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package utils;

import imple.ColaPrioridad;
import tda.ColaPrioridadTDA;

public class ColaPrioridadUtils {
   public ColaPrioridadUtils() {
   }

   public static void llenarCola(ColaPrioridadTDA cola) {
      for(int i = 0; i < 10; ++i) {
         cola.acolarPrioridad((int)(Math.random() * 11.0), (int)(Math.random() * 11.0));
      }

   }

   public static void mostrarCola(ColaPrioridadTDA cola) {
      ColaPrioridadTDA Colaaux = new ColaPrioridad();
      Colaaux.inicializarCola();

      do {
         int elemento = cola.primero();
         int prioridad = cola.prioridad();
         System.out.print("Elemento: " + elemento + ", Prioridad: " + prioridad + "\n");
         Colaaux.acolarPrioridad(elemento, prioridad);
         cola.desacolar();
      } while(!cola.colaVacia());

      do {
         cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
         Colaaux.desacolar();
      } while(!Colaaux.colaVacia());

   }

   public static void vaciarCola(ColaPrioridadTDA cola) {
      while(!cola.colaVacia()) {
         cola.desacolar();
      }

   }

   public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA cola) {
      ColaPrioridadTDA Colaaux = new ColaPrioridad();
      ColaPrioridadTDA Colacopia = new ColaPrioridad();
      Colaaux.inicializarCola();
      Colacopia.inicializarCola();

      while(!cola.colaVacia()) {
         int elemento = cola.primero();
         int prioridad = cola.prioridad();
         Colaaux.acolarPrioridad(elemento, prioridad);
         Colacopia.acolarPrioridad(elemento, prioridad);
         cola.desacolar();
      }

      while(!Colaaux.colaVacia()) {
         cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
         Colaaux.desacolar();
      }

      return Colacopia;
   }
}
