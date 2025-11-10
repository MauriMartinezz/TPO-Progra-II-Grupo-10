package parte1.EJ1.uso;

import parte1.EJ1.Implementación.ConjuntoEspecial_anexo;
import parte1.EJ1.interfaz.ConjuntoEspecialTDA;

public class Uso {

    public static void main(String[] args) {
        ConjuntoEspecial_anexo ce = new ConjuntoEspecial_anexo();
        ce.inicializarConjunto();

        ConjuntoEspecialTDA.Respuesta r;

        r = ce.agregar(10);
        System.out.println("Agregar 10, error? " + r.error);

        r = ce.agregar(10);
        System.out.println("Agregar 10 otra vez, error? " + r.error);

        r = ce.elegir();
        System.out.println("Elegir, error? " + r.error + ", valor: " + r.rta);

        r = ce.sacar(5);
        System.out.println("Sacar 5, error? " + r.error);

        r = ce.sacar(10);
        System.out.println("Sacar 10, error? " + r.error);

        System.out.println("Conjunto vacío? " + ce.conjuntoVacio());
    }
}
