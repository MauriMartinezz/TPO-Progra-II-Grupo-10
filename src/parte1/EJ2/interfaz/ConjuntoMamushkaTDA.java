package parte1.EJ2.interfaz;

/* Se define un nuevo TDA denominado ConjuntoMamushkaTDA basado en 
ConjuntoTDA, con la particularidad de que se permite más de una acepción de cada 
elemento agregado. Tal cual como en ConjuntoTDA, no existe orden alguno. Su 
especificación se muestra en el anexo, leer detenidamente los comentarios de cada método. */

public interface ConjuntoMamushkaTDA { 
    void inicializar( ); //inicializa el TDA 
    void guardar(int dato); //agrega el elemento dato al TDA 
    void sacar(int dato); //elimina del TDA una acepción del elemento dato 
    int elegir( ); //muestra un elemento agregado al TDA (arbitrario) 
    int perteneceCant(int dato); //devuelve la cantidad de veces que se 
    //encuentra el elemento dato en el TDA 
    boolean estaVacio( ); //devuelve un boolean que informa si el TDA está 
    //vacío 
}