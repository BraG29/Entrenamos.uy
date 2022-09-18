package logica.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import logica.datatypes.*;
import logica.datatypes.DtCuponera;
import logica.usuario.Usuario;

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
	
	public DtCuponera seleccionCuponera(String nombreCup) {
		return null;
	}
	
	public DtActividadDeportiva seleccionActividad(String nombreAct) {
		return null;
	}
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL){
		
	}
		



	public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo,
			LocalDateTime fechaAlta) { //agregar foto para la actividad
		
	}

	public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta, String IMG_URL) {


	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDate _fechaInicio, LocalDate _fechaFin,
			LocalDate fechaFin, float descuento) {
	}
	public void registroDictadoClase(String pNombreActividad, String pNombreClase, String pNombreSocio) {
    	
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
        public ArrayList<String> getActisDeCuponera(String nombreCup){
            return null;
        }
        public boolean agregarActividadCuponera(String nombreCup,String nombreActi,int cantClases){
            return false;
        }
        //-----------------------------------------------------------------------------------------------------------------
        //Operaciones ConsultaUsuario--------------------------------------------------------------------------------------
        
        //-----------------------------------------------------------------------------------------------------------------
        public ArrayList<String> getNombreInstituciones(){
            return null;
        }

        public ArrayList<String> consultarActividadDepo(String nombreInsti){
            return null;
        }
        
        public ArrayList<String> consultarClases(String nombreActividad){   
        	return null;
        }
        
        public String[] getUnaClase(String nombreClase){	
        	return null;
        }
        
        public ArrayList<DtUsrKey> consultarProfe(String nombreInsti){
            return null;
        }
        
        public void darAltaClase(String nombreInsti,String nombreActiDepo,String nombreClase,LocalDateTime fechaInicio,DtUsrKey profeKey ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){
            
        }
        
        public void recordarInsti(String nombreInsti) {
        	
        }
        
        public DtActividadDeportiva getDtActividadDeportiva(String nombreActi) {
        	return null;
        }
        
        public ArrayList<String> listaCuponerasRegistradasParaActiDepo(String nombreActi) {
        	return null;
        }
        
        public ArrayList<String> getClasesPorActiDepo(String nombreActi){
        	return null;
        }
        
        public ArrayList<String> getClasesVigentesPorActiDepo(String nombreActi){
        	return null;
        }
        
        public ArrayList<String> getSociosHabilitados(String nombreClase) {
        	return null;
        }
        
        public DtCuponera getDtCuponera(String nombreCupo) {
        	return null;
        }
        public DtClase getDtClaseXInsti(String nombreInsti,String nombreActi, String nombreClase) {
        	return null;
        }
        
        public Usuario getUsuario(DtUsrKey UsrKey){
            return null;
        }
        
        public ArrayList<String> getClaseRegistradaSocio(DtSocio socio){
            return null;
        }
        
        public String getActividadDepoAsociadaClase(String nomClase, String insti){
            return null; 
        }
        
        public DtActividadDeportiva getDtActividadDepo(String nomActi){
            return null;
        }
        
        public DtClase getDtClase(String nomClase){
            return null;
        }
}
