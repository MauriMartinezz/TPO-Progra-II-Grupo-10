package parte1.EJ1;

public class Respuesta {
    private boolean correcto;
    private int valor;

    public Respuesta(boolean correcto, int valor) {
        this.correcto = correcto;
        this.valor = valor;
    }

    public boolean esCorrecto() {
        return correcto;
    }

    public int getValor() {
        return valor;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Respuesta[correcto=" + correcto + ", valor=" + valor + "]";
    }
}
