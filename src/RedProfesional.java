public class RedProfesional {
    private Diccionario<Integer, Perfil> usuarios;
    private ColaCircular<Postulacion> postulaciones;
    private Grafo conexiones;
    private ArbolHabilidades arbolHabilidades;

    public RedProfesional() {
        usuarios = new Diccionario<>();
        postulaciones = new ColaCircular<>(100);
        conexiones = new Grafo();
        arbolHabilidades = new ArbolHabilidades();
    }

    public boolean registrarUsuario(Perfil perfil) {
        boolean agregado = usuarios.insertar(perfil.getId(), perfil);
        if (agregado) {
            conexiones.agregarVertice(perfil);
        }
        return agregado;
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

    public boolean conectarUsuarios(int id1, int id2) {
        return conexiones.agregarArista(id1, id2);
    }

    public int gradoDeSeparacion(int id1, int id2) {
        return conexiones.gradoDeSeparacion(id1, id2);
    }

    public Lista<Perfil> contactosRecomendados(int id) {
        return conexiones.contactosRecomendados(id);
    }
}