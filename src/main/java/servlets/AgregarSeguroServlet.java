package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Seguro;
import Entidad.TipoSeguro;
import dao.Conexion;



/**
 * Servlet implementation class AgregarSeguroServlet
 */
@WebServlet("/AgregarSeguroServlet")
public class AgregarSeguroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarSeguroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String nextId = "";
		List<TipoSeguro> listaCategoriaSeguros = new ArrayList<>();
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		
		try {
			cn = conexion.getConnection();
			Statement st = cn.createStatement();
			
			
			String queryId = "SELECT IFNULL(MAX(idSeguro),0)+1 AS proximoId FROM seguros";
			ResultSet rsId = st.executeQuery(queryId);
			if (rsId.next()) {
				nextId = rsId.getString("proximoId");
			}
			
			
			String queryTipos = "SELECT * FROM tiposeguros";
			ResultSet rsTipos = st.executeQuery(queryTipos);
			while (rsTipos.next()) {
				TipoSeguro ts = new TipoSeguro();
				ts.setIdTipo(rsTipos.getInt("idTipo"));
				ts.setDescripcion(rsTipos.getString("descripcion"));
				listaCategoriaSeguros.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		request.setAttribute("nextId", nextId);
		request.setAttribute("tipos", listaCategoriaSeguros);

		
		request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

