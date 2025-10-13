package parte1.EJ5;

import tda.ColaPrioridadTDA;
import tda.DiccionarioSimpleTDA;
import imple.ColaPrioridad;
import imple.Conjunto;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private ColaPrioridadTDA cola;

    @Override
    public void inicializarDiccionario() {
        cola = new ColaPrioridad();
        cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
        // Si ya existe, eliminamos la clave anterior antes de agregar
        eliminar(clave);
        cola.acolarPrioridad(valor, clave); // valor = elemento, prioridad = clave
    }

    @Override
    public void eliminar(int clave) {
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int val = cola.primero();
            int pri = cola.prioridad();
            cola.desacolar();
            if (pri != clave) {
                aux.acolarPrioridad(val, pri);
            }
        }

        // Restauramos
        while (!aux.colaVacia()) {
            int val = aux.primero();
            int pri = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(val, pri);
        }
    }

    @Override
    public int recuperar(int clave) {
        int resultado = 0;
        boolean encontrado = false;

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int val = cola.primero();
            int pri = cola.prioridad();
            cola.desacolar();

            if (pri == clave) {
                resultado = val;
                encontrado = true;
            }
            aux.acolarPrioridad(val, pri);
        }

        // Restauramos
        while (!aux.colaVacia()) {
            int val = aux.primero();
            int pri = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(val, pri);
        }

        if (!encontrado)
            throw new RuntimeException("Clave no encontrada: " + clave);

        return resultado;
    }

    @Override
    public Conjunto claves() {
        Conjunto conjunto = new Conjunto();
        conjunto.inicializarConjunto();

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int val = cola.primero();
            int pri = cola.prioridad();
            cola.desacolar();
            conjunto.agregar(pri);
            aux.acolarPrioridad(val, pri);
        }

        // Restauramos
        while (!aux.colaVacia()) {
            int val = aux.primero();
            int pri = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(val, pri);
        }

        return conjunto;
    }
}
