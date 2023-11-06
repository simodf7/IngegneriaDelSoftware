package entity;

import java.sql.Date;
import java.util.ArrayList;

import database.DBCittadinoRegistrato;
import database.DBRegistroCittadini;
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

public class EntityRegistroCittadini {

	private static EntityRegistroCittadini instance = null;
	private ArrayList<EntityCittadinoRegistrato> cittadini; 
	
	

	private EntityRegistroCittadini () {
		
		DBRegistroCittadini registroCittadini = new DBRegistroCittadini(); 
		
		ArrayList<DBCittadinoRegistrato> c = new ArrayList<DBCittadinoRegistrato>(); 
		c = registroCittadini.ottieniCittadini(); 
		this.cittadini = new ArrayList<EntityCittadinoRegistrato>();
		
		
		for(DBCittadinoRegistrato cittadino: c) {
			this.cittadini.add(new EntityCittadinoRegistrato(cittadino)); 
		}
	
	
	
	}
	
	
	public static EntityRegistroCittadini getInstance() {
		if(instance == null) instance = new EntityRegistroCittadini();
		return instance;
	}
	
	
	public int aggiungiCittadino(String nome,String cognome, String cf,
			Date dataNascita, String luogoNascita, String luogoResidenza, 
			String telefono, String email, String username, String password) {
		

		EntityCittadinoRegistrato cittadino = new EntityCittadinoRegistrato();    
		cittadino.setIdCittadino(DBCittadinoRegistrato.getID()); 
		
		try{

			cittadino.setNome(nome);
			cittadino.setCognome(cognome);
			cittadino.setCf(cf);
			cittadino.setDataNascita(dataNascita);
			cittadino.setLuogoNascita(luogoNascita);
			cittadino.setLuogoResidenza(luogoResidenza);
			cittadino.setTelefono(telefono);
			cittadino.setEmail(email);
			cittadino.setUsername(username);
			cittadino.setPassword(password);


			
			
			
		} catch (NomeNonValido ex) {
				System.out.println(ex);
				return -3;
			} catch (NomeNonValido1 ex) {
				System.out.println(ex);
				return -4;
			} catch (CognomeNonValido ex) {
				System.out.println(ex);
				return -5;
			} catch (CognomeNonValido1 ex) {
				System.out.println(ex);
				return -6;
			} catch (CfNonValido ex) {
				System.out.println(ex);
				return -7;
			} catch (CfNonValido1 ex) {
				System.out.println(ex);
				return -8;
			} catch (TelefonoNonValido ex) {
				System.out.println(ex);
				return -9;
			} catch (TelefonoNonValido1 ex) {
				System.out.println(ex);
				return -10;
			} catch (EmailNonValida ex) {
				System.out.println(ex);
				return -11;
			} catch (PasswordNonValida ex) {
				System.out.println(ex);
				return -12;
			} catch (PasswordNonValida1 ex) {
				System.out.println(ex);
				return -13;
			} catch (PasswordNonValida2 ex) {
				System.out.println(ex);
				return -14;
			} catch (LuogoResidenzaNonValido ex) {
				System.out.println(ex);
				return -15;
			} catch (LuogoResidenzaNonValido1 ex) {
				System.out.println(ex);
				return -16;
			} catch (LuogoNascitaNonValido ex) {
				System.out.println(ex);
				return -17;
			} catch (LuogoNascitaNonValido1 ex) {
				System.out.println(ex);
				return -18;
			} catch (UsernameNonValido ex) {
				System.out.println(ex);
				return -19;
			}			
			
		
		// controllo 
		
		boolean trovato = false;
		for(EntityCittadinoRegistrato c: cittadini) {
			if(c.getCf().equals(cf)) {
				trovato = true;
				break; 
			}
		}
		
		if(trovato) {
			return -2;
		}
		else {
			cittadini.add(cittadino);
			return cittadino.effettuaRegistrazione();
		}
		
	}
	
	
	public int cercaCittadino(String username, String password) {

		boolean loginCheck = false; 
		int idCittadino = 0; 
		
		for(EntityCittadinoRegistrato c: cittadini) {
			if(c.getUsername().equals(username) && c.getPassword().equals(password)) {
				loginCheck = true;
				idCittadino = c.getIdCittadino();
				break; 
			}
		}
		
		if(loginCheck == true) {
			return idCittadino;
		}
		
		return 0; 
	}


	public int cercaCittadino(String cf) {
		// TODO Auto-generated method stub
		
		for(EntityCittadinoRegistrato c: cittadini) {
			if(c.getCf().equals(cf)) {
				return c.getIdCittadino(); 
			}
		}
		
		return -2;
	}
	
	
	
	
	
}