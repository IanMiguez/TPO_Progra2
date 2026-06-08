public class Perfil {

    private int id;
    private String nombre;
    private String profesion;

    public Perfil(int id, String nombre, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}