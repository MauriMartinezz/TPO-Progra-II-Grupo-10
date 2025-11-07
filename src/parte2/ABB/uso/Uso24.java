package uso;

import implementacion.*;
import interfaz.*;

public class Uso24 {

    public static void main(String[] args) {
	        ABBTDA arbol = new ABB();
	        arbol.inicializarArbol();
	        
	        // Insertando elementos en el ABB 
	        arbol.agregarElem(50);
	        arbol.agregarElem(30);
	        arbol.agregarElem(70);
	        arbol.agregarElem(20);
	        arbol.agregarElem(40);
	        arbol.agregarElem(60);
	        arbol.agregarElem(80);  
	        
	        
	        
	     // Imprimir el árbol en formato jerárquico
	        System.out.println("Árbol en formato jerárquico:");
	        ImprimirArbol.imprimirJerarquia(arbol);
	        System.out.println();
	        
	        // Imprimir el árbol en inorden
	        System.out.print("Árbol en inorden: ");
	        inOrden(arbol);
	        System.out.println();
	        
	        // Elemento a buscar
	        int elemento = 40;
	        
	        
	        
	        // Buscar con método recursivo
	        boolean encontrado = buscarElemento(arbol, 40);
	        System.out.println("Elemento " + elemento + " encontrado (recursivo): " + encontrado);
	        
	        // Determinar si un elemento es hoja
	        boolean esHoja = esHoja(arbol, elemento);
	        System.out.println("Elemento " + elemento + " es hoja: " + esHoja);
	        
	        // Calcular la cantidad de elementos en el árbol
	        int cantidadElementos = contarElementos(arbol);
	        System.out.println("La cantidad de elementos en el árbol es: " + cantidadElementos);
	        
	     // Calcular la altura del árbol
		    int altura = calcularAltura(arbol);
		    System.out.println("La altura del árbol es: " + altura);
		    
		    
		 // Crear un conjunto con los elementos mayores que k
		    int k = 40;
		    ConjuntoTDA conjuntoMayores = elementosMayoresQueK(arbol, k);
		    System.out.println("Elementos mayores que " + k + ":");
		    while (!conjuntoMayores.conjuntoVacio()) {
		        int num = conjuntoMayores.elegir();
		        System.out.print(num + " ");
		        conjuntoMayores.sacar(num);
		    }
		    System.out.println();
		    
	    }

	    public static boolean buscarElemento(ABBTDA arbol, int elemento) {
	        if (arbol.arbolVacio()) {
	            return false;
	        }
	        if (arbol.raiz() == elemento) {
	            return true;
	        } else if (elemento < arbol.raiz()) {
	            return buscarElemento(arbol.hijoIzq(), elemento);
	        } else {
	            return buscarElemento(arbol.hijoDer(), elemento);
	        }
	    }
	    
	    public static void inOrden(ABBTDA arbol) {
	        if (!arbol.arbolVacio()) {
	        	inOrden(arbol.hijoIzq());
	            System.out.print(arbol.raiz() + " ");
	            inOrden(arbol.hijoDer());
	        }
	    }
	    
	    public static boolean esHoja(ABBTDA arbol, int elemento) {
	        if (arbol.arbolVacio()) {
	            return false;
	        }
	        if (arbol.raiz() == elemento) {
	            return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();
	        } else if (elemento < arbol.raiz()) {
	            return esHoja(arbol.hijoIzq(), elemento);
	        } else {
	            return esHoja(arbol.hijoDer(), elemento);
	        }
	    }
	    
	       
	    public static int contarElementos(ABBTDA arbol) {
	        if (arbol.arbolVacio()) {
	            return 0;
	        } else {
	            return 1 + contarElementos(arbol.hijoIzq()) + contarElementos(arbol.hijoDer());
	        }
	    }
	    
	    public static int calcularAltura(ABBTDA arbol) {
	        if (arbol.arbolVacio()) {
	            return -1; // Altura de un árbol vacío
	        } else {
	            int alturaIzq = calcularAltura(arbol.hijoIzq());
	            int alturaDer = calcularAltura(arbol.hijoDer());
	            return 1 + Math.max(alturaIzq, alturaDer);
	        }
	    }
	    
	    
	    public static ConjuntoTDA elementosMayoresQueK(ABBTDA arbol, int k) {
	        ConjuntoTDA conjunto = new Conjunto();
	        conjunto.inicializarConjunto();
	        agregarMayoresQueK(arbol, k, conjunto);
	        return conjunto;
	    }

	    private static void agregarMayoresQueK(ABBTDA arbol, int k, ConjuntoTDA conjunto) {
	        if (!arbol.arbolVacio()) {
	            if (arbol.raiz() > k) {
	                conjunto.agregar(arbol.raiz());
	            }
	            agregarMayoresQueK(arbol.hijoIzq(), k, conjunto);
	            agregarMayoresQueK(arbol.hijoDer(), k, conjunto);
	        }
	    }
}
