package parte1.EJ1.Implementación;

import imple.Conjunto;
import parte1.EJ1.interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private Conjunto conjunto;

    @Override
    public void inicializarConjunto() {
        // complejidad O(1)
        conjunto = new Conjunto();
        conjunto.inicializarConjunto();
    }

    @Override
    public Respuesta agregar(int valor) {
        // complejidad O(n) debido a la operación pertenece()
        Respuesta res = new Respuesta();
        if (!conjunto.pertenece(valor)) {
            conjunto.agregar(valor);
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }

    @Override
    public Respuesta sacar(int valor) {
        // complejidad O(n) debido a la operación pertenece()
        Respuesta res = new Respuesta();
        if (conjunto.pertenece(valor)) {
            conjunto.sacar(valor);
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }

    @Override
    public Respuesta elegir() {
        // complejidad O(1)
        Respuesta res = new Respuesta();
        if (!conjunto.conjuntoVacio()) {
            res.rta = conjunto.elegir();
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }

    @Override
    public boolean pertenece(int valor) {
        // complejidad O(n)
        return conjunto.pertenece(valor);
    }

    @Override
    public boolean conjuntoVacio() {
        // complejidad O(1)
        return conjunto.conjuntoVacio();
    }
}
