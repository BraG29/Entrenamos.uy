package logica.datatypes;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class DtActividadDeportiva {
    public final String nombreAct;
    public final String descripcion;
    public final float duracion;
    public final float costo;
    public final LocalDateTime fechaRegistro;
    public final ArrayList<DtClase> clases;
    public final ArrayList<DtCuponera> cuponeras;
    
    public DtActividadDeportiva(
    		String nomAct, String desc, float dura, float cost, LocalDateTime fecha,
    		ArrayList<DtClase> clase, ArrayList<DtCuponera> cupo){
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; //checkear que esto se permita :7
        this.clases = clase;
        this.cuponeras = cupo;
    }
}
