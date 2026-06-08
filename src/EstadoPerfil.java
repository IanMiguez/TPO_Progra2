public class EstadoPerfil {

    private String nombre;
    private String profesion;

    public EstadoPerfil(String nombre, String profesion) {
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }
}