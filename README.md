# Sistema de Red Social Profesional (RSP)

## Integrantes:
-  Maximo Zaragoza
-  Ian Miguez

## Alternativa Elegida:
- A) Ecosistema de Red Social Profesional

## Estructura de Datos:
- TDAs.Diccionario (sobre lista enlazada de pares clave-valor)
- TDAs.Lista enlazada simple
- TDAs.Pila (LIFO, arreglo)
- Cola Circular (FIFO, arreglo)
- Árbol n-ario
- Grafo (lista de adyacencia, no dirigido)

## Funcionalidades Implementadas en esta Segunda Etapa:
- Identificación de perfil por ID con TDAs.Diccionario
- Gestión de postulaciones por orden de llegada con Cola Circular
- Deshacer la última actualización del perfil con TDAs.Pila
- Metodos de Gestion de Usuarios
- Red de contactos: conexión entre usuarios, grado de separación (BFS) y contactos recomendados (vínculos en común) (Grafo)

## Cómo compilar, ejecutar y probar
Requisitos: tener instalado el JDK (Java) e IntelliJ IDEA.

- Abrir el proyecto en IntelliJ IDEA.
- Ir a la clase `Main` (en `src/Service/Main.java`).
- Ejecutarla con el botón Run (la flecha verde) o con Shift+F10.
- El programa arranca con datos de ejemplo y muestra un menú por consola.
- Para probar, se elige cada opción del menú (1 a 15); cada una usa uno de los TDAs
    (buscar usuario, conectar contactos, grado de separación, postular, deshacer, etc.).
    La opción 0 cierra el programa.


## Organización del proyecto:
src/
├── TDAs/      Estructuras de datos hechas a mano (Diccionario, Lista, Pila,
│              ColaCircular, Grafo, ArbolHabilidades + nodos auxiliares)
├── models/    Entidades del dominio (Perfil, Postulacion, EstadoPerfil)
└── Service/   RedProfesional (fachada de los 5 TDAs) y Main (menú por consola)

## Link del Repositorio:
- https://github.com/IanMiguez/TPO_Progra2


## Basado en linkedin de una forma simplificada donde:
- Hay profesionales
- Usuarios se conectan entre si
- Postulación a empleos
- Edición de cambios en perfil

## Actividades Realizadas por cada Integrante:
### - Ian Miguez:
    - Clases: models.Perfil, Estado models.Perfil, TDAs.Lista, TDAs.Diccionario.
    - Service.RedProfesional: Métodos de Gestión de Usuarios

### - Maximo Zaragoza:
    - Clases: TDAs.Nodo, Cola Circular, TDAs.Pila, Service.Main, Casos de Prueba.
    - Service.RedProfesional: integración de los TDAs y operaciones del sistema.
