package logica;

import java.time.LocalDate;


public class ActividadDeportiva {
    private String nombreAct;
    private String descripcion;
    private int duracion;//en minutos gente
    private float costo;
    private LocalDate fechaRegistro;

    
    
    //Getters
    public String getNombreAct() {
        return nombreAct;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public float getCosto() {
        return costo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    //Setters
    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
    
}
