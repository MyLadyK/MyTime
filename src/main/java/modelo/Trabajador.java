package modelo;


/**
 * Clase <strong>Trabajador</strong>
 */
public class Trabajador {

	private int idTrabajador;
	private String dni;
	private String puesto;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String telefono;
	private String permiso;
	
	
	public Trabajador() {
		
	}
	
	/**
	 * Constructor con todos los atributos
	 * @param idTrabajador Atributo que indica el id de <strong>Trabajador</strong>
	 * @param dni Atributo que indica el dni del <strong>Trabajador</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Trabajador</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Trabajador</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Trabajador</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Trabajador</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Trabajador</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Trabajador</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Trabajador</strong>
	 */
	public Trabajador(int idTrabajador, String dni, String puesto, String nombre, String apellido1, String apellido2,
			String correo, String telefono, String permiso) {
		super();
		this.idTrabajador = idTrabajador;
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
	 * Constructor con todos los atributos salvo idTrabajador para insertar en la <strong>Base de Datos</strong> 
	 * @param dni Atributo que indica el dni del <strong>Trabajador</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Trabajador</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Trabajador</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Trabajador</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Trabajador</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Trabajador</strong>
	 * @param telefono Atributo que indica el número de teléfono del <strong>Trabajador</strong>
	 * @param permiso Atributo que indica el tipo de permiso del <strong>Trabajador</strong>
	 */
	
	public Trabajador(String dni, String puesto, String nombre, String apellido1, String apellido2,
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
	 * Constructor para la listar de forma escueta los datos almacenados en la <strong> Base de Datos</strong>
	 * @param puesto Atributo que indica el puesto de trabajo asignado al <strong>Trabajador</strong>
	 * @param nombre Atributo que indica el nombre del <strong>Trabajador</strong>
	 * @param apellido1 Atributo que indica el primer apellido del <strong>Trabajador</strong>
	 * @param apellido2 Atributo que indica el segundo apellido del <strong>Trabajador</strong>
	 * @param correo Atributo que indica la dirección de correo electrónico del <strong>Trabajador</strong>
	 */
	public Trabajador(String puesto, String nombre, String apellido1, String apellido2, String correo) {
		super();
		this.puesto = puesto;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
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
	
	

	@Override
	public String toString() {
		return "Trabajador [idTrabajador=" + idTrabajador + ", dni=" + dni + ", puesto=" + puesto + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", telefono="
				+ telefono + ", permiso=" + permiso + "]";
	}
	
	
	
	
	
	
}
