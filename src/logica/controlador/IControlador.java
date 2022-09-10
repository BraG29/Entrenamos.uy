package logica.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import logica.datatypes.*;

public class IControlador {

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac) {
	}

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
	}

	public ArrayList<DtUsrKey> listarUsuarios() {
		return null;
	}

	public DtUsuario getDatosUsuario(DtUsrKey usrKey) {
		return null;
	}

	public void modificarDatos(String nombre, String apellido, LocalDate fechaNac) {

	}

	public void modificarDatos(String nombre, String apellido, LocalDate fechaNac, String institucion,
			String descripcion, String biografia, String sitioWeb) {
	}

	public void altaInstitucion(String nombreInst, String descripcion, String URL) {

	}

	public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo,
			LocalDateTime fechaAlta) {
	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDateTime _fechaInicio, LocalDateTime _fechaFin,
			float descuento) {
	}
        
        public ArrayList<String> getNombreInstituciones(){
            return null;
        }

        public ArrayList<String> consultarActividadDepo(String nombreInsti){
            return null;
        }
}
