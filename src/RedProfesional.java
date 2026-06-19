public class RedProfesional {
    private Diccionario<Integer, Perfil> usuarios;
    private ColaCircular<Postulacion> postulaciones;
    private Grafo conexiones;
    private ArbolHabilidades arbolHabilidades;
    private Diccionario<Integer, Pila<EstadoPerfil>> historiales;
    private int proximoId;

    public RedProfesional() {
        usuarios = new Diccionario<>();
        postulaciones = new ColaCircular<>(100);
        conexiones = new Grafo();
        arbolHabilidades = new ArbolHabilidades();
        historiales = new Diccionario<>();
        proximoId = 1;
    }

    public Perfil registrarUsuario(String nombre, String profesion) {
        Perfil perfil = new Perfil(proximoId, nombre, profesion);
        usuarios.insertar(perfil.getId(), perfil);
        conexiones.agregarVertice(perfil);
        historiales.insertar(perfil.getId(), new Pila<>(50));
        proximoId++;
        return perfil;
    }

    public boolean actualizarNombre(int id, String nuevoNombre) {
        Perfil perfil = usuarios.buscar(id);
        if (perfil == null) {
            return false;
        }
        guardarEstado(id);
        perfil.setNombre(nuevoNombre);
        return true;
    }

    public boolean actualizarProfesion(int id, String nuevaProfesion) {
        Perfil perfil = usuarios.buscar(id);
        if (perfil == null) {
            return false;
        }
        guardarEstado(id);
        perfil.setProfesion(nuevaProfesion);
        return true;
    }

    private void guardarEstado(int id) {
        Perfil perfil = usuarios.buscar(id);
        Pila<EstadoPerfil> historial = historiales.buscar(id);
        if (perfil != null && historial != null) {
            historial.apilar(new EstadoPerfil(perfil.getNombre(), perfil.getProfesion()));
        }
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

    public boolean agregarHabilidad(String categoria, String habilidad) {
        return arbolHabilidades.agregarEnCategoria(categoria, habilidad);
    }

    public boolean existeHabilidad(String nombre) {
        return arbolHabilidades.buscar(nombre) != null;
    }

    public void mostrarHabilidades() {
        arbolHabilidades.mostrar();
    }

    public boolean asignarHabilidad(int idPerfil, String habilidad) {
        Perfil perfil = usuarios.buscar(idPerfil);
        if (perfil == null) {
            return false;
        }
        if (arbolHabilidades.buscar(habilidad) == null) {
            return false;
        }
        return perfil.agregarHabilidad(habilidad);
    }

    public Lista<Perfil> buscarPorCategoria(String categoria) {
        Lista<Perfil> resultado = new Lista<>();
        Lista<String> habilidadesBuscadas = arbolHabilidades.obtenerHabilidadesDesde(categoria);
        if (habilidadesBuscadas.estaVacia()) {
            return resultado;
        }

        Lista<Perfil> todos = usuarios.obtenerValores();
        for (int i = 0; i < todos.cantidadElementos(); i++) {
            Perfil perfil = todos.obtener(i);
            for (int j = 0; j < habilidadesBuscadas.cantidadElementos(); j++) {
                if (perfil.tieneHabilidad(habilidadesBuscadas.obtener(j))) {
                    resultado.agregar(perfil);
                    break;
                }
            }
        }
        return resultado;
    }

    public Lista<Perfil> buscarPorEspecialidad(String habilidad) {
        Lista<Perfil> resultado = new Lista<>();
        Lista<Perfil> todos = usuarios.obtenerValores();
        for (int i = 0; i < todos.cantidadElementos(); i++) {
            Perfil perfil = todos.obtener(i);
            if (perfil.tieneHabilidad(habilidad)) {
                resultado.agregar(perfil);
            }
        }
        return resultado;
    }
}