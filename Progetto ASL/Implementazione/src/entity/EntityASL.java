package entity;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.DBCittadinoRegistrato;
import database.DBCodiceQr;
import database.DBMedico;
import database.DBPrenotazione;
import database.DBVisita;
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
import exceptions.SpecializzazioneNonValida;
import exceptions.SpecializzazioneNonValida1;
import exceptions.TelefonoNonValido;
import exceptions.TelefonoNonValido1;
import exceptions.UsernameNonValido;

public class EntityASL {
	
	private static EntityASL instance = null; 
	
	
	private EntityASL() {
	
	}
	
	
	
	
	
	public static EntityASL getInstance() {
		if(instance == null) instance = new EntityASL(); 
		return instance; 
	}
	
	
	public int effettuaRegistrazione(String nome,String cognome, String cf,
			Date dataNascita, String luogoNascita, String luogoResidenza, 
			String telefono, String email, String username, String password) {
		
	
		
		EntityRegistroCittadini registro = EntityRegistroCittadini.getInstance();
		return registro.aggiungiCittadino(nome,cognome,cf, dataNascita, luogoNascita, luogoResidenza, 
				telefono, email, username, password);

		
		
	}
	
	
	
	
	public int effettuaLoginCittadino(String username, String password) {
		// TODO Auto-generated method stub

		
		EntityRegistroCittadini registro = EntityRegistroCittadini.getInstance();
		return registro.cercaCittadino(username, password);
		
	}
	
	
	
	
	public int prenotaVisitaOnLine(int idCittadino, Date data, Time orario, String descrizione) {
		
	
		int idVisita = verificaDisponibilita(data, orario, descrizione);
		
		if (idVisita >=1) {
			EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
			return registro.aggiungiPrenotazione(idCittadino,data,idVisita);
		}
		else {
			return 0;
		}
		
		
		
		
		
	}
	

	public int verificaDisponibilita(Date data, Time orario, String descrizione) {
		
		EntityRegistroVisite registroVisite = EntityRegistroVisite.getInstance();
		return registroVisite.verificaDisponibilita(data, orario, descrizione);
	}



	public int inserisciDatiMedici(String nome, String cognome, String specializzazione, String email, String password) {
		// TODO Auto-generated method stub
		
		
		EntityRegistroMedici registro = EntityRegistroMedici.getInstance();
		return registro.aggiungiMedico(nome,cognome, specializzazione,email,password);
		
		
	}





	public int inserisciVisita(String giorno, Time orario, String descrizione, int idMedico) {
		// TODO Auto-generated method stub
		
		
		EntityRegistroVisite registro = EntityRegistroVisite.getInstance();
		return registro.aggiungiVisita(giorno, orario, descrizione, idMedico);
		
	
	}





	public int prenotaVisita(String cf, int idVisita, Date data) {
		// TODO Auto-generated method stub
		
		int idCittadino = ricercaCittadino(cf);
		
		EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
		return registro.aggiungiPrenotazione(idCittadino,data,idVisita);
		
	}





	public int disdiciVisitaOnLine(int idCittadino, Date data, Time orario, String descrizione) {
		// TODO Auto-generated method stub

		
		EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
		return registro.rimuoviPrenotazioneOnLine(idCittadino, data,  orario, descrizione);
		
		
		
		
	}





	public int disdiciVisita(Date data, Time orario, String descrizione, String nome, String cognome) {
		// TODO Auto-generated method stub
		

		EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
		return registro.rimuoviPrenotazione(data, orario, descrizione,  nome, cognome);
		
	
	}





	public String[][] cercaDatiVisiteConMedico(String descrizione) {
		// TODO Auto-generated method stub
		
		EntityRegistroVisite registro = EntityRegistroVisite.getInstance();
		return registro.cercaVisitaConMedico(descrizione); 
	}





	public int modificaVisita(int idVisita, String giorno, Time orario, String descrizione) {
		// TODO Auto-generated method stub
		
		
		EntityRegistroVisite registro = EntityRegistroVisite.getInstance();
		return registro.modificaVisita(idVisita, giorno, orario,  descrizione);
			

	}





	public String[][] cercaDatiVisite(String nome, String cognome, String specializzazione) {
		// TODO Auto-generated method stub
		
		EntityRegistroVisite registro = EntityRegistroVisite.getInstance();
		return registro.cercaVisita(nome, cognome, specializzazione);
		
		
	}


	
	public int ricercaCittadino(String cf) {
		
		EntityRegistroCittadini registro = EntityRegistroCittadini.getInstance();
		return registro.cercaCittadino(cf);

		
	}
	



	public String[][] trovaPrenotazioniMedici(int idMedico) {
		// TODO Auto-generated method stub
		
		EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
		return registro.cercaPrenotazioniMedico(idMedico);
		
		
		
	}





	public boolean effettuaLoginPersonale(String password) {
		// TODO Auto-generated method stub
		
		if(password.equals("P8A=49")) {
			return true; 
		}
		
		return false;
	}





	public int effettuaLoginMedico(String email, String password) {
		// TODO Auto-generated method stub
		
		EntityRegistroMedici registro = EntityRegistroMedici.getInstance();
		return registro.cercaMedico(email, password);
		
		
	
	}
	
	
	
	
}
