package logica.datatypes;

import java.time.LocalDate;

public class DtUsuario {
	public final String nickname;
	public final String email;
	public final String nombre;
	public final LocalDate fechaNac;
	
	
	public DtUsuario(String nickname, String email, String nombre, LocalDate fechaNac) {
		this.nickname = nickname;
		this.email = email;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
	}
}
