package entity;

import database.DBCittadinoRegistrato;
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
import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import control.Controller;


public class EntityCittadinoRegistrato {
	
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

	// costruttore con la PK
	
	public EntityCittadinoRegistrato() {
		super(); 
	}
	
	public EntityCittadinoRegistrato(int idCittadino) {
		
		this.idCittadino=idCittadino;
		DBCittadinoRegistrato cittadinoRegistrato = new DBCittadinoRegistrato(idCittadino); //carico dal DB con la PK
		this.nome = cittadinoRegistrato.getNome();
		this.cognome = cittadinoRegistrato.getCognome();
		this.cf = cittadinoRegistrato.getCf();
		this.dataNascita = cittadinoRegistrato.getDataNascita();
		this.luogoNascita = cittadinoRegistrato.getLuogoNascita();
		this.luogoResidenza = cittadinoRegistrato.getLuogoResidenza();
		this.telefono = cittadinoRegistrato.getTelefono();
		this.email = cittadinoRegistrato.getEmail();
		this.username = cittadinoRegistrato.getUsername();
		this.password = cittadinoRegistrato.getPassword();
	}
	
	//costruttore copia da oggettoDB
	
	public EntityCittadinoRegistrato(DBCittadinoRegistrato cittadinoRegistrato) {
		
		this.idCittadino = cittadinoRegistrato.getIdCittadino();
		this.nome = cittadinoRegistrato.getNome();
		this.cognome = cittadinoRegistrato.getCognome();
		this.cf = cittadinoRegistrato.getCf();
		this.dataNascita = cittadinoRegistrato.getDataNascita();
		this.luogoNascita = cittadinoRegistrato.getLuogoNascita();
		this.luogoResidenza = cittadinoRegistrato.getLuogoResidenza();
		this.telefono = cittadinoRegistrato.getTelefono();
		this.email = cittadinoRegistrato.getEmail();
		this.username = cittadinoRegistrato.getUsername();
		this.password = cittadinoRegistrato.getPassword();
		
	}

//	public int SalvaInDB(String nome,String cognome, String cf,
//			Date dataNascita, String luogoNascita, String luogoResidenza, 
//			String telefono, String email, String username, String password) {
//		
//		int ret=0;
//		
//		DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato();
//		
//		
//		try{
//
//			cittadino.setNome(nome);
//			cittadino.setCognome(cognome);
//			cittadino.setCf(cf);
//			cittadino.setDataNascita(dataNascita);
//			cittadino.setLuogoNascita(luogoNascita);
//			cittadino.setLuogoResidenza(luogoResidenza);
//			cittadino.setTelefono(telefono);
//			cittadino.setEmail(email);
//			cittadino.setUsername(username);
//			cittadino.setPassword(password);
//
//
//	
//			ret = cittadino.salvaInDB();
//			
//			if(ret>0) {
//				System.out.println("Cittadino registrato con successo!");
//			}
//
//		} catch (NomeNonValido ex) {
//				System.out.println(ex);
//				ret=-3;
//			} catch (NomeNonValido1 ex) {
//				System.out.println(ex);
//				ret=-4;
//			} catch (CognomeNonValido ex) {
//				System.out.println(ex);
//				ret=-5;
//			} catch (CognomeNonValido1 ex) {
//				System.out.println(ex);
//				ret=-6;
//			} catch (CfNonValido ex) {
//				System.out.println(ex);
//				ret=-7;
//			} catch (CfNonValido1 ex) {
//				System.out.println(ex);
//				ret=-8;
//			} catch (TelefonoNonValido ex) {
//				System.out.println(ex);
//				ret=-9;
//			} catch (TelefonoNonValido1 ex) {
//				System.out.println(ex);
//				ret=-10;
//			} catch (EmailNonValida ex) {
//				System.out.println(ex);
//				ret=-11;
//			} catch (PasswordNonValida ex) {
//				System.out.println(ex);
//				ret=-12;
//			} catch (PasswordNonValida1 ex) {
//				System.out.println(ex);
//				ret=-13;
//			} catch (PasswordNonValida2 ex) {
//				System.out.println(ex);
//				ret=-14;
//			} catch (LuogoResidenzaNonValido ex) {
//				System.out.println(ex);
//				ret=-15;
//			} catch (LuogoResidenzaNonValido1 ex) {
//				System.out.println(ex);
//				ret=-16;
//			} catch (LuogoNascitaNonValido ex) {
//				System.out.println(ex);
//				ret=-17;
//			} catch (LuogoNascitaNonValido1 ex) {
//				System.out.println(ex);
//				ret=-18;
//			} catch (UsernameNonValido ex) {
//				System.out.println(ex);
//				ret=-19;
//			}	
//		
//		return ret;
//	}

	
	public int effettuaRegistrazione() {
		DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato();
		cittadino.setIdCittadino(this.idCittadino);
		cittadino.setNome(this.nome);
		cittadino.setCognome(this.cognome);
		cittadino.setCf(this.cf);
		cittadino.setDataNascita(this.dataNascita);
		cittadino.setLuogoNascita(this.luogoNascita);
		cittadino.setLuogoResidenza(this.luogoResidenza);
		cittadino.setTelefono(this.telefono);
		cittadino.setEmail(this.email);
		cittadino.setUsername(this.username);
		cittadino.setPassword(this.password);
		
		return cittadino.create();
		
	}
	
	
	
//	public int cercaCittadinoPerCf(String cf) {
//		
//		DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato();
//		
//		try{
//			cittadino.setCf(cf);
//		} catch (CfNonValido ex) {
//			System.out.println(ex);
//		} catch (CfNonValido1 ex) {
//			System.out.println(ex);
//		}
//		
//		
//		return cittadino.cercaCittadinoPerCf(); 
//		
//		
//	}
	
	
	
	
	
	
//	public int cercaCittadinoPerLogin(String username, String password) {
//		
//		
//		
//		int ret = 0; 
//		
//		try{
//		
//			
//			DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(); 
//			cittadino.setUsername(username);
//			cittadino.setPassword(password);
//			ret = cittadino.cercaCittadinoPerLogin();
//
//		}catch (UsernameNonValido ex) {
//				System.out.println(ex);
//				ret=-2;
//			}catch (PasswordNonValida ex) {
//				System.out.println(ex);
//				ret=-3;
//			} catch (PasswordNonValida1 ex) {
//				System.out.println(ex);
//				ret=-4;
//			} catch (PasswordNonValida2 ex) {
//				System.out.println(ex);
//				ret=-5;
//			}	
//				
//		
//		return ret; 
//		
//	}
	
	

	
	public int getIdCittadino() {
		return idCittadino;
	}

	public void setIdCittadino(int idCittadino) {
		this.idCittadino = idCittadino;
	}
	
	public String getNome() {
		
		return nome;
	}

	public void setNome (String nome) throws NomeNonValido, NomeNonValido1{
		
		Pattern pattern = Pattern.compile("[^A-Za-z]");
        Matcher matcher = pattern.matcher(nome);
        boolean s = matcher.find();

    
        
		if((nome.length()<=30 && !s)){
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) throws CfNonValido,CfNonValido1{
		
		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$");
        Matcher matcher = pattern.matcher(cf);
        boolean s = matcher.find();

		if(cf.length()==16 && s){
			this.cf = cf;
		}else if(cf.length()>16 || cf.length()<16){
			throw new CfNonValido();
		}else if(!s){
			throw new CfNonValido1();
		}

	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) throws LuogoNascitaNonValido,LuogoNascitaNonValido1{
		
		Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(luogoNascita);
        boolean s = matcher.find();

		if(luogoNascita.length()<=60 && !s){
			this.luogoNascita = luogoNascita;
		}else if(luogoNascita.length()>60){
			throw new LuogoNascitaNonValido();
		}else if(s){
			throw new LuogoNascitaNonValido1();
		}

	}

	public String getLuogoResidenza() {
		return luogoResidenza;
	}

	public void setLuogoResidenza(String luogoResidenza) throws LuogoResidenzaNonValido,LuogoResidenzaNonValido1{
		
		Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(luogoResidenza);
        boolean s = matcher.find();

		if(luogoResidenza.length()<=60 && !s){
			this.luogoResidenza = luogoResidenza;
		}else if(luogoResidenza.length()>60){
			throw new LuogoResidenzaNonValido();
		}else if(s){
			throw new LuogoResidenzaNonValido1();
		}

	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws TelefonoNonValido,TelefonoNonValido1{
		
		Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(telefono);
        boolean s = matcher.find();
        
		if(telefono.length()==10 && !s){
			this.telefono = telefono;
		}else if(telefono.length()>10 || telefono.length()<10){
			throw new TelefonoNonValido();
		}else if(s){
			throw new TelefonoNonValido1();
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailNonValida{

		if(email.contains("@")) {
			this.email = email;
        } else {
			throw new EmailNonValida();
        }
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws UsernameNonValido{
		
		if(username.length()<=15){
			this.username = username;
		}else throw new UsernameNonValido();

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PasswordNonValida,PasswordNonValida1,PasswordNonValida2{
		
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "EntityCittadinoRegistrato [idCittadino=" + idCittadino + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", dataNascita=" + dataNascita + ", luogoNascita=" + luogoNascita + ", luogoResidenza=" + luogoResidenza + ", telefono=" + telefono + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
}
