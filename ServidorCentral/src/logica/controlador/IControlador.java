package logica.controlador;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.spi.PersistenceProvider;

import logica.datatypes.*;
import logica.usuario.Usuario;

public interface IControlador {

    public void initConnection();

    public void closeConnection();

    public void altaUsuario(String nick, String nombre, String apellido, String email, String pass, LocalDate fechaNac,
            File img);

    public void altaUsuario(String nick, String nombre, String apellido, String email, String pass, LocalDate fechaNac,
            String institucion, String descripcion, String biografia, String sitioWeb, File img);

    public ArrayList<DtUsuario> listarUsuarios();

    public DtUsrKey consultaUsuario(String credencial);

    public void modificarDatos(String nickname, String nombre, String apellido, LocalDate fechaNac, File img);

    public void modificarDatos(String nickname, String nombre, String apellido, LocalDate fechaNac, String institucion,
            String descripcion, String biografia, String sitioWeb, File img);

    // CU Consulta de cuponeras de actividades deportivas
    public ArrayList<String> listaCuponerasRegistradas();

    public DtCuponera seleccionCuponera(String nombreCup);

    public DtActividadDeportiva seleccionActividad(String nombreAct);

    // CU alta institucion deportiva
    public void altaInstitucion(String nombreInst, String descripcion, String URL);

    // public void altaActividadDepo(String nombreActividad, String nombreInsti,
    // String desc, float dura, float costo,
    // LocalDateTime fechaAlta);

    public void altaActividadDepo(
            String nombreActividad, String nombreInsti, String desc,
            float dura, float costo, LocalDateTime fechaAlta, ArrayList<String> catSeleccionadas);

    public void altaCuponera(String nombreCup, String descripcion, LocalDate _fechaInicio, LocalDate _fechaFin,
            LocalDate fechaFin, float descuento);

    public ArrayList<String> listaCategorias();

    public void registroDictadoClase(String pNombreActividad, String pNombreClase, DtUsrKey socioKey);

    // Operaciones
    // AgregarActividadDeportivaCuponera--------------------------------------------------------------------
    public ArrayList<DtCuponera> ListarCuponeras();

    // public ArrayList<DtInstitucion> ListarInstituciones();

    public ArrayList<String> getNombreCuponeras();

    public ArrayList<String> getActisDeCuponera(String nombreCup);

    public void agregarActividadCuponera(String nombreCup, String nombreActi, int cantClases);
    // -----------------------------------------------------------------------------------------------------------------
    // Operaciones
    // ConsultaUsuario--------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    public ArrayList<String> getNombreInstituciones();

    public ArrayList<String> consultarActividadDepo(String nombreInsti);

    public ArrayList<String> consultarClases(String nombreActividad);

    public String[] getUnaClase(String nombreClase);

    public ArrayList<DtUsrKey> consultarProfe(String nombreInsti);

    public void darAltaClase(String nombreInsti, String nombreActiDepo,
            String nombreClase, LocalDateTime fechaInicio, DtUsrKey profeKey, int sociosMin, int sociosMax, String URL,
            LocalDate fechaAlta);

    public void recordarInsti(String nombreInsti);

    public DtActividadDeportiva getDtActividadDeportiva(String nombreActi);

    public ArrayList<String> listaCuponerasRegistradasParaActiDepo(String nombreActi);

    public ArrayList<String> getClasesPorActiDepo(String nombreActi);

    // public ArrayList<String> getClasesVigentesPorActiDepo(String nombreActi);

    public ArrayList<DtSocio> getSocios();

    public DtCuponera getDtCuponera(String nombreCupo);

    public DtClase getDtClaseXInsti(String nombreInsti, String nombreActi, String nombreClase);

    public Usuario getUsuario(DtUsrKey UsrKey);

    public ArrayList<String> getClaseRegistradaSocio(DtSocio socio);

    public String getActividadDepoAsociadaClase(String nomClase, String insti);

    // public DtActividadDeportiva getDtActividadDepo(String nomActi);

    // public DtClase getDtClase(String nomClase);

    public HashMap<String, ArrayList<Object>> getHashInstisAndProfes();

    public DtInstitucion getDtInsti(String nombreInsti);

    public HashMap<String, DtInstitucion> getHashDtInstis();

    public void altaCategoria(String nomCategoria);

    public void guardarImagen(File img, String nombre, String folder);

    public ArrayList<String> getAllCategorias();

    // CU Aceptar/Rechazar actividad deportiva
    public ArrayList<String> listaActividadesIngresada();

    public void rechazoAceptoActividad(String nombreActividad, int Estado);

    // CU seguir usuario
    public void followUsr(DtUsrKey seguidor, DtUsrKey seguido);

    // CU dejar de seguir usuario
    public void unfollowUsr(DtUsrKey seguidor, DtUsrKey seguido);

    public ArrayList<String> getCategoriaXActi(String actiDepo);

}
