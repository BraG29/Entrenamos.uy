package logica.institucion;

import java.time.LocalDateTime;
import java.util.HashMap;

import logica.clase.Clase;
import logica.cuponera.Cuponera;
import logica.datatypes.DtActividadDeportiva;
import java.util.ArrayList;


public class ActividadDeportiva {
    private String nombreAct;
    private String descripcion;
    private int duracion;//en minutos gente
    private float costo;
    private LocalDateTime fechaRegistro;
    private HashMap clases = new HashMap<String,Clase>();
    private HashMap cuponeras = new HashMap<String,Cuponera>();

    
    
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

    public LocalDateTime getFechaRegistro() {
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

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    public DtActividadDeportiva getDTActividadDeportiva(){
        ArrayList<String> strClases = new ArrayList<String>();
        strClases.addAll(clases.keySet());
        
        ArrayList<String> strCuponeras = new ArrayList<String>();
        strCuponeras.addAll(cuponeras.keySet());
        
        DtActividadDeportiva DtActi = new DtActividadDeportiva(this.nombreAct, this.descripcion, this.duracion, this.costo, this.fechaRegistro, strClases, strCuponeras);
        return DtActi;
    }
    
    public ArrayList<String> getNombreClases(){
        ArrayList<String> nombreClases = new ArrayList<String>();
        nombreClases.addAll(clases.keySet());
        
        return nombreClases;
    }
    
}
