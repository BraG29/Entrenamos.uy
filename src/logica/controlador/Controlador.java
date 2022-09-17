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

public class Controlador extends IControlador {
	
	private String nombreCup;
	private Usuario uRecordado;
	private Institucion instiRecordada;
	//en menu  principal hay un ejemplo de instancia de entity manager
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tran;
        
        //Se Supone que el Entity Manager y el Entity Transaction ya los define el controlador
        //Y el menu Principal Maneja cuando los abre y cierra
        //No Abran ni Cierren conneciones en sus metodos, usen el em y el tran como vienen 

	public void initConnection(){
		this.emf = Persistence.createEntityManagerFactory("PersistenceApp");
		this.em = emf.createEntityManager();
		this.tran = em.getTransaction();
	}
	
	public void closeConnection(){
		this.em.close();
		this.emf.close();
	}

	
	public void altaUsuario(String nick, String nombre, String apellido, String email, LocalDate fechaNac, String imagen) {

		//EntityManager em = emf.createEntityManager();
		try {
			Socio s = new Socio(nick, apellido, email, nombre, fechaNac, imagen);
			tran.begin();
			em.persist(s);
			em.flush();
			this.tran.commit();
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
			tran.begin();
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
			//tran.rollback();
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
			tran.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaUpdate<Socio> cu = cb.createCriteriaUpdate(Socio.class);
			Root<Socio> rootSocio = cu.from(Socio.class);
			cu.set(rootSocio.get("nombre"), nombre);
			cu.set(rootSocio.get("apellido"), apellido);
			cu.set(rootSocio.get("fechaNac"), fechaNac);
			cu.set(rootSocio.get("urlImagen"), imagen);
			cu.where(cb.equal(rootSocio.get("nickname"), this.uRecordado.getNickname()));
			em.createQuery(cu).executeUpdate();
			//em.flush();
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
			tran.begin();
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
			//em.flush();
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
			tran.begin();
			consultaCuponera = em.createQuery("SELECT nombreCup FROM Cuponera").getResultList();//resultado = nombre
		}catch (Exception ex) {
			if (em != null) {
				tran.rollback();
			}
		}
		for (int i = 0; i < consultaCuponera.size(); i++) {//itero y agrego nombres a la lista que voy a retornar ekisde
			String nombresCuponeras = (String) consultaCuponera.get(i); //obtengo el nombre en el q estoy parado casteo a string xq consulta es de tipo List
			listaCuponeras.add(nombresCuponeras);//agrego a la lista
		}
		return listaCuponeras;
	}
	
	public ArrayList<String> listaCuponerasRegistradasParaActiDepo(String nombreActi) {
		
		ArrayList<String> listaCuponeras = new ArrayList<String>();
		ActividadDeportiva acti = em.find(ActividadDeportiva.class,nombreActi);
		listaCuponeras = acti.getNombreCupo();
		
		//listaCuponeras.addAll(em.createNativeQuery("SELECT nom_cuponera FROM Actividad_Cuponera WHERE nom_actividad = " + "'" + nombreActi + "'").getResultList()) ;
//		try {
//			//tran.begin();
//			
//		}catch (Exception ex) {
//			if (em != null) {
//				tran.rollback();
//			}
//		} finally {
//			//em.close();
//		}
		
		//resultado = nombre
		return listaCuponeras;
	}

	public DtCuponera seleccionCuponera(String nombreCup) {
            
                //Kevin Viera:  Se Supone que el Entity Manager y el Entity Transaction ya los define el controlador
                //              Y el menu Principal Maneja cuando los abre y cierra 
		//EntityManager em = emf.createEntityManager();// cuidao        
		Cuponera cup = null;
		String nombre= null, descripcion = null;
		Integer cant_clase = 0;
		Float descuento = 0F;
		LocalDate fecha_inicio = null, fecha_fin = null, fecha_alta = null;
		DtCuponera cupData = null;
		ArrayList<String> nombresActividades = new ArrayList<String>();
		try {
			//em.getTransaction().begin();//cuidao 
			tran.begin();//usar el Entity Transaction Definido en el Controlador         
			cup = em.find(Cuponera.class, nombreCup); //busco cuponera seleccionada  CUIDAO
			if(cup == null){
				throw new Exception("La cuponera seleccionada no existe");
			}		
			cupData = cup.getData();
			return cupData;		
		}catch (Exception ex) {
			if (em != null) {//cuidaaaaao
				//em.getTransaction().rollback();//ay mi madre el bicho
                                tran.rollback();
			}
		}
		return cupData;
	}
	
	//CU alta institucion deportiva
	public void altaInstitucion(String nombreInst, String descripcion, String URL) {
		//EntityManager em = emf.createEntityManager();

		try {
			Institucion existe = em.find(Institucion.class,nombreInst); //devuelve null si no existe
			if(existe != null) {
				throw new Exception("La institución ingresada ya existe");
			}
			tran.begin();
			Institucion inst = new Institucion(nombreInst, descripcion, URL);
			inst.setNombreInst(nombreInst);
			inst.setDescripcion(descripcion);
			inst.setInstURL(URL);
			em.persist(inst);
			tran.commit();
		} catch (Exception ex) {
			tran.rollback();
			ex.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void altaCuponera(String nombreCup, String descripcion, LocalDate fechaIni, LocalDate fechaFin,
			LocalDate fechaAlta, float descuento) {

		try {
			//initConnection(); Esto solo lo tiene que manejar el menu Principal
			tran.begin();
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
			//closeConnection(); Esto solo lo tiene que manejar el menu Principal
		}

	}

	public void registroDictadoDeClase(String pClase, String pSocio) {

		try {
			tran.begin(); 
			// TODO Pasa un id una fecha actual, un precio de actividad
			// TODO Agrega a la coleccion de Socio
			/*Registro reg = new Registro(pClase, pSocio);
			reg.setNombreInst(nombreInst);
			reg.setDescripcion(descripcion);
			em.persist(reg);*/
			tran.commit();
		} catch (Exception ex) {
			tran.rollback();
			ex.printStackTrace();
		}
	}

	
	private static Controlador instance;

	private void Controlador() {
	}
        
//        public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta){ //agregar foto
//            
//            //System.out.println(nombreActividad + nombreInsti + desc + dura + costo + fechaAlta);
//            
//
//            //Institucion insti = new Institucion(em.find(Institucion)(Institucion.class, nombreInsti));
//            EntityManager em = emf.createEntityManager();
//        }
        
        //q carajos paso aca   att:Lucas
        //posta, QUE MIERDA PASO LOKO?!?!?!?!?!?!?! att. el shody
            
        public void altaActividadDepo(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta, String IMG_URL){
        	System.out.println("Antes de buscar la insti");

            Institucion insti = em.find(Institucion.class, nombreInsti);
            System.out.println("Despues de buscar la insti "+insti.getNombreInst());
            
            if(insti != null){
                //hay que hacer try and catch
                try{
                    insti.darAltaActividadDeportiva(nombreActividad, nombreInsti, desc, dura, costo, fechaAlta,IMG_URL, this.em, this.tran);
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
        listaADevolver.addAll(em.createQuery("select nombreInst from Institucion").getResultList());
        return listaADevolver;
    }
                    
        public ArrayList<String> consultarActividadDepo(String nombreInsti){
            ArrayList<String> listaADevolver = new ArrayList<String>();
            listaADevolver.addAll(em.createQuery("select a.nombreAct from ActividadDeportiva a WHERE insti_nombre = " + "'" + nombreInsti + "'").getResultList());  
            return listaADevolver;
        }
        
        
        public ArrayList<String> consultarClases(String nombreActividad){
            ArrayList<String> listaADevolver = new ArrayList<String>();            
            listaADevolver.addAll(em.createQuery("select nombre from Clase c where nombre in (select nom_clase from Actividad_Clase ac where nom_actividad = '" + nombreActividad + "')").getResultList());
            return listaADevolver;
        }
        
        public String[] getUnaClase(String nombreClase){
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
                  
            return listaADevolver;
        }
        
        public void registroDictadoClase(String inst, String actD, String clas, String soci) {
        	
        }
        
      //------------------------------------------------------------------------------------------------------------------------------------------
        //Operaciones AgregarActividadDeportivaCuponera--------------------------------------------------------------------
        public ArrayList<DtCuponera> ListarCuponeras(){//unused
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
        
        public ArrayList<DtInstitucion> ListarInstituciones(){//unused
            ArrayList<DtInstitucion> l = new ArrayList<DtInstitucion>();
            return l;
        }
//------------------------------------------------------------------------------------------------------------------------------------------        
        public ArrayList<String> getNombreCuponeras(){
            
            ArrayList<String> listaADevolver = new ArrayList<String>();
            
            //EntityManager em = emf.createEntityManager();
            
            listaADevolver.addAll(em.createQuery("select c.nombreCup from Cuponera c").getResultList());
            
            return listaADevolver;
            
        }
        
        public ArrayList<String> getActisDeCuponera(String nombreCup){
            ArrayList<ActividadDeportiva> listaActis= new ArrayList<>();
            ArrayList<String> listaADevolver = new ArrayList<>(); 
            String findQuery = "select c.actividades from Cuponera c WHERE c.nombreCup = :nombre";
            
            
            Query find = em.createQuery(findQuery);
            find.setParameter("nombre",nombreCup);
            listaActis.addAll(find.getResultList());
             
            for(ActividadDeportiva actis : listaActis){
                System.out.println(actis.getNombreAct());
                listaADevolver.add(actis.getNombreAct());
            }
            
            return listaADevolver;
        }
        
        public boolean agregarActividadCuponera(String nombreCup,String nombreActi,int cantClases){
            
            //debug
            System.out.println("In agregarActividadCuponera");
            System.out.println(nombreCup);
            System.out.println(nombreActi);
            System.out.println(cantClases);
            
            //Find Objects
            Cuponera cup = em.find(Cuponera.class, nombreCup);
            ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
            
            //More Debug
            System.out.println("Cup Name: ");
            System.out.println(cup.getNombreCup());
            System.out.println("Acti Name: ");
            System.out.println(acti.getNombreAct());
            
            //If Objects Found Attempt to Persist, else return False
            if(cup != null && acti != null)
            {
                //attempt to Persist
                boolean success = cup.aniadirAD(acti, cantClases, em, tran);
                //if successful, return true, else false
                if(success == true)
                {
                    return true;
                }
                else return false;
            }
            else return false;
        }
        
        public Usuario getUsuario(DtUsrKey usrKey){
            
            Usuario Usr = em.find(Usuario.class, new Usuario(usrKey.nickname,usrKey.email));
            return Usr;
            
        }
        
        //-----------------------------------------------------------------------------------------------------------------
        
        
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

            System.out.println("Antes de crear el profe");
            Profesor profe = em.find(Profesor.class, new Usuario(profeKey.nickname,profeKey.email));
            System.out.println("despues de crear el profe");
            
            //em.flush();
            
            try{
                Clase claseDictada = profe.darAltaClaseProfe(nombreInsti,nombreActiDepo, nombreClase, fechaInicio , sociosMin, sociosMax, URL,fechaAlta, this.em,this.tran);
                if(claseDictada == null) System.out.println("claseDictada == null");
                this.instiRecordada.darAltaClaseInsti(nombreActiDepo, claseDictada, em, tran);
            }catch(Exception e){
                throw new IllegalArgumentException(e);
            }   
        }
//------------------------------------------------------------------------------------------------------------------------------------------ 
        
      public void recordarInsti(String nombreInsti) {
    	  
    	  this.instiRecordada = this.em.find(Institucion.class,nombreInsti);
    	  System.out.println(this.instiRecordada.getNombreInst());
      }
      
//------------------------------------------------------------------------------------------------------------------------------------------ 
      public DtActividadDeportiva getDtActividadDeportiva(String nombreActi) {
    	  ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
    	  return acti.getDTActividadDeportiva();
      }
      
      public ArrayList<String> getClasesPorActiDepo(String nombreActi){
    	  ArrayList<String> listaADevolver = new ArrayList<String>();
    	  ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
    	  listaADevolver = acti.getNombreClases();
    	  return listaADevolver;
      }
      
      public ArrayList<String> getClasesVigentesPorActiDepo(String nombreActi){
    	  ArrayList<String> listaADevolver = new ArrayList<String>();
    	  ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
    	  listaADevolver = acti.getNombreClases();
    	  return listaADevolver;
      }
      
      public DtCuponera getDtCuponera(String nombreCupo){
    	  Cuponera cupo = em.find(Cuponera.class, nombreCupo);
    	  return cupo.getData();
      }
      
      public DtClase getDtClaseXInsti(String nombreInsti,String nombreActi, String nombreClase) {
    	  System.out.println("Antes de buscar la Insti para la Clase");
    	  Institucion insti = em.find(Institucion.class, nombreInsti);
    	  System.out.println("Despues de buscar la Insti para la Clase");
    	  
    	  DtClase claseADevolver = insti.getDtClaseXActiDepo( nombreActi, nombreClase, em);
    	  return claseADevolver;
      }
      
      public ArrayList<String> getClaseRegistradaSocio(DtSocio socio){

          Usuario s = em.find(Usuario.class, new Usuario(socio.nickname,socio.email));
                  
          Collection<Registro> registros = ((Socio)s).getRegistro();
          
          ArrayList<String> output = new ArrayList<>();
          
          for(Registro r : registros){
              output.add(r.getClaseAsociada().getNombreClase());
          }
          return output;
      }
      
      public String getActividadDepoAsociadaClase(String nomClase, String nomInsti){
          
          Institucion inst = em.find(Institucion.class, nomInsti);
          
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
                            return acti.getNombreAct();
                          }
                      }
                      
                  }
                  
              }
              
          }
          return null; 
      }
      
      public DtActividadDeportiva getDtActividadDepo(String nomActi){
          ActividadDeportiva acti = em.find(ActividadDeportiva.class,nomActi);
          if(acti != null){
            return acti.getDTActividadDeportiva();
          }
          return null;
      }
}
