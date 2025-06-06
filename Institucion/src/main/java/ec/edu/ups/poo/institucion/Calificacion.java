package ec.edu.ups.poo.institucion;

public class Calificacion {
    private int nota;
    private Asignatura asignatura;

    public Calificacion(int nota, Asignatura asignatura) {
        this.nota = nota;
        this.asignatura = asignatura;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Asignatura: " + asignatura.getNombre() + " | Nota: " + nota;
    }
}
