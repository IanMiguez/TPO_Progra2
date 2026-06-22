package models;

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
        return "models.Postulacion{" +
                "postulante=" + postulante.getNombre() +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
