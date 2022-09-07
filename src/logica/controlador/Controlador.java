package logica.controlador;

import java.lang.management.GarbageCollectorMXBean;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import logica.datatypes.DtUsrKey;
import logica.institucion.Institucion;
import logica.usuario.Profesor;
import logica.usuario.Socio;
import logica.datatypes.*;

public class Controlador extends IControlador {
	
	//en menu  principal hay un ejemplo de instancia de entity manager
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceApp");
	
	
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac) {
		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Socio s = new Socio(nick, apellido, email, nombre, fechaNac);
			em.persist(s);
			em.flush();
			em.getTransaction().commit();
			System.out.println("Usuario creado");
		}catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException)e.getCause().getCause();
			if(eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			}else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		em.close();
	}
	
	
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
		EntityManager em = emf.createEntityManager();
		try {
			Institucion i = em.find(Institucion.class, institucion);
			if(i==null) {
				throw new IllegalArgumentException("No existe la institucion");
			}
			em.getTransaction().begin();
			Profesor p = new Profesor(nick, apellido, email, nombre, fechaNac, biografia, descripcion,sitioWeb, i);
			em.persist(p);
			em.flush();
			em.getTransaction().commit();
			System.out.println("Usuario creado");
		}catch (PersistenceException e) {
			em.getTransaction().rollback();
			SQLException eSQL = (SQLException)e.getCause().getCause();
			if(eSQL.getErrorCode() == 1062) {
				throw new IllegalArgumentException("Ya existe un Usuario con ese nick o email");
			}else {
				throw new IllegalArgumentException("No se ha podido dar de alta al usuario");
			}
		}
		em.close();
	}
	public static Controlador getInstance() {
		if(instance == null)
			instance = new Controlador();
		return instance;
	}
	public ArrayList<DtUsrKey> listarUsuarios() {
		DtUsrKey u1 = new DtUsrKey("kratos", "pablito@mail.com");
		DtUsrKey u2 = new DtUsrKey("chrollo", "esteban@mail.com");
		DtUsrKey u3 = new DtUsrKey("katsu", "mika@mail.com");
		ArrayList<DtUsrKey> l = new ArrayList<DtUsrKey>();
		l.add(u1);
		l.add(u2);
		l.add(u3);
		return l;
	}
	
	public DtUsuario getDatosUsuario(DtUsrKey usrKey) {
		DtUsuario dtU = new DtSocio("","","","",null);
		return dtU;
	}
	
	public void modificarDatos(String nombre,String apellido,LocalDate fechaNac) {
		
	}
	public void modificarDatos(
			String nombre,String apellido,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
	}
	
	private static Controlador instance;
	private void Controlador(){
	}
}
