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
import dao.DaoSeguro;
import dao.DaoTipoSeguro;


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
		
			if(request.getParameter("AgregarSeguro") != null) {
				
			
				DaoSeguro daoSeguro = new DaoSeguro();
				DaoTipoSeguro daoTipoSeguro = new DaoTipoSeguro();
				
				String nextId = daoSeguro.obtenerSiguienteId();
				List<TipoSeguro> listaCategoriaSeguros= daoTipoSeguro.listarCategorias();
				
			
				
			
		        request.setAttribute("nextId", nextId);
		        request.setAttribute("listaCategorias", listaCategoriaSeguros);

		   
		        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
