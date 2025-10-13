package parte1.EJ1;

import imple.Conjunto; // suponiendo que la librería se llama lib y contiene ConjuntoTDA

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private Conjunto conjunto;

    @Override
    public void inicializarConjunto() {
        conjunto = new Conjunto();
        conjunto.inicializarConjunto();
    }

    @Override
    public Respuesta agregar(int valor) {
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
        return conjunto.pertenece(valor);
    }

    @Override
    public boolean conjuntoVacio() {
        return conjunto.conjuntoVacio();
    }
}
