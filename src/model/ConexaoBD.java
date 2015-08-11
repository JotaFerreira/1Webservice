package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	private static final String URL = "jdbc:mysql://localhost:3306/bdandroid";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	
	public static Connection conexaoMySql() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");		
		return DriverManager.getConnection(URL,USUARIO,SENHA);
			
	}
	
}
