public class Pila<T> {
    private Object[] datos;
    private int tope;
    private int max;

    public Pila(int max) {
        this.max = max;
        this.datos = new Object[max];
        this.tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == max - 1;
    }

    public void apilar(T elemento) {
        if (estaLlena()) {
            System.out.println("Error: pila llena");
        } else {
            tope = tope + 1;
            datos[tope] = elemento;
        }
    }

    public T desapilar() {
        if (estaVacia()) {
            System.out.println("Error: pila vacía");
            return null;
        } else {
            T x = (T) datos[tope];
            tope = tope - 1;
            return x;
        }
    }

    public T verTope() {
        if (estaVacia()) {
            System.out.println("Error: pila vacía");
            return null;
        } else {
            return (T) datos[tope];
        }
    }

    public int tamaño() {
        return tope + 1;
    }
}
