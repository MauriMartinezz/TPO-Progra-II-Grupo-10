package parte1.EJ11;

import implementacion.Cola;
import implementacion.DiccionarioMultiple;
import interfaz.ColaTDA;
import interfaz.DiccionarioMultipleTDA;

//   Definir un método que reciba un `DiccionarioMultipleTDA` y devuelva una `ColaTDA` con todos los **valores sin repetición**.  
//   → Recorrer claves, recopilar valores y eliminar duplicados.
public class Punto_XI {

    public static ColaTDA obtenerValoresUnicos(DiccionarioMultipleTDA diccionario){
        ColaTDA valoresUnicosCola = new Cola();
        valoresUnicosCola.inicializar();

        return valoresUnicosCola;
    }
    public static void main(String[] args) {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultiple();
        diccionario.inicializar();
    }
}
