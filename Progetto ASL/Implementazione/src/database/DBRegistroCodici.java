package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DBRegistroCodici {

	private ArrayList<DBCodiceQr> codici; 
	
	
	public DBRegistroCodici() {
		caricaCodici();
	}
	
	



	public ArrayList<DBCodiceQr> ottieniCodici() {
		// TODO Auto-generated method stub
		return this.codici;
	}
	
	public void caricaCodici() {
		
		this.codici = new ArrayList<DBCodiceQr>(); 
		
		String query = new String("select codice from CodiceQR");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				DBCodiceQr codice = new DBCodiceQr(rs.getString("codice"));
				this.codici.add(codice);
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




