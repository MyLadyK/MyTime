package modelo;

/**
 * Clase que representa una <strong>Solicitud</strong>
 */
public class Solicitud {
    
    /** Identificador de la solicitud. */
    private int idSolicitud;
    
    /** Tipo de solicitud. */
    private String tipo;
    
    /** Fecha de la solicitud. */
    private String fecha;
    
    /** Constructor por defecto. */
    public Solicitud() {
        
    }
    
    /**
     * Constructor con parámetros.
     * 
     * @param idSolicitud Identificador de la solicitud.
     * @param tipo Tipo de solicitud.
     * @param fecha Fecha de la solicitud.
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

    /**
     * Retorna una representación en cadena de la solicitud.
     * 
     * @return Una cadena que representa la solicitud.
     */
    @Override
    public String toString() {
        return "Solicitud [idSolicitud=" + idSolicitud + ", tipo=" + tipo + ", fecha=" + fecha + "]";
    }
    
}