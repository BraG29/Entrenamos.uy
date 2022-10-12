package logica.controlador;
import logica.clase.Clase;
import logica.cuponera.Cuponera;

import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.time.LocalDate;

import logica.institucion.Institucion;
import logica.institucion.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;
import javax.persistence.Query;
//import javax.persistence.


import org.hibernate.jpa.internal.util.PessimisticNumberParser;
//import org.hibernate.mapping.List;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

//import com.mysql.cj.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import logica.clase.Registro;

import logica.institucion.Institucion;
import logica.usuario.Profesor;
import logica.usuario.Socio;
import logica.usuario.Usuario;
import logica.cuponera.Cuponera;
import logica.datatypes.*;
import logica.institucion.ActividadDeportiva;
import logica.institucion.Institucion;

public class Controlador implements IControlador {
	
	private String nombreCup;
	//private Usuario uRecordado;
	private Institucion instiRecordada;
	//en menu  principal hay un ejemplo de instancia de entity manager
	private EntityManagerFactory emf;
        
	private static Controlador instance;

	private void Controlador() {
	}
    
	
	public void initConnection(){
		this.emf = Persistence.createEntityManagerFactory("PersistenceApp");
	}
	
	public void closeConnection(){
		this.emf.close();
	}

	public static Controlador getInstance() {
		if (instance == null)
			instance = new Controlador();
		return instance;
	}
	
	public void guardarImagen(File img, String nombre, String folder) {
		String rutaDir = System.getProperty("user.dir");//llega hasta el proyecto
		try {
			Files.copy(
					Paths.get(img.getPath()),
					Paths.get(rutaDir+"/src/"+folder+"/"+"."+nombre),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IllegalArgumentException("No se ha podido guardar la imagen");
		}
	}
	
	public void altaUsuario(String nick, String nombre, String apellido, String email, String pass, LocalDate fechaNac, File img) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Socio s = new Socio(nick, apellido, email, pass, nombre, fechaNac);
			em.persist(s);
			em.flush();
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		guardarImagen(img, nick, "imgUsers");
		em.clear();
		em.close();
	}

	public void altaUsuario(String nick, String nombre, String apellido, String email, String pass, LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb, File img) {
		EntityManager em = emf.createEntityManager();
		try {
			Institucion i = em.find(Institucion.class, institucion);
			if (i == null) {
				throw new IllegalArgumentException("No existe la institucion");
			}
			Profesor p =
					new Profesor(nick, apellido, email, pass, nombre, fechaNac, biografia, descripcion, sitioWeb, i);
			em.getTransaction().begin();
			em.persist(p);
			em.flush();
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		guardarImagen(img, nick, "imgUsers");
		em.clear();
		em.close();
	}

	public ArrayList<DtUsuario> listarUsuarios() {
		EntityManager em = emf.createEntityManager();
		ArrayList datosUsr = new ArrayList<DtUsuario>();
		DtUsuario dtU = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> rootUsr = cq.from(Usuario.class);
		cq.select(rootUsr);
		List usuarios = em.createQuery(cq).getResultList();
		
		for(int i = 0; i < usuarios.size(); i++) {
			Usuario u = (Usuario) usuarios.get(i);
			
			if(u instanceof Profesor) {
				Profesor p = (Profesor)u;
				dtU = p.getDatosProfe();
			}else {
				Socio s = (Socio)u;
				dtU = s.getDatosSocio();
			}
			datosUsr.add(dtU);
		}
		em.clear();
		em.close();
		return datosUsr;
	}

	public void modificarDatos(String nickname, String nombre,String apellido,LocalDate fechaNac) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<Socio> cu = cb.createCriteriaUpdate(Socio.class);
			Root<Socio> rootSocio = cu.from(Socio.class);
			cu.set(rootSocio.get("nombre"), nombre);
			cu.set(rootSocio.get("apellido"), apellido);
			cu.set(rootSocio.get("fechaNac"), fechaNac);
			cu.where(cb.equal(rootSocio.get("nickname"), nickname));
			em.createQuery(cu).executeUpdate();
			//em.flush();
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
		}
		em.clear();
		em.close();
	}
	
	public void modificarDatos(
			String nickname, String nombre,String apellido,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<Profesor> cu = cb.createCriteriaUpdate(Profesor.class);
			Root<Profesor> rootProfesor = cu.from(Profesor.class);
			Institucion nuevaInst = em.find(Institucion.class, institucion);
			if(nuevaInst == null) {
				throw new IllegalArgumentException("La institución no existe");
			}
			cu.set(rootProfesor.get("nombre"), nombre);
			cu.set(rootProfesor.get("apellido"), apellido);
			cu.set(rootProfesor.get("fechaNac"), fechaNac);
			cu.set(rootProfesor.get("institucion"), nuevaInst);
			cu.set(rootProfesor.get("biografia"), biografia);
			cu.set(rootProfesor.get("descripcion"), descripcion);
			cu.set(rootProfesor.get("sitioWeb"), sitioWeb);
			cu.where(cb.equal(rootProfesor.get("nickname"), nickname));
			em.createQuery(cu).executeUpdate();
			//em.flush();
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
		}
		em.clear();
		em.close();
	}
	
	//CU Consulta de cuponeras de actividades deportivas
	public ArrayList<String> listaCuponerasRegistradas() {
		ArrayList<String> listaCuponeras = new ArrayList<String>();
		EntityManager em = emf.createEntityManager();
		ArrayList<String> consultaCuponera = null;
		try {
			em.getTransaction().begin();
			consultaCuponera = (ArrayList<String>) em.createQuery("SELECT nombreCup FROM Cuponera").getResultList();//resultado = nombre
		}catch (Exception ex) {
			if (em != null) {
				em.getTransaction().rollback();
			}
		}
		for (int i = 0; i < consultaCuponera.size(); i++) {//itero y agrego nombres a la lista que voy a retornar ekisde
			String nombresCuponeras = (String) consultaCuponera.get(i); //obtengo el nombre en el q estoy parado casteo a string xq consulta es de tipo List
			listaCuponeras.add(nombresCuponeras);//agrego a la lista
		}
		return listaCuponeras;
	}
	
	public ArrayList<String> listaCuponerasRegistradasParaActiDepo(String nombreActi) {
		
		EntityManager em = emf.createEntityManager();
		ArrayList<String> listaCuponeras = new ArrayList<String>();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class,nombreActi);
		listaCuponeras = acti.getNombreCupo();
		
		//listaCuponeras.addAll(em.createNativeQuery("SELECT nom_cuponera FROM Actividad_Cuponera WHERE nom_actividad = " + "'" + nombreActi + "'").getResultList()) ;
//		try {
//			//em.getTransaction().begin();
//			
//		}catch (Exception ex) {
//			if (em != null) {
//				em.getTransaction().rollback();
//			}
//		} finally {
//			//em.close();
//		}
		
		//resultado = nombre
		return listaCuponeras;
	}

	public DtCuponera seleccionCuponera(String nombreCup) {
               
		EntityManager em = emf.createEntityManager();
		Cuponera cup = null;
		DtCuponera cupData = null;
		try {
			em.getTransaction().begin();        
			cup = em.find(Cuponera.class, nombreCup); //busco cuponera seleccionada  
			
			if(cup == null){
				throw new Exception("La cuponera seleccionada no existe");
			}		
			cupData = cup.getData();
			return cupData;		
		}catch (Exception ex) {
			if (em != null) {
                em.getTransaction().rollback();
			}
		}
		return cupData;
	}

	public DtActividadDeportiva seleccionActividad(String nombreAct) {
		
		ActividadDeportiva act = null;
		DtActividadDeportiva dataAct = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			act = em.find(ActividadDeportiva.class, nombreAct);
			if(act == null){
				throw new Exception("La actividad seleccionada no existe");
			}
			dataAct = act.getDTActividadDeportiva();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
		em.clear();
		em.close();
		return dataAct;
	}
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL) {
		
		EntityManager em = emf.createEntityManager();

		try {
			Institucion existe = em.find(Institucion.class,nombreInst); //devuelve null si no existe
			if(existe != null) {
				throw new Exception("La institución ingresada ya existe");
			}
			em.getTransaction().begin();
			Institucion inst = new Institucion(nombreInst, descripcion, URL);
			inst.setNombreInst(nombreInst);
			inst.setDescripcion(descripcion);
			inst.setInstURL(URL);
			em.persist(inst);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			em.clear();
			em.close();
		}

	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDate fechaIni, LocalDate fechaFin,
			LocalDate fechaAlta, float descuento) {

		EntityManager em = emf.createEntityManager();
		try {
			//initConnection(); Esto solo lo tiene que manejar el menu Principal
			em.clear();
			em.getTransaction().begin();
			Cuponera nuevaCuponera = new Cuponera(nombreCup, descripcion, fechaIni, fechaFin, descuento, fechaAlta, 0);
			nuevaCuponera.setNombreCup(nombreCup);
			nuevaCuponera.setDescripcion(descripcion);
			nuevaCuponera.setFechaInicio(fechaIni);
			nuevaCuponera.setFechaFin(fechaFin);
			nuevaCuponera.setDescuento(descuento);
			nuevaCuponera.setFechaAlta(fechaAlta);
			nuevaCuponera.setCantClases(0);
			em.persist(nuevaCuponera);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (em != null) {
				em.getTransaction().rollback();
			}
			ex.printStackTrace();
		} finally {
			em.clear();
			em.close();
		}

	}
	            
    public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta,ArrayList<String> catSeleccionadas){
    	EntityManager em = emf.createEntityManager();
        Institucion insti = em.find(Institucion.class, nombreInsti);
        ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActividad);
        
        
        if(acti != null) {
        	throw new IllegalArgumentException("Ya existe una Actividad Deportiva con ese nombre");
        }
        if(insti == null) {
        	throw new IllegalArgumentException("No existe la institucion");
        }
        
        ArrayList<Categoria> arrCat = new ArrayList<>();
        
        for(int i = 0; i < catSeleccionadas.size();i++) {
        	arrCat.add(em.find(Categoria.class, catSeleccionadas.get(i)));
        }
        
        try{
        	em.getTransaction().begin();
            acti = insti.darAltaActividadDeportiva(nombreActividad, nombreInsti, desc, dura, costo, fechaAlta,arrCat);
            em.persist(acti);
            em.getTransaction().commit();
        }catch(Exception e){
        	em.getTransaction().rollback();
            throw new IllegalArgumentException(e.getMessage());
        }
		em.clear();
		em.close(); 
    }
        
    public ArrayList<String> getNombreInstituciones(){
    	EntityManager em = emf.createEntityManager();
        ArrayList<String> listaADevolver = new ArrayList<String>();
        listaADevolver.addAll(em.createQuery("select nombreInst from Institucion").getResultList());
		em.clear();
		em.close();
        return listaADevolver;
    }
                    
    public ArrayList<String> consultarActividadDepo(String nombreInsti){//ARREGLAR
    	EntityManager em = emf.createEntityManager();
        ArrayList<String> listaADevolver = new ArrayList<String>();
        listaADevolver.addAll(em.createQuery("select a.nombreAct from ActividadDeportiva a WHERE institucion = " + "'" + nombreInsti + "'").getResultList());
		em.clear();
		em.close();  
        return listaADevolver;
    }
        
        
    public ArrayList<String> consultarClases(String nombreActividad){
    	EntityManager em = emf.createEntityManager();
        ArrayList<String> listaADevolver = new ArrayList<String>();            
        listaADevolver.addAll(
        		em.createQuery("select nombre from Clase c where actividad_deportiva = '" + nombreActividad + "'").getResultList());
		em.clear();
		em.close();
        return listaADevolver;
    }
    
    public String[] getUnaClase(String nombreClase){
    	EntityManager em = emf.createEntityManager();
    	String[] listaADevolver = new String[6];
    	String urlDeLaClase = "";
    	String cantMaxDeLaClase = "";
    	String cantMinDeLaClase = "";
    	String horaIniDeLaClase = "";
    	String fechaDeLaClase = "";
    	String registroDeLaClase = "";
        
        urlDeLaClase = em.createQuery("select URL from Clase c where nombre = '" + nombreClase + "'").toString();
        cantMaxDeLaClase = em.createQuery("select cant_maxima from Clase c where nombre = '" + nombreClase + "'").toString();
        cantMinDeLaClase = em.createQuery("select cant_minima from Clase c where nombre = '" + nombreClase + "'").toString();
        horaIniDeLaClase = em.createQuery("select hora_inicio from Clase c where nombre = '" + nombreClase + "'").toString();
        fechaDeLaClase = em.createQuery("select fecha from Clase c where nombre = '" + nombreClase + "'").toString();
        registroDeLaClase = em.createQuery("select fecha_registro from Clase c where nombre = '" + nombreClase + "'").toString();
        
        listaADevolver[0] = urlDeLaClase;
        listaADevolver[1] = cantMaxDeLaClase;
        listaADevolver[2] = cantMinDeLaClase;
        listaADevolver[3] = horaIniDeLaClase;
        listaADevolver[4] = fechaDeLaClase;
        listaADevolver[5] = registroDeLaClase;
		em.clear();
		em.close();
              
        return listaADevolver;
    }
        
    public void registroDictadoClase(String pNombreActividad, String pNombreClase, DtUsrKey socioKey) {
    	EntityManager em = emf.createEntityManager();
    	Usuario keyUsr = new Usuario(socioKey.nickname, socioKey.email);        	
    	ActividadDeportiva actividadDeportivaActual = em.find(ActividadDeportiva.class, pNombreActividad);
    	Clase c = actividadDeportivaActual.getClase(pNombreClase);
    	Socio socioActual = (Socio) em.find(Usuario.class, keyUsr);
    	Float costo = actividadDeportivaActual.getCosto();
    	LocalDate fecha = LocalDate.now();
		socioActual.registrarAClase(c, fecha, costo);
		em.clear();
		em.close();
    }
    
  //------------------------------------------------------------------------------------------------------------------------------------------
    //Operaciones AgregarActividadDeportivaCuponera--------------------------------------------------------------------
    public ArrayList<DtCuponera> ListarCuponeras(){//unused
        //call entity manager and do the query
        EntityManager em = emf.createEntityManager();
        
        List<Cuponera> list = em.createQuery("SELECT c FROM Cuponera c").getResultList();
        
        ArrayList<DtCuponera> l = null;
        
        for(Cuponera cup : list)
        {
            Collection<String> actividades = null;
            Collection<ActividadDeportiva> Actis = cup.getActividades();
            for(ActividadDeportiva a : Actis)
            {
                actividades.add(a.getNombreAct());
            }
            DtCuponera DtCup = new DtCuponera(cup.getNombreCup(),cup.getDescripcion(),cup.getFechaInicio(),cup.getFechaFin(),cup.getDescuento(),cup.getFechaAlta(),cup.getCantClases(),actividades);
            l.add(DtCup);
        }
		em.clear();
		em.close();
          
        return l;
    }
    
    
//------------------------------------------------------------------------------------------------------------------------------------------        
    public ArrayList<String> getNombreCuponeras(){
        
        ArrayList<String> listaADevolver = new ArrayList<String>();
        
        EntityManager em = emf.createEntityManager();
        
        listaADevolver.addAll(em.createQuery("select c.nombreCup from Cuponera c").getResultList());

		em.clear();
		em.close();
        return listaADevolver;
        
    }
    
    public ArrayList<String> getActisDeCuponera(String nombreCup){
        ArrayList<ActividadDeportiva> listaActis= new ArrayList<>();
        ArrayList<String> listaADevolver = new ArrayList<>(); 
        String findQuery = "select c.actividades from Cuponera c WHERE c.nombreCup = :nombre";
        EntityManager em = emf.createEntityManager();
        
        Query find = em.createQuery(findQuery);
        find.setParameter("nombre",nombreCup);
        listaActis.addAll(find.getResultList());
         
        for(ActividadDeportiva actis : listaActis){
            System.out.println(actis.getNombreAct());
            listaADevolver.add(actis.getNombreAct());
        }
		em.clear();
		em.close();
        
        return listaADevolver;
    }
    
    public void agregarActividadCuponera(String nombreCup,String nombreActi,int cantClases){
    	
    	EntityManager em = emf.createEntityManager();
    	try {
    		em.clear();
    		em.getTransaction().begin();
            Cuponera cup = em.find(Cuponera.class, nombreCup);
            ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
	        if(cup == null || acti == null) {
	        	throw new IllegalArgumentException("Actividad deportiva o cuponera invalido");
	        }           
    		cup.aniadirAD(acti, cantClases); //ya no vamos a pasar Entity manager ni transacciones
            acti.agregarCup(cup);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
			
		}catch (IllegalArgumentException e) {
			throw e;
		}
    }
    
    public Usuario getUsuario(DtUsrKey usrKey){
    	
    	EntityManager em = emf.createEntityManager();
        Usuario Usr = em.find(Usuario.class, new Usuario(usrKey.nickname,usrKey.email));
        em.clear();
        em.close();
        return Usr;
        
    }
    
    //-----------------------------------------------------------------------------------------------------------------
    
    
    public ArrayList<DtUsrKey> consultarProfe(String nombreInsti){
        ArrayList<String> listaNick = new ArrayList<String>();
        ArrayList<String> listaEmails = new ArrayList<String>();
        
        EntityManager em = emf.createEntityManager();
        
        listaNick.addAll(em.createQuery("select p.nickname from Profesor p WHERE institucion =" + "'" + nombreInsti + "'").getResultList());
        listaEmails.addAll(em.createQuery("select p.email from Profesor p WHERE institucion =" + "'" + nombreInsti + "'").getResultList());
        
        ArrayList<DtUsrKey> listaADevolver = new ArrayList<DtUsrKey>();
        for(int i = 0; i < listaNick.size();i++) {
        	
        	listaADevolver.add(new DtUsrKey(listaNick.get(i),listaEmails.get(i)));
        	//listaADevolver.add(listaNick.get(i) + " / " + listaEmails.get(i));
        }
        
        //System.out.println(list.toString());
		em.clear();
		em.close();
        return listaADevolver;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------       
    public void darAltaClase(String nombreInsti,String nombreActiDepo, String nombreClase,LocalDateTime fechaInicio, DtUsrKey profeKey ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){

    	EntityManager em = emf.createEntityManager();
    	
        Profesor profe = em.find(Profesor.class, new Usuario(profeKey.nickname,profeKey.email));
        ActividadDeportiva actiDepo = em.find(ActividadDeportiva.class, nombreActiDepo);
        
        try{
        	em.getTransaction().begin();
            Clase claseDictada = profe.darAltaClaseProfe(nombreInsti, nombreClase, fechaInicio , sociosMin, sociosMax, URL,fechaAlta, actiDepo);
            em.persist(claseDictada);
            actiDepo.darAltaClaseActi(claseDictada);
            em.getTransaction().commit();
        }catch(Exception e){
        	em.getTransaction().rollback();
            throw new IllegalArgumentException(e.getMessage());
        } 
		em.clear();
		em.close();  
    }
//------------------------------------------------------------------------------------------------------------------------------------------ 
        
	public void recordarInsti(String nombreInsti) {
		  
		EntityManager em = emf.createEntityManager();
		this.instiRecordada = em.find(Institucion.class,nombreInsti);
		em.clear();
		em.close();
		System.out.println(this.instiRecordada.getNombreInst());
	}
      
//------------------------------------------------------------------------------------------------------------------------------------------ 
	public DtActividadDeportiva getDtActividadDeportiva(String nombreActi) {
		EntityManager em = emf.createEntityManager();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
		em.clear();
		em.close();
		return acti.getDTActividadDeportiva();
	}
      
	public ArrayList<String> getClasesPorActiDepo(String nombreActi){
		EntityManager em = emf.createEntityManager();
		ArrayList<String> listaADevolver = new ArrayList<String>();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
		listaADevolver = acti.getNombreClases();
		em.clear();
		em.close();
		return listaADevolver;
	}
  
	public ArrayList<String> getClasesVigentesPorActiDepo(String nombreActi) {
		EntityManager em = emf.createEntityManager();
		ArrayList<String> listaADevolver = new ArrayList<String>();
		ArrayList<String> listaDeClases = new ArrayList<String>();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
		listaDeClases = acti.getNombreClases();
		for (int i = 0; i < listaDeClases.size(); i++) {
			listaADevolver.addAll(em.createQuery("select c.nombreClase from Clase c where cant_minima < cant_maxima AND nombre = '" + listaDeClases.get(i) + "'").getResultList());
		}
		em.clear();
		em.close();
		return listaADevolver;
	}
  
	public ArrayList<String> getSociosHabilitados(String nombreClase) {
		EntityManager em = emf.createEntityManager();
		ArrayList<String> listaADevolver = new ArrayList<String>();
		listaADevolver.addAll(em.createQuery("select s.nombre from Socio s").getResultList());
		em.clear();
		em.close();
		return listaADevolver;
	}
  
	public DtCuponera getDtCuponera(String nombreCupo){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Cuponera cupo = em.find(Cuponera.class, nombreCupo);
		DtCuponera dtCupo = cupo.getData();
		em.clear();
		em.close();
		return dtCupo;
	}
  
	public DtClase getDtClaseXInsti(String nombreInsti,String nombreActi, String nombreClase) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Antes de buscar la Insti para la Clase");
		Institucion insti = em.find(Institucion.class, nombreInsti);
		System.out.println("Despues de buscar la Insti para la Clase");
		    	  
		DtClase claseADevolver = insti.getDtClaseXActiDepo( nombreActi, nombreClase, em);
		em.clear();
		em.close();
		return claseADevolver;
	}
      
	public ArrayList<String> getClaseRegistradaSocio(DtSocio socio){
		
		EntityManager em = emf.createEntityManager();
		Usuario s = em.find(Usuario.class, new Usuario(socio.nickname,socio.email));
		ArrayList<String> output = new ArrayList<>();
		if(s != null){        
			Collection<Registro> registros = ((Socio)s).getRegistro();
			for(Registro r : registros){
				output.add(r.getClaseAsociada().getNombreClase());
			}
		}
		em.clear();
		em.close();
		return output;
	}
      
	public String getActividadDepoAsociadaClase(String nomClase, String nomInsti){

		EntityManager em = emf.createEntityManager();
		Institucion inst = em.find(Institucion.class, nomInsti);
		String nombreAct = null;
		if(inst != null){
		      
			ArrayList<String> actiDepos = inst.getActividadesDeportivas();
			
			for(String s : actiDepos){
			      
				ActividadDeportiva acti = em.find(ActividadDeportiva.class, s);
				if(acti != null){
				      
					ArrayList<String> clasesDeActi = acti.getNombreClases();
					  
					for(String str : clasesDeActi){
						boolean isAsosiated = nomClase.equals(str);
						if(isAsosiated == true)
						{
							nombreAct = acti.getNombreAct();
						}
					}
				      
				}
			      
			}
			      
		}
		em.clear();
		em.close();
		return nombreAct; 
	}
      
	public DtActividadDeportiva getDtActividadDepo(String nomActi){
		EntityManager em = emf.createEntityManager();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class,nomActi);
		DtActividadDeportiva datosAC = null;
		if(acti != null){
			datosAC = acti.getDTActividadDeportiva();
		}
		em.clear();
		em.close();
		return datosAC;
	}
	  
	public DtClase getDtClase(String nomClase){ 
		EntityManager em = emf.createEntityManager(); 
		Clase c = em.find(Clase.class, nomClase);
		DtClase datosClase = null;
		if(c != null){
			datosClase = c.getData();
		}
		return datosClase;
	}
	
	public HashMap<String, ArrayList<Object>> getHashInstisAndProfes(){
   	  
   	   HashMap<String, ArrayList<Object>> hashADevolver = new HashMap<>();
   	   ArrayList<String> listaDeInstis = new ArrayList<>();
   	  
   	   listaDeInstis.addAll(this.getNombreInstituciones());
   	  
   	   for(int i = 0; i < listaDeInstis.size(); i++) {
   		  
   		   ArrayList<Object> listaDeListas = new ArrayList<>();//creo el ArrayList de objetos genericos.
   		   listaDeListas.add(this.consultarActividadDepo(listaDeInstis.get(i)));//a la primera posicion le paso un ArrayList con todos los nombres de las ActisDepo.
   		   listaDeListas.add(this.consultarProfe(listaDeInstis.get(i)));//a la 2nda posicion le paso un ArrayList de DtUsrKey con todos los profes de esta Insti.
   		  
   		   hashADevolver.put(listaDeInstis.get(i), listaDeListas);//armo el hashmap
   	   }
   	   return hashADevolver;
   	   }
     
     
     public DtInstitucion getDtInsti(String nombreInsti) {
    	 EntityManager em = emf.createEntityManager();
    	 return em.find(Institucion.class, nombreInsti).getDTInstitucion();
     }
     
     
     public HashMap<String,ArrayList<DtActividadDeportiva>> getHashInstisAndDtActis() {
    	 
    	 HashMap<String,ArrayList<DtActividadDeportiva>> hashADevolver = new HashMap<>();
   	  
   	  	 ArrayList<String> listaNomInstis = this.getNombreInstituciones();
   	  
   	  	 for(int i = 0; i < listaNomInstis.size();i++) {
   		  
   	  		 ArrayList<String> listaActis = this.consultarActividadDepo(listaNomInstis.get(i));
   	  		 ArrayList<DtActividadDeportiva> listaDtActi = new ArrayList<>();
   	  		 
	   		 for(int c = 0; c < listaActis.size();c++) {
	   			 listaDtActi.add(this.getDtActividadDepo(listaActis.get(c)));
	   		 }
	   	 hashADevolver.put(listaNomInstis.get(i),listaDtActi);
   	  	 }
   	  	 return hashADevolver;
	}
     
     
    //CU Aceptar/Rechazar actividad deportiva
     public ArrayList<String> listaActividadesIngresada(){
	  EntityManager em = emf.createEntityManager();
		ArrayList<String> listaActividad = new ArrayList<String>();
 		ArrayList<String> consultaActividad = new ArrayList<String>();
 		try {
 			em.getTransaction().begin();
 			consultaActividad = (ArrayList<String>) em.createQuery("SELECT nombreAct FROM ActividadDeportiva where Estado = 0 ").getResultList();//nombre Actividades con estado Ingresada
 		}catch (Exception ex) {
 			if (em != null) {
 				em.getTransaction().rollback();
 			}
 		}
 		
 		for (int i = 0; i < consultaActividad.size(); i++) {//itero y agrego nombres a la lista que voy a retornar ekisde
 			String nombresActividadesIngresadas = (String)consultaActividad.get(i);
 			listaActividad.add(nombresActividadesIngresadas);//agrego a la lista
 		}
 		
 		em.clear();
		em.close();
		
 		return listaActividad;
    	 
     }
    
     public void rechazoAceptoActividad(String nombreActividad, int Estado) {
    	EntityManager em = emf.createEntityManager();
		try {
			ActividadDeportiva act = em.find(ActividadDeportiva.class, nombreActividad);
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<ActividadDeportiva> cu = cb.createCriteriaUpdate(ActividadDeportiva.class);
			Root<ActividadDeportiva> rootAct = cu.from(ActividadDeportiva.class);
			cu.set(rootAct.get("estadoActual"), Estado);
			cu.where(cb.equal(rootAct.get("nombreAct"), nombreActividad));
			em.createQuery(cu).executeUpdate();
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
		}
		em.clear();
		em.close();
     }

     
     //CU seguir usuario
     public void followUsr(String seguidor, String seguido){}
     
     //CU dejar de seguir usuario
     public void unfollowUsr(String seguidor, String seguido){}
     
     public void altaCategoria(String nomCat) {
    	 EntityManager em = emf.createEntityManager();
    	 
    	 try {
    		 Categoria Cat = em.find(Categoria.class, nomCat);
    		 
    		 if(Cat != null) {
    			 throw new IllegalArgumentException("La Categoría ya existe");
        	 }
    	 }
    	 catch(Exception e) {
    		 em.clear();
    		 em.close();
    		 throw e;
    	 }
    	 
    	 
    	 try{
        		 em.getTransaction().begin();
        		 
        		 Categoria catAAniadir = new Categoria(nomCat);
        		 em.persist(catAAniadir);
        		 
        		 em.getTransaction().commit();
        		 
    	 } catch (Exception ex) {
 			em.getTransaction().rollback();
 			ex.printStackTrace();
 		} finally {
 			em.clear();
 			em.close();
 		}
     }
     
     public ArrayList<String> getAllCategorias(){
    	 ArrayList<String> arrayADevolver = new ArrayList<>();
    	 EntityManager em = emf.createEntityManager();
    	 
    	 arrayADevolver.addAll(em.createQuery("select c.nombreCat from Categoria c").getResultList());
    	 
    		em.clear();
    		em.close(); 
    	 
    	 return arrayADevolver;
     }
     
     public ArrayList<String> getCategoriaXActi(String actiDepo){
    	 ArrayList<String> arrADevolver = new ArrayList<>();
    	 EntityManager em = emf.createEntityManager();
    	 
    	 ActividadDeportiva acti = em.find(ActividadDeportiva.class, actiDepo);
    	 arrADevolver.addAll(acti.getDTActividadDeportiva().categorias);
    	 
    	 em.clear();
    	 em.close();
    	 
    	 return arrADevolver; 
    	 
     }
}
