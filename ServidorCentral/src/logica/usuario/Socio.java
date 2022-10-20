package logica.usuario;

//import logica.Clase; not implemented
//import logica.Registro; not implemented
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

import logica.clase.Clase;
import logica.clase.Registro;
import logica.cuponera.CompraCuponera;
import logica.datatypes.DtSocio;
import logica.datatypes.DtUsuario;

@Entity
public class Socio extends Usuario {

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
//	@JoinColumn(name="nick_socio", referencedColumnName="nickname")
//	@JoinColumn(name="id_reg", referencedColumnName="id")
//	@JoinTable(name="Socio_Reg",
//		joinColumns = @JoinColumn(name="nick_socio", referencedColumnName="nickname"),
//		inverseJoinColumns = @JoinColumn(name="id_reg"))
    private Collection<Registro> registro;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private Collection<CompraCuponera> compra;

    // methods-----------------------------------------------------------------------

    public Socio() {
        super();
        // TODO Auto-generated constructor stub
        compra = new ArrayList<>();// Siempren inicien el las colleciones
        registro = new ArrayList<>();
    }

    public Socio(String nickname, String apellido, String email, String pass, String nombre, LocalDate fechaNac) {
        super(nickname, apellido, email, pass, nombre, fechaNac);
        // TODO Auto-generated constructor stub

        compra = new ArrayList<>();// Siempren inicien el las colleciones
        registro = new ArrayList<>();
    }

    public DtUsuario getDatosSocio() {
        DtUsuario dtS = new DtSocio(this.nickname, this.email, this.nombre, this.apellido, this.fechaNac, getImagen());
        return dtS;
    }

    public Registro registrarAClase(Clase c, LocalDate fecha, float costo) {
        for (Registro reg : registro) {
            if (reg.esRegistroDe(c))
                throw new IllegalArgumentException("El socio ya tiene un registro para la clase");
        }
        Registro r = new Registro(fecha, costo, c, this);
        registro.add(r);
        return r;
    }

    public Collection<Registro> getRegistro() {
        return registro;
    }
}
