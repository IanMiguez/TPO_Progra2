package TDAs;

public class Lista<T> {

    private Nodo<T> inicio;
    private int cantidad;

    public Lista() {
        inicio = null;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int cantidadElementos() {
        return cantidad;
    }

    public void agregar(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            inicio = nuevo;
        } else {

            Nodo<T> actual = inicio;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }

        cantidad++;
    }

    public boolean buscar(T dato) {

        Nodo<T> actual = inicio;

        while (actual != null) {

            if (actual.getDato().equals(dato)) {
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public T obtener(int posicion) {

        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }

        Nodo<T> actual = inicio;

        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    public void mostrar() {

        Nodo<T> actual = inicio;

        while (actual != null) {

            System.out.println(actual.getDato());

            actual = actual.getSiguiente();
        }
    }
    public void reemplazar(int posicion, T dato) {

        if (posicion < 0 || posicion >= cantidad) {
            return;
        }

        Nodo<T> actual = inicio;

        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(dato);
    }

    public void eliminar(int posicion) {

        if (posicion < 0 || posicion >= cantidad) {
            return;
        }

        if (posicion == 0) {
            inicio = inicio.getSiguiente();
        } else {

            Nodo<T> actual = inicio;

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }

        cantidad--;
    }
}