package logica;

import java.time.LocalDate;
import logica.datatypes.DtUsuario;
import logica.datatypes.DtUsrKey;
/**
 *
 * @author elinzar
 */
public class Usuario {
    
    protected String nickname;
    protected String email;
    protected String nombre;
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
    public Usuario(String nickname, String email, String nombre, LocalDate fechaNac) {
        this.nickname = nickname;
        this.email = email;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        // Falta la imagen .png
    }
//Methods-----------------------------------------------------------------------
    public DtUsrKey getKey(){
        DtUsrKey output = new DtUsrKey(this.nickname,this.email);
        return output;
    }
    
    public DtUsuario getDatosUsr(){
        DtUsuario output = new DtUsuario (this.nickname, this.email, this.nombre, this.fechaNac);
        return output;
    }
    public DtUsuario getDatosCompletos(){//should be implemented by child classes
        DtUsuario output = new DtUsuario(this.nickname, this.email, this.nombre, this.fechaNac);
        return output;
    }
}
