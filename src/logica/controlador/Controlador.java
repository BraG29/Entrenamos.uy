package logica.controlador;
import logica.clase.Clase;
import logica.cuponera.Cuponera;
import java.lang.management.GarbageCollectorMXBean;
import java.sql.SQLException;
import java.time.LocalDate;

import logica.institucion.Institucion;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
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
import java.util.List;
import javax.persistence.Query;

import logica.institucion.Institucion;
import logica.usuario.Profesor;
import logica.usuario.Socio;
import logica.usuario.Usuario;
import logica.cuponera.Cuponera;
import logica.datatypes.*;
import logica.institucion.ActividadDeportiva;
import logica.institucion.Institucion;

public class Controlador extends IControlador {
	
	private String nombreCup;
	private Usuario uRecordado;
	private Institucion instiRecordada;
	//en menu  principal hay un ejemplo de instancia de entity manager
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tran;

	public void initConnection(){
		this.emf = Persistence.createEntityManagerFactory("PersistenceApp");
		this.em = emf.createEntityManager();
		this.tran = em.getTransaction();
		this.tran.begin();
	}
	
	public void closeConnection(){
		this.em.close();
		this.emf.close();
	}

	
	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac, String imagen) {

		//EntityManager em = emf.createEntityManager();
		try {
			Socio s = new Socio(nick, apellido, email, nombre, fechaNac, imagen);
			em.persist(s);
			em.flush();
			tran.commit();
			System.out.println("Usuario creado");
		} catch (PersistenceException e) {
			tran.rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}

		}
		//em.close();
	}

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac,
			String imagen, String institucion, String descripcion, String biografia, String sitioWeb) {
		//EntityManager em = emf.createEntityManager();
		try {
			Institucion i = em.find(Institucion.class, institucion);
			if (i == null) {
				throw new IllegalArgumentException("No existe la institucion");
			}
			Profesor p = new Profesor(nick, apellido, email, nombre, fechaNac, imagen, biografia, descripcion, sitioWeb, i);
			em.persist(p);
			em.flush();
			tran.commit();
			System.out.println("Usuario creado");
		} catch (PersistenceException e) {
			tran.rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		//em.close();
	}

	public static Controlador getInstance() {
		if (instance == null)
			instance = new Controlador();
		return instance;
	}

	public ArrayList<DtUsrKey> listarUsuarios() {
		//EntityManager em = emf.createEntityManager();
		ArrayList listUsuarios = new ArrayList<DtUsrKey>();
		java.util.List listNickSocio = null;
		java.util.List listEmailSocio = null;
		java.util.List listNickProfe = null;
		java.util.List listEmailProfe = null;
		try {
			//tran.begin();
			listNickSocio = em.createQuery("SELECT nickname FROM Socio").getResultList();
			listEmailSocio = em.createQuery("SELECT email FROM Socio").getResultList();
			listNickProfe = em.createQuery("SELECT nickname FROM Profesor").getResultList();
			listEmailProfe = em.createQuery("SELECT email FROM Profesor").getResultList();
		}catch(PersistenceException e) {
			tran.rollback();
		}
		for(int i = 0; i < listNickSocio.size(); i++) {
			String nS = (String)listNickSocio.get(i);
			String eS = (String)listEmailSocio.get(i);
			DtUsrKey keySocio = new DtUsrKey(nS, eS);
			listUsuarios.add(keySocio);
		}
		for(int i = 0; i < listNickProfe.size(); i++) {
			String nP = (String)listNickProfe.get(i);
			String eP = (String)listEmailProfe.get(i);
			DtUsrKey keyProfe = new DtUsrKey(nP, eP);
			listUsuarios.add(keyProfe);
		}
		//em.close();
		return listUsuarios;
	}

	public DtUsuario getDatosUsuario(DtUsrKey usrKey) {
		//EntityManager em = emf.createEntityManager();
		Usuario u = null;
		try {
			//tran.begin();
			u = em.find(Usuario.class, new Usuario(usrKey.nickname,usrKey.email));
			this.uRecordado = u;
		} catch (PersistenceException e) {
			tran.rollback();
		}
		if(u instanceof Profesor) {
			Profesor p = (Profesor)u;
			DtUsuario dtP = p.getDatosProfe();
			//em.close();
			return dtP;
		}else {
			Socio s = (Socio)u;
			DtUsuario dtS = s.getDatosSocio();
			//em.close();
			return dtS;
		}
	}




	public void modificarDatos(String nombre,String apellido,LocalDate fechaNac, String imagen) {
		//EntityManager em = emf.createEntityManager();
		try {
			//tran.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<Socio> cu = cb.createCriteriaUpdate(Socio.class);
			Root<Socio> rootSocio = cu.from(Socio.class);
			cu.set(rootSocio.get("nombre"), nombre);
			cu.set(rootSocio.get("apellido"), apellido);
			cu.set(rootSocio.get("fechaNac"), fechaNac);
			cu.set(rootSocio.get("urlImagen"), imagen);
			cu.where(cb.equal(rootSocio.get("nickname"), this.uRecordado.getNickname()));
			em.createQuery(cu).executeUpdate();
			em.flush();
			tran.commit();
		}catch(PersistenceException e) {
			tran.rollback();
		}
	}
	public void modificarDatos(
			String nombre,String apellido,LocalDate fechaNac, String imagen,
			String institucion, String descripcion, String biografia, String sitioWeb) {
		
		//EntityManager em = emf.createEntityManager();
		try {
			//tran.begin();
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
			cu.set(rootProfesor.get("urlImagen"), imagen);
			cu.set(rootProfesor.get("institucion"), nuevaInst);
			cu.set(rootProfesor.get("biografia"), biografia);
			cu.set(rootProfesor.get("descripcion"), descripcion);
			cu.set(rootProfesor.get("sitioWeb"), sitioWeb);
			cu.where(cb.equal(rootProfesor.get("nickname"), this.uRecordado.getNickname()));
			em.createQuery(cu).executeUpdate();
			em.flush();
			tran.commit();
		}catch(PersistenceException e) {
			tran.rollback();
		}

	}
	//CU Consulta de cuponeras de actividades deportivas
	public ArrayList<String> listaCuponerasRegistradas() {
		
		ArrayList<String> listaCuponeras = new ArrayList<String>();
		//EntityManager em = emf.createEntityManager();
		java.util.List consultaCuponera = null;
		try {
			//tran.begin();
			consultaCuponera = em.createQuery("SELECT nombreCup FROM Cuponera").getResultList();//resultado = nombre
		}catch (Exception ex) {
			if (em != null) {
				tran.rollback();
			}
		} finally {
			//em.close();
		}
		for (int i = 0; i < consultaCuponera.size(); i++) {//itero y agrego nombres a la lista que voy a retornar ekisde
			String nombresCuponeras = (String) consultaCuponera.get(i); //obtengo el nombre en el q estoy parado casteo a string xq consulta es de tipo List
			listaCuponeras.add(nombresCuponeras);//agrego a la lista
		}
		return listaCuponeras;
	}
	
/*	
	public ArrayList<String> seleccionCuponera(String nombreCup) {
		
		EntityManager em = emf.createEntityManager();
		Cuponera cup = null;
		
		try {
			em.getTransaction().begin();
			cup = em.find(Cuponera.class, nombreCup); //busco cuponera seleccionada
			if(cup == null){
				throw new Exception("La cuponera seleccionada no existe");
			}
			cup.getData();
		}catch (Exception ex) {
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}
		
		//cup.getNombres(); //esto le paso al combobox?
		return null;
	}
	*/
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL) {

		//EntityManager em = emf.createEntityManager();

		try {
			Institucion existe = em.find(Institucion.class,nombreInst); //devuelve null si no existe
			if(existe != null) {
				throw new Exception("La institución ingresada ya existe");
			}
			//tran.begin();
			Institucion inst = new Institucion(nombreInst, descripcion, URL);
			inst.setNombreInst(nombreInst);
			inst.setDescripcion(descripcion);
			inst.setInstURL(URL);
			em.persist(inst);
			tran.commit();
		} catch (Exception ex) {
			if (em != null) {
				tran.rollback();
			}
			ex.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDate fechaIni, LocalDate fechaFin,
			LocalDate fechaAlta, float descuento) {


		//LocalDateTime fechaAlta = LocalDateTime.now();

		try {
			//tran.begin();
			Cuponera nuevaCuponera = new Cuponera(nombreCup, descripcion, fechaIni, fechaFin, descuento, fechaAlta, 0);
			nuevaCuponera.setNombreCup(nombreCup);
			nuevaCuponera.setDescripcion(descripcion);
			nuevaCuponera.setFechaInicio(fechaIni);
			nuevaCuponera.setFechaFin(fechaFin);
			nuevaCuponera.setDescuento(descuento);
			nuevaCuponera.setFechaAlta(fechaAlta);
			nuevaCuponera.setCantClases(0);
			em.persist(nuevaCuponera);
			tran.commit();
		} catch (Exception ex) {
			if (em != null) {
				tran.rollback();
			}
			ex.printStackTrace();
		} finally {
			//em.close();
		}

	}

	private static Controlador instance;

	private void Controlador() {
	}
        
        public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta){

            Institucion insti = em.find(Institucion.class, nombreInsti);
            
            if(insti != null){
                //hay que hacer try and catch
                try{
                    insti.darAltaActividadDeportiva(nombreActividad, nombreInsti, desc, dura, costo, fechaAlta, this.emf);
                }catch(Exception e){
                    throw new IllegalArgumentException(e.getMessage());
                }
                
            }else{
                //System.out.println("TODO MAL ANDA AMIGOOOOOOO");
                throw new IllegalArgumentException("No existe la institucion: " + nombreInsti);
                //excepción de que insti no existe
            }  
        }
        
        public ArrayList<String> getNombreInstituciones(){
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            //EntityManager em = emf.createEntityManager();
            
            //em.find(Institucion.class,);
            
            //List<Institucion> instis = em.createQuery("select i.nombreInst from Institucion i").getResultList();
            
            listaADevolver.addAll(em.createQuery("select i.nombreInst from Institucion i").getResultList());  
            
            return listaADevolver;
        }
        
        public ArrayList<String> consultarActividadDepo(String nombreInsti){//no se quién me toco la función, pero esto debe devolver las ACTIVIDADES DEPORTIVAS, algo OBVIO que dice en el mismo nombre de la funcion.
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            //EntityManager em = emf.createEntityManager();
            
            
            listaADevolver.addAll(em.createQuery("select a.nombreAct from ActividadDeportiva a WHERE insti_nombre = " + "'" + nombreInsti + "'").getResultList());  
      
            
            return listaADevolver;
        }
        
        
      //------------------------------------------------------------------------------------------------------------------------------------------
        //Operaciones AgregarActividadDeportivaCuponera--------------------------------------------------------------------
        public ArrayList<DtCuponera> ListarCuponeras(){
            //call entity manager and do the query
            //EntityManager em = emf.createEntityManager();
            
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
              
            return l;
        }
        
        
//------------------------------------------------------------------------------------------------------------------------------------------
        public ArrayList<DtInstitucion> ListarInstituciones(){
            ArrayList<DtInstitucion> l = new ArrayList<DtInstitucion>();
            return l;
        }
//------------------------------------------------------------------------------------------------------------------------------------------        
        public ArrayList<String> getNombreCuponeras(){
            
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            //EntityManager em = emf.createEntityManager();
            
            //listaADevolver.addAll(em.createQuery("select c.nombreCup from Cuponeras c").getResultList());  me tira error "cuponera no esta mapeada"
            
            return listaADevolver;
            
        }
        
//------------------------------------------------------------------------------------------------------------------------------------------
        
        
        public ArrayList<DtUsrKey> consultarProfe(String nombreInsti){
            ArrayList<String> listaNick = new ArrayList<String>();
            ArrayList<String> listaEmails = new ArrayList<String>();
            
            //EntityManager em = emf.createEntityManager();
            
            listaNick.addAll(em.createQuery("select p.nickname from Profesor p WHERE institucion =" + "'" + nombreInsti + "'").getResultList());
            listaEmails.addAll(em.createQuery("select p.email from Profesor p WHERE institucion =" + "'" + nombreInsti + "'").getResultList());
            
            ArrayList<DtUsrKey> listaADevolver = new ArrayList<DtUsrKey>();
            for(int i = 0; i < listaNick.size();i++) {
            	
            	listaADevolver.add(new DtUsrKey(listaNick.get(i),listaEmails.get(i)));
            	//listaADevolver.add(listaNick.get(i) + " / " + listaEmails.get(i));
            }
            
            //System.out.println(list.toString());
            return listaADevolver;
        }
//----------------------------------------------------------------------------------------------------------------------------------------------------       
        public void darAltaClase(String nombreInsti,String nombreActiDepo,String nombreClase,LocalDateTime fechaInicio,DtUsrKey profeKey ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){

            System.out.println("Antes de crear la insti");
            Profesor profe = em.find(Profesor.class, new Usuario(profeKey.nickname,profeKey.email));
            System.out.println("despues de crear la insti");
            
            try{
                Clase claseDictada = profe.darAltaClaseProfe(nombreInsti,nombreActiDepo, nombreClase, fechaInicio , sociosMin, sociosMax, URL,fechaAlta, em);
            }catch(Exception e){
                throw new IllegalArgumentException(e.getMessage());
            }   
        }
      //------------------------------------------------------------------------------------------------------------------------------------------ 
        
      public void recordarInsti(String nombreInsti) {
    	  EntityManager em = this.emf.createEntityManager();
    	  
    	  this.instiRecordada = em.find(Institucion.class,nombreInsti);
    	  System.out.println(this.instiRecordada.getNombreInst());
      }
      
    //------------------------------------------------------------------------------------------------------------------------------------------ 
      
}
