package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String HOST    = "jdbc:mysql://localhost:3306/";
    private String USER = "admin";
    private String PASS   = "admin";
    private String  DBNAME  = "SegurosGroup";
    
    

    public Connection getConnection() {
    	Connection cn=null;
    	try {
    		cn=DriverManager.getConnection(HOST + DBNAME,USER,PASS);
    		System.out.println("Conectado");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
        return cn; 
    }
}
