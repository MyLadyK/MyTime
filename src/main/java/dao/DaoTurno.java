package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import modelo.Turno;

public class DaoTurno {
	private Connection con = null;
	
	private static DaoTurno instance = null;

	public DaoTurno() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static DaoTurno getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoTurno();
		}
		return instance;
	}
	
	

	public void generarTurno (int anno, String mes, String diaInicio, String diaFin, String horaInicio, String horaFin, int numTrabajadores) throws SQLException {
	    
		String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	    int indiceDiaInicio = Arrays.asList(diasSemana).indexOf(diaInicio);
	    int indiceDiaFin = Arrays.asList(diasSemana).indexOf(diaFin);

	    for (int trabajador = 1; trabajador <= numTrabajadores; trabajador++) {
	        String tipoTurno = "";

	        int horaInicioInt = Integer.parseInt(horaInicio.split(":")[0]);
	        int horaFinInt = Integer.parseInt(horaFin.split(":")[0]);

	        if (horaInicioInt >= 5 && horaInicioInt < 13) {
	            tipoTurno = "Mañana";
	        } else if (horaInicioInt >= 13 && horaInicioInt < 22) {
	            tipoTurno = "Tarde";
	        } else {
	            tipoTurno = "Noche";
	        }

	            Turno nuevoTurno = new Turno(anno, mes, diaInicio, diaFin, horaInicio, horaFin, tipoTurno);
	            insertarTurno(nuevoTurno);
	            
	    }
	}

	public void insertarTurno(Turno nuevoTurno) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"INSERT turno (año, mes, diaInicio, diaFin, horaInicio, horaFin, tipoTurno) VALUES (?,?,?,?,?,?,?)");
		ps.setInt(1, nuevoTurno.getAnno());
		ps.setString(2, nuevoTurno.getMes());
		ps.setString(3, nuevoTurno.getDiaInicio());
		ps.setString(4, nuevoTurno.getDiaFin());
		ps.setString(5, nuevoTurno.getHoraInicio());
		ps.setString(6, nuevoTurno.getHoraFin());
		ps.setString(7, nuevoTurno.getTipoTurno());


		// Ejecutar la query
		int filas = ps.executeUpdate();
		System.out.println("Se han añadido " + filas + " filas");

		ps.close();
	}

	
}


