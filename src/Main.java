// pruebas cola y pila
public class Main {

    public static void main(String[] args) {


        System.out.println("===== COLA CIRCULAR (FIFO) =====");
        ColaCircular<String> postulaciones = new ColaCircular<>(3);

        postulaciones.encolar("Ana");
        postulaciones.encolar("Bruno");
        postulaciones.encolar("Carla");
        postulaciones.encolar("Diego");

        System.out.println("Frente (sin sacar): " + postulaciones.verFrente());
        System.out.println("Cantidad: " + postulaciones.tamaño());

        System.out.println("Atiende: " + postulaciones.desencolar());
        System.out.println("Atiende: " + postulaciones.desencolar());


        postulaciones.encolar("Diego");
        postulaciones.encolar("Eva");

        System.out.println("Atiende: " + postulaciones.desencolar());
        System.out.println("Atiende: " + postulaciones.desencolar());
        System.out.println("Atiende: " + postulaciones.desencolar());
        System.out.println("Cantidad final: " + postulaciones.tamaño());


        System.out.println("\n===== PILA (LIFO) =====");
        Pila<String> cambios = new Pila<>(5);

        cambios.apilar("nombre: Juan");
        cambios.apilar("profesión: Estudiante");
        cambios.apilar("profesión: Programador");

        System.out.println("Tope (sin sacar): " + cambios.verTope());
        System.out.println("Cantidad: " + cambios.tamaño());

        System.out.println("Deshacer: " + cambios.desapilar());
        System.out.println("Deshacer: " + cambios.desapilar());
        System.out.println("Deshacer: " + cambios.desapilar());
        System.out.println("Deshacer: " + cambios.desapilar());


        System.out.println("\n===== DICCIONARIO (perfil por ID) =====");
        Diccionario<Integer, Perfil> perfiles = new Diccionario<>();

        perfiles.insertar(1, new Perfil(1, "Ana", "Ingeniera"));
        perfiles.insertar(2, new Perfil(2, "Bruno", "Diseñador"));
        perfiles.insertar(3, new Perfil(3, "Carla", "Contadora"));

        boolean ok = perfiles.insertar(1, new Perfil(1, "Otro", "Otra"));
        System.out.println("Insertar ID 1 de nuevo (esperado false): " + ok);

        System.out.println("Buscar ID 2: " + perfiles.buscar(2));
        System.out.println("Cantidad: " + perfiles.tamanio());

        perfiles.modificar(3, new Perfil(3, "Carla", "Contadora Senior"));
        System.out.println("ID 3 modificado: " + perfiles.buscar(3));

        perfiles.eliminar(2);
        System.out.println("Buscar ID 2 tras eliminar (esperado null): " + perfiles.buscar(2));

        System.out.println("Perfiles actuales:");
        perfiles.mostrar();
    }
}
