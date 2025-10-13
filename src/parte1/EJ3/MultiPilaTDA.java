package parte1.EJ3;

import tda.PilaTDA;

public interface MultiPilaTDA {

    void apilar(PilaTDA valores);      // Inserta una pila al tope
    void desapilar(PilaTDA valores);   // Desapila una pila del tope si coincide
    PilaTDA tope(int cantidad);        // Devuelve una pila con los primeros n elementos
    void inicializarPila();            // Inicializa la multipila
    boolean pilaVacia();               // Indica si la multipila está vacía
}
