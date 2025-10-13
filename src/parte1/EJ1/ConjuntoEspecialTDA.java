package parte1.EJ1;
import imple.Conjunto;

public class ConjuntoEspecialTDA {

    private Conjunto conjunto;

    public ConjuntoEspecialTDA() {
        conjunto = new Conjunto();
    }

    public Respuesta agregar(int elemento) {
        // chequear si el elemento se agregó correctamente
        conjunto.agregar(elemento);
        boolean exito = conjunto.pertenece(elemento);
        return new Respuesta(exito, elemento);
    }

    public Respuesta eliminar(int elemento) {
        conjunto.sacar(elemento);
        boolean exito = !conjunto.pertenece(elemento);
        return new Respuesta(exito, elemento);
    }

    public Respuesta contiene(int elemento) {
        boolean existe = conjunto.pertenece(elemento);
        int valor = existe ? elemento : -1;
        return new Respuesta(true, valor);
    }
}
