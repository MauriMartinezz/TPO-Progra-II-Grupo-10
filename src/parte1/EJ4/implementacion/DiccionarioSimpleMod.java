package parte1.EJ4.implementacion;

import parte1.EJ4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    
    @Override  
    public void inicializarDiccionario(); //inicializa el TDA 
    
    @Override  
    public void agregar(int clave, int valor); //agrega el par clave-valor al TDA, 
    //conjuntamente con la cantidad de veces que dicho valor se vio 
    //modificado. Si la clave se agrega por primera vez, el factor de 
    //modificaciones será 0. Si la clave se agrega por segunda vez, 
    //modificándose el valor, el factor de 
    //modificaciones será 1. Y así sucesivamente. 
    
    @Override  
    public void eliminar(int clave); //elimina la clave del TDA, con su valor y 
    //factor de modificaciones 
    
    @Override  
    public int recuperar(int clave); //devuelve el valor asociado a la clave, que 
    //se supone existente 
    
    @Override  
    public int recuperarMod(int clave); //devuelve la cantidad de 
    //modificaciones que sufrió el valor relacionado a dicha clave, que se 
    //supone existente 
    
    @Override  
    public ConjuntoTDA claves(); //devuelve el conjunto de claves 

}
