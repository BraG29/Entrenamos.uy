package logica.datatypes;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class DtActividadDeportiva {
    public final String nombreAct;
    public final String descripcion;
    public final int duracion;
    public final float costo;
    public final LocalDateTime fechaRegistro;
    public final ArrayList<String> clases;
    
    public DtActividadDeportiva(String nomAct, String desc, int dura, float cost, LocalDateTime fecha, ArrayList<String> clase){
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; //checkear que esto se permita :7
        this.clases = clase;
    }
}