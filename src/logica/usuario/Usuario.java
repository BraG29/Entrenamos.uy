package logica.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import logica.datatypes.DtUsuario;
import logica.datatypes.DtUsrKey;
/**
 *
 * @author elinzar
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {
    
	@Id
    protected String nickname;
	@Id
    protected String email;
    protected String nombre;
    protected String apellido;
    @Column(name="fecha_nacimiento")
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
    	
//Constructors------------------------------------------------------------------
    //Empty constructor
    public Usuario() {
	}
    //Full constructor
    public Usuario(String nickname, String apellido, String email, String nombre, LocalDate fechaNac) {
        this.nickname = nickname;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        // Falta la imagen .png
    }
//Methods-----------------------------------------------------------------------
    public DtUsrKey getKey(){
        DtUsrKey output = new DtUsrKey(this.nickname,this.email);
        return output;
    }
    
    public DtUsuario getDatosUsr(){
        return null;
    }
    public DtUsuario getDatosCompletos(){//should be implemented by child classes
        return null;
    }
}
