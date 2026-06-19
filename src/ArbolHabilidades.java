public class ArbolHabilidades {
    private NodoHabilidad raiz;

    public ArbolHabilidades() {
        raiz = new NodoHabilidad("Habilidades");
    }

    public NodoHabilidad getRaiz() {
        return raiz;
    }

    public NodoHabilidad buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private NodoHabilidad buscarRecursivo(NodoHabilidad actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (actual.getNombre().equalsIgnoreCase(nombre)) {
            return actual;
        }
        Lista<NodoHabilidad> hijos = actual.getHijos();
        for (int i = 0; i < hijos.cantidadElementos(); i++) {
            NodoHabilidad encontrado =
                    buscarRecursivo(hijos.obtener(i), nombre);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    public boolean agregarEnCategoria(String categoria, String habilidad) {
        if (buscar(habilidad) != null) {
            return false;
        }
        NodoHabilidad nodoCategoria = buscar(categoria);
        if (nodoCategoria == null) {
            nodoCategoria = new NodoHabilidad(categoria);
            raiz.agregarHijo(nodoCategoria);
        }
        nodoCategoria.agregarHijo(new NodoHabilidad(habilidad));
        return true;
    }

    public Lista<String> obtenerHabilidadesDesde(String nombre) {
        Lista<String> resultado = new Lista<>();
        NodoHabilidad nodo = buscar(nombre);
        if (nodo != null) {
            recolectar(nodo, resultado);
        }
        return resultado;
    }

    private void recolectar(NodoHabilidad actual, Lista<String> acumulador) {
        acumulador.agregar(actual.getNombre());
        Lista<NodoHabilidad> hijos = actual.getHijos();
        for (int i = 0; i < hijos.cantidadElementos(); i++) {
            recolectar(hijos.obtener(i), acumulador);
        }
    }

    public void mostrar() {
        mostrarRecursivo(raiz, 0);
    }

    private void mostrarRecursivo(
            NodoHabilidad actual,
            int nivel) {

        if (actual == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }

        System.out.println(actual.getNombre());

        Lista<NodoHabilidad> hijos =
                actual.getHijos();

        for (int i = 0; i < hijos.cantidadElementos(); i++) {

            mostrarRecursivo(
                    hijos.obtener(i),
                    nivel + 1
            );
        }
    }
}