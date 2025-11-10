package utils;

public class DiccionarioSimpleUtils {

    public static void mostrarDS(tda.DiccionarioSimpleTDA dic) {
        tda.ConjuntoTDA claves = dic.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int valor = dic.recuperar(clave);
            System.out.println("Clave: " + clave + " -> Valor: " + valor);
            claves.sacar(clave);
        }
    }
    
}
