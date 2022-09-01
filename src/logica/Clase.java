package logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Clase {
    private String nombreClase;
    private LocalDate fecha;
    private LocalTime horaIni;
    private int cantMin;
    private int cantMax;
    private String claseURL;
    private LocalDate fechaRegistro;
    //atributos calculados:
    private LocalTime horaFin;
    private int cantSocios;
    
    
    //Constructor, faltan los atributos calculados: horaFin y cantSocios.
    public Clase(String nombreClase, LocalDate fecha, LocalTime horaIni, int cantMin, int cantMax, String claseURL, LocalDate fechaRegistro) {
        this.nombreClase = nombreClase;
        this.fecha = fecha;
        this.horaIni = horaIni;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.claseURL = claseURL;
        this.fechaRegistro = fechaRegistro;
    }


    
    
    //Getters-------------------------------------------------------------------
    public String getNombreClase() {
        return nombreClase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public int getCantMin() {
        return cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public String getClaseURL() {
        return claseURL;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public int getCantSocios() {
        return cantSocios;
    }

    
    //Setters-------------------------------------------------------------------
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHoraIni(LocalTime horaIni) {
        this.horaIni = horaIni;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public void setClaseURL(String claseURL) {
        this.claseURL = claseURL;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } 
}
