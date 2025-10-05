package implementacion;

import interfaz.ConjuntoTDA;
import interfaz.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA{
  class nodo{
        int clave;
        int valor;
    }

    private nodo[] valores;
    private int cantidad;

    @Override
    public void inicializar() {
        valores = new nodo[100];
        cantidad = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = clave2Pos(clave);
        if (pos == -1){
            nodo aux = new nodo();
            aux.clave = clave;
            aux.valor = valor;
            valores[cantidad] = aux;
            cantidad++;
        }
        else {
            valores[pos].valor = valor;
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = clave2Pos(clave);
        if (pos != -1){
            valores[pos] = valores[cantidad-1];
            cantidad--;
        }
    }

    @Override
    public int recuperar(int clave) {
        int pos = clave2Pos(clave);
        if (pos != -1){
            return valores[pos].valor;
        }
        return 0;
    }

    @Override
    public ConjuntoTDA obtenerClaves() {
        ConjuntoTDA resultado = new ConjuntoEstatico() {
        };
        resultado.inicializar();
        for (int i=0; i<cantidad; i++){
            resultado.agregar(valores[i].clave);
        }
        return resultado;
    }

    private int clave2Pos(int clave){
        int resultado = -1;
        boolean encontrado = false;
        for (int i=0; i<cantidad && !encontrado; i++){
            if (valores[i].clave == clave){
                resultado = i;
                encontrado = true;
            }
        }
        return resultado;
    }

}
