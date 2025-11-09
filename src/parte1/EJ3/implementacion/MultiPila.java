package parte1.EJ3.implementacion;

import tda.PilaTDA;
import imple.Pila;
import parte1.EJ3.interfaz.MultiPilaTDA;

/*
 ### Ejercicio 3
Se define un nuevo TDA denominado MultiPilaTDA basado en PilaTDA, con la 
particularidad de recibir una PilaTDA por parámetro al apilar (la misma debe apilarse a 
continuación de la multipila), y otra al desapilar (la misma debe chequear que los valores 
tope de la multipila coincidan para desapilar, sino no debe hacer nada). Tanto en el método 
apilar como en el método desapilar, ambas pilas vienen inicializadas y contienen cualquier 
cantidad de elementos (incluso cero). El método tope devuelve una PilaTDA con los 
primeros elementos de la multipila, se recibe por parámetro un número mayor o igual que 
cero, que representa la cantidad de ellos (de recibir un número superior a la cantidad de 
elementos de la multipila, debe devolver todos). Se solicita realizar la presente 
implementación con el TDA ya visto PilaTDA, o en su defecto con estructuras dinámicas (no 
puede realizarse la implementación con estructuras estáticas). Su especificación se muestra 
en el anexo, leer detenidamente los comentarios de cada método.
 */

public class MultiPila implements MultiPilaTDA {
    private class Nodo { // la célula de la estructura
        int info; // el valor almacenado
        Nodo sig; // la referencia al siguiente nodo
    }

    private Nodo primero; // la referencia a la estructura

    public void inicializarPila() {
        primero = null;
    }

    public void apilar(PilaTDA x) { // el nuevo elemento se agrega al inicio
        while (!x.pilaVacia()) {
            Nodo nuevo = new Nodo();
            nuevo.info = x.tope();
            x.desapilar();
            nuevo.sig = primero;
            primero = nuevo;
        }
    }

    public void desapilar(PilaTDA valores) {
        // desapilar (la misma debe chequear que los valores tope de la multipila coincidan para desapilar, sino no debe hacer nada)
        Nodo actual = primero;

        // chequear si la pila ingresada por parametro coincide con los elementos tope de la multipila
        PilaTDA aux = utils.PilaUtils.copiarPila(valores);
        boolean coincide = true;
        while (!valores.pilaVacia() && actual != null) {
            aux.apilar(valores.tope());
            valores.desapilar();
            if (actual.info != aux.tope()) {
                coincide = false;
            } else {
                actual = actual.sig;
            }
        }

        if (coincide){
            while (!valores.pilaVacia() && actual != null) { // mientras coincida y queden elementos en valores y en la multipila
                if (actual.info != valores.tope()) {
                    coincide = false;
                } else {
                    valores.desapilar();
                    actual = actual.sig;
                }
            }
        }
    }

    public boolean pilaVacia() {
        return (primero == null);
    }

    public PilaTDA tope(int cantidad) {
        PilaTDA resultado = new Pila(); // pila auxiliar para almacenar el resultado
        resultado.inicializarPila();

        Nodo actual = primero;
        int contador = 0;

        while (actual != null && contador < cantidad) {
            resultado.apilar(actual.info);
            actual = actual.sig; // avanza en el nodo
            contador++;
        }

        return resultado;

        // Invertir la pila para mantener el orden original (depende de la interpretación)
        // PilaTDA invertida = new Pila();
        // invertida.inicializarPila();
        // while (!resultado.pilaVacia()) {
        //     invertida.apilar(resultado.tope());
        //     resultado.desapilar();
        // }

        // return invertida;
    }
}