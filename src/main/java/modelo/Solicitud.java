package modelo;

/**
 * 
 */
public class Solicitud {
	
	private int idSolicitud;
	private String tipo;
	private String fecha;
	
	
	public Solicitud() {
		
	}
	
	/**
	 * 
	 * @param idSolicitud
	 * @param tipo
	 * @param fecha
	 */
	public Solicitud(int idSolicitud, String tipo, String fecha) {
		super();
		this.idSolicitud = idSolicitud;
		this.tipo = tipo;
		this.fecha = fecha;
	}


	public int getIdSolicitud() {
		return idSolicitud;
	}


	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Solicitud [idSolicitud=" + idSolicitud + ", tipo=" + tipo + ", fecha=" + fecha + "]";
	}
	
}
