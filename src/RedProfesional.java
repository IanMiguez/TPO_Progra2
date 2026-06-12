public class RedProfesional {

    private Diccionario<Integer, Perfil> usuarios;

    public RedProfesional() {
        usuarios = new Diccionario<>();
    }

    public boolean registrarUsuario(Perfil perfil) {

        return usuarios.insertar(
                perfil.getId(),
                perfil
        );
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
}