package logica.datatypes;

import java.io.File;
import java.time.LocalDate;

public class DtProfesor extends DtUsuario {

    public final String institucion;
    public final String biografia;
    public final String descripcion;
    public final String sitioWeb;

    public DtProfesor(
            String nickname, String email, String nombre, String apellido, LocalDate fechaNac,
            String institucion, String biografia, String descripcion, String sitioWeb, File img) {
        super(nickname, email, nombre, apellido, fechaNac, img);
        this.institucion = institucion;
        this.biografia = biografia;
        this.descripcion = descripcion;
        this.sitioWeb = sitioWeb;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }
}
