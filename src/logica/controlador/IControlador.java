package logica.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import logica.datatypes.*;

import logica.datatypes.DtCuponera;

public class IControlador {

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac, String imagen) {
	}
	
	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac, 
			String imagen, String institucion, String descripcion, String biografia, String sitioWeb) {
	}


	public ArrayList<DtUsrKey> listarUsuarios() {
		return null;
	}

	public DtUsuario getDatosUsuario(DtUsrKey usrKey) {
		return null;
	}

	public void modificarDatos(String nombre, String apellido, LocalDate fechaNac, String imagen) {

	}

	public void modificarDatos(String nombre, String apellido, LocalDate fechaNac, String institucion,
			String imagen, String descripcion, String biografia, String sitioWeb) {
	}

	//CU Consulta de cuponeras de actividades deportivas
	public ArrayList<String> listaCuponerasRegistradas() {
		return null;
	}
	
	public DtCuponera seleccionCuponera(String nombreCup) {
		return null;
	}
	
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL){
		
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
        
        public ArrayList<String> consultarProfe(String nombreInsti){
            return null;
        }
        
        public void darAltaClase(String nombreInsti,String nombreClase,LocalDateTime fechaInicio,String nombreProfe ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){
            
        }
}
