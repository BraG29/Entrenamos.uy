package logica.usuario;
//import logica.Clase; not implemented
//import logica.Registro; not implemented
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import logica.clase.Clase;
import logica.clase.Registro;
import logica.cuponera.CompraCuponera;
import logica.datatypes.DtSocio;
import logica.datatypes.DtUsuario;
/**
 *
 * @author elinzar
 */
@Entity
public class Socio extends Usuario {
	
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="nick_socio", referencedColumnName="nickname")
//	@JoinColumn(name="id_reg", referencedColumnName="id")
//	@JoinTable(name="Socio_Reg",
//		joinColumns = @JoinColumn(name="nick_socio", referencedColumnName="nickname"),
//		inverseJoinColumns = @JoinColumn(name="id_reg"))
    private Collection<Registro> registro;
       
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CompraCuponera> compra;
	
	
	
	//methods-----------------------------------------------------------------------   

    public Socio() {
		super();
		// TODO Auto-generated constructor stub
                compra = new ArrayList<>();// Siempren inicien el las colleciones
                registro = new ArrayList<>();
	}



	public Socio(String nickname, String apellido, String email, String nombre, LocalDate fechaNac, String urlImagen ) {
		super(nickname, apellido, email, nombre, fechaNac, urlImagen);
		// TODO Auto-generated constructor stub
                
                compra = new ArrayList<>();// Siempren inicien el las colleciones
                registro = new ArrayList<>();
	}

	public DtUsuario getDatosSocio() {
		DtUsuario dtS = new DtSocio(
				this.nickname, this.email, this.nombre, this.apellido, this.fechaNac, this.urlImagen);
		return dtS;
	}

	public void registrarAClase(Clase c, LocalDate fecha){
        //needs implementation
        }

    public Collection<Registro> getRegistro() {
        return registro;
    }
        
        
   
}
