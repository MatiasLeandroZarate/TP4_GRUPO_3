package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidad.TipoSeguro;

public class DaoSeguro {

	
	
	public String obtenerSiguienteId() {
	
	
	    String query = "SELECT IFNULL(MAX(idSeguro),0)+1 AS proximoId FROM seguros";			
	    String nextId = "";
	    
	    Conexion conexion = new Conexion();
        Connection cn = null;
        
        try {
            cn = conexion.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);  
            nextId = rs.getString("proximoId");               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nextId;
	}
    
	
}
