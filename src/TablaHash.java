public class TablaHash {

    private static class NodoHash {
        int clave;
        Perfil valor;
        NodoHash siguiente;

        NodoHash(int clave, Perfil valor) {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private NodoHash[] casilleros;
    private int capacidad;
    private int cantidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.casilleros = new NodoHash[capacidad];
        this.cantidad = 0;
    }

    private int hash(int clave) {
        return Math.abs(clave) % capacidad;
    }

    public void insertar(Perfil perfil) {
        int indice = hash(perfil.getId());
        NodoHash actual = casilleros[indice];

        while (actual != null) {
            if (actual.clave == perfil.getId()) {
                System.out.println("Ya existe un perfil con ID " + perfil.getId() + ". Se actualiza el perfil existente.");
                actual.valor = perfil;
                return;
            }
            actual = actual.siguiente;
        }

        NodoHash nuevo = new NodoHash(perfil.getId(), perfil);
        nuevo.siguiente = casilleros[indice];
        casilleros[indice] = nuevo;
        cantidad++;
    }

    public Perfil buscar(int id) {
        int indice = hash(id);
        NodoHash actual = casilleros[indice];

        while (actual != null) {
            if (actual.clave == id) return actual.valor;
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminar(int id) {
        int indice = hash(id);
        NodoHash actual = casilleros[indice];
        NodoHash anterior = null;

        while (actual != null) {
            if (actual.clave == id) {
                if (anterior == null) {
                    casilleros[indice] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                cantidad--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean contiene(int id) {
        return buscar(id) != null;
    }

    public int cantidad() { return cantidad; }

    public boolean estaVacia() { return cantidad == 0; }

    public void mostrarTabla() {
        System.out.println("=== Contenido de la Tabla Hash ===");
        for (int i = 0; i < capacidad; i++) {
            System.out.print("Casillero " + i + ": ");
            NodoHash actual = casilleros[i];
            if (actual == null) {
                System.out.println("(vacio)");
            } else {
                while (actual != null) {
                    System.out.print(actual.valor + " ");
                    actual = actual.siguiente;
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
