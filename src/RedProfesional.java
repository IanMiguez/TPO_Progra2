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
}