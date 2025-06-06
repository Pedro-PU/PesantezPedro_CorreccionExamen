package ec.edu.ups.poo.institucion;
import java.util.ArrayList;
import java.util.List;
public class Curso {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public String toString() {
        return " - " + nombre;
    }
}
