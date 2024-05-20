package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Supervisor;
import modelo.Usuario;

public class DaoUsuario {
	private Connection con = null;

	// Singleton
	private static DaoUsuario instance = null;

	public DaoUsuario() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static DaoUsuario getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoUsuario();
		}
		return instance;
	}

	// Insertar supervisor o trabajador
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

			// Ejecutar la query
			int filas = ps.executeUpdate();
			System.out.println("Se han añadido " + filas + " filas");

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

			// Ejecutar la query
			int filas = ps.executeUpdate();
			System.out.println("Se han añadido " + filas + " filas");

			ps.close();

		} else {
			System.out.println("No ha entrado en los condicionales.");
		}

	}

	// Listar Usuarios con todos los datos (salvo contraseña)

	public ArrayList<Usuario> listar() throws SQLException {

		String sql = "SELECT * FROM usuario"; // Actualizar query para que incluya BD trabajadores

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
	
	
	public void eliminar(Usuario us) throws SQLException {
		
	    PreparedStatement ps;
	    
	        ps = con.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
	        ps.setInt(1, us.getIdUsuario());
	        int filas = ps.executeUpdate();
	        
	        System.out.println("Se han eliminado " + filas + " filas");
	        
	        ps.close();  
	    
	}
	

	/*
	//Login funcional
	public Usuario loginUsuario(String correo, String contrasena) {
		Usuario usuario = null;
		
		 String query = "SELECT correo, permiso FROM usuario WHERE correo = ? AND contrasena = ?";
		    try (PreparedStatement ps = con.prepareStatement(query)) {
		        ps.setString(1, correo);
		        ps.setString(2, contrasena);

		        try (ResultSet resultSet = ps.executeQuery()) {
		            if (resultSet.next()) {
		                usuario = new Usuario(resultSet.getString("correo"), resultSet.getString("permiso"));
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return usuario;
		
	}
	*/
	
	//Login con todo para datos de perfil
	
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
	
	

	// JSON

	public String dameJson() throws SQLException {

		String txtJSON = "";
		Gson gson = new Gson();
		txtJSON = gson.toJson(this.listar());

		return txtJSON;
	}

	/*
	public Supervisor logIn (Supervisor sup, String contrasena) {
		String sql = "SELECT FROM supervisor WHERE correo = ? AND contrasena=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sup.getCorreo());
		ps.setString(2, contrasena);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		Supervisor s = new Supervisor (rs.getString("correo"), rs.getString("contrasena"), rs.getString("permiso"));
		
		return s;
		
	}

*/
	
}
