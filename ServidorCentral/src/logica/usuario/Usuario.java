package logica.usuario;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import logica.datatypes.DtUsrKey;
import logica.datatypes.DtUsuario;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

    @Id
    @Column(unique = true)
    protected String nickname;
    @Id
    @Column(unique = true)
    protected String email;
    protected String contrasenia;
    protected String nombre;
    protected String apellido;
    @Column(name = "fecha_nacimiento")
    protected LocalDate fechaNac;

// Getters and Setters----------------------------------------------------------
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Constructors------------------------------------------------------------------
    // Empty constructor
    public Usuario() {
    }

    // Full constructor
    public Usuario(String nickname, String apellido, String email, String pass, String nombre, LocalDate fechaNac) {
        this.nickname = nickname;
        this.email = email;
        this.contrasenia = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        // Falta la imagen .png
    }

    public Usuario(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    // Methods-----------------------------------------------------------------------
    public DtUsrKey getKey() {
        DtUsrKey output = new DtUsrKey(this.nickname, this.email);
        return output;
    }

    public DtUsuario getDatosCompletos() {// should be implemented by child classes
        return null;
    }

    public File getImagen() {
        String rutaDir = System.getProperty("user.dir");
        String imgPath = rutaDir + "/src/imgUsr/" + "." + nickname;
        File img = new File(imgPath);
        return img;
    }
}
