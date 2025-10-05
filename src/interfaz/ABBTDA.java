package interfaz;

public interface ABBTDA {
    public void inicializar();
    public int raiz();
    public ABBTDA hijoIzquierdo();
    public ABBTDA hijoDerecho();
    public void agregar(int valor);
    public void eliminar(int valor);
    public boolean arbolVacio();
}
