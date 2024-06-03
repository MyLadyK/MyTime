package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoTurno;
import dao.DaoUsuario;

/**
 * Clase que representa un <strong>Turno</strong>
 *
 * @author Grisella Padilla Díaz
 * @version 4.2
 * @since 22-03-2024
 * @see DaoTurno
 */
public class Turno {
	
	private int idTurno;
	private int anno;
	private String mes;
	private String diaInicio;
	private String diaFin;
	private String horaInicio;
	private String horaFin;
	private String tipoTurno;
	
	/**
	 * Constructor vacio para crear el objeto turno
	 */
	public Turno() {
		
	}
	
	/**
	 * Constructor con todos los atributos
	 * 
	 * @param idTurno Atributo que indica el id de <strong>Turno</strong>
	 * @param anno Atributo que indica el año de <strong>Turno</strong>
	 * @param mes Atributo que indica el mes de <strong>Turno</strong>
	 * @param diaInicio Atributo que indica el dia de la semana de inicio de <strong>Turno</strong>
	 * @param diaFin Atributo que indica el dia de la semana que acaba el <strong>Turno</strong>
	 * @param horaInicio Atributo que indica la hora a la que comienza el <strong>Turno</strong>
	 * @param horaFin Atributo que indica la hora a la que finaliza el <strong>Turno</strong>
	 * @param tipoTurno Atributo que indica el tipo de <strong>Turno</strong>
	 */
	public Turno(int idTurno, int anno, String mes, String diaInicio, String diaFin, String horaInicio, String horaFin, String tipoTurno) {
		super();
		this.idTurno = idTurno;
		this.anno = anno;
		this.mes = mes;
		this.diaInicio = diaInicio;
		this.diaFin = diaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.tipoTurno = tipoTurno;
	
	}
	
	
	/**
	 * Constructor con todos los atributos salvo idTurno para insertar en la <strong>base de datos</strong>
	 * 
	 * @param anno Atributo que indica el año de <strong>Turno</strong>
	 * @param mes Atributo que indica el mes de <strong>Turno</strong>
	 * @param diaInicio Atributo que indica el dia de la semana de inicio de <strong>Turno</strong>
	 * @param diaFin Atributo que indica el dia de la semana que acaba el <strong>Turno</strong>
	 * @param horaInicio Atributo que indica la hora a la que comienza el <strong>Turno</strong>
	 * @param horaFin Atributo que indica la hora a la que finaliza el <strong>Turno</strong>
	 * @param tipoTurno Atributo que indica el tipo de <strong>Turno</strong>
	 */
	public Turno(int anno, String mes, String diaInicio, String diaFin, String horaInicio, String horaFin, String tipoTurno) {
		super();
		this.anno = anno;
		this.mes = mes;
		this.diaInicio = diaInicio;
		this.diaFin = diaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.tipoTurno = tipoTurno;
	}
	
	/**
	 * Constructor para generar un turno
	 * 
	 * @param anno Atributo que indica el año de <strong>Turno</strong>
	 * @param mes Atributo que indica el mes de <strong>Turno</strong>
	 * @param tipoTurno Atributo que indica el tipo de <strong>Turno</strong>
	 */
	public Turno(int anno, String mes, String tipoTurno) {
		super();
		this.anno = anno;
		this.mes = mes;
		this.tipoTurno = tipoTurno;
	}
	
	/**
	 * Constructor para listar turnos
	 * 
	 * @param idTurno Atributo que indica el id de <strong>Turno</strong>
	 * @param anno Atributo que indica el año de <strong>Turno</strong>
	 * @param mes Atributo que indica el mes de <strong>Turno</strong>
	 * @param tipoTurno Atributo que indica el tipo de <strong>Turno</strong>
	 */
	public Turno(int idTurno, int anno, String mes, String tipoTurno) {
		super();
		this.idTurno = idTurno;
		this.anno = anno;
		this.mes = mes;
		this.tipoTurno = tipoTurno;
	
	}


	public int getIdTurno() {
		return idTurno;
	}


	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	

	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}

	

	public String getDiaInicio() {
		return diaInicio;
	}


	public void setDiaInicio(String diaInicio) {
		this.diaInicio = diaInicio;
	}


	public String getDiaFin() {
		return diaFin;
	}


	public void setDiaFin(String diaFin) {
		this.diaFin = diaFin;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	

	public String getTipoTurno() {
		return tipoTurno;
	}


	public void setTipoTurno(String tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	/**
	 * Metodo insertarTurno, el cual <strong>añade</strong> los datos del turno generado a la base de datos mediante un formulario 
	 * @throws SQLException si se produce un error en la insercion de turnos
	 */
	public void insertarTurno() throws SQLException {
		DaoTurno.getInstance().insertarTurno(this);
		
	}
	
	/**
	 * Metodo listar, el cual <strong>lista</strong> los turnos previamente insertados en la base de datos
	 * @return Devuelve la <strong>lista de turnos</strong> obtenida de la base de datos
	 * @throws SQLException si se produce un error en la visualizacion de turnos
	 */
	public ArrayList<Turno> listar() throws SQLException{
		return DaoTurno.getInstance().listar();
	}

	/**
	 * Método para representar el turno como una cadena de texto
	 * @return cadena de texto que representa al turno
	 */
	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", anno=" + anno + ", mes=" + mes + ", diaInicio=" + diaInicio
				+ ", diaFin=" + diaFin + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", tipoTurno="
				+ tipoTurno + "]";
	}

	
}
