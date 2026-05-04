package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidad.TipoSeguro;


public class DaoTipoSeguro {

	
	 public List<TipoSeguro> listarCategorias() {
	        List<TipoSeguro> lista = new ArrayList<>();
	        String query = "SELECT * FROM tiposeguros";
	        Conexion conexion = new Conexion();
	        Connection cn = null;
	        try {
	            cn = conexion.getConnection();
	            Statement st = cn.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next()) {
	                TipoSeguro ts = new TipoSeguro();
	                ts.setIdTipo(rs.getInt("idTipo"));
	                ts.setDescripcion(rs.getString("descripcion"));
	                lista.add(ts);	              
	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	 
	 
}
