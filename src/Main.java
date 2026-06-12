// Pruebas de los modulos implementados:
//   - Cola circular (postulaciones por orden de llegada)
//   - Pila (deshacer la ultima actualizacion del perfil)
//   - Diccionario (identificar/recuperar un perfil por su ID)
public class Main {

    public static void main(String[] args) {

        // Funcionalidad / Métodos
        RedProfesional red = new RedProfesional();

        red.registrarUsuario(
                new Perfil(1,"Ian Miguez","Programador")
        );

        red.registrarUsuario(
                new Perfil(2,"Maximo Zaragoza","Diseñador de Moda")
        );

        System.out.println(
                red.buscarUsuario(1)
        );

        red.mostrarUsuarios();


        // Prueba de implementaciones
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


        System.out.println("\n===== PILA: deshacer cambios del perfil (LIFO) =====");
        Perfil perfil = new Perfil(10, "Juan", "Estudiante");
        Pila<EstadoPerfil> historial = new Pila<>(10);
        System.out.println("Perfil inicial:      " + perfil);

        // Antes de cada cambio, guardamos el estado anterior en la pila
        historial.apilar(new EstadoPerfil(perfil.getNombre(), perfil.getProfesion()));
        perfil.setProfesion("Programador Junior");
        System.out.println("Tras cambio 1:       " + perfil);

        historial.apilar(new EstadoPerfil(perfil.getNombre(), perfil.getProfesion()));
        perfil.setProfesion("Programador Senior");
        System.out.println("Tras cambio 2:       " + perfil);

        EstadoPerfil anterior = historial.desapilar();
        perfil.setNombre(anterior.getNombre());
        perfil.setProfesion(anterior.getProfesion());
        System.out.println("Despues de deshacer: " + perfil);

        System.out.println("\n===== PERFIL =====");

        Perfil p1 = new Perfil(1, "Ian", "Programador");

        System.out.println(p1);

        p1.setProfesion("Analista");

        System.out.println("Profesión modificada:");
        System.out.println(p1);

        System.out.println("\n===== ESTADO PERFIL =====");

        EstadoPerfil estado =
                new EstadoPerfil("Ian", "Programador");

        System.out.println("Nombre: " + estado.getNombre());
        System.out.println("Profesión: " + estado.getProfesion());

        System.out.println("\n===== ENTRADA<K,V> =====");

        Entrada<Integer, String> entrada =
                new Entrada<>(10, "Java");

        System.out.println("Clave: " + entrada.getClave());
        System.out.println("Valor: " + entrada.getValor());

        entrada.setValor("Python");

        System.out.println("Nuevo valor: " + entrada.getValor());

        System.out.println("\n===== LISTA<T> =====");

        Lista<String> lista = new Lista<>();

        System.out.println("¿Vacía?: " + lista.estaVacia());

        lista.agregar("Java");
        lista.agregar("Python");
        lista.agregar("SQL");

        System.out.println("Cantidad: " +
                lista.cantidadElementos());

        System.out.println("Buscar Python: " +
                lista.buscar("Python"));

        System.out.println("Elemento posición 1: " +
                lista.obtener(1));

        lista.reemplazar(1, "C#");

        System.out.println("Lista luego de reemplazar:");
        lista.mostrar();

        lista.eliminar(0);

        System.out.println("Lista luego de eliminar posición 0:");
        lista.mostrar();

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
