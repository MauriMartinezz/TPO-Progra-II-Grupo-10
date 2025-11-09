package parte1.EJ11.uso;

import imple.Cola;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

//   Definir un método que reciba un `DiccionarioMultipleTDA` y devuelva una `ColaTDA` con todos los **valores sin repetición**.  
//   → Recorrer claves, recopilar valores y eliminar duplicados.
public class Punto_XI {

    public static ColaTDA obtenerValoresUnicos(DiccionarioMultipleTDA diccionario) {
        // Complejidad: P
        ColaTDA valoresUnicosCola = new Cola();
        valoresUnicosCola.inicializarCola();
        ConjuntoTDA claves = diccionario.claves();
        DiccionarioMultipleTDA diccionarioAux = utils.DiccionarioMultipleUtils.copiarDM(diccionario);

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            ConjuntoTDA valoresConLaClave = diccionarioAux.recuperar(clave);

            while (!valoresConLaClave.conjuntoVacio()) {
                int valor = valoresConLaClave.elegir();

                if (!utils.ColaUtils.existeElementoEnCola(valoresUnicosCola, clave)) {
                    valoresUnicosCola.acolar(valor);
                }
                valoresConLaClave.sacar(valor);
            }
            claves.sacar(clave);
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
