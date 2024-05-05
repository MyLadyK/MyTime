package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;

import dao.DaoSupervisor;

public class Supervisor {
	
	private int idSupervisor;
	private String dni;
	private String puesto;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private int telefono;
	private String permiso;
	
	
	//Constructor vacío
	public Supervisor() {
		
	}
	
	//Constructor con todo
	public Supervisor(int idSupervisor, String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, int telefono, String permiso) {
		super();
		this.idSupervisor = idSupervisor;
		this.dni = dni;
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.telefono = telefono;
		this.permiso =permiso;
	}
	
	//Constructor con todo salvo id para insertar en BD 
	public Supervisor(String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, int telefono, String permiso) {
		super();
		this.dni = dni;
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.telefono = telefono;
		this.permiso = permiso;
		
	}

	
	//Constructor para la lista corta de datos y usarlo en el método listar
	public Supervisor(String puesto, String nombre, String apellido1, String apellido2, String correo) {
		super();
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	//G&S
	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPermiso() {
		//System.out.println("Permiso en supervisor." +permiso);
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	
	//Método insertar
	public void insertar() throws SQLException {
		// DaoSupervisor dao = new DaoSupervisor(); //Sin patrón Singleton
		// dao.insertar(this);
		DaoSupervisor.getInstance().insertar(this); // Con patrón Singleton
	}
	
	
	// Método listar
		public ArrayList<Supervisor> listar() throws SQLException{
			return DaoSupervisor.getInstance().listar();
		}
	
	
	
	//ToString
	@Override
	public String toString() {
		return "Supervisor [idSupervisor=" + idSupervisor + ", dni=" + dni + ", puesto=" + puesto + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", telefono="
				+ telefono + ", permiso="
						+ permiso + "]";
	}
	

}
