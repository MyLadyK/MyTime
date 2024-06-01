package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



/**
 * Clase para manejar la conexión a la base de datos.
 */
public class DBConexion {

    /** Instancia de la conexión. */
    public static Connection instance = null;
    
    /** URL de la base de datos MySQL. */
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/mytime"; 

    /** Constructor privado para evitar instanciación. */
    private DBConexion() {
        
    }

    /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al conectar a la base de datos.
     */
    public static Connection getConnection() throws SQLException {
        
        if (instance == null) {
            Properties props = new Properties();
            props.put("user", "root");
            props.put("password", "");
            
            instance = DriverManager.getConnection(JDBC_URL, props);
        }
        return instance;
        
    }
}
