package parte1.EJ2.uso;

import parte1.EJ2.implementacion.ConjuntoMamushka;
import parte1.EJ2.interfaz.ConjuntoMamushkaTDA;

/* Se define un nuevo TDA denominado ConjuntoMamushkaTDA basado en 
ConjuntoTDA, con la particularidad de que se permite más de una acepción de cada 
elemento agregado. Tal cual como en ConjuntoTDA, no existe orden alguno. Su 
especificación se muestra en el anexo, leer detenidamente los comentarios de cada método.*/

public class Uso {

    public static void llenarConjunto(ConjuntoMamushkaTDA C) {

        for(int i = 0; i < 10; ++i) {
            int elemento = (int)(Math.random() * 11.0);
            C.guardar(elemento);
        }

   }

    public static void vaciarConjunto(ConjuntoMamushkaTDA C) {

        while(!C.estaVacio()) {
            int elemento = C.elegir();
            C.sacar(elemento);
        }

   }

    public static ConjuntoMamushkaTDA copiarConjunto(ConjuntoMamushkaTDA C) {
      ConjuntoMamushkaTDA CCopia = new ConjuntoMamushka();
      ConjuntoMamushkaTDA CAux = new ConjuntoMamushka();
      CCopia.inicializar();
      CAux.inicializar();

      int elemento;
      while(!C.estaVacio()) {
         elemento = C.elegir();
         CCopia.guardar(elemento);
         CAux.guardar(elemento);
         C.sacar(elemento);
      }

      while(!CAux.estaVacio()) {
         elemento = CAux.elegir();
         C.guardar(elemento);
         CAux.sacar(elemento);
      }

      return CCopia;
   }

    public static void imprimirConjunto(ConjuntoMamushkaTDA conjunto) {
        ConjuntoMamushkaTDA conjuntoAux = new ConjuntoMamushka();
        conjuntoAux.inicializar();

        int elemento;
        while(!conjunto.estaVacio()) {
            elemento = conjunto.elegir();
            conjuntoAux.guardar(elemento);
            System.out.println(elemento);
            conjunto.sacar(elemento);
        }

        while(!conjuntoAux.estaVacio()) {
            elemento = conjuntoAux.elegir();
            conjunto.guardar(elemento);
            conjuntoAux.sacar(elemento);
        }

   }

    public static void main(String[] args) {
        ConjuntoMamushkaTDA conj = new ConjuntoMamushka();
        conj.inicializar();

        llenarConjunto(conj);
        imprimirConjunto(conj);
        
        //mostramos numeros
        System.out.println("Imprimimos cant de datos de elementos de ejemplo");
        System.out.println(9);
        System.out.println("\tCant: " + conj.perteneceCant(9));
        System.out.println(2);
        System.out.println("\tCant: " + conj.perteneceCant(2));
        System.out.println(5);
        System.out.println("\tCant: " + conj.perteneceCant(5));
        System.out.println(7);
        System.out.println("\tCant: " + conj.perteneceCant(7));
        System.out.println(1);
        System.out.println("\tCant: " + conj.perteneceCant(1));
    }
}