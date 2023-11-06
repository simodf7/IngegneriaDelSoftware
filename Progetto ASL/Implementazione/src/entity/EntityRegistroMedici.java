package entity;

import java.util.ArrayList;

import database.DBMedico;
import database.DBRegistroMedici;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.EmailNonValida;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;
import exceptions.PasswordNonValida;
import exceptions.PasswordNonValida1;
import exceptions.PasswordNonValida2;

public class EntityRegistroMedici {

	private static EntityRegistroMedici instance = null;
	private ArrayList<EntityMedico> medici; 
	
	

	private EntityRegistroMedici () {
		
		DBRegistroMedici registroMedici = new DBRegistroMedici(); 
		
		ArrayList<DBMedico> m = new ArrayList<DBMedico>(); 
		m = registroMedici.ottieniMedici(); 
		this.medici = new ArrayList<EntityMedico>();
		
		
		for(DBMedico medico: m) {
			this.medici.add(new EntityMedico(medico)); 
		}
	
	
	
	}
	
	
	public static EntityRegistroMedici getInstance() {
		if(instance == null) instance = new EntityRegistroMedici();
		return instance;
	}
	
	
	public int aggiungiMedico(String nome, String cognome, String specializzazione, String email, String password) {
		
		
		
			EntityMedico medico = new EntityMedico();
			medico.setIdMedico(DBMedico.getID());
			
							
		
			try{
		
				medico.setNome(nome);
				medico.setCognome(cognome);
				medico.setSpecializzazione(specializzazione);
				medico.setEmail(email);
				medico.setPassword(password);
				
			}catch (NomeNonValido ex) {
				System.out.println(ex);
				return -2;
			} catch (NomeNonValido1 ex) {
				System.out.println(ex);
				return -3;
			} catch (CognomeNonValido ex) {
				System.out.println(ex);
				return -4;
			} catch (CognomeNonValido1 ex) {
				System.out.println(ex);
				return -5;
			}  catch (EmailNonValida ex) {
				System.out.println(ex);
				return -6;
			} catch (PasswordNonValida ex) {
				System.out.println(ex);
				return -7;
			} catch (PasswordNonValida1 ex) {
				System.out.println(ex);
				return -8;
			} catch (PasswordNonValida2 ex) {
				System.out.println(ex);
				return -9;
			}
			
			

			// controllo 
			
			boolean trovato = false; 
			
			for(EntityMedico m: medici) {
				if(m.getEmail().equals(email) && m.getPassword().equals(password)) {
					trovato = true; 
					break;
				}
			}
				
			if(trovato == false) {
				medici.add(medico);
				
				
				if(medico.inserisciDatiMedici() == 1) {
					return medico.getIdMedico();
				}
				else return -1;
			}
				
			
			
			
		
		
		
		return 0; // medico gia presente 
				
				
		
		
	}


	public int cercaMedico(String email, String password) {
		// TODO Auto-generated method stub
		
		for(EntityMedico m: medici) {
			if(m.getEmail().equals(email) && m.getPassword().equals(password)) {
				return m.getIdMedico();
			}
		}
		
		return -1;
	}
	
	
}