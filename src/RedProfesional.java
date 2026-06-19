public class RedProfesional {
    private Diccionario<Integer, Perfil> usuarios;
    private ColaCircular<Postulacion> postulaciones;

    public RedProfesional() {
        usuarios = new Diccionario<>();
        postulaciones = new ColaCircular<>(100);
    }

    public boolean registrarUsuario(Perfil perfil) {
        return usuarios.insertar(perfil.getId(), perfil);
    }

    public Perfil buscarUsuario(int id) {
        return usuarios.buscar(id);
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.eliminar(id);
    }

    public void mostrarUsuarios() {
        usuarios.mostrar();
    }

    public boolean agregarPostulacion(Postulacion postulacion) {
        return postulaciones.encolar(postulacion);
    }

    public Postulacion procesarPostulacion() {
        return postulaciones.desencolar();
    }

    public Postulacion verSiguientePostulacion() {
        return postulaciones.verFrente();
    }

    public int cantidadPostulaciones() {
        return postulaciones.tamaño();
    }
}