package logica.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import logica.datatypes.*;
import logica.usuario.Usuario;

public interface IControlador {
	
	public void initConnection();
	
	public void closeConnection();

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac);
	
	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac, 
			String institucion, String descripcion, String biografia, String sitioWeb);

	public ArrayList<DtUsuario> listarUsuarios();

	public void modificarDatos(String nickname, String nombre, String apellido, LocalDate fechaNac);

	public void modificarDatos(String nickname, String nombre, String apellido, LocalDate fechaNac, String institucion,
			String descripcion, String biografia, String sitioWeb);

	//CU Consulta de cuponeras de actividades deportivas
	public ArrayList<String> listaCuponerasRegistradas();
	
	public DtCuponera seleccionCuponera(String nombreCup);
	
	public DtActividadDeportiva seleccionActividad(String nombreAct);
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL);



	//	public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo,
	//	LocalDateTime fechaAlta);

	public void altaActividadDepo(
			String nombreActividad, String nombreInsti, String desc, 
			float dura, float costo, LocalDateTime fechaAlta);

	public void altaCuponera(String nombreCup, String descripcion, LocalDate _fechaInicio, LocalDate _fechaFin,
			LocalDate fechaFin, float descuento);
	public void registroDictadoClase(String pNombreActividad, String pNombreClase, DtUsrKey socioKey);
        
    //Operaciones AgregarActividadDeportivaCuponera--------------------------------------------------------------------
    public ArrayList<DtCuponera> ListarCuponeras();
    
    //public ArrayList<DtInstitucion> ListarInstituciones();
    
    public ArrayList<String> getNombreCuponeras();
    public ArrayList<String> getActisDeCuponera(String nombreCup);
    public void agregarActividadCuponera(String nombreCup,String nombreActi,int cantClases);
    //-----------------------------------------------------------------------------------------------------------------
    //Operaciones ConsultaUsuario--------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    public ArrayList<String> getNombreInstituciones();

    public ArrayList<String> consultarActividadDepo(String nombreInsti);
    
    public ArrayList<String> consultarClases(String nombreActividad);
    
    public String[] getUnaClase(String nombreClase);
    
    public ArrayList<DtUsrKey> consultarProfe(String nombreInsti);
    
    public void darAltaClase(String nombreInsti,String nombreActiDepo,
    		String nombreClase,LocalDateTime fechaInicio,DtUsrKey profeKey ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta);
    public void recordarInsti(String nombreInsti);
    
    public DtActividadDeportiva getDtActividadDeportiva(String nombreActi);
    
    public ArrayList<String> listaCuponerasRegistradasParaActiDepo(String nombreActi);
    
    public ArrayList<String> getClasesPorActiDepo(String nombreActi);
    
    public ArrayList<String> getClasesVigentesPorActiDepo(String nombreActi);
    
    public ArrayList<String> getSociosHabilitados(String nombreClase);
    
    public DtCuponera getDtCuponera(String nombreCupo);
    
    public DtClase getDtClaseXInsti(String nombreInsti,String nombreActi, String nombreClase);
    
    public Usuario getUsuario(DtUsrKey UsrKey);
    
    public ArrayList<String> getClaseRegistradaSocio(DtSocio socio);
    
    public String getActividadDepoAsociadaClase(String nomClase, String insti);
    
    public DtActividadDeportiva getDtActividadDepo(String nomActi);
    
    public DtClase getDtClase(String nomClase);
    
    public HashMap<String, ArrayList<Object>> getHashInstisAndProfes();
    
    public DtInstitucion getDtInsti(String nombreInsti);
    
    public HashMap<String,ArrayList<DtActividadDeportiva>> getHashInstisAndDtActis();
    
    public void altaCategoria(String nomCategoria);

}
