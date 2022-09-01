package logica.controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import logica.datatypes.DtUsrKey;
import logica.datatypes.*;


public class Controlador extends IControlador {
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac) {
	}
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
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
