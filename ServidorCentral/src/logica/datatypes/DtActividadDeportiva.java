package logica.datatypes;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class DtActividadDeportiva {
    public final String nombreAct;
    public final String descripcion;
    public final float duracion;
    public final float costo;
    public final DtInstitucion institucion;
    public final LocalDateTime fechaRegistro;
    public final ArrayList<DtClase> clases;
    public final ArrayList<DtCuponera> cuponeras;
    public final ArrayList<String> categorias;

    public DtActividadDeportiva(
    		String nomAct, String desc, float dura, float cost, LocalDateTime fecha, DtInstitucion institucion,
    		ArrayList<DtClase> clase, ArrayList<DtCuponera> cupo, ArrayList<String> cate){
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; //checkear que esto se permita :7
        this.institucion = institucion;
        this.clases = clase;
        this.cuponeras = cupo;
        this.categorias = cate;
    }
}
