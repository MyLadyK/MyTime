package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;

import dao.DaoSupervisor;

/**
 * Clase <strong>Supervisor</strong>
 */
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
	
	/**
	 * Constructor vacio para crear el objeto Supervisor
	 */
	
	public Supervisor() {
		
	}
	
	/**
	 * Constructor con todos los atributos
	 * @param idSupervisor Atributo que indica el id de <strong>Supervisor</strong>
	 * @param dni Atributo que indica el dni del <strong>Supervisor</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Supervisor</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Supervisor</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Supervisor</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Supervisor</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Supervisor</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Supervisor</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Supervisor</strong>
	 */
	
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
	
	/**
	 * Constructor con todos los atributos salvo idSupervisor para insertar en la <strong>Base de Datos</strong> 
	 * @param dni Atributo que indica el dni del <strong>Supervisor</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Supervisor</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Supervisor</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Supervisor</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Supervisor</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Supervisor</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Supervisor</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Supervisor</strong>
	 */
	
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

	/**
	 * Constructor para la listar de forma escueta los datos almacenados en la <strong> Base de Datos</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Supervisor</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Supervisor</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Supervisor</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Supervisor</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Supervisor</strong>
	 */
	
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
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	
	/**
	 * Metodo insertar, el cual <strong>añade</strong> los datos de los usuarios mediante un formulario 
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoSupervisor.getInstance().insertar(this); // Con patrón Singleton
	}
	
	
	/**
	 * Metodo listar, el cual <strong>lista</strong> los datos de los usuarios previamente insertados
	 * @return
	 * @throws SQLException
	 */
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
