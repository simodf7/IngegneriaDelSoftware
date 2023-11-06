package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBRegistroCittadini {

	private ArrayList<DBCittadinoRegistrato> cittadini; 
	
	
	public DBRegistroCittadini() {
		caricaCittadini();
	}
	
	
	
	
//	public static DBRegistroCittadini getInstance() {
//		if(instance == null) instance = new DBRegistroCittadini();
//		return instance;
//	}



	public ArrayList<DBCittadinoRegistrato> ottieniCittadini() {
		// TODO Auto-generated method stub
		return this.cittadini;
	}
	
	public void caricaCittadini() {
		
		this.cittadini = new ArrayList<DBCittadinoRegistrato>(); 
		
		String query = new String("select idCittadino from CittadinoRegistrato");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(rs.getInt("idCittadino"));
				this.cittadini.add(cittadino);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} finally { // Chiusura connessione
		
			try{
			DBConnectionManager.closeConnection();
		
			} catch(SQLException e){
			e.printStackTrace();
			}
		}
		
		
	}
	
	
}



