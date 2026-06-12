public class Diccionario<K, V> {

    private Lista<Entrada<K, V>> elementos;

    public Diccionario() {
        elementos = new Lista<>();
    }

    public boolean estaVacio() {
        return elementos.estaVacia();
    }

    public int tamaño() {
        return elementos.cantidadElementos();
    }

    public boolean existe(K clave) {

        for (int i = 0; i < elementos.cantidadElementos(); i++) {

            Entrada<K, V> entrada = elementos.obtener(i);

            if (entrada.getClave().equals(clave)) {
                return true;
            }
        }

        return false;
    }

    public boolean insertar(K clave, V valor) {

        if (existe(clave)) {
            return false;
        }

        elementos.agregar(new Entrada<>(clave, valor));

        return true;
    }

    public V buscar(K clave) {

        for (int i = 0; i < elementos.cantidadElementos(); i++) {

            Entrada<K, V> entrada = elementos.obtener(i);

            if (entrada.getClave().equals(clave)) {
                return entrada.getValor();
            }
        }

        return null;
    }

    public boolean modificar(K clave, V nuevoValor) {

        for (int i = 0; i < elementos.cantidadElementos(); i++) {

            Entrada<K, V> entrada = elementos.obtener(i);

            if (entrada.getClave().equals(clave)) {

                entrada.setValor(nuevoValor);

                return true;
            }
        }

        return false;
    }

    public boolean eliminar(K clave) {

        for (int i = 0; i < elementos.cantidadElementos(); i++) {

            Entrada<K, V> entrada = elementos.obtener(i);

            if (entrada.getClave().equals(clave)) {
                elementos.eliminar(i);
                return true;
            }
        }

        return false;
    }

    public void mostrar() {

        if (estaVacio()) {
            System.out.println("Diccionario vacio");
        } else {
            elementos.mostrar();
        }
    }

}