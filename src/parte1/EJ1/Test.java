package parte1.EJ1;

public class Test {
    public static void main(String[] args) {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecialTDA();

        System.out.println(conjunto.agregar(5));
        System.out.println(conjunto.agregar(10));
        System.out.println(conjunto.contiene(5));
        System.out.println(conjunto.eliminar(5));
        System.out.println(conjunto.contiene(5));
    }
}
