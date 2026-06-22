package TDAs;

public class ColaCircular<T> {

    private Object[] datos;
    private int frente;
    private int fin;
    private int cantidad;
    private int max;


    public ColaCircular(int max) {
        this.max = max;
        this.datos = new Object[max];
        this.frente = -1;
        this.fin = -1;
        this.cantidad = 0;
    }


    public boolean estaVacia() {
        return cantidad == 0;
    }


    public boolean estaLlena() {
        return cantidad == max;
    }


    public boolean encolar(T elemento) {
        if (estaLlena()) {
            System.out.println("Error: cola llena");
            return false;
        }
        if (estaVacia()) {
            frente = 0;
        }
        fin = (fin + 1) % max;
        datos[fin] = elemento;
        cantidad = cantidad + 1;
        return true;
    }

    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Error: cola vacía");
            return null;
        }
        T eliminado = (T) datos[frente];
        if (frente == fin) {
            frente = -1;
            fin = -1;
            cantidad = 0;
        } else {
            frente = (frente + 1) % max;
            cantidad = cantidad - 1;
        }
        return eliminado;
    }

    public T verFrente() {
        if (estaVacia()) {
            System.out.println("Error: cola vacía");
            return null;
        }
        return (T) datos[frente];
    }


    public int tamaño() {
        return cantidad;
    }
}
