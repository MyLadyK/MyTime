package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import dao.DaoTurno;
import dao.DaoUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Turno;

/**
 * Servlet implementation class ListarTurno
 */
public class ListarTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTurno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
	            PrintWriter out = response.getWriter();
	            DaoTurno daoTurno = DaoTurno.getInstance();
	            DaoUsuario daoUsuario = DaoUsuario.getInstance();
	            ArrayList<Turno> turnos = daoTurno.listar();
	            
	            ArrayList<Map<String, Object>> turnosConTrabajador = new ArrayList<>();
	            for (Turno turno : turnos) {
	                Map<String, Object> turnoMap = new HashMap<>();
	                turnoMap.put("anno", turno.getAnno());
	                turnoMap.put("mes", turno.getMes());
	                turnoMap.put("diaInicio", turno.getDiaInicio());
	                turnoMap.put("diaFin", turno.getDiaFin());
	                turnoMap.put("horaInicio", turno.getHoraInicio());
	                turnoMap.put("horaFin", turno.getHoraFin());
	                turnoMap.put("tipoTurno", turno.getTipoTurno());
	                turnoMap.put("idUsuario", turno.getIdUsuario());
	                turnoMap.put("nombreUsuario", daoUsuario.obtenerNombreUsuario(turno.getIdUsuario()));
	                turnosConTrabajador.add(turnoMap);
	            }

	            Gson gson = new Gson();
	            String resultado = gson.toJson(turnosConTrabajador);
	            out.print(resultado);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
