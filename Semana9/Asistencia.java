import java.time.LocalDateTime;

public class Asistencia {
    private String dni;
    private LocalDateTime fechaHora;
    private String estado; // Presente, Ausente, Tardanza
    private String justificacion;

    public Asistencia(String dni, String estado) {
        this.dni = dni;
        this.estado = estado;
        this.fechaHora = LocalDateTime.now();
        this.justificacion = "";
    }

    public String getDni() {
        return dni;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Estado: " + estado + ", Fecha: " + fechaHora + ", Justificación: " + justificacion;
    }
}
