package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Date; 



public class DBPrenotazione {

	private int idPrenotazione;
	private Date data;
	private DBCodiceQr codiceQr; 
	private DBCittadinoRegistrato cittadino; 
	private DBVisita visita; 
	
	
	public DBPrenotazione() {
		super(); 
	}
	
	
	public DBPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione; 
		read(); 
	
	}
	
	
	public void read() {
		
		String query = new String("select * from Prenotazione where idPrenotazione =" + this.idPrenotazione);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				
				this.setData(rs.getDate("giorno"));
				//this.setOrario(rs.getTime("orario"));
				//.setDescrizioneVisita(rs.getString("descrizioneVisita"));
				
				DBCodiceQr codice = new DBCodiceQr(rs.getString("codice_CodiceQr")); 
				codice.read(); 
				this.setCodiceQR(codice); 
				
				DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(rs.getInt("cittadinoRegistrato_idCittadino")); 
				cittadino.read(); 
				this.setCittadino(cittadino); 
				
				DBVisita visita = new DBVisita(rs.getInt("visita_idVisita")); 
				visita.read(); 
				this.setVisita(visita); 
				
				
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
		
		int ret = -1;
		
		String query = "INSERT INTO Prenotazione(idPrenotazione, giorno, CittadinoRegistrato_idCittadino, "
				+ "Visita_IdVisita, Codice_CodiceQR) VALUES (" + this.idPrenotazione + ", \'"+ this.data + "\','"  + this.cittadino.getIdCittadino() + "\','" + this.visita.getIdVisita() + "\','" +  this.codiceQr.getcodiceQR()  + "\')"; 

		
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
	
	
//	public ArrayList<Integer> verificaDisponibilita() {
//		
//		ArrayList<Integer> id_trovati = new ArrayList<Integer>(); 
//		
//		String query = new String("select idVisita from visita where giorno = dayofweek(\'" + this.data + "\') and "
//				+ "orario =\'" + this.visita.getOrario() + "\' and descrizione =\'" + this.visita.getDescrizione() + "\'and idVisita not in(" + "select visita_idVisita from prenotazione"
//						+ " where giorno = \'" + this.data + "\')" ); 
//	
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			while(rs.next()) {
//				id_trovati.add(rs.getInt("idVisita")); 				
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//		return id_trovati; 
//	}
		
	

		

	
	
	
	
	
//	public int verificaEsistenzaPrenotazione() {
//		
//		int ret = -1; 
//		String query = new String("select idPrenotazione from prenotazione P, visita V, cittadinoregistrato C where P.visita_idVisita = V.idVisita and "
//				+ "P.CittadinoRegistrato_idCittadino = C.idCittadino and P.giorno =\'" + this.data + "\' and V.orario =\'" + this.visita.getOrario() + "\' and V.descrizione =\'"
//						+ this.visita.getDescrizione() + "\' and C.nome =\'" + this.cittadino.getNome() + "\' and C.cognome =\'" + this.cittadino.getCognome() + "\'" ); 
//	
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			if(rs.next()) {
//				ret = rs.getInt("idPrenotazione"); 				
//			}
//			else ret = 0;
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			ret = -1; 
//		}
//		
//		return ret; 
//		
//	}
	
	
//	public int prenotaVisita() {
//		
//		DBCodiceQr codice = new DBCodiceQr(); 
//		setCodiceQR(codice); 
//		codice.salvaInDB(); 
//		return salvaInDB();
//		
//	}
	
	

	
	public int disdiciVisita() {
		
		int ret; 
		
		String query =  new String("delete P from Prenotazione P where idPrenotazione =" + this.idPrenotazione); 
		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
		
	}
	
	
	
//      public ArrayList<String> trovaPrenotazioniMedici() {
//
//		ArrayList<String> info = new ArrayList<String>(); 
//		
//		// String[][] data = {};
//		
//		String query = new String("select P.giorno, V.orario, V.descrizione, Q.piano, Q.stanza, C.nome, C.cognome"
//				+ " from visita v, prenotazione p, cittadinoregistrato c, codiceqr q where p.visita_IdVisita = v.idVisita "
//				+ "and p.cittadinoRegistrato_idCittadino = c.idCittadino and p.codice_CodiceQr = q.CodiceQr and v.medico_idMedico = " + this.visita.getMedico().getIdMedico() ); 
//	
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			while(rs.next()) {
//
//			
//				info.add(rs.getDate("P.giorno").toString());
//				info.add(rs.getTime("V.orario").toString());
//				info.add(rs.getString("V.descrizione"));
//				info.add(String.valueOf(rs.getString("Q.piano")));
//				info.add(rs.getString("Q.stanza"));
//				info.add(rs.getString("C.nome"));
//				info.add(rs.getString("C.cognome"));
//			
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
//		return info; 
//		
//		
//	}
      
      
      public static int getID() {
  		int i=1;
  		
  		try {
  			
  			ResultSet res=DBConnectionManager.selectQuery("select max(idPrenotazione) as max from prenotazione");
  			
  			if(res.next()) { // se c'è almeno un record
  				i = res.getInt("max") + 1;
  			}
  			
  		}catch(SQLException | ClassNotFoundException e) {
  			e.printStackTrace();
  		}
  			
  		return i;
      }
	
	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}


	public DBCodiceQr getCodiceQR() {
		return codiceQr;
	}

	public void setCodiceQR(DBCodiceQr codiceQR) {
		this.codiceQr = codiceQR;
	}

	public DBCittadinoRegistrato getCittadino() {
		return cittadino;
	}

	public void setCittadino(DBCittadinoRegistrato cittadino) {
		this.cittadino = cittadino;
	}

	public DBVisita getVisita() {
		return visita; 
	}
	
	public void setVisita(DBVisita visita) {
		this.visita = visita; 
	}
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public Time getOrario() {
//		return orario;
//	}
//
//	public void setOrario(Time orario) {
//		this.orario = orario;
//	}

	@Override
	public String toString() {
		return "DBPrenotazione [idPrenotazione=" + idPrenotazione + ", data=" + data + ", codiceQR=" + codiceQr.getcodiceQR() + "]";
	}


	
	
}
