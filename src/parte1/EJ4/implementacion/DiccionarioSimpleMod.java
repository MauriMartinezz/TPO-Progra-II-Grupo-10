package parte1.EJ4.implementacion;

/* Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en 
DiccionarioSimpleTDA, con la particularidad de registrar la cantidad de veces que el valor 
se ve modificado (entrada: clave-valor-factorMod). Su especificación se muestra en el anexo, 
leer detenidamente los comentarios de cada método. */

import parte1.EJ4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    
    @Override  
    public void inicializarDiccionario(){

        
    }; //inicializa el TDA 
    
    @Override  
    public void agregar(int clave, int valor){

        
    }; //agrega el par clave-valor al TDA, 
    //conjuntamente con la cantidad de veces que dicho valor se vio 
    //modificado. Si la clave se agrega por primera vez, el factor de 
    //modificaciones será 0. Si la clave se agrega por segunda vez, 
    //modificándose el valor, el factor de 
    //modificaciones será 1. Y así sucesivamente. 
    
    @Override  
    public void eliminar(int clave){

        
    }; //elimina la clave del TDA, con su valor y 
    //factor de modificaciones 
    
    @Override  
    public int recuperar(int clave){

        return 0;
    }; //devuelve el valor asociado a la clave, que 
    //se supone existente 
    
    @Override  
    public int recuperarMod(int clave){

        return 0;
    }; //devuelve la cantidad de 
    //modificaciones que sufrió el valor relacionado a dicha clave, que se 
    //supone existente 
    
    @Override  
    public ConjuntoTDA claves(){
        ConjuntoTDA C = new Conjunto();
        return C;
    }; //devuelve el conjunto de claves 

}
