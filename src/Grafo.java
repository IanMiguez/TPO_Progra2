public class Grafo {

    private Lista<Vertice> vertices;

    public Grafo() {
        this.vertices = new Lista<>();
    }

    public boolean agregarVertice(Perfil perfil) {
        if (buscarVertice(perfil.getId()) != null) {
            return false;
        }
        vertices.agregar(new Vertice(perfil));
        return true;
    }

    public boolean agregarArista(int id1, int id2) {
        Vertice v1 = buscarVertice(id1);
        Vertice v2 = buscarVertice(id2);

        if (v1 == null || v2 == null || v1 == v2) {
            return false;
        }

        if (!v1.getAdyacentes().buscar(v2)) {
            v1.getAdyacentes().agregar(v2);
        }
        if (!v2.getAdyacentes().buscar(v1)) {
            v2.getAdyacentes().agregar(v1);
        }
        return true;
    }

    public int grado(int id) {
        Vertice v = buscarVertice(id);
        if (v == null) {
            return -1;
        }
        return v.getAdyacentes().cantidadElementos();
    }

    public boolean sonContactos(int id1, int id2) {
        Vertice v1 = buscarVertice(id1);
        Vertice v2 = buscarVertice(id2);
        if (v1 == null || v2 == null) {
            return false;
        }
        return v1.getAdyacentes().buscar(v2);
    }

    public int gradoDeSeparacion(int idOrigen, int idDestino) {
        Vertice origen = buscarVertice(idOrigen);
        Vertice destino = buscarVertice(idDestino);

        if (origen == null || destino == null) {
            return -1;
        }
        if (origen == destino) {
            return 0;
        }

        int n = vertices.cantidadElementos();
        ColaCircular<Vertice> cola = new ColaCircular<>(n);
        ColaCircular<Integer> distancias = new ColaCircular<>(n);
        Lista<Vertice> visitados = new Lista<>();

        cola.encolar(origen);
        distancias.encolar(0);
        visitados.agregar(origen);

        while (!cola.estaVacia()) {
            Vertice actual = cola.desencolar();
            int dist = distancias.desencolar();

            Lista<Vertice> vecinos = actual.getAdyacentes();
            for (int i = 0; i < vecinos.cantidadElementos(); i++) {
                Vertice vecino = vecinos.obtener(i);

                if (vecino == destino) {
                    return dist + 1;
                }
                if (!visitados.buscar(vecino)) {
                    visitados.agregar(vecino);
                    cola.encolar(vecino);
                    distancias.encolar(dist + 1);
                }
            }
        }
        return -1;
    }

    public Lista<Perfil> contactosRecomendados(int id) {
        Lista<Perfil> recomendados = new Lista<>();
        Vertice yo = buscarVertice(id);
        if (yo == null) {
            return recomendados;
        }

        Lista<Vertice> misContactos = yo.getAdyacentes();
        for (int i = 0; i < misContactos.cantidadElementos(); i++) {
            Vertice contacto = misContactos.obtener(i);

            Lista<Vertice> contactosDelContacto = contacto.getAdyacentes();
            for (int j = 0; j < contactosDelContacto.cantidadElementos(); j++) {
                Vertice candidato = contactosDelContacto.obtener(j);

                boolean noSoyYo = candidato != yo;
                boolean noEsContactoMio = !misContactos.buscar(candidato);
                boolean noEstaYaRecomendado = !recomendados.buscar(candidato.getPerfil());

                if (noSoyYo && noEsContactoMio && noEstaYaRecomendado) {
                    recomendados.agregar(candidato.getPerfil());
                }
            }
        }
        return recomendados;
    }

    public void mostrar() {
        for (int i = 0; i < vertices.cantidadElementos(); i++) {
            Vertice v = vertices.obtener(i);
            Lista<Vertice> vecinos = v.getAdyacentes();

            String linea = v.getPerfil().getNombre() + " -> ";
            for (int j = 0; j < vecinos.cantidadElementos(); j++) {
                linea = linea + vecinos.obtener(j).getPerfil().getNombre();
                if (j < vecinos.cantidadElementos() - 1) {
                    linea = linea + ", ";
                }
            }
            System.out.println(linea);
        }
    }

    private Vertice buscarVertice(int id) {
        for (int i = 0; i < vertices.cantidadElementos(); i++) {
            Vertice v = vertices.obtener(i);
            if (v.getPerfil().getId() == id) {
                return v;
            }
        }
        return null;
    }
}
