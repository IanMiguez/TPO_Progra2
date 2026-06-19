public class NodoHabilidad {
    private String nombre;
    private Lista<NodoHabilidad> hijos;

    public NodoHabilidad(String nombre) {
        this.nombre = nombre;
        this.hijos = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Lista<NodoHabilidad> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoHabilidad hijo) {
        hijos.agregar(hijo);
    }

    public boolean tieneHijos() {
        return !hijos.estaVacia();
    }

    @Override
    public String toString() {
        return nombre;
    }
}