package control;

import java.sql.Date;
import java.sql.Time;
//import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.EntityASL;
import entity.EntityCittadinoRegistrato;
import entity.EntityPrenotazione;
import entity.EntityVisita;
import entity.EntityMedico;

import exceptions.*; 



public class Controller {
	
	public static Controller instance; 
	
	private Controller() {
		
	}
	
	
	public static Controller getInstance() {
		if(instance == null) instance = new Controller(); 
		return instance; 
	}
	
	public int effettuaRegistrazione(String nome,String cognome, String cf,
			Date dataNascita, String luogoNascita, String luogoResidenza, 
			String telefono, String email, String username, String password) {
		
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.effettuaRegistrazione(nome,cognome,cf, dataNascita, luogoNascita, luogoResidenza, 
				telefono, email, username, password);  
		
	}
	
	

	

	
	
	
	public int effettuaLoginCittadino(String username, String password) {
		
		EntityASL singleton = EntityASL.getInstance();
		int ret = singleton.effettuaLoginCittadino(username, password); 
		return ret; 
		
		
		
		
	}
	
	
	
	public int prenotaVisitaOnLine(int idCittadino, Date data, Time orario, String descrizione) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.prenotaVisitaOnLine(idCittadino, data, orario, descrizione);
		
	
	}
	
	
	public int verificaDisponibilita(Date data, Time orario, String descrizione) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.verificaDisponibilita(data,orario,descrizione);
		
	}
	
	public int prenotaVisita(String cf, int idVisita, Date data) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.prenotaVisita(cf, idVisita, data);
		
	}
	
	
	
	public int inserisciDatiMedici(String nome, String cognome, String specializzazione, String email, String password) {
		
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.inserisciDatiMedici(nome,cognome,specializzazione,email, password);
		
		
		
	}
	
	
	
	public  String[][] cercaDatiVisite(String nome, String cognome, String specializzazione){
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.cercaDatiVisite(nome, cognome, specializzazione);
		
		
	}
	
	
	
	
	public int inserisciVisita(String giorno, Time orario, String descrizione, int idMedico) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.inserisciVisita(giorno,orario, descrizione, idMedico);
		

	}
	
	
	public  String[][] cercaDatiVisiteConMedico(String descrizione) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.cercaDatiVisiteConMedico(descrizione);
	
	}
	
	

	
	
	public int modificaVisita(int idVisita, String giorno, Time orario, String descrizione) {
		
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.modificaVisita(idVisita, giorno , orario, descrizione);

	}
	
	
	
	
	
	public int disdiciVisitaOnLine(int idCittadino, Date data, Time orario, String descrizione) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.disdiciVisitaOnLine(idCittadino, data, orario, descrizione);
		
	
	}
	
	
	
	public int disdiciVisita(Date data, Time orario, String descrizione, String nome, String cognome) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.disdiciVisita(data, orario, descrizione, nome, cognome);
		
		
	}
	
	public int ricercaCittadino(String cf) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.ricercaCittadino(cf);
	}
	

	
	
	
	public  String[][] trovaPrenotazioniMedici(int idMedico){
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.trovaPrenotazioniMedici(idMedico);
		
		
		
	}
	
	
	
	public boolean effettuaLoginPersonale(String password) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.effettuaLoginPersonale(password);
	}
	
	public int effettuaLoginMedico(String email, String password) {
		
		EntityASL singleton = EntityASL.getInstance();
		return singleton.effettuaLoginMedico(email, password);
	}
	
	
	// FUNZIONI DI CONTROLLO


	
	public boolean isNomeValido(String nome) throws NomeNonValido {
        if(nome.length()>0 && nome.length()<=30) {
			return true;
		} else {
			throw new NomeNonValido();
		}
    }

	public boolean isNomeValido1(String nome) throws NomeNonValido1 {

		Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(nome);

       if(matcher.find()) {
        	throw new NomeNonValido1();
        } else {
			return true;
        }
    }

	public boolean isCognomeValido(String cognome) throws CognomeNonValido {
        if(cognome.length()>0  && cognome.length()<=30) {
			return true;
		} else {
			throw new CognomeNonValido();
		}
    }

	public boolean isCognomeValido1(String cognome) throws CognomeNonValido1 {

		
		Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(cognome);

       if(matcher.find()) {
        	throw new CognomeNonValido1();
        } else {
			return true;
        }
    }
	
	public boolean isCfValido(String cf) throws CfNonValido {
        if(cf.length()==16) {
			return true;
		} else {
			throw new CfNonValido();
		}
    }

	public boolean isCfValido1(String cf) throws CfNonValido1 {  // fixare presenza numeri

		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$");
        Matcher matcher = pattern.matcher(cf);

       if(matcher.find()) {
    	   return true;
        } else {
        	throw new CfNonValido1();
        }
    }

	public boolean isLuogoResidenzaValido(String lr) throws LuogoResidenzaNonValido {
        if(lr.length()>0 && lr.length()<=60) {
			return true;
		} else {
			throw new LuogoResidenzaNonValido();
		}
    }

	public boolean isLuogoResidenzaValido1(String lr) throws LuogoResidenzaNonValido1 {

		Pattern pattern = Pattern.compile("[^A-Za-z ]"); //Aggiungo uno spazio per contemplare anche ___ ___
        Matcher matcher = pattern.matcher(lr);

       if(matcher.find()) {
        	throw new LuogoResidenzaNonValido1();
        } else {
			return true;
        }
    }

	public boolean isLuogoNascitaValido(String ln) throws LuogoNascitaNonValido {
        if(ln.length()>0 && ln.length()<=60) {
			return true;
		} else {
			throw new LuogoNascitaNonValido();
		}
    }

	public boolean isLuogoNascitaValido1(String ln) throws LuogoNascitaNonValido1 {

		Pattern pattern = Pattern.compile("[^A-Za-z ]"); //Aggiungo uno spazio per contemplare anche ___ ___
        Matcher matcher = pattern.matcher(ln);

       if(matcher.find()) {
        	throw new LuogoNascitaNonValido1();
        } else {
			return true;
        }
    }

	public boolean isTelefonoValido(String tel) throws TelefonoNonValido {
        if(tel.length()==10) {
			return true;
		} else {
			throw new TelefonoNonValido();
		}
    }

	public boolean isTelefonoValido1(String tel) throws TelefonoNonValido1 {

		Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(tel);

       if(matcher.find()) {
        	throw new TelefonoNonValido1();
        } else {
			return true;
        }
    }

	public boolean isEmailValida(String em) throws EmailNonValida {

       if(em.contains("@")) {
			return true;
        } else {
			throw new EmailNonValida();
        }
    }

	public boolean isUsernameValido(String us) throws UsernameNonValido {
        if(us.length()>0 &&  us.length()<=15) {
			return true;
		} else {
			throw new UsernameNonValido();
		}
    }

	public boolean isPasswordValida(String pass) throws PasswordNonValida {
        if(pass.length()>=8 && pass.length()<=20) {
			return true;
		} else {
			throw new PasswordNonValida();
		}
    }

	public boolean isPasswordValida1(String pass) throws PasswordNonValida1 {

		Pattern pattern = Pattern.compile("[^A-Za-z0-9]"); //Contiene un simbolo speciale
        Matcher matcher = pattern.matcher(pass);

       if(matcher.find()) {
			return true;
        } else {
			throw new PasswordNonValida1();
        }
    }

	public boolean isPasswordValida2(String pass) throws PasswordNonValida2 {

		char ch;
    	boolean upperCaseFlag = false;
    	boolean lowerCaseFlag = false;

    	for(int i=0;i < pass.length();i++) {
        	ch = pass.charAt(i);

        	if (Character.isUpperCase(ch)) {
            	upperCaseFlag = true;
        	} else if (Character.isLowerCase(ch)) {
            	lowerCaseFlag = true;
        	}
        	
		}

       if(upperCaseFlag && lowerCaseFlag) {
			return true;
        } else {
			throw new PasswordNonValida2(); //Non contiene minuscola o maiuscola
        }

    }

	
	public boolean isSpecializzazioneValida(String sp) throws SpecializzazioneNonValida {
        if(sp.length()>0 && sp.length()<=50) {
			return true;
		} else {
			throw new SpecializzazioneNonValida();
		}
    }

	public boolean isSpecializzazioneValida1(String sp) throws SpecializzazioneNonValida1 {

		Pattern pattern = Pattern.compile("[^A-Za-z]"); 
        Matcher matcher = pattern.matcher(sp);

       if(matcher.find()) {
        	throw new SpecializzazioneNonValida1();
        } else {
			return true;
        }
    }

	//Eccezioni PrenotaVisitaOnLine

	public boolean isDescrizioneVisitaValida(String vi) throws DescrizioneVisitaNonValida {
        if(vi.length()>0 && vi.length()<=50) {
			return true;
		} else {
			throw new DescrizioneVisitaNonValida();
		}
    }

	public boolean isDescrizioneVisitaValida1(String vi) throws DescrizioneVisitaNonValida1 {

		Pattern pattern = Pattern.compile("[^A-Za-z ]"); //Aggiungo uno spazio per contemplare anche ___ ___
        Matcher matcher = pattern.matcher(vi);

       if(matcher.find()) {
        	throw new DescrizioneVisitaNonValida1();
        } else {
			return true;
        }
    }
	
	
	
	
	
	
	
}





