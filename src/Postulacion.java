// Representa la postulacion de un perfil a un puesto de trabajo.
// Se gestiona por orden de llegada (FIFO) usando la ColaCircular.
public class Postulacion {

    private Perfil postulante;
    private String puesto;

    public Postulacion(Perfil postulante, String puesto) {
        this.postulante = postulante;
        this.puesto = puesto;
    }

    public Perfil getPostulante() {
        return postulante;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Postulacion{" +
                "postulante=" + postulante.getNombre() +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
