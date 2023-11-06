package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DBRegistroMedici {

	private ArrayList<DBMedico> medici; 
	
	
	public DBRegistroMedici() {
		caricaMedici();
	}
	
	



	public ArrayList<DBMedico> ottieniMedici() {
		// TODO Auto-generated method stub
		return this.medici;
	}
	
	public void caricaMedici() {
		
		this.medici = new ArrayList<DBMedico>(); 
		
		String query = new String("select idMedico from Medico");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBMedico medico = new DBMedico(rs.getInt("idMedico"));
				this.medici.add(medico);
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



