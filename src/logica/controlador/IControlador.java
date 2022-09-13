package logica.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import logica.datatypes.*;

import logica.datatypes.DtCuponera;

public class IControlador {
	
	public void initConnection() {
		
	}
	
	public void closeConnection() {
		
	}

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
	
	public ArrayList<String> seleccionCuponera(String nombreCup) {
		return null;
	}
	
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL){
		
	}
		


	public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta) {

	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDate _fechaInicio, LocalDate _fechaFin,
			LocalDate fechaFin, float descuento) {
	}
        
        //Operaciones AgregarActividadDeportivaCuponera--------------------------------------------------------------------
        public ArrayList<DtCuponera> ListarCuponeras(){
            return null;
        }
        public ArrayList<DtInstitucion> ListarInstituciones(){
            return null;
        }
        
        public ArrayList<String> getNombreCuponeras(){
            return null;
        }
        //-----------------------------------------------------------------------------------------------------------------
        public ArrayList<String> getNombreInstituciones(){
            return null;
        }

        public ArrayList<String> consultarActividadDepo(String nombreInsti){
            return null;
        }
        
        public ArrayList<DtUsrKey> consultarProfe(String nombreInsti){
            return null;
        }
        
        public void darAltaClase(String nombreInsti,String nombreActiDepo,String nombreClase,LocalDateTime fechaInicio,DtUsrKey profeKey ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){
            
        }
        
        public void recordarInsti(String nombreInsti) {
        	
        }
}
