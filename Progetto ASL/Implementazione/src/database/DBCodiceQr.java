package database;

import java.sql.ResultSet;
import java.sql.SQLException;





public class DBCodiceQr {

	private String codice;
	private String stanza;
	private String piano;
	// primary key aggiunta a prenotazione
	
	
	public DBCodiceQr() {
		super(); 
//		this.codice = generateRandomString(20);
//		this.stanza = generateRandomString(2); 
//		Random random = new Random();
//        this.piano = String.valueOf((random.nextInt(5) + 1)); // casting
	}
	
	
	public DBCodiceQr(String codice) {
		
		this.codice = codice; 
		read(); 
	}
	
	
	public void read() {
		
		String query = new String("select * from CodiceQR where codice = \'" + this.codice + "\'");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setStanza(rs.getString("stanza"));
				this.setPiano(rs.getString("piano"));
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
	

	public int create() {
		

	
		int ret = 0;
		
		
		
		String query = "INSERT INTO CodiceQR(codice, stanza, piano) VALUES ( \'"+ this.codice +"\',"+"\'"+ this.stanza +"\','"+ this.piano+"\')"; 

		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} finally { // Chiusura connessione
			
			try{
			DBConnectionManager.closeConnection();
		
			} catch(SQLException e){
			e.printStackTrace();
			}
		}
		
		
		
		return ret;
	}
	
	
	

	

  

	
	
	public String getcodiceQR() {
		return codice;
	}
	public void setcodiceQR(String codice) {
		this.codice = codice;
	}
	
	public String getStanza() {
		return stanza;
	}
	public void setStanza(String stanza) {
		this.stanza = stanza;
	}
	
	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}
	
	
	
	@Override
	public String toString() {
		return "DBCodiceQR [codiceQR=" + codice + ", stanza=" + stanza + ", piano=" + piano +"]";
	}

	
	

	
	
	
	
}
