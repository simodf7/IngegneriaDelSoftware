package database;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;



public class DBVisita {
	
	private int idVisita;
	private int giorno;
	private Time orario;
	private String descrizione;
	private DBMedico medico; 
	

	public DBVisita(int idVisita) {
		this.idVisita = idVisita; 
		read(); 
	}
	
	
	public DBVisita() {
		// TODO Auto-generated constructor stub
		super();
	}


	public void read() {
		
		String query = new String("select * from Visita where idVisita =" + this.idVisita);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setGiorno(rs.getInt("giorno")); 
				this.setOrario(rs.getTime("orario"));
				this.setDescrizione(rs.getString("descrizione"));
				
				DBMedico medico = new DBMedico(rs.getInt("Medico_idMedico")); 
				medico.read();
				this.setMedico(medico); 
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
	
	
//	public void cercaVisita() {
//		
//		String query = new String("select * from Visita where idVisita =" + this.idVisita);
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			if(rs.next()) {
//				
//				this.setGiorno(rs.getInt("giorno")); 
//				this.setOrario(rs.getTime("orario"));
//				this.setDescrizione(rs.getString("descrizione"));
//				
//				DBMedico medico = new DBMedico(rs.getInt("Medico_idMedico")); 
//				medico.read();
//				this.setMedico(medico); 
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
	
	public int create() {
		
		
	
		int ret = 0;
		
		String query = "INSERT INTO Visita(idVisita, giorno, orario, descrizione, Medico_idMedico) VALUES ( " + this.idVisita + ", \'" + this.giorno + "\','" + this.orario + "\','" + this.descrizione + "\','" 
		+ this.medico.getIdMedico() + "\')"; 

		
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
	
	
//	public String[][] cercaDatiVisite() {
//		
//		String[] giorni = {"Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
//		
//		String query = new String("select idVisita,giorno,orario,descrizione from Visita where medico_idMedico =" + medico.getIdMedico());
//		ArrayList<String> info = new ArrayList<String>(); 
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			while(rs.next()) {
//				info.add(String.valueOf(rs.getInt("idVisita")));
//				info.add(giorni[rs.getInt("giorno")-1]); 
//				info.add(rs.getTime("orario").toString());
//				info.add(rs.getString("descrizione"));
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		
//		String[][] data = new String[info.size()/4][4]; 
//		
//		for(int i = 0; i<info.size()/4 ;i++){
//		   for(int j = 0; j<4;j++){
//			   		if(i==0) { 
//			   			data[i][j] = info.get(j); 
//			   			}
//			   		else {
//			   			data[i][j] = info.get(j + 4*i);
//			   		} 
//		     }
//		}
//		
//		return data; 
//		
//	}
//	
	
//	public String[][] cercaDatiVisiteConMedico() {
//		
//		String[] giorni = {"Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
//		
//		String query = new String("select V.giorno, V.orario, M.nome, M.cognome from visita V join medico m on V.Medico_idMedico = M.idMedico where V.descrizione =\'" 
//				+ this.descrizione + "\'");
//	
//		
//		ArrayList<String> info = new ArrayList<String>(); 
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			while(rs.next()) {
//				
//				info.add(rs.getString("M.nome")); 
//				info.add(rs.getString("M.cognome"));
//				info.add(giorni[rs.getInt("V.giorno")-1]);
//				info.add(rs.getTime("V.orario").toString());
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
//		String[][] data = new String[info.size()/4][4]; 
//		
//		for(int i = 0; i<info.size()/4 ;i++){
//		   for(int j = 0; j<4;j++){
//			   		if(i==0) { 
//			   			data[i][j] = info.get(j); 
//			   			}
//			   		else {
//			   			data[i][j] = info.get(j + 4*i);
//			   		} 
//		     }
//		}
//		
//		return data; 
//		
//	}
	
	
	
	
	public int update() {

		
	
		int ret = 0;
		
		String query = "UPDATE Visita set giorno=" + this.giorno + " , orario =\'" + this.orario + "\', descrizione = \'" + this.descrizione + "\' where idVisita =" + this.idVisita; 

		
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		
		
		
		return ret;
	}

	
	
	public static int getID() {
		int i=1;
		
		try {
			
			ResultSet res=DBConnectionManager.selectQuery("select max(idVisita) as max from visita");
			
			if(res.next()) { // se c'è almeno un record
				i = res.getInt("max") + 1;
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return i;
}
	
	
	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public DBMedico getMedico() {
		return medico;
	}

	public void setMedico(DBMedico medico) {
		this.medico = medico;
	}
	
	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public Time getOrario() {
		return orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	@Override
	public String toString() {
		return "DBVisita [idVisita=" + idVisita + ", giorno=" + giorno + ", orario=" + orario + ", descrizione=" + descrizione + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
