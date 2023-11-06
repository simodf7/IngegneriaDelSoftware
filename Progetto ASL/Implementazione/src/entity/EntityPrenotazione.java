package entity;

import database.DBPrenotazione;
import database.DBCittadinoRegistrato;
import database.DBCodiceQr;
import database.DBMedico;
import database.DBVisita;
import exceptions.CognomeNonValido;
import exceptions.CognomeNonValido1;
import exceptions.NomeNonValido;
import exceptions.NomeNonValido1;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class EntityPrenotazione {
	
	private int idPrenotazione;
	private Date data;
//	private Time orario;
//	private String descrizioneVisita;
	private EntityCodiceQr codiceQr; 
	private EntityCittadinoRegistrato cittadino; 
	private EntityVisita visita; 
	
	
	public EntityPrenotazione() {
		super();
	}
	
	//costruttore con la PK
	public EntityPrenotazione(int idPrenotazione) {
		
		this.idPrenotazione=idPrenotazione;
		DBPrenotazione prenotazione = new DBPrenotazione(idPrenotazione); //carico dal DB con la PK
		this.data = prenotazione.getData();
		
		
		this.codiceQr = new EntityCodiceQr(prenotazione.getCodiceQR()); //attenzione
		this.cittadino = new EntityCittadinoRegistrato(prenotazione.getCittadino());
		this.visita = new EntityVisita(prenotazione.getVisita()); 
		
	}
	
	//costruttore copia da oggettoDB
	public EntityPrenotazione(DBPrenotazione prenotazione) {
		
		this.idPrenotazione=prenotazione.getIdPrenotazione();
		this.data = prenotazione.getData();
		this.codiceQr = new EntityCodiceQr(prenotazione.getCodiceQR()); //attenzione
		this.cittadino = new EntityCittadinoRegistrato(prenotazione.getCittadino());
		this.visita = new EntityVisita(prenotazione.getVisita()); 
		
	}
	
	
	
	public int prenotaVisita() {
		// TODO Auto-generated method stub
		
		DBPrenotazione prenotazione = new DBPrenotazione();
		prenotazione.setData(this.data);
		prenotazione.setIdPrenotazione(this.idPrenotazione);
		
		DBVisita visita = new DBVisita(this.visita.getIdVisita());
		prenotazione.setVisita(visita);
		
		DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(this.getCittadino().getIdCittadino());
		prenotazione.setCittadino(cittadino);
		
		
		// un po diverso dagli altri DB che sono gia presenti in memoria qui è necessario 
		// fare dei set perche caricadaDb non si puo fare in quanto il codice Qr non è ancora in memoria 
		DBCodiceQr codice = new DBCodiceQr();  
		codice.setcodiceQR(this.getCodiceQR().getcodiceQR());
		codice.setPiano(this.getCodiceQR().getPiano());
		codice.setStanza(this.getCodiceQR().getStanza());
		codice.create();
		
		
		prenotazione.setCodiceQR(codice);
		
		
		return prenotazione.create();
		
	}
	
	
	
	
//	public int prenotaVisitaOnLine(Date data, Time orario, String descrizione, int idCittadino) {
//
//        DBPrenotazione prenotazione = new DBPrenotazione();
//        prenotazione.setData(data);
//        DBVisita visita = new DBVisita(); 
//        visita.setOrario(orario);
//        visita.setDescrizione(descrizione);
//        prenotazione.setVisita(visita);
//        
//        ArrayList<Integer> visite_trovate = prenotazione.verificaDisponibilita();
//        
//        int id_visita = associaMedico(visite_trovate); 
//        
//        if(id_visita == 0) {return 0;} // se non ho trovato visite
//        
//        visita.setIdVisita(id_visita);
//        prenotazione.setVisita(visita); 
//        
//        DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(idCittadino);
//        prenotazione.setCittadino(cittadino);
//        
//        return prenotazione.prenotaVisita();
//    }
	
	
	
	
//	public int prenotaVisita(int idCittadino,int idVisita, Date data) {
//		
//		DBPrenotazione prenotazione = new DBPrenotazione();
//		prenotazione.setData(data);
//		System.out.println("ID CITTADINO " + idCittadino);
//		System.out.println("ID VISITA " + idVisita);
//		
//		DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(idCittadino); 
//		DBVisita visita = new DBVisita(idVisita);
//		
//		prenotazione.setCittadino(cittadino);
//		prenotazione.setVisita(visita);
//		
//		return prenotazione.prenotaVisita(); 
//				
//	}
//	
	
	
	
	
//	  public int disdiciVisitaOnLine(Date data, Time orario, String descrizione, int idCittadino) {
//
//	        DBPrenotazione prenotazione = new DBPrenotazione();
//	        DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(idCittadino);
//	        prenotazione.setData(data);
//	        
//	        DBVisita visita = new DBVisita(); 
//	        visita.setOrario(orario);
//	        visita.setDescrizione(descrizione);
//	        prenotazione.setVisita(visita);
//	        prenotazione.setCittadino(cittadino);
//	        
//	        int id_Prenotazione = prenotazione.verificaEsistenzaPrenotazione(); 
//	        
//	        System.out.println("ID " + id_Prenotazione);
//	        if(id_Prenotazione == 0 || id_Prenotazione == -1 ) return 0; // se non esiste la prenotazione o errore query
//	        
//	        prenotazione.setIdPrenotazione(id_Prenotazione);
//	      
//	        return prenotazione.disdiciVisita();
//	  }
	  
	  
	  
	  public int disdiciVisitaOnLine() {
		  
		  	DBPrenotazione prenotazione = new DBPrenotazione();
	        DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato(this.getCittadino().getIdCittadino());
	        prenotazione.setData(this.data);
	        
	        DBVisita visita = new DBVisita(); 
	        visita.setOrario(this.getVisita().getOrario());
	        visita.setDescrizione(this.getVisita().getDescrizione());
	        prenotazione.setVisita(visita);
	        prenotazione.setCittadino(cittadino);
	        prenotazione.setIdPrenotazione(this.idPrenotazione);
	      
	        return prenotazione.disdiciVisita();
		  
		  
	  }
	  
	  
	  public int disdiciVisita() {
		  
		  	DBPrenotazione prenotazione = new DBPrenotazione();
	        DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato();
	        
	        prenotazione.setData(data);
	        
	        DBVisita visita = new DBVisita();
	        visita.setOrario(this.getVisita().getOrario());
	        visita.setDescrizione(this.getVisita().getDescrizione());

	        prenotazione.setVisita(visita); 
	        
        	cittadino.setNome(this.getCittadino().getNome());
        	cittadino.setCognome(this.getCittadino().getCognome());
	        
	        prenotazione.setCittadino(cittadino);
	        prenotazione.setIdPrenotazione(this.getIdPrenotazione());
	        
	        return prenotazione.disdiciVisita();
		  
		  
	  }
	  
	  
	  
	
	
	
	
	
	
//	  public int disdiciVisita(Date data, Time orario, String descrizione, String nome, String cognome) {
//
//	        DBPrenotazione prenotazione = new DBPrenotazione();
//	        DBCittadinoRegistrato cittadino = new DBCittadinoRegistrato();
//	        
//	        prenotazione.setData(data);
//	        
//	        DBVisita visita = new DBVisita();
//	        visita.setOrario(orario);
//	        visita.setDescrizione(descrizione);
//
//	        prenotazione.setVisita(visita); 
//	        
//	        try {
//	        	cittadino.setNome(nome);
//	        	cittadino.setCognome(cognome);
//	        } catch (NomeNonValido ex) {
//				System.out.println(ex);
//			} catch (NomeNonValido1 ex) {
//				System.out.println(ex);
//			} catch (CognomeNonValido ex) {
//				System.out.println(ex);
//			} catch (CognomeNonValido1 ex) {
//				System.out.println(ex);
//			}
//	        
//	        prenotazione.setCittadino(cittadino);
//	        
//	        int id_Prenotazione = prenotazione.verificaEsistenzaPrenotazione();      
//	        if(id_Prenotazione == 0 || id_Prenotazione == -1 ) return 0; // se non esiste la prenotazione o errore query
//	        
//	        prenotazione.setIdPrenotazione(id_Prenotazione);
//	        
//	        return prenotazione.disdiciVisita();
//	  }
	
	  
	  
	  
	  
	
//	  public String[][] trovaPrenotazioniMedici(int idMedico){
//
//	        DBPrenotazione prenotazione = new DBPrenotazione();
//	        DBMedico medico = new DBMedico(idMedico);
//	        DBVisita visita = new DBVisita(); 
//	        visita.setMedico(medico);
//	        prenotazione.setVisita(visita);
//	        
//	        ArrayList<String> visite_medico = prenotazione.trovaPrenotazioniMedici();
//	        
//	        String[][] data = new String[visite_medico.size()/7][7]; 
//			
//			for(int i = 0; i<visite_medico.size()/7 ;i++){
//			   for(int j = 0; j<7;j++){
//				   		if(i==0) { 
//				   			data[i][j] = visite_medico.get(j); 
//				   			}
//				   		else {
//				   			data[i][j] = visite_medico.get(j + 7*i);
//				   		} 
//			     }
//			}
//			
//			return data; 
//	    }
//	
	
	
	
	
//	  public int verificaInSportello(Date data, Time orario, String descrizione) {
//
//	        DBPrenotazione prenotazione = new DBPrenotazione();
//	        prenotazione.setData(data);
//	        
//	        DBVisita visita = new DBVisita(); 
//
//	        visita.setOrario(orario);
//	        visita.setDescrizione(descrizione);
//	        prenotazione.setVisita(visita);
//
//	        ArrayList<Integer> visite_trovate = prenotazione.verificaDisponibilita();
//	        
//	        
//	        
//	        return associaMedico(visite_trovate); 
//	    }
	
	  
	  
	
//	public int associaMedico(ArrayList<Integer> id) {
//	
//	if (id.size() >= 1) {
//		return id.get(0);
//	}
//	else {
//		return 0; 
//	}
//}
	

	
	
	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

//	public String getDescrizioneVisita() {
//		return descrizioneVisita;
//	}
//
//	public void setDescrizioneVisita(String descrizioneVisita) {
//		this.descrizioneVisita = descrizioneVisita;
//	}

	public EntityCodiceQr getCodiceQR() {
		return codiceQr;
	}

	public void setCodiceQR(EntityCodiceQr codiceQR) {
		this.codiceQr = codiceQR;
	}

	public EntityCittadinoRegistrato getCittadino() {
		return cittadino;
	}

	public void setCittadino(EntityCittadinoRegistrato cittadino) {
		this.cittadino = cittadino;
	}

	public EntityVisita getVisita() {
		return visita; 
	}
	
	public void setVisita(EntityVisita visita) {
		this.visita = visita; 
	}
	
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean verificaDisponibilita() {
		// TODO Auto-generated method stub
		return false;
	}

	

//	public Time getOrario() {
//		return orario;
//	}
//
//	public void setOrario(Time orario) {
//		this.orario = orario;
//	}

//	@Override
//	public String toString() {
//		return "EntityPrenotazione [idPrenotazione=" + idPrenotazione + ", data=" + data + ", orario=" + orario + ", descrizioneVisita=" + descrizioneVisita + ", codiceQR=" + codiceQr.getcodiceQR() + "]";
//	}




	
	
}
