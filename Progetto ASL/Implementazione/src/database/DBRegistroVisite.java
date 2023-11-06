package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DBRegistroVisite {

	private ArrayList<DBVisita> visite; 
	
	
	public DBRegistroVisite() {
		caricaVisite();
	}
	
	


	public ArrayList<DBVisita> ottieniVisite() {
		// TODO Auto-generated method stub
		return this.visite;
	}
	
	public void caricaVisite() {
		
		this.visite = new ArrayList<DBVisita>(); 
		
		String query = new String("select idVisita from Visita");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBVisita visita = new DBVisita(rs.getInt("idVisita"));
				this.visite.add(visita);
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



