package logica.clase;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Clase implements Serializable{
	@Id
	@Column(name="nombre")
    private String nombreClase;
    
    private LocalDate fecha;
    @Column(name="hora_inicio")
    private LocalTime horaIni;
    @Column(name="cant_minima")
    private int cantMin;
    @Column(name="cant_maxima")
    private int cantMax;
    @Column(name="URL")
    private String claseURL;
    @Column(name="fecha_registro")
    private LocalDate fechaRegistro;
    //atributos calculados:
    @Column(name="hora_fin")
    private LocalTime horaFin;
    @Column(name="cant_socios")
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
