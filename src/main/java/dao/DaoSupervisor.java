package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Supervisor;

public class DaoSupervisor {
	private Connection con = null;

	// Singleton
	private static DaoSupervisor instance = null;

	public DaoSupervisor() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static DaoSupervisor getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoSupervisor();
		}
		return instance;
	}

	// Insertar supervisor o trabajador
	public void insertar(Supervisor sup) throws SQLException {
		
		if("supervisor" .equals(sup.getPermiso()) ) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT supervisor (dni, puesto, nombre, apellido1, apellido2, correo, telefono, contrasena, permiso) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sup.getDni());
			ps.setString(2, sup.getPuesto());
			ps.setString(3, sup.getNombre());
			ps.setString(4, sup.getApellido1());
			ps.setString(5, sup.getApellido2());
			ps.setString(6, sup.getCorreo());
			ps.setInt(7, sup.getTelefono());
			ps.setString(8, sup.getDni());
			ps.setString(9, sup.getPermiso());
			

			// Ejecutar la query
			int filas = ps.executeUpdate();
			System.out.println("Se han añadido " + filas + " filas");

			ps.close();
			
		}else if("trabajador" .equals(sup.getPermiso())) {
			
			PreparedStatement ps = con.prepareStatement(
					"INSERT trabajador (dni, puesto, nombre, apellido1, apellido2, correo, telefono, contrasena, permiso) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sup.getDni());
			ps.setString(2, sup.getPuesto());
			ps.setString(3, sup.getNombre());
			ps.setString(4, sup.getApellido1());
			ps.setString(5, sup.getApellido2());
			ps.setString(6, sup.getCorreo());
			ps.setInt(7, sup.getTelefono());
			ps.setString(8, sup.getDni());
			ps.setString(9, sup.getPermiso());

			// Ejecutar la query
			int filas = ps.executeUpdate();
			System.out.println("Se han añadido " + filas + " filas");

			ps.close();
			
		}else {
			System.out.println("No ha entrado en los condicionales.");
		}

		
	}
	
	//Listar Usuarios con todos los datos (salvo contraseña)
	
	public ArrayList <Supervisor> listar() throws SQLException{
		
		String sql = "SELECT * FROM supervisor";		//Actualizar query para que incluya BD trabajadores
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();
		
		ArrayList <Supervisor> sup = null;
		
		while (result.next()) {
			if(sup == null) {
				sup = new ArrayList<Supervisor>();
			}
			sup.add(new Supervisor(result.getInt("idSupervisor"), result.getString("dni"), result.getString("puesto"), result.getString("nombre"), 
					result.getString("apellido1"), result.getString("apellido2"), result.getString("correo"), result.getInt("telefono"),
					 result.getString("permiso")));
		}
		return sup;
	}


	//JSON
	
	public String dameJson() throws SQLException {
		
		String txtJSON = "";
		Gson gson = new Gson();
		txtJSON = gson.toJson(this.listar());
		
		return txtJSON;
	}
	
}
