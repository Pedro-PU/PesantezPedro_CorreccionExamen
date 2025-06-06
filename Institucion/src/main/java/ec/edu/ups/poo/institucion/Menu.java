package ec.edu.ups.poo.institucion;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Menu {
    private List<Curso> cursos;
    private List<Asignatura> asignaturas;
    private Scanner sc;

    public Menu() {
        cursos = new ArrayList<>();
        asignaturas = new ArrayList<>();
        sc = new Scanner(System.in);
        cargarDatosIniciales();
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n----- MENÚ PRINCIPAL -----");
            System.out.println("1. Crear nuevo curso");
            System.out.println("2. Agregar estudiante a curso");
            System.out.println("3. Agregar calificación a estudiante");
            System.out.println("4. Ver cursos y estudiantes");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> crearCurso();
                case 2 -> agregarEstudiante();
                case 3 -> agregarCalificacion();
                case 4 -> mostrarDatos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void cargarDatosIniciales() {
        Asignatura mate = new Asignatura("MAT001", "Matemáticas");
        Asignatura lit = new Asignatura("LIT001", "Literatura");
        asignaturas.add(mate);
        asignaturas.add(lit);

        Curso cursoA = new Curso("1ro Bachillerato A");
        cursos.add(cursoA);

        Estudiante juan = new Estudiante("0107568649", "Juan Pérez", cursoA);
        juan.agregarCalificacion(90, mate);
        juan.agregarCalificacion(85, lit);
        cursoA.agregarEstudiante(juan);
    }
    private void crearCurso() {
        System.out.print("Ingrese nombre del nuevo curso: ");
        String nombre = sc.nextLine();
        Curso nuevoCurso = new Curso(nombre);
        cursos.add(nuevoCurso);
        System.out.println("Curso creado exitosamente: " + nuevoCurso);
    }
    private void agregarEstudiante() {
        Curso curso = seleccionarCurso();
        if (curso == null) return;

        System.out.print("Ingrese cédula del estudiante: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = sc.nextLine();

        Estudiante estudiante = new Estudiante(cedula, nombre, curso);
        curso.agregarEstudiante(estudiante);
        System.out.println("Estudiante agregado al curso: " + estudiante);
    }
    private void agregarCalificacion() {
        Curso curso = seleccionarCurso();
        if (curso == null) return;

        Estudiante estudiante = seleccionarEstudiante(curso);
        if (estudiante == null) return;

        Asignatura asignatura = seleccionarAsignatura();
        if (asignatura == null) return;

        System.out.print("Ingrese la nota: ");
        int nota = Integer.parseInt(sc.nextLine());

        estudiante.agregarCalificacion(nota, asignatura);
        System.out.println("Nota registrada: " + new Calificacion(nota, asignatura));
    }
    private void mostrarDatos() {
        for (Curso curso : cursos) {
            System.out.println("\nCurso: " + curso);
            for (Estudiante est : curso.getEstudiantes()) {
                System.out.println("  - " + est);
                for (Calificacion c : est.getCalificaciones()) {
                    System.out.println("    * " + c);
                }
            }
        }
    }
    private Curso seleccionarCurso() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
            return null;
        }

        System.out.println("Cursos disponibles:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i));
        }

        System.out.print("Seleccione un curso: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > cursos.size()) {
            System.out.println("Opción inválida.");
            return null;
        }
        return cursos.get(opcion - 1);
    }
    private Estudiante seleccionarEstudiante(Curso curso) {
        List<Estudiante> estudiantes = curso.getEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en este curso.");
            return null;
        }

        System.out.println("Estudiantes del curso:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i));
        }

        System.out.print("Seleccione un estudiante: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > estudiantes.size()) {
            System.out.println("Opción inválida.");
            return null;
        }
        return estudiantes.get(opcion - 1);
    }
    private Asignatura seleccionarAsignatura() {
        System.out.println("Asignaturas disponibles:");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println((i + 1) + ". " + asignaturas.get(i));
        }

        System.out.println((asignaturas.size() + 1) + ". Crear nueva asignatura");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == asignaturas.size() + 1) {
            System.out.print("Ingrese la id de la nueva asignatura: ");
            String idAsig = sc.nextLine();
            System.out.print("Ingrese nombre de la nueva asignatura: ");
            String nombre = sc.nextLine();
            Asignatura nueva = new Asignatura(idAsig, nombre);
            asignaturas.add(nueva);
            return nueva;
        } else if (opcion >= 1 && opcion <= asignaturas.size()) {
            return asignaturas.get(opcion - 1);
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }
}
