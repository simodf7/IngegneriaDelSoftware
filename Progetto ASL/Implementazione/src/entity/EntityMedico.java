package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.DBMedico;
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

public class EntityMedico {
	
	private int idMedico;
	private String nome;
	private String cognome;
	private String specializzazione;
	private String email;
	private String password;
	
	
	public EntityMedico() {
		super();
	}
	
	//costruttore con la PK
	public EntityMedico(int idMedico) {
		
		this.idMedico = idMedico;
		DBMedico medico = new DBMedico(idMedico); //carico dal DB con la PK
		this.nome = medico.getNome();
		this.cognome = medico.getCognome();
		this.specializzazione = medico.getSpecializzazione();
		this.email = medico.getEmail();
		this.password = medico.getPassword();
	}
	
	//costruttore copia da oggettoDB
	public EntityMedico(DBMedico medico) {
		
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
		this.cognome = medico.getCognome();
		this.specializzazione = medico.getSpecializzazione();
		this.email = medico.getEmail();
		this.password = medico.getPassword(); 
		
	}
	
	
//	public int inserisciDatiMedici(String nome, String cognome, String specializzazione) {
//		
//		DBMedico medico = new DBMedico(); 
//		int ret = 0; 
//		
//		try{
//
//			medico.setNome(nome);
//			medico.setCognome(cognome);
//			medico.setSpecializzazione(specializzazione);
//
//			ret = medico.salvaInDB();   
//
//			if(ret == -1) return ret;  // se c'e' errore nell'inserimento 
//		
//			ret = medico.cercaMedico();
//			
//			
//		}catch (NomeNonValido ex) {
//			System.out.println(ex);
//			return -2;
//		} catch (NomeNonValido1 ex) {
//			System.out.println(ex);
//			return -3;
//		} catch (CognomeNonValido ex) {
//			System.out.println(ex);
//			return -4;
//		} catch (CognomeNonValido1 ex) {
//			System.out.println(ex);
//			return -5;
//		} catch (SpecializzazioneNonValida ex) {
//			System.out.println(ex);
//			return -6;
//		} catch (SpecializzazioneNonValida1 ex) {
//			System.out.println(ex);
//			return -7;
//		}
//		
//		
//		return ret;
//	}
	
	
	public int inserisciDatiMedici() {
		
		DBMedico medico = new DBMedico();
		medico.setIdMedico(this.idMedico);
		
		medico.setNome(this.nome);
		medico.setCognome(this.cognome);
		medico.setSpecializzazione(this.specializzazione);
		medico.setEmail(this.email);
		medico.setPassword(password);
		
		return medico.create();
		
		
	}
	
	
	
	
//	public int cercaMedico(String nome, String cognome, String specializzazione) { // che devo fare?
//		DBMedico medico = new DBMedico();  
//		
//		try {
//			medico.setNome(nome);
//			medico.setCognome(cognome);
//			medico.setSpecializzazione(specializzazione);
//			
//		}catch (NomeNonValido ex) {
//			System.out.println(ex);
//		} catch (NomeNonValido1 ex) {
//			System.out.println(ex);
//		} catch (CognomeNonValido ex) {
//			System.out.println(ex);
//		} catch (CognomeNonValido1 ex) {
//			System.out.println(ex);
//		} catch (SpecializzazioneNonValida ex) {
//			System.out.println(ex);
//		} catch (SpecializzazioneNonValida1 ex) {
//			System.out.println(ex);
//		}
//		
//			
//		return medico.cercaMedico(); 
//	}
	
	

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NomeNonValido,NomeNonValido1{
		
		Pattern pattern = Pattern.compile("[^A-Za-z]");
        Matcher matcher = pattern.matcher(nome);
        boolean s = matcher.find();

		if(nome.length()<=30 && !s){
			this.nome = nome;
		}else if(nome.length()>30){
			throw new NomeNonValido();
		}else if(s){
			throw new NomeNonValido1();
		}
		
	}

	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) throws CognomeNonValido,CognomeNonValido1{
		
		Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(cognome);
        boolean s = matcher.find();

		if(cognome.length()<=30 && !s){
			this.cognome = cognome;
		}else if(cognome.length()>30){
			throw new CognomeNonValido();
		}else if(s){
			throw new CognomeNonValido1();
		}

	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
//	public void setSpecializzazione(String specializzazione) throws SpecializzazioneNonValida,SpecializzazioneNonValida1 {
//		
//		Pattern pattern = Pattern.compile("[^A-Za-z]");
//        Matcher matcher = pattern.matcher(specializzazione);
//        boolean s = matcher.find();
//
//		if(specializzazione.length()<=50 && !s){
//			this.specializzazione = specializzazione;
//		}else if(specializzazione.length()>50){
//			throw new SpecializzazioneNonValida();
//		}else if(s){
//			throw new SpecializzazioneNonValida1();
//		}
//
//	}
	
	
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) throws EmailNonValida {
		
		if(email.contains("@")) {
			this.email = email;
        } else {
			throw new EmailNonValida();
        }
		
	}
	
	public String getPassword() {
		return password; 
	}
	
	
	
	public void setPassword(String password) throws PasswordNonValida1, PasswordNonValida, PasswordNonValida2 {
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(password);
        boolean s = matcher.find();

		char ch;
    	boolean upperCaseFlag = false;
    	boolean lowerCaseFlag = false;

    	for(int i=0;i<password.length();i++) {
        	ch = password.charAt(i);

        	if (Character.isUpperCase(ch)) {
            	upperCaseFlag = true;
        	} else if (Character.isLowerCase(ch)) {
            	lowerCaseFlag = true;
        	}
        	
		}

		if((password.length()>=8 && password.length()<=20) && s && upperCaseFlag && lowerCaseFlag ){
			this.password = password;
		}else if (!s){
			throw new PasswordNonValida1();
		}else if(password.length()<8 || password.length()>20){
			throw new PasswordNonValida();
		}else if(!upperCaseFlag || !lowerCaseFlag){
			throw new PasswordNonValida2();
		}
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "EntityMedico [idMedico=" + idMedico + ", nome=" + nome + ", cognome=" + cognome + ", specializzazione=" + specializzazione + "]";
	}




	
	
}
