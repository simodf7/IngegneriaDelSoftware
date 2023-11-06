package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "mydb";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root"; 
	private static String password = "Progettois2023";
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		conn = null;		
		Class.forName(driver); //com.mysql.cj.jdbc.Driver
		
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		
		if(conn != null) conn.close();
	}
	
	public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {
		
		conn = getConnection();
		//System.out.println("Connessione Effettuata");
		
		Statement statment = conn.createStatement();
		
		ResultSet ret = statment.executeQuery(query);
	
		return ret;
	}
	
	public static int updateQuery(String query) throws ClassNotFoundException, SQLException {
		
		conn = getConnection();
		Statement statement = conn.createStatement();
		int ret = statement.executeUpdate(query);
		conn.close();
		return ret;
	}
	
	public static Integer updateQueryReturnGeneratedKey(String query) throws ClassNotFoundException, SQLException {
		Integer ret = null;
		
		conn = getConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = statement.getGeneratedKeys();
		if (rs.next()){
		    ret = rs.getInt(1);
		}
		
		conn.close();
		
		return ret;
	}
}