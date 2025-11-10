//implementación completa de Conjunto

/* ### Ejercicio 1
Se define un nuevo TDA denominado ConjuntoEspecialTDA basado en ConjuntoTDA,
con la particularidad de permitir determinar si las operaciones se realizan correctamente,
o no. Algunos de sus métodos devuelven el objeto Respuesta, que contiene dos elementos:
un booleano que determina la correctitud de ejecución y un entero que informa lo solicitado
por el método en sí, si el método lo requiere y su ejecución fue satisfactoria. Su especificación
se muestra en el anexo, leer detenidamente los comentarios de cada método.
 */
package parte1.EJ1.Implementación;
import parte1.EJ1.interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {
    private int[] a;
    private int cant;

    public void inicializarConjunto() {
        this.a = new int[100];
        this.cant = 0;
    }

    public Respuesta agregar(int x) {
        Respuesta res = new Respuesta();
        if (!this.pertenece(x)) {
            this.a[this.cant] = x;
            ++this.cant;
            res.error = false;
        } else {
            res.error = true;
        }
        return res;

    }

    public boolean conjuntoVacio() {
        return this.cant == 0;
    }

    public Respuesta elegir() {
        Respuesta res = new Respuesta();
        if (!this.conjuntoVacio()) {
            int max = this.cant - 1;
            int min = 0;
            int pos = (int) (Math.random() * (double) (max - min + 1) + (double) min);
            res.rta = this.a[pos];
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }

    public boolean pertenece(int x) {
        int i;
        for (i = 0; i < this.cant && this.a[i] != x; ++i) {
        }
        return i < this.cant;
    }

    public Respuesta sacar(int x) {
        Respuesta res = new Respuesta();
        if (this.pertenece(x)) {
            int i;
            for (i = 0; i < this.cant && this.a[i] != x; ++i) {
            }
            this.a[i] = this.a[this.cant - 1];
            --this.cant;
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }
}