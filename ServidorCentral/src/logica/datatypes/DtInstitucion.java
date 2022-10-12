package logica.datatypes;

import java.util.ArrayList;

import logica.institucion.ActividadDeportiva;

public class DtInstitucion {
    public final String nombreInst;
    public final String descripcion;
    public final String instURL;
    public final ArrayList<DtActividadDeportiva> actividades;
    
    
    public DtInstitucion(String nomInst, String desc, String URL, ArrayList<DtActividadDeportiva> acti){
        this.nombreInst = nomInst;
        this.descripcion = desc;
        this.instURL = URL;
        this.actividades = acti;
    }
}
