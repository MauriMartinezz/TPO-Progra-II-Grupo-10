package utils;

import imple.Conjunto;
import imple.DiccionarioMultiple;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class DiccionarioMultipleUtils {
    public static void mostrarDM(DiccionarioMultipleTDA DM) {

        ConjuntoTDA Claves = DM.claves();
        ConjuntoTDA Valores = new Conjunto();
        Valores.inicializarConjunto();
        int clave = 0;
        int elemento = 0;

        while (!Claves.conjuntoVacio()) {

            clave = Claves.elegir();
            Valores = DM.recuperar(clave);
            System.out.println("Clave: " + clave);
            while (!Valores.conjuntoVacio()) {

                elemento = Valores.elegir();
                System.out.println("\t" + elemento);
                Valores.sacar(elemento);
            }

            Claves.sacar(clave);
        }

    }

    public static DiccionarioMultipleTDA copiarDM(DiccionarioMultipleTDA DM) {

        DiccionarioMultipleTDA DMcopia = new DiccionarioMultiple();
        DMcopia.inicializarDiccionario();
        ConjuntoTDA Claves = DM.claves();
        ConjuntoTDA Valores = new Conjunto();
        Valores.inicializarConjunto();
        int clave = 0;
        int elemento = 0;

        while (!Claves.conjuntoVacio()) {

            clave = Claves.elegir();
            Valores = DM.recuperar(clave);
            while (!Valores.conjuntoVacio()) {

                elemento = Valores.elegir();
                DMcopia.agregar(clave, elemento);
                Valores.sacar(elemento);

            }

            Claves.sacar(clave);
        }

        return DMcopia;
    }

    public static void llenarDM(DiccionarioMultipleTDA DM) {

        for (int i = 0; i < 3; i++) {
            int clave = (int) (Math.random() * 11);
            for (int j = 0; j < 3; j++) {
                DM.agregar(clave, (int) (Math.random() * 11));
            }
        }

    }
}