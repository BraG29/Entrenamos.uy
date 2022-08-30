package logica.datatypes;

import java.time.LocalDate;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String email, String nombre, LocalDate fechaNac) {
		super(nickname, email, nombre, fechaNac);
	}
}
