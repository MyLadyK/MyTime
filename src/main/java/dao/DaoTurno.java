package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import modelo.Turno;

/**
 * Clase DaoTurno para la gestión de turnos en la base de datos
 * Esta clase proporciona métodos para generar, insertar, listar turnos y convertirlos a formato JSON
 * Utiliza el patrón Singleton para garantizar que solo exista una instancia de DaoTurno
 *
 * @author Grisella Padilla Díaz
 * @version 4.2
 * @since 22-03-2024
 * @see DBConexion
 * @see Turno
 */


public class DaoTurno {
	private Connection con = null;
	
	private static DaoTurno instance = null;

	/**
	 * Constructor de DaoTurno.
	 * 
	 * @throws SQLException si hay un error al obtener la conexión
	 */
	public DaoTurno() throws SQLException {
		con = DBConexion.getConnection();
	}

	/**
	 * Metodo para obtener la instancia de DaoTurno mediante <strong>patron Singleton</strong>
	 * 
	 * @return la instancia de DaoTurno
	 * @throws SQLException si hay un error al crear la instancia
	 */
	public static DaoTurno getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoTurno();
		}
		return instance;
	}
	
	/**
	 * Metodo para <strong>generar</strong> un turno
	 * 
	 * @param anno el año del turno
	 * @param mes el mes del turno
	 * @param diaInicio el día de la semana que inicia el turno
	 * @param diaFin el día de la semana que finaliza el turno
	 * @param horaInicio la hora de inicio del turno
	 * @param horaFin la hora de fin del turno
	 * @param numTrabajadores el número de trabajadores en el turno
	 * @throws SQLException si hay un error al generar el turno
	 */
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

	/**
	 * Metodo para <strong>insertar</strong>  un turno en la base de datos
	 * 
	 * @param nuevoTurno el turno a insertar
	 * @throws SQLException si hay un error al insertar el turno
	 */
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


		ps.executeUpdate();
		

		ps.close();
	}
	
	/**
	 * Metodo para <strong>listar</strong> todos los turnos de la base de datos
	 * 
	 * @return una lista de turnos
	 * @throws SQLException si hay un error al listar los turnos
	 */
	public ArrayList<Turno> listar() throws SQLException {

		String sql = "SELECT * FROM turno"; 

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();

		ArrayList<Turno> t1 = null;

		while (result.next()) {
			if (t1 == null) {
				t1 = new ArrayList<Turno>();
			}
			t1.add(new Turno(result.getInt("año"), result.getString("mes"), result.getString("tipoTurno")));
		}
		return t1;
	}


	/**
	 * Metodo para obtener un <strong>JSON</strong> de todos los turnos
	 * 
	 * @return un string en formato JSON de todos los turnos
	 * @throws SQLException si hay un error al obtener el JSON
	 */
	public String dameJson() throws SQLException {

		String txtJSON = "";
		Gson gson = new Gson();
		txtJSON = gson.toJson(this.listar());

		return txtJSON;
	}
	
}


