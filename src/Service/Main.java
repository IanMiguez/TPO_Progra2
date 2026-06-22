package Service;

import TDAs.Lista;
import models.Perfil;
import models.Postulacion;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        RedProfesional red = new RedProfesional();
        cargarDatosDemo(red);

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Elegi una opcion: ");

            switch (opcion) {
                case 1: registrarUsuario(red); break;
                case 2: red.mostrarUsuarios(); break;
                case 3: buscarUsuario(red); break;
                case 4: actualizarPerfil(red); break;
                case 5: deshacerCambio(red); break;
                case 6: conectarUsuarios(red); break;
                case 7: red.mostrarConexiones(); break;
                case 8: gradoDeSeparacion(red); break;
                case 9: contactosRecomendados(red); break;
                case 10: postular(red); break;
                case 11: procesarPostulacion(red); break;
                case 12: agregarHabilidad(red); break;
                case 13: red.mostrarHabilidades(); break;
                case 14: asignarHabilidad(red); break;
                case 15: buscarPorEspecialidad(red); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida.");
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("===== RED SOCIAL PROFESIONAL =====");
        System.out.println("1.  Registrar usuario");
        System.out.println("2.  Mostrar usuarios");
        System.out.println("3.  Buscar usuario por ID");
        System.out.println("4.  Actualizar perfil");
        System.out.println("5.  Deshacer ultimo cambio de un perfil");
        System.out.println("6.  Conectar dos usuarios (contactos)");
        System.out.println("7.  Mostrar red de contactos");
        System.out.println("8.  Grado de separacion entre dos usuarios");
        System.out.println("9.  Contactos recomendados");
        System.out.println("10. Postular a un puesto");
        System.out.println("11. Procesar siguiente postulacion");
        System.out.println("12. Agregar habilidad (al arbol)");
        System.out.println("13. Mostrar arbol de habilidades");
        System.out.println("14. Asignar habilidad a un usuario");
        System.out.println("15. Buscar usuarios (por categoria o especialidad)");
        System.out.println("0.  Salir");
    }

    private static void registrarUsuario(RedProfesional red) {
        String nombre = leerTexto("Nombre: ");
        String profesion = leerTexto("Profesion: ");

        Perfil perfil = red.registrarUsuario(nombre, profesion);
        System.out.println("Usuario registrado con ID: " + perfil.getId());
    }

    private static void buscarUsuario(RedProfesional red) {
        int id = leerEntero("ID a buscar: ");
        Perfil perfil = red.buscarUsuario(id);
        if (perfil != null) {
            System.out.println(perfil);
        } else {
            System.out.println("No existe un usuario con ese ID.");
        }
    }

    private static void actualizarPerfil(RedProfesional red) {
        int id = leerEntero("ID del perfil a actualizar: ");
        if (red.buscarUsuario(id) == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        System.out.println("Que dato queres modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Profesion");
        int opcion = leerEntero("Opcion: ");

        switch (opcion) {
            case 1:
                red.actualizarNombre(id, leerTexto("Nuevo nombre: "));
                System.out.println("Perfil actualizado: " + red.buscarUsuario(id));
                break;
            case 2:
                red.actualizarProfesion(id, leerTexto("Nueva profesion: "));
                System.out.println("Perfil actualizado: " + red.buscarUsuario(id));
                break;
            default:
                System.out.println("Opcion invalida. No se modifico nada.");
        }
    }

    private static void deshacerCambio(RedProfesional red) {
        int id = leerEntero("ID del perfil: ");
        if (red.deshacerCambio(id)) {
            System.out.println("Cambio deshecho: " + red.buscarUsuario(id));
        } else {
            System.out.println("No hay cambios para deshacer (o el ID no existe).");
        }
    }

    private static void conectarUsuarios(RedProfesional red) {
        int id1 = leerEntero("ID usuario 1: ");
        int id2 = leerEntero("ID usuario 2: ");
        if (red.conectarUsuarios(id1, id2)) {
            System.out.println("Usuarios conectados.");
        } else {
            System.out.println("No se pudo conectar (IDs invalidos o iguales).");
        }
    }

    private static void gradoDeSeparacion(RedProfesional red) {
        int id1 = leerEntero("ID origen: ");
        int id2 = leerEntero("ID destino: ");
        int grado = red.gradoDeSeparacion(id1, id2);
        if (grado == -1) {
            System.out.println("No estan conectados (o algun ID no existe).");
        } else {
            System.out.println("Grado de separacion: " + grado);
        }
    }

    private static void contactosRecomendados(RedProfesional red) {
        int id = leerEntero("ID del usuario: ");
        Lista<Perfil> recomendados = red.contactosRecomendados(id);
        if (recomendados.estaVacia()) {
            System.out.println("Sin recomendaciones.");
        } else {
            System.out.println("Contactos recomendados:");
            recomendados.mostrar();
        }
    }

    private static void postular(RedProfesional red) {
        int id = leerEntero("ID del postulante: ");
        if (red.buscarUsuario(id) == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }
        String puesto = leerTexto("Puesto: ");
        if (red.postular(id, puesto)) {
            System.out.println("Postulacion registrada.");
        } else {
            System.out.println("No se pudo registrar (cola llena).");
        }
    }

    private static void procesarPostulacion(RedProfesional red) {
        Postulacion p = red.procesarPostulacion();
        if (p != null) {
            System.out.println("Procesando: " + p);
            System.out.println("Postulaciones restantes: " + red.cantidadPostulaciones());
        } else {
            System.out.println("No hay postulaciones pendientes.");
        }
    }

    private static void agregarHabilidad(RedProfesional red) {
        String categoria = leerTexto("Categoria / area (ej: Tecnologia, Cocina): ");
        String habilidad = leerTexto("Habilidad (ej: Java, Pasteleria): ");
        if (red.agregarHabilidad(categoria, habilidad)) {
            System.out.println("Habilidad agregada dentro de '" + categoria + "'.");
        } else {
            System.out.println("Esa habilidad ya existe en el arbol.");
        }
    }

    private static void asignarHabilidad(RedProfesional red) {
        int id = leerEntero("ID del usuario: ");
        if (red.buscarUsuario(id) == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }
        String habilidad = leerTexto("Habilidad a asignar: ");
        if (!red.existeHabilidad(habilidad)) {
            System.out.println("Esa habilidad no existe en el arbol. Agregala primero (opcion 12).");
            return;
        }
        if (red.asignarHabilidad(id, habilidad)) {
            System.out.println("Habilidad asignada: " + red.buscarUsuario(id));
        } else {
            System.out.println("El usuario ya tenia esa habilidad.");
        }
    }

    private static void buscarPorEspecialidad(RedProfesional red) {
        System.out.println("Buscar por:");
        System.out.println("1. Categoria / area (ej: Tecnologia)");
        System.out.println("2. Especialidad (ej: Java)");
        int opcion = leerEntero("Opcion: ");

        switch (opcion) {
            case 1:
                Lista<String> categorias = red.obtenerCategorias();
                System.out.println("Categorias disponibles:");
                for (int i = 0; i < categorias.cantidadElementos(); i++) {
                    System.out.println((i + 1) + ". " + categorias.obtener(i));
                }
                int opcionCategoria = leerEntero("Seleccione una categoria: ");
                if (opcionCategoria < 1 ||
                        opcionCategoria > categorias.cantidadElementos()) {
                    System.out.println("Opcion invalida.");
                    return;
                }
                String categoria = categorias.obtener(opcionCategoria - 1);
                mostrarResultadoBusqueda(red.buscarPorCategoria(categoria), categoria);
                break;

            case 2:
                Lista<String> categorias2 = red.obtenerCategorias();
                System.out.println("Categorias disponibles:");
                for (int i = 0; i < categorias2.cantidadElementos(); i++) {
                    System.out.println((i + 1) + ". " + categorias2.obtener(i));
                }
                int opcionCategoria2 = leerEntero("Seleccione una categoria: ");
                if (opcionCategoria2 < 1 || opcionCategoria2 > categorias2.cantidadElementos()) {

                    System.out.println("Opcion invalida.");
                    return;
                }

                String categoriaSeleccionada = categorias2.obtener(opcionCategoria2 - 1);

                Lista<String> habilidades = red.obtenerHabilidadesDeCategoria(categoriaSeleccionada);

                System.out.println("Especialidades disponibles:");

                for (int i = 0; i < habilidades.cantidadElementos(); i++) {

                    System.out.println((i + 1) + ". " + habilidades.obtener(i));
                }

                int opcionHabilidad = leerEntero("Seleccione una especialidad: ");
                if (opcionHabilidad < 1 || opcionHabilidad > habilidades.cantidadElementos()) {
                    System.out.println("Opcion invalida.");
                    return;
                }

                String habilidadSeleccionada = habilidades.obtener(opcionHabilidad - 1);

                mostrarResultadoBusqueda(red.buscarPorEspecialidad(habilidadSeleccionada), habilidadSeleccionada);
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private static void mostrarResultadoBusqueda(Lista<Perfil> encontrados, String criterio) {
        if (encontrados.estaVacia()) {
            System.out.println("No se encontraron usuarios para '" + criterio + "'.");
        } else {
            System.out.println("Usuarios encontrados para '" + criterio + "':");
            encontrados.mostrar();
        }
    }

    private static void cargarDatosDemo(RedProfesional red) {
        red.registrarUsuario("Ana", "Ingeniera");
        red.registrarUsuario("Bruno", "Disenador");
        red.registrarUsuario("Carla", "Contadora");
        red.registrarUsuario("Diego", "Abogado");
        red.registrarUsuario("Eva", "Medica");

        red.conectarUsuarios(1, 2);
        red.conectarUsuarios(2, 3);
        red.conectarUsuarios(3, 4);
        red.conectarUsuarios(1, 5);

        red.agregarHabilidad("Tecnologia", "Java");
        red.agregarHabilidad("Tecnologia", "Python");
        red.agregarHabilidad("Cocina", "Pasteleria");

        red.asignarHabilidad(1, "Java");
        red.asignarHabilidad(2, "Java");
        red.asignarHabilidad(3, "Python");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!Character.isDigit(c)) {
                return -1;
            }
        }
        return Integer.parseInt(texto);
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }
}