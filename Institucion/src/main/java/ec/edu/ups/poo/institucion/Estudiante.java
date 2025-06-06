package ec.edu.ups.poo.institucion;
import java.util.ArrayList;
import java.util.List;
public class Estudiante {
    private String cedula;
    private String nombre;
    private Curso curso;
    private List<Calificacion> calificaciones;

    public Estudiante(String cedula, String nombre, Curso curso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.curso = curso;
        this.calificaciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void agregarCalificacion(int nota, Asignatura asignatura) {
        calificaciones.add(new Calificacion(nota, asignatura));
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
