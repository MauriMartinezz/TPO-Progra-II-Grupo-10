package parte1.EJ1;

// Interfaz ConjuntoEspecialTDA
public interface ConjuntoEspecialTDA {

    // Clase que encapsula la respuesta de las operaciones
    public class Respuesta {
        public boolean error; // true si hubo error, false si no
        public int rta;       // valor devuelto, si corresponde
    }

    void inicializarConjunto();            // Inicializa el conjunto
    Respuesta agregar(int valor);          // Agrega un valor al conjunto
    Respuesta sacar(int valor);            // Elimina un valor del conjunto
    Respuesta elegir();                    // Devuelve un valor del conjunto
    boolean pertenece(int valor);          // Indica si un valor pertenece
    boolean conjuntoVacio();               // Indica si el conjunto está vacío
}
