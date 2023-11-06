package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBRegistroPrenotazioni {

	private ArrayList<DBPrenotazione> prenotazioni; 
	
	
	public DBRegistroPrenotazioni() {
		caricaPrenotazioni();
	}
	
	



	public ArrayList<DBPrenotazione> ottieniPrenotazioni() {
		// TODO Auto-generated method stub
		return this.prenotazioni;
	}
	
	public void caricaPrenotazioni() {
		
	this.prenotazioni = new ArrayList<DBPrenotazione>(); 
		
		String query = new String("select idPrenotazione from Prenotazione");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBPrenotazione prenotazione = new DBPrenotazione(rs.getInt("idPrenotazione"));
				this.prenotazioni.add(prenotazione);
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
