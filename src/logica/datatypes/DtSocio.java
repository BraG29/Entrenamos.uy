package logica.datatypes;

import java.time.LocalDate;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String email, String nombre, String apellido, LocalDate fechaNac) {
		super(nickname, email, nombre, apellido, fechaNac);
	}
}
