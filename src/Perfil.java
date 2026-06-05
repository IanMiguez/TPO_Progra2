public class Perfil {

    private int id;
    private String nombre;
    private String puesto;
    private String empresa;

    public Perfil(int id, String nombre, String puesto, String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.empresa = empresa;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public String getEmpresa() { return empresa; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    @Override
    public String toString() {
        return "[ID: " + id
                + " | Nombre: " + nombre
                + " | Puesto: " + puesto
                + " | Empresa: " + empresa + "]";
    }
}
