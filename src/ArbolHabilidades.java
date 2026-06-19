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

    public boolean agregarHabilidad(
            String nombrePadre,
            String nuevaHabilidad) {
        NodoHabilidad padre = buscar(nombrePadre);
        if (padre == null) {
            return false;
        }
        padre.agregarHijo(
                new NodoHabilidad(nuevaHabilidad)
        );
        return true;
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