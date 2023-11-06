package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.DBVisita;
import database.DBRegistroVisite;

public class EntityRegistroVisite {

	private static EntityRegistroVisite instance = null;
	private ArrayList<EntityVisita> visite; 
	
	

	private EntityRegistroVisite () {
		
		DBRegistroVisite registroVisite = new DBRegistroVisite(); 
		
		ArrayList<DBVisita> v = new ArrayList<DBVisita>(); 
		v = registroVisite.ottieniVisite(); 
		this.visite = new ArrayList<EntityVisita>();
		
		
		for(DBVisita visita: v) {
			this.visite.add(new EntityVisita(visita)); 
		}
	
	
	
	}
	
	
	public static EntityRegistroVisite getInstance() {
		if(instance == null) instance = new EntityRegistroVisite();
		return instance;
	}
	
	
	public int aggiungiVisita(String giorno, Time orario, String descrizione, int idMedico) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Domenica", 1);
		map.put("Lunedi", 2);
		map.put("Martedi", 3);
		map.put("Mercoledi", 4);
		map.put("Giovedi", 5);
		map.put("Venerdi", 6);
		map.put("Sabato", 7);
		
		
		
		EntityVisita visita = new EntityVisita();
		visita.setIdVisita(DBVisita.getID());
		visita.setDescrizione(descrizione);
		visita.setGiorno(map.get(giorno)); 
		visita.setOrario(orario);
		
		EntityMedico medico = new EntityMedico(idMedico);
		visita.setMedico(medico);
		
		
		visite.add(visita);
		return visita.inserisciVisita();
	}


	public String[][] cercaVisitaConMedico(String descrizione) {
		// TODO Auto-generated method stub
		
		String[] giorni = {"Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
		ArrayList<String> info = new ArrayList<String>(); 
		
		for(EntityVisita v: visite) {
			if(v.getDescrizione().equals(descrizione)) {
				info.add(v.getMedico().getNome());
				info.add(v.getMedico().getCognome());
				info.add(giorni[v.getGiorno()-1]); 
				info.add(v.getOrario().toString());
			}
		}
		
		
		String[][] data = new String[info.size()/4][4]; 
		
		for(int i = 0; i<info.size()/4 ;i++){
		   for(int j = 0; j<4;j++){
			   		if(i==0) { 
			   			data[i][j] = info.get(j); 
			   			}
			   		else {
			   			data[i][j] = info.get(j + 4*i);
			   		} 
		     }
		}
		
		
		
		return data;
	}


	public int modificaVisita(int idVisita, String giorno, Time orario, String descrizione) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Domenica", 1);
		map.put("Lunedi", 2);
		map.put("Martedi", 3);
		map.put("Mercoledi", 4);
		map.put("Giovedi", 5);
		map.put("Venerdi", 6);
		map.put("Sabato", 7);
		
		for(EntityVisita v: visite) {
			if(v.getIdVisita() == idVisita) {
				v.setGiorno(map.get(giorno));
				v.setOrario(orario);
				v.setDescrizione(descrizione);
				break;
			}
		}
		
		
		EntityVisita visita = new EntityVisita(); 
		visita.setGiorno(map.get(giorno)); 
		visita.setOrario(orario);
		visita.setDescrizione(descrizione);
		visita.setIdVisita(idVisita);
		
	
		return visita.modificaVisita();
		
	}


	public String[][] cercaVisita(String nome, String cognome, String specializzazione) {
		// TODO Auto-generated method stub
		

		String[] giorni = {"Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"};
		ArrayList<String> info = new ArrayList<String>();
		
		
		for(EntityVisita v: visite) {
			if(v.getMedico().getNome().equals(nome) && v.getMedico().getCognome().equals(cognome) && v.getMedico().getSpecializzazione().equals(specializzazione)) {
				
				info.add(String.valueOf(v.getIdVisita()));
				info.add(giorni[v.getGiorno()-1]); 
				info.add(v.getOrario().toString());
				info.add(v.getDescrizione());
			}
		}
		
		String[][] data = new String[info.size()/4][4]; 
		
		for(int i = 0; i<info.size()/4 ;i++){
		   for(int j = 0; j<4;j++){
			   		if(i==0) { 
			   			data[i][j] = info.get(j); 
			   			}
			   		else {
			   			data[i][j] = info.get(j + 4*i);
			   		} 
		     }
		}
		
		return data; 
	}


	public int verificaDisponibilita(Date data, Time orario, String descrizione) {
		// TODO Auto-generated method stub
		
		
		boolean trovato = false;
		
		for(EntityVisita v: visite) {
			if(v.getGiorno() == data.getDay()+1 && v.getOrario().toLocalTime().equals(orario.toLocalTime())  && v.getDescrizione().equals(descrizione)) {
				
				trovato = false; 
				
				EntityRegistroPrenotazioni registro = EntityRegistroPrenotazioni.getInstance();
				trovato = registro.cercaPrenotazione(v, data);
			
				
				if(trovato == false) {
					return v.getIdVisita();
				}


			}
			
			
		}
		
		return -1; // visita non trovata
		
		
		
	}
	
}