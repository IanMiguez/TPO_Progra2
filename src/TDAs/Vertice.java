package TDAs;

public class Vertice {

    private Perfil perfil;
    private Lista<Vertice> adyacentes;

    public Vertice(Perfil perfil) {
        this.perfil = perfil;
        this.adyacentes = new Lista<>();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Lista<Vertice> getAdyacentes() {
        return adyacentes;
    }
}