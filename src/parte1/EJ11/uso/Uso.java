package parte1.EJ11.uso;

import imple.Cola;
import imple.Conjunto;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

/* ### Ejercicio 11
Se define un método que reciba un DiccionarioMultipleTDA y devuelva una ColaTDA con todos los valores del diccionario, sin ninguna repetición.
 */
public class Uso {

    public static ColaTDA obtenerValoresUnicos(DiccionarioMultipleTDA diccionario) {
        // Complejidad: O(n*m) donde n es la cantidad de claves y m la cantidad de valores por clave
        ColaTDA valoresUnicosCola = new Cola();
        valoresUnicosCola.inicializarCola();
        ConjuntoTDA claves = diccionario.claves();
        DiccionarioMultipleTDA diccionarioAux = utils.DiccionarioMultipleUtils.copiarDM(diccionario);

        ConjuntoTDA valoresDiccionario = new Conjunto();
        valoresDiccionario.inicializarConjunto();

        while (!claves.conjuntoVacio()) { // recorrer las claves
            int clave = claves.elegir();
            ConjuntoTDA valoresConLaClave = diccionarioAux.recuperar(clave);

            while (!valoresConLaClave.conjuntoVacio()) { // recorrer los valores de la clave
                    int valor = valoresConLaClave.elegir();
                    if(!valoresDiccionario.pertenece(valor)){ // si el valor no está en el conjunto de valores ya agregados
                        valoresUnicosCola.acolar(valor); 
                        valoresDiccionario.agregar(valor);
                    }
                    valoresConLaClave.sacar(valor);
                    claves.sacar(clave);
            }
        }

        return valoresUnicosCola;
    }

    public static void main(String[] args) {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultiple();
        diccionario.inicializarDiccionario();
        System.out.println("**********************");
        utils.DiccionarioMultipleUtils.llenarDM(diccionario);
        utils.DiccionarioMultipleUtils.mostrarDM(diccionario);
        System.out.println("**********************");

        System.out.println("COLA CON VALORES ÚNICOS");
        ColaTDA valoresUnicos = obtenerValoresUnicos(diccionario);
        utils.ColaUtils.imprimirCola(valoresUnicos);
        System.out.println("**********************");

    }
}
