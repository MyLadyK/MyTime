package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoTurno;


public class Turno {
	
	private int idTurno;
	private int anno;
	private String mes;
	private String diaInicio;
	private String diaFin;
	private String horaInicio;
	private String horaFin;
	private String tipoTurno;
	
	public Turno() {
		
	}
	
	
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
	
	
	//Constructor para insertar
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
	
	//Constructor crear turno
	public Turno(int anno, String mes, String tipoTurno) {
		super();
		this.anno = anno;
		this.mes = mes;
		this.tipoTurno = tipoTurno;
	}
	
	//Constructor listar turno NO
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

	public void insertarTurno() throws SQLException {
		DaoTurno.getInstance().insertarTurno(this);
		
	}
	
	public ArrayList<Turno> listar() throws SQLException{
		return DaoTurno.getInstance().listar();
	}


	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", anno=" + anno + ", mes=" + mes + ", diaInicio=" + diaInicio
				+ ", diaFin=" + diaFin + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", tipoTurno="
				+ tipoTurno + "]";
	}

	
}
