package parte1.EJ4.uso;

import parte1.EJ4.implementacion.DiccionarioSimpleMod;
import parte1.EJ4.interfaz.DiccionarioSimpleModTDA;

public class uso {

    public static void main (String[] args) {
    
    DiccionarioSimpleModTDA diccionario = new DiccionarioSimpleMod();
    diccionario.inicializarDiccionario();

    System.out.println("Agregamos claves y valores:");
    System.out.println("Clave 1 -> Valor 100");
    diccionario.agregar(1, 100);
    System.out.println("Clave 2 -> Valor 200");
    diccionario.agregar(2, 200);
    System.out.println("Clave 3 -> Valor 300");
    diccionario.agregar(1, 150);
    System.out.println("Clave 4 -> Valor 400");
    diccionario.agregar(3, 300);
    System.out.println("Clave 1 -> Valor 175");
    diccionario.agregar(2, 250);
    System.out.println("Clave 2 -> Valor 275");
    diccionario.agregar(1, 175);
    System.out.println("Clave 3 -> Valor 350");
    diccionario.agregar(4, 400);
    System.out.println("Clave 2 -> Valor 280");
    diccionario.agregar(3, 350);

        
    System.out.println("Recuperamos valores:");
    System.out.println("Clave 1 sufrio " + diccionario.recuperarMod(1) + " modificaciones.");
    System.out.println("Clave 2 sufrio " + diccionario.recuperarMod(2) + " modificaciones.");
    System.out.println("Clave 3 sufrio " + diccionario.recuperarMod(3) + " modificaciones.");
    
    }
}
