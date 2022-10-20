package logica.datatypes;

import java.io.File;
import java.time.LocalDate;

public class DtUsuario {
    public final String nickname;
    public final String email;
    public final String nombre;
    public final String apellido;
    public final LocalDate fechaNac;
    public final File imagen;

    public DtUsuario(String nickname, String email, String nombre, String apellido, LocalDate fechaNac, File img) {
        this.nickname = nickname;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.imagen = img;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public File getImagen() {
        return imagen;
    }
}
