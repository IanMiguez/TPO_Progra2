public class RedProfesional {
    private static final int MAX_POSTULACIONES = 100;
    private static final int MAX_HISTORIAL = 50;

    private Diccionario<Integer, Perfil> usuarios;
    private ColaCircular<Postulacion> postulaciones;
    private Grafo conexiones;
    private ArbolHabilidades arbolHabilidades;
    private Diccionario<Integer, Pila<EstadoPerfil>> historiales;
    private int proximoId;

    public RedProfesional() {
        usuarios = new Diccionario<>();
        postulaciones = new ColaCircular<>(MAX_POSTULACIONES);
        conexiones = new Grafo();
        arbolHabilidades = new ArbolHabilidades();
        historiales = new Diccionario<>();
        proximoId = 1;
    }

    public Perfil registrarUsuario(String nombre, String profesion) {
        Perfil perfil = new Perfil(proximoId, nombre, profesion);
        usuarios.insertar(perfil.getId(), perfil);
        conexiones.agregarVertice(perfil);
        historiales.insertar(perfil.getId(), new Pila<>(MAX_HISTORIAL));
        proximoId++;
        return perfil;
    }

    public boolean actualizarPerfil(int id, String nuevoNombre, String nuevaProfesion) {
        Perfil perfil = usuarios.buscar(id);
        if (perfil == null) {
            return false;
        }
        Pila<EstadoPerfil> historial = historiales.buscar(id);
        if (historial != null) {
            historial.apilar(new EstadoPerfil(perfil.getNombre(), perfil.getProfesion()));
        }
        perfil.setNombre(nuevoNombre);
        perfil.setProfesion(nuevaProfesion);
        return true;
    }

    public boolean deshacerCambio(int id) {
        Perfil perfil = usuarios.buscar(id);
        if (perfil == null) {
            return false;
        }
        Pila<EstadoPerfil> historial = historiales.buscar(id);
        if (historial == null || historial.estaVacia()) {
            return false;
        }
        EstadoPerfil anterior = historial.desapilar();
        perfil.setNombre(anterior.getNombre());
        perfil.setProfesion(anterior.getProfesion());
        return true;
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

    public boolean sonContactos(int id1, int id2) {
        return conexiones.sonContactos(id1, id2);
    }

    public void mostrarConexiones() {
        conexiones.mostrar();
    }

    public boolean postular(int idPerfil, String puesto) {
        Perfil perfil = usuarios.buscar(idPerfil);
        if (perfil == null) {
            return false;
        }
        return postulaciones.encolar(new Postulacion(perfil, puesto));
    }

    public boolean agregarHabilidad(String habilidadPadre, String nuevaHabilidad) {
        return arbolHabilidades.agregarHabilidad(habilidadPadre, nuevaHabilidad);
    }

    public boolean existeHabilidad(String nombre) {
        return arbolHabilidades.buscar(nombre) != null;
    }

    public void mostrarHabilidades() {
        arbolHabilidades.mostrar();
    }
}