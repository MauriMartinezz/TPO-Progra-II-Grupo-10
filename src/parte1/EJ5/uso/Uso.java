package parte1.EJ5.uso;

import parte1.EJ5.implementacion.DiccionarioSimple;
import tda.DiccionarioSimpleTDA;

public class Uso {

    public static void main(String[] args) {
        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();

        dic.agregar(1, 100);
        dic.agregar(2, 200);
        dic.agregar(3, 300);

        System.out.println("Recuperar clave 2: " + dic.recuperar(2)); // Espera 200
        
        dic.agregar(1, 150); // Actualiza valor de clave 1
        System.out.println("Recuperar clave 1 después de actualizar: " + dic.recuperar(1)); // Espera 150
        
        dic.agregar(4, 400);
        System.out.println("Recuperar clave 4: " + dic.recuperar(4)); // Espera 400

        dic.eliminar(5); // Intentar eliminar clave no existente
        System.out.println("Recuperar clave 5 (no existente): " + dic.recuperar(5)); // Espera 0 o error

    }
}
