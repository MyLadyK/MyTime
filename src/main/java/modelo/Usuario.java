package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConexion;
import dao.DaoUsuario;

/**
 * Clase que representa un <strong>Usuario</strong>
 *
 * @author Grisella Padilla Díaz
 * @version 4.2
 * @since 22-03-2024
 * @see DaoUsuario
 */
public class Usuario {

	public int idUsuario;
	private String dni;
	private String puesto;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String telefono;
	private String permiso;
	
	/**
	 * Constructor vacio para crear el objeto Supervisor
	 */
	
	public Usuario() {
		
	}
	
	/**
	 * Constructor con todos los atributos
	 * 
	 * @param idUsuario Atributo que indica el id de <strong>Usuario</strong>
	 * @param dni Atributo que indica el dni del <strong>Usuario</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Usuario</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Usuario</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Usuario</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Usuario</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Usuario</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Usuario</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Usuario</strong>
	 */
	
	public Usuario(int idUsuario, String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, String telefono, String permiso) {
		super();
		this.idUsuario = idUsuario;
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
	 * Constructor con todos los atributos salvo idUsuario para insertar en la <strong>Base de Datos</strong> 
	 * 
	 * @param dni Atributo que indica el dni del <strong>Usuario</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Usuario</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Usuario</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Usuario</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Usuario</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Usuario</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Usuario</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Usuario</strong>
	 */
	
	public Usuario(String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, String telefono, String permiso) {
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
	 * Constructor para la listar de forma extensa los datos almacenados en la <strong> Base de Datos</strong>
	 * 
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Usuario</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Usuario</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Usuario</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Usuario</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Usuario</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Usuario</strong>
	 */
	public Usuario(String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, String telefono) {
		super();
		this.dni = dni;
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.telefono = telefono;
	}
	/**
	 * Constructor para la listar de forma escueta los datos almacenados en la <strong> Base de Datos</strong>
	 * 
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Usuario</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Usuario</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Usuario</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Usuario</strong>
	 */
	
	public Usuario(String puesto, String nombre, String apellido1, String apellido2, String correo) {
		super();
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	
	/**
	 * Constructor para usar con el login
	 * 
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Usuario</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Usuario</strong>
	 */
	public Usuario(String correo, String permiso) {
		this.correo = correo;
		this.permiso = permiso;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	
	/**
	 * Metodo insertar, el cual <strong>añade</strong> los datos de los usuarios a la base de datos mediante un formulario 
	 * @throws SQLException si se produce un error en la insercion de usuarios
	 */
	public void insertar() throws SQLException {
		DaoUsuario.getInstance().insertar(this); // Con patrón Singleton
	}
	
	
	/**
	 * Metodo listar, el cual <strong>lista</strong> los datos de los usuarios previamente insertados en la base de datos
	 * @return Devuelve la <strong>lista de usuarios</strong> obtenida de la base de datos
	 * @throws SQLException si se produce un error en la visualizacion de usuarios
	 */
	public ArrayList<Usuario> listar() throws SQLException{
		return DaoUsuario.getInstance().listar();
	}
	
	/**
	 * Metodo modificar, el cual <strong>modifica</strong> los datos de los usuarios previamente insertados en la base de datos	
	 * @throws SQLException si se produce un error en la modificacion de usuarios
	 */
	public void modificar() throws SQLException {
		 DaoUsuario.getInstance().modificar(this); 
	}	
	
	/**
	 * Metodo eliminar, el cual <strong>elimina</strong> los datos de los usuarios previamente insertados en la base de datos
	 * @throws SQLException si se produce un error en la insercion de usuarios
	 */
	public void eliminar() throws SQLException {
		DaoUsuario.getInstance().eliminar(this); 
	}
	

	/**
	 * Método para representar el usuario como una cadena de texto
	 * @return cadena de texto que representa al usuario
	 */
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", puesto=" + puesto + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", telefono="
				+ telefono + ", permiso=" + permiso + "]";
	}
	
	
}
