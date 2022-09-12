package logica.controlador;

import java.lang.management.GarbageCollectorMXBean;
import java.sql.SQLException;
import java.time.LocalDate;

import logica.institucion.Institucion;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


import javax.persistence.Query;
//import javax.persistence.


import org.hibernate.jpa.internal.util.PessimisticNumberParser;
//import org.hibernate.mapping.List;

//import com.mysql.cj.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import logica.institucion.Institucion;
import logica.usuario.Profesor;
import logica.usuario.Socio;
import logica.usuario.Usuario;
import logica.cuponera.Cuponera;
import logica.datatypes.*;
import logica.institucion.Institucion;

public class Controlador extends IControlador {
	
	private String nombreCup;
	private Usuario uRecordado;
	//en menu  principal hay un ejemplo de instancia de entity manager
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceApp");

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Socio s = new Socio(nick, apellido, email, nombre, fechaNac);
			em.persist(s);
			em.flush();
			em.getTransaction().commit();
			System.out.println("Usuario creado");
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		em.close();
	}

	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
		EntityManager em = emf.createEntityManager();
		try {
			Institucion i = em.find(Institucion.class, institucion);
			if (i == null) {
				throw new IllegalArgumentException("No existe la institucion");
			}
			em.getTransaction().begin();
			Profesor p = new Profesor(nick, apellido, email, nombre, fechaNac, biografia, descripcion, sitioWeb, i);
			em.persist(p);
			em.flush();
			em.getTransaction().commit();
			System.out.println("Usuario creado");
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException) e.getCause().getCause();
			if (eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			} else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		em.close();
	}

	public static Controlador getInstance() {
		if (instance == null)
			instance = new Controlador();
		return instance;
	}

	public ArrayList<DtUsrKey> listarUsuarios() {
		EntityManager em = emf.createEntityManager();
		ArrayList listUsuarios = new ArrayList<DtUsrKey>();
		java.util.List listNickSocio = null;
		java.util.List listEmailSocio = null;
		java.util.List listNickProfe = null;
		java.util.List listEmailProfe = null;
		try {
			em.getTransaction().begin();
			listNickSocio = em.createQuery("SELECT nickname FROM Socio").getResultList();
			listEmailSocio = em.createQuery("SELECT email FROM Socio").getResultList();
			listNickProfe = em.createQuery("SELECT nickname FROM Profesor").getResultList();
			listEmailProfe = em.createQuery("SELECT email FROM Profesor").getResultList();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
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
		em.close();
		return listUsuarios;
	}

	public DtUsuario getDatosUsuario(DtUsrKey usrKey) {
		EntityManager em = emf.createEntityManager();
		Usuario u = null;
		try {
			em.getTransaction().begin();
			u = em.find(Usuario.class, new Usuario(usrKey.nickname,usrKey.email));
			this.uRecordado = u;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
		}
		if(u instanceof Profesor) {
			Profesor p = (Profesor)u;
			DtUsuario dtP = p.getDatosProfe(emf);
			em.close();
			return dtP;
		}else {
			Socio s = (Socio)u;
			DtUsuario dtS = s.getDatosSocio();
			em.close();
			return dtS;
		}
	}




	public void modificarDatos(String nombre,String apellido,LocalDate fechaNac) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<Socio> cu = cb.createCriteriaUpdate(Socio.class);
			Root<Socio> rootSocio = cu.from(Socio.class);
			cu.set(rootSocio.get("nombre"), nombre);
			cu.set(rootSocio.get("apellido"), apellido);
			cu.set(rootSocio.get("fechaNac"), fechaNac);
			cu.where(cb.equal(rootSocio.get("nickname"), this.uRecordado.getNickname()));
			em.createQuery(cu).executeUpdate();
			em.flush();
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
		}
	}
	public void modificarDatos(
			String nombre,String apellido,LocalDate fechaNac,
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
			cu.where(cb.equal(rootProfesor.get("nickname"), this.uRecordado.getNickname()));
			em.createQuery(cu).executeUpdate();
			em.flush();
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
		}

	}
	//CU Consulta de cuponeras de actividades deportivas
	public ArrayList<String> listaCuponerasRegistradas() {
		ArrayList<String> listaCuponeras = new ArrayList<String>();
		
		//iterar en cuponeras
		//obtener nombre
		//devolver lista
		return null;
	}
	
	public DtCuponera seleccionCuponera(String nombreCup) {
		
		//encontrar cuponera
		//obtener datos
		//iterar en actividades
		//obtener nombre
		//devolver resultado(datos)
		return null;
	}
	
	//CU alta institucion deportiva

	public void altaInstitucion(String nombreInst, String descripcion, String URL) {

		EntityManager em = emf.createEntityManager();

		
		//controlar si existe.

		try {
			em.getTransaction().begin();
			Institucion inst = new Institucion(nombreInst, descripcion, URL);
			inst.setNombreInst(nombreInst);
			inst.setDescripcion(descripcion);
			inst.setInstURL(URL);
			em.persist(inst);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (em != null) {
				em.getTransaction().rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDateTime fechaIni, LocalDateTime fechaFin,
			float descuento) {

		EntityManager em = emf.createEntityManager();
		LocalDateTime fechaAlta = LocalDateTime.now();

		try {
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
			em.close();
		}

	}

	private static Controlador instance;

	private void Controlador() {
	}
        
        public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta){
            
            //System.out.println(nombreActividad + nombreInsti + desc + dura + costo + fechaAlta);
            

            //Institucion insti = new Institucion(em.find(Institucion)(Institucion.class, nombreInsti));
            EntityManager em = emf.createEntityManager();
            Institucion insti = em.find(Institucion.class, nombreInsti);
            
            if(insti != null){
                //hay que hacer try and catch
                try{
                    insti.darAltaActividadDeportiva(nombreActividad, nombreInsti, desc, dura, costo, fechaAlta, this.emf);
                }catch(Exception e){
                    throw new IllegalArgumentException(e.getMessage());
                }
                
            }else{
                throw new IllegalArgumentException("No existe la institucion: " + nombreInsti);
                //System.out.println("TODO MAL ANDA AMIGOOOOOOO");
                //excepción de que insti no existe
            }  
        }
        
        public ArrayList<String> getNombreInstituciones(){
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            EntityManager em = emf.createEntityManager();
            
            //em.find(Institucion.class,);
            
            //List<Institucion> instis = em.createQuery("select i.nombreInst from Institucion i").getResultList();
            
            listaADevolver.addAll(em.createQuery("select i.nombreInst from Institucion i").getResultList());  
            
            return listaADevolver;
        }
        
        public ArrayList<String> consultarActividadDepo(String nombreInsti){
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            EntityManager em = emf.createEntityManager();
            
            
            listaADevolver.addAll(em.createQuery("select a.nombreAct from ActividadDeportiva a WHERE insti_nombre =" + "'" + nombreInsti + "'").getResultList());  
            //System.out.println(listaADevolver);
            return listaADevolver;
        }
        
        
        public ArrayList<String> consultarProfe(String nombreInsti){
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            EntityManager em = emf.createEntityManager();
            
            
            listaADevolver.addAll(em.createQuery("select p.nombre from Profesor p WHERE institucion =" + "'" + nombreInsti + "'").getResultList());  
            //System.out.println(listaADevolver);
            return listaADevolver;
        }
        
        public void darAltaClase(String nombreInsti,String nombreClase,LocalDateTime fechaInicio,String nombreProfe ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta){
            EntityManager em = emf.createEntityManager();
            
            Institucion insti = em.find(Institucion.class,nombreInsti);
            
            try{
                insti.darAltaClaseInsti(nombreInsti, nombreClase, fechaInicio, nombreProfe , sociosMin, sociosMax, URL,fechaAlta, this.emf);
            }catch(Exception e){
                
            }
            
            
        }
        
}
