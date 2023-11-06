package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.CfNonValido;
import exceptions.CfNonValido1;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.EmailNonValida;
import exceptions.LuogoNascitaNonValido;
import exceptions.LuogoNascitaNonValido1;
import exceptions.LuogoResidenzaNonValido;
import exceptions.LuogoResidenzaNonValido1;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;
import exceptions.TelefonoNonValido;
import exceptions.TelefonoNonValido1;
import exceptions.UsernameNonValido;

import java.sql.Date;





public class DBCittadinoRegistrato {

	private int idCittadino;
	private String nome;
	private String cognome;
	private String cf;
	private Date dataNascita;
	private String luogoNascita;
	private String luogoResidenza;
	private String telefono;
	private String email;
	private String username;
	private String password;

	
	public DBCittadinoRegistrato() {
		super(); 
	}
	
	
	
	public DBCittadinoRegistrato(int idCittadino) {
		
		this.idCittadino = idCittadino; 
		read(); 
		
	}
	



	public void read() {
		
		String query = new String("select * from CittadinoRegistrato where idCittadino =" + this.idCittadino);
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.nome = rs.getString("nome"); 
				this.cognome = rs.getString("cognome");
				this.cf = rs.getString("cf");
				this.dataNascita = rs.getDate("dataNascita");
				this.luogoNascita = rs.getString("luogoNascita");
				this.luogoResidenza = rs.getString("luogoResidenza");
				this.telefono = rs.getString("telefono");
				this.email = rs.getString("email");
				this.username = rs.getString("username");
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
	
	
	
//	public int cercaCittadinoPerCf() {
//		 
//		int ret = -1;
//		
//		String query = new String("select idCittadino from CittadinoRegistrato where cf =\'" + this.cf + "\'");
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			if(rs.next()) { 
//				ret = rs.getInt("idCittadino"); 
//			}
//			else { ret = 0; }
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return ret;
//		
//	}
	
	
	
	
	
//	public int cercaCittadinoPerLogin() {
//		 
//		int ret = -1;
//		
//		String query = new String("select idCittadino from CittadinoRegistrato where username =\'" + this.username  + "\' and password = \'" + this.password + "\'" );
//		
//		try {
//			ResultSet rs = DBConnectionManager.selectQuery(query);
//			
//			if(rs.next()) { 
//				ret = rs.getInt("idCittadino"); 
//			}
//			else { ret = 0; }
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return ret;
//		
//		
//		
//	}
	
	
	
	public int create()
	{
	
			
		int ret;
		
		
		// ??????????
		String query = "INSERT INTO CittadinoRegistrato(idCittadino,nome,cognome,cf,dataNascita,luogoNascita,"
				+ "luogoResidenza,telefono,email,username,password) VALUES ("+ this.idCittadino 
				+ ",'" + this.nome + "\','" + this.cognome + "\','" + this.cf + "\','" + 
				this.dataNascita + "\','" + this.luogoNascita + "\','" + this.luogoResidenza + "\','" + this.telefono + "\','" + this.email + "\','" + this.username + "\','" + this.password + "\')"; 

	
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
		
		
		System.out.println("DB " + ret);
		
		return ret;
	
	}
	
	
	
	
	
	
	
	public static int getID() {
		int i=1;
		
		try {
			
			ResultSet res=DBConnectionManager.selectQuery("select max(idCittadino) as max from cittadinoRegistrato");
			
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
	
	
	
	public int getIdCittadino() {
		return idCittadino;
	}
	


	public void setIdCittadino(int idCittadino) {
		this.idCittadino = idCittadino;
	}
	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {this.nome = nome;}
	

	public String getCognome() {
		return cognome;
	}

	
	
	public void setCognome(String cognome) {this.cognome = cognome;}
	
	

	public String getCf() {
		return cf;
	}

	
	public void setCf(String cf) {this.cf = cf;}
	

	public String getLuogoNascita() {
		return luogoNascita;
	}

	

	
	public void setLuogoNascita(String luogoNascita) {this.luogoNascita = luogoNascita;}
	

	public String getLuogoResidenza() {
		return luogoResidenza;
	}


	
	
	public void setLuogoResidenza(String luogoResidenza) {this.luogoResidenza = luogoResidenza;}
	
	public String getTelefono() {
		return telefono;
	}


	
	public void setTelefono(String telefono) {this.telefono = telefono;}

	public String getEmail() {
		return email;
	}


	
	public void setEmail(String email) {this.email = email;}

	public String getUsername() {
		return username;
	}


	
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {
		return password;
	}

	
	
	public void setPassword(String password) {this.password = password;}
	

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita; // (?) 
	}

	@Override
	public String toString() {
		return "DBCittadinoRegistrato [idCittadino=" + idCittadino + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", dataNascita=" + dataNascita + ", luogoNascita=" + luogoNascita + ", luogoResidenza=" + luogoResidenza + ", telefono=" + telefono + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
