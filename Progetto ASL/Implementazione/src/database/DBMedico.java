package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.EmailNonValida;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;
import exceptions.SpecializzazioneNonValida;
import exceptions.SpecializzazioneNonValida1;

public class DBMedico {
	
	private int idMedico; 
	private String nome;
	private String cognome;
	private String specializzazione;
	private String email;
	private String password;
	
	
	public DBMedico() {
		super(); 
	}
	
	
	public DBMedico(int idMedico){
		this.idMedico = idMedico; 
		read(); 
	}
	
	
	
	
	public void read() {
		
		String query = new String("select * from Medico where idMedico =" + this.idMedico);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.nome = rs.getString("nome"); 
				this.cognome = rs.getString("cognome");
				this.specializzazione = rs.getString("specializzazione");
				this.email = rs.getString("email");
				this.password = rs.getString("password");
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
		
		String query = "INSERT INTO Medico(idMedico, nome, cognome, specializzazione, email, password) VALUES (" + this.idMedico + ",\'" + this.nome + "\','" + this.cognome
				+ "\','" + this.specializzazione + "\','" + this.email + "\','" + this.password + "\')"; 
 
		
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
	
	
//	public int cercaMedico(){
//		
//
//		int ret = -1; 
//		
//		String query = new String("select idMedico from Medico where nome=\'" + this.nome + "\' and cognome=\'"+ this.cognome +
//				"\' and specializzazione=\'" + this.specializzazione + "\'");
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			if(rs.next()) {
//				ret = rs.getInt("idMedico");
//			}
//			else { ret = 0; }
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		
//		return ret; 
//		
//	}
	
	
	public static int getID() {
		int i=1;
		
		try {
			
			ResultSet res=DBConnectionManager.selectQuery("select max(idMedico) as max from medico");
			
			if(res.next()) { // se c'è almeno un record
				i = res.getInt("max") + 1;
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally { // Chiusura connessione
			
			try{
			DBConnectionManager.closeConnection();
		
			} catch(SQLException e){
			e.printStackTrace();
			}
		}
			
		return i;
}
	
	
	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) { this.nome = nome;}

	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {this.cognome = cognome;}
	
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
	public void setSpecializzazione(String specializzazione) {this.specializzazione = specializzazione;}

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {this.email = email;}
	
	public String getPassword() {
		return password; 
	}
	
	
	
	public void setPassword(String password) {this.password = password;}
	
	
	
	@Override
	public String toString() {
		return "DBMedico [idMedico=" + idMedico + ", nome=" + nome + ", cognome=" + cognome + ", specializzazione=" + specializzazione + "]";
	}

	
	
	

}
