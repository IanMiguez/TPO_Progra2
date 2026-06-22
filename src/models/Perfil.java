package models;

import TDAs.Lista;

public class Perfil {

    private int id;
    private String nombre;
    private String profesion;
    private Lista<String> habilidades;

    public Perfil(int id, String nombre, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
        this.habilidades = new Lista<>();
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

    public Lista<String> getHabilidades() {
        return habilidades;
    }

    public boolean tieneHabilidad(String habilidad) {
        for (int i = 0; i < habilidades.cantidadElementos(); i++) {
            if (habilidades.obtener(i).equalsIgnoreCase(habilidad)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarHabilidad(String habilidad) {
        if (tieneHabilidad(habilidad)) {
            return false;
        }
        habilidades.agregar(habilidad);
        return true;
    }

    private String habilidadesComoTexto() {
        String texto = "[";
        for (int i = 0; i < habilidades.cantidadElementos(); i++) {
            texto = texto + habilidades.obtener(i);
            if (i < habilidades.cantidadElementos() - 1) {
                texto = texto + ", ";
            }
        }
        return texto + "]";
    }

    @Override
    public String toString() {
        return "models.Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", habilidades=" + habilidadesComoTexto() +
                '}';
    }
}