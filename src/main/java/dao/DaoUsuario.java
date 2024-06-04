package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

/**
 * Clase DaoUsuario para la gestión de usuarios en la base de datos
 * Esta clase proporciona métodos para insertar, listar, modificar, eliminar y autenticar usuarios
 * Utiliza el patrón Singleton para garantizar que solo exista una instancia de DaoUsuario
 *
 * @author Grisella Padilla Díaz
 * @version 4.2
 * @since 22-03-2024
 * @see DBConexion
 * @see Usuario
 */

public class DaoUsuario {
	private Connection con = null;

	
	private static DaoUsuario instance = null;

	/**
	 * Constructor de DaoUsuario
	 * 
	 * @throws SQLException al haber un error obteniendo la conexión
	 */
	public DaoUsuario() throws SQLException {
		con = DBConexion.getConnection();
	}

	/**
	 * Metodo para obtener la instancia de DaoUsuario haciendo uso del <strong>patrón Singleton</strong>
	 * 
	 * @return devuelve la instancia DaoUsuario
	 * @throws SQLException si hay errores al crear la instancia
	 */
	public static DaoUsuario getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoUsuario();
		}
		return instance;
	}

	/**
	 * Metodo que <strong>inserta</strong> un usuario en la base de datos
	 * 
	 * @param us es el usuarario a insertar
	 * @throws SQLException si hay errores al insertar un usuario
	 */
	public void insertar(Usuario us) throws SQLException {

		if ("supervisor".equals(us.getPermiso())) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT usuario (dni, puesto, nombre, apellido1, apellido2, correo, telefono, contrasena, permiso) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, us.getDni());
			ps.setString(2, us.getPuesto());
			ps.setString(3, us.getNombre());
			ps.setString(4, us.getApellido1());
			ps.setString(5, us.getApellido2());
			ps.setString(6, us.getCorreo());
			ps.setString(7, us.getTelefono());
			ps.setString(8, us.getDni());
			ps.setString(9, us.getPermiso());

			
			ps.executeUpdate();
			
			ps.close();

		} else if ("trabajador".equals(us.getPermiso())) {

			PreparedStatement ps = con.prepareStatement(
					"INSERT usuario (dni, puesto, nombre, apellido1, apellido2, correo, telefono, contrasena, permiso) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, us.getDni());
			ps.setString(2, us.getPuesto());
			ps.setString(3, us.getNombre());
			ps.setString(4, us.getApellido1());
			ps.setString(5, us.getApellido2());
			ps.setString(6, us.getCorreo());
			ps.setString(7, us.getTelefono());
			ps.setString(8, us.getDni());
			ps.setString(9, us.getPermiso());

			
			ps.executeUpdate();

			ps.close();

		}

	}


	/**
	 * Metodo para <strong>listar</strong> los usuarios desde la base de datos
	 * 
	 * @return la lista de usuarios
	 * @throws SQLException al haber errores listando usuarios
	 */
	public ArrayList<Usuario> listar() throws SQLException {

		String sql = "SELECT * FROM usuario"; 

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();

		ArrayList<Usuario> us = null;

		while (result.next()) {
			if (us == null) {
				us = new ArrayList<Usuario>();
			}
			us.add(new Usuario(result.getInt("idUsuario"), result.getString("dni"), result.getString("puesto"), result.getString("nombre"),
					result.getString("apellido1"), result.getString("apellido2"), result.getString("correo"),
					result.getString("telefono"), result.getString("permiso")));
		}
		return us;
	}

	/**
	 * Metodo para <strong>modificar</strong> un usuario en la base de datos
	 * 
	 * @param us el usuario a modifcar
	 * @throws SQLException si hay errores al modificar el usuario
	 */
	
	public void modificar(Usuario us) throws SQLException {
		
		System.out.println("id de usuario: " +us.idUsuario);
		
	    PreparedStatement ps;
	    	
	    	ps = con.prepareStatement(
	                "UPDATE usuario SET dni = ?, puesto = ?, nombre = ?, apellido1 = ?, apellido2 = ?, correo = ?, telefono = ? WHERE idUsuario = ?");
	    	ps.setString(1, us.getDni());
		    ps.setString(2, us.getPuesto());
		    ps.setString(3, us.getNombre());
		    ps.setString(4, us.getApellido1());
		    ps.setString(5, us.getApellido2());
		    ps.setString(6, us.getCorreo());
		    ps.setString(7, us.getTelefono());
		    ps.setInt(8, us.getIdUsuario());
		   
		    int filas = ps.executeUpdate();
		    System.out.println("Se han modificado " +filas+ " filas");
		    
		    ps.close();   
	    
	}
	
	/**
	 * Metodo para <strong>eliminar</strong> un usuario de la base de datos
	 * 
	 * @param us el usuario a eliminar
	 * @throws SQLException si hay errores al eliminar el usuario
	 */
	
	public void eliminar(Usuario us) throws SQLException {
		
	    PreparedStatement ps;
	    
	        ps = con.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
	        ps.setInt(1, us.getIdUsuario());
	        int filas = ps.executeUpdate();
	        
	        System.out.println("Se han eliminado " + filas + " filas");
	        
	        ps.close();  
	    
	}
	
	
	/**
	 * Metodo para <strong>iniciar</strong> sesión de un usuario
	 * 
	 * @param correo la direccion de correo electronico del usuario
	 * @param contrasena la contraseña del usuario
	 * @return el usuario que ha iniciado sesion
	 */
	
	public Usuario loginUsuario(String correo, String contrasena) {
	    Usuario usuario = null;
	    String query = "SELECT idUsuario, dni, puesto, nombre, apellido1, apellido2, correo, telefono, contrasena, permiso FROM usuario WHERE correo = ? AND contrasena = ?";
	    
	    try (PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setString(1, correo);
	        ps.setString(2, contrasena);

	        try (ResultSet resultSet = ps.executeQuery()) {
	            if (resultSet.next()) {
	                usuario = new Usuario();
	                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
	                usuario.setDni(resultSet.getString("dni"));
	                usuario.setPuesto(resultSet.getString("puesto"));
	                usuario.setNombre(resultSet.getString("nombre"));
	                usuario.setApellido1(resultSet.getString("apellido1"));
	                usuario.setApellido2(resultSet.getString("apellido2"));
	                usuario.setCorreo(resultSet.getString("correo"));
	                usuario.setTelefono(resultSet.getString("telefono"));
	                usuario.setPermiso(resultSet.getString("permiso"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return usuario;
	}
	
	/**
	 * Metodo que obtiene el nombre del usuario dado su idUsuario
	 * 
	 * @param idUsuario
	 * @return nombre del usuario
	 * @throws SQLException si hay un error en la obtención del nombre
	 */
	 public String obtenerNombreUsuario(int idUsuario) throws SQLException {
	        String sql = "SELECT nombre FROM usuario WHERE idUsuario = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, idUsuario);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            return rs.getString("nombre");
	        } else {
	            return null;
	        }
	    }
	
	/**
	 * Metodo para obtener un <strong>JSON</strong> de todos los usuarios
	 * 
	 * @return un string en formato JSON de todos los usuarios
	 * @throws SQLException si hay errores al obtener el JSON
	 */

	public String dameJson() throws SQLException {

		String txtJSON = "";
		Gson gson = new Gson();
		txtJSON = gson.toJson(this.listar());

		return txtJSON;
	}

	
}
