// Pruebas cola y pila
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
    }
}
