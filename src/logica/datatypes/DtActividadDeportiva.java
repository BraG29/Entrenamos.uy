package logica.datatypes;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class DtActividadDeportiva {
    public final String nombreAct;
    public final String descripcion;
    public final float duracion;
    public final float costo;
    public final LocalDateTime fechaRegistro;
    public final ArrayList<String> clases;
    public final ArrayList<String> cuponeras;
    public final String IMG_URL;
    
    public DtActividadDeportiva(String nomAct, String desc, float dura, float cost, LocalDateTime fecha, ArrayList<String> clase, ArrayList<String> cupo){
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; //checkear que esto se permita :7
        this.clases = clase;
        this.cuponeras = cupo;
        this.IMG_URL = null;
    }
    
    public DtActividadDeportiva(String nomAct, String desc, float dura, float cost, LocalDateTime fecha, ArrayList<String> clase, ArrayList<String> cupo,String IMG){
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; //checkear que esto se permita :7
        this.clases = clase;
        this.cuponeras = cupo;
        this.IMG_URL = IMG;
    }
}
