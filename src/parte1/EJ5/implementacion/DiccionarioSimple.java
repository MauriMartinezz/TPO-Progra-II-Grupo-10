package parte1.EJ5.implementacion;

import tda.ColaPrioridadTDA;
import tda.DiccionarioSimpleTDA;
import imple.ColaPrioridad;
import imple.Conjunto;

/*
 ### Ejercicio 5
Se busca implementar un DiccionarioSimpleTDA usando únicamente una 
ColaPrioridadTDA. Aclaración: se mantiene la interfaz de DiccionarioSimpleTDA; en la 
implementación en vez de utilizar un arreglo de enteros (estructura estática) o una lista 
enlazada (estructura dinámica), sólo puede usarse una ColaPrioridadTDA. 
 */
public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private ColaPrioridadTDA cola;

    @Override
    public void inicializarDiccionario() {
        // complejidad O(1)
        cola = new ColaPrioridad();
        cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
        // complejidad O(n)
        eliminar(clave);
        // clave no existe, seguimos
        cola.acolarPrioridad(valor, clave); // valor = elemento, prioridad = clave
    }

    @Override
    public void eliminar(int clave) {
        // complejidad O(n)
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
        // complejidad O(n)
        int resultado = 0;
        boolean encontrado = false;

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) { //recorremos la cola
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
            return 0; //o Throw new Exception("Clave no encontrada");

        return resultado;
    }

    @Override
    public Conjunto claves() {
        // complejidad O(n)
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
