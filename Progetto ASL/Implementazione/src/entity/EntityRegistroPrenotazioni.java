package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import database.DBPrenotazione;
import database.DBRegistroPrenotazioni;

public class EntityRegistroPrenotazioni {

	private static EntityRegistroPrenotazioni instance = null;
	private ArrayList<EntityPrenotazione> prenotazioni; 
	
	

	private EntityRegistroPrenotazioni () {
		
		DBRegistroPrenotazioni registroPrenotazioni =  new DBRegistroPrenotazioni(); 
		
		ArrayList<DBPrenotazione> p = new ArrayList<DBPrenotazione>(); 
		p = registroPrenotazioni.ottieniPrenotazioni(); 
		this.prenotazioni = new ArrayList<EntityPrenotazione>();
		
		
		for(DBPrenotazione prenotazione: p) {
			this.prenotazioni.add(new EntityPrenotazione(prenotazione)); 
		}
	
	
	
	}
	
	
	public static EntityRegistroPrenotazioni getInstance() {
		if(instance == null) instance = new EntityRegistroPrenotazioni();
		return instance;
	}


	public int rimuoviPrenotazioneOnLine(int idCittadino, Date data, Time orario, String descrizione) {
		// TODO Auto-generated method stub
		

		for(EntityPrenotazione p: prenotazioni) { //  v.getOrario().toLocalTime().compareTo(orario.toLocalTime()) == 0
			if(p.getData().toLocalDate().equals(data.toLocalDate()) && p.getVisita().getOrario().toLocalTime().equals(orario.toLocalTime()) && p.getVisita().getDescrizione().equals(descrizione)
					&& p.getCittadino().getIdCittadino() == idCittadino) {
				prenotazioni.remove(p);
				return p.disdiciVisitaOnLine(); 
			}
		}
		
		return 0; 
	}


	public int rimuoviPrenotazione(Date data, Time orario, String descrizione, String nome, String cognome) {
		// TODO Auto-generated method stub
		
		for(EntityPrenotazione p: prenotazioni) {
			
			if(p.getData().toLocalDate().equals(data.toLocalDate()) && p.getVisita().getOrario().toLocalTime().equals(orario.toLocalTime()) && p.getVisita().getDescrizione().equals(descrizione)
					&& p.getCittadino().getNome().equals(nome) && p.getCittadino().getCognome().equals(cognome)) {
				
				
				prenotazioni.remove(p);
				return p.disdiciVisita(); 
			}
		}
		
		
		
		
		return 0;
	}


	public String[][] cercaPrenotazioniMedico(int idMedico) {
		// TODO Auto-generated method stub

		ArrayList<String> visite_medico = new ArrayList<String>(); 
		
		
		
		for(EntityPrenotazione p: prenotazioni) {
			if(p.getVisita().getMedico().getIdMedico() == idMedico) {
				
				visite_medico.add(p.getData().toString());
				visite_medico.add(p.getVisita().getOrario().toString());
				visite_medico.add(p.getVisita().getDescrizione());
				visite_medico.add(p.getCodiceQR().getPiano());
				visite_medico.add(p.getCodiceQR().getStanza());
				visite_medico.add(p.getCittadino().getNome());
				visite_medico.add(p.getCittadino().getCognome());
				
				
			}
		}
		
		      
        String[][] data = new String[visite_medico.size()/7][7]; 
		
		for(int i = 0; i<visite_medico.size()/7 ;i++){
		   for(int j = 0; j<7;j++){
			   		if(i==0) { 
			   			data[i][j] = visite_medico.get(j); 
			   			}
			   		else {
			   			data[i][j] = visite_medico.get(j + 7*i);
			   		} 
		     }
		}
		
		return data; 
		
	}


	public boolean cercaPrenotazione(EntityVisita v, Date data) {
		// TODO Auto-generated method stub
		
		
		boolean trovato = false;
		int i=0; 
		
		while(i < prenotazioni.size() && !trovato) {

			if(prenotazioni.get(i).getData().equals(data) && prenotazioni.get(i).getVisita().getIdVisita() == v.getIdVisita()) {
				trovato = true; 
			}
			
			
			i++; 
			
		}
		
		return trovato;
		
		
	}


	public int aggiungiPrenotazione(int idCittadino, Date data, int idVisita) {
		// TODO Auto-generated method stub
		
		EntityPrenotazione prenotazione = new EntityPrenotazione();
		prenotazione.setData(data);

		
		EntityCittadinoRegistrato cittadino = new EntityCittadinoRegistrato(idCittadino);
		prenotazione.setCittadino(cittadino);


		EntityVisita visita = new EntityVisita(idVisita);		
		prenotazione.setVisita(visita);
		prenotazione.setIdPrenotazione(DBPrenotazione.getID());
		
		EntityCodiceQr codice = new EntityCodiceQr();
		System.out.println("CODICE " + codice.getcodiceQR());
		prenotazione.setCodiceQR(codice);
		
		EntityRegistroCodici registro = EntityRegistroCodici.getInstance();
		registro.aggiungiCodice(codice);
		
		
		this.prenotazioni.add(prenotazione);
		return prenotazione.prenotaVisita(); 
		

	}
	
	
	
//	public int aggiungiPrenotazione() {
//		
//	}
//	
	
	
	
	
	
	
}



