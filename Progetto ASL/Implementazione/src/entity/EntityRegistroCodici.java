package entity;

import java.util.ArrayList;

import database.DBCodiceQr;
import database.DBRegistroCodici;

public class EntityRegistroCodici {

	private static EntityRegistroCodici instance = null;
	private ArrayList<EntityCodiceQr> codici; 
	
	

	private EntityRegistroCodici () {
		
		DBRegistroCodici registroCodici = new DBRegistroCodici(); 
		
		ArrayList<DBCodiceQr> c = new ArrayList<DBCodiceQr>(); 
		c = registroCodici.ottieniCodici(); 
		this.codici = new ArrayList<EntityCodiceQr>();
		
		
		for(DBCodiceQr codice: c) {
			this.codici.add(new EntityCodiceQr(codice)); 
		}
	
	
	
	}
	
	
	public static EntityRegistroCodici getInstance() {
		if(instance == null) instance = new EntityRegistroCodici();
		return instance;
	}


	public void aggiungiCodice(EntityCodiceQr codice) {
		// TODO Auto-generated method stub
		codici.add(codice);
	}
	
	
}