package logica.clase;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import logica.datatypes.DtClase;
import logica.institucion.ActividadDeportiva;
import logica.usuario.Profesor;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actividad_deportiva")
    private ActividadDeportiva claseDe;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Profesor profesor;
    
    @OneToMany(mappedBy = "claseAsociada", cascade = CascadeType.ALL)
    private Collection<Registro> registros; 
    
    
    
    //Constructor, faltan los atributos calculados: horaFin y cantSocios.
    public Clase(String nombreClase, LocalDate fecha, LocalTime horaIni, int cantMin, int cantMax, String claseURL, LocalDate fechaRegistro, Profesor profe, ActividadDeportiva actiDepo ) {
        this.nombreClase = nombreClase;
        this.fecha = fecha; //fecha de inicio
        this.horaIni = horaIni;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.claseURL = claseURL;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        this.claseDe = actiDepo;
    }
    
    public Clase() {
    	
    };

    public void aniadirReg(Registro r) {
    	registros.add(r);
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
    
    public DtClase getData() {
    	System.out.println("Antes de armar el DtClase");
    	DtClase claseADevolver = new DtClase(this.nombreClase, this.fecha, this.horaIni, this.cantMin, this.cantMax, this.claseURL, this.fechaRegistro, this.horaFin, this.cantSocios);
    	System.out.println("Despues de armar el DtClase");
    	return claseADevolver;
    }
}
