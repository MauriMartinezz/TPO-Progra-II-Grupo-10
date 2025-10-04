package interfaz;

public interface DiccionarioMultipleTDA {
    void inicializar();
    void agregar(int clave, int valor);
    void eliminar(int clave);
    ConjuntoTDA recuperar(int clave);
    ConjuntoTDA obtenerClaves();
    void eliminarValor(int clave, int valor);
    boolean estaVacio();
}
