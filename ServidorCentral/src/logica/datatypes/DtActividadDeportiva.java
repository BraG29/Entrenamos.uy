package logica.datatypes;

import java.util.ArrayList;

import logica.institucion.Estado;

import java.time.LocalDateTime;

public class DtActividadDeportiva {
    public final String nombreAct;
    public final String descripcion;
    public final float duracion;
    public final float costo;
    // public final DtInstitucion institucion;
    public final LocalDateTime fechaRegistro;
    public final Estado estadoActual;
    public final ArrayList<DtClase> clases;
    public final ArrayList<DtCuponera> cuponeras;
    public final ArrayList<String> categorias;

    public DtActividadDeportiva(
            String nomAct, String desc, float dura, float cost, LocalDateTime fecha, Estado estado,
            ArrayList<DtClase> clase, ArrayList<DtCuponera> cupo, ArrayList<String> cate) {
        this.nombreAct = nomAct;
        this.descripcion = desc;
        this.duracion = dura;
        this.costo = cost;
        this.fechaRegistro = fecha; // checkear que esto se permita :7
        this.estadoActual = estado;
        // this.institucion = institucion;
        this.clases = clase;
        this.cuponeras = cupo;
        this.categorias = cate;
    }

    public String getNombreAct() {
        return nombreAct;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getDuracion() {
        return duracion;
    }

    public float getCosto() {
        return costo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public ArrayList<DtClase> getClases() {
        return clases;
    }

    public ArrayList<DtCuponera> getCuponeras() {
        return cuponeras;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }
}
