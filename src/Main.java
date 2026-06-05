public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   RED SOCIAL PROFESIONAL - TABLA HASH");
        System.out.println("==========================================\n");

        TablaHash perfiles = new TablaHash(10);

        System.out.println(">>> Insertando perfiles...\n");
        perfiles.insertar(new Perfil(101, "Carlos Lopez",  "Desarrollador Java",  "TechCorp"));
        perfiles.insertar(new Perfil(102, "Maria Gomez",   "Disenadora UX",       "Creativa SA"));
        perfiles.insertar(new Perfil(111, "Juan Perez",    "Project Manager",     "BuildIt"));
        perfiles.insertar(new Perfil(205, "Ana Torres",    "Data Scientist",      "DataLab"));
        perfiles.insertar(new Perfil(121, "Luis Ramirez",  "DevOps Engineer",     "CloudNet"));

        perfiles.mostrarTabla();

        System.out.println(">>> Buscando perfiles...\n");
        int idBuscar = 111;
        Perfil encontrado = perfiles.buscar(idBuscar);
        if (encontrado != null) {
            System.out.println("Perfil encontrado con ID " + idBuscar + ": " + encontrado);
        } else {
            System.out.println("No existe perfil con ID " + idBuscar);
        }

        int idInexistente = 999;
        Perfil noEncontrado = perfiles.buscar(idInexistente);
        if (noEncontrado != null) {
            System.out.println("Perfil encontrado con ID " + idInexistente + ": " + noEncontrado);
        } else {
            System.out.println("No existe perfil con ID " + idInexistente);
        }
        System.out.println();

        System.out.println(">>> Intentando insertar ID 101 duplicado...\n");
        perfiles.insertar(new Perfil(101, "Carlos L. (actualizado)", "Tech Lead", "TechCorp"));
        System.out.println("Perfil con ID 101 ahora: " + perfiles.buscar(101) + "\n");

        System.out.println(">>> Eliminando perfil con ID 102 (Maria Gomez)...\n");
        boolean eliminado = perfiles.eliminar(102);
        System.out.println("Se elimino? " + eliminado);
        System.out.println("Sigue existiendo el ID 102? " + perfiles.contiene(102));
        System.out.println("Cantidad de perfiles ahora: " + perfiles.cantidad() + "\n");

        perfiles.mostrarTabla();
    }
}
