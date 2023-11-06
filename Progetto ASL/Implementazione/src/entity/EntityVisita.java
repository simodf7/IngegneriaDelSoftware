package entity;

import database.DBVisita;
import database.DBMedico;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityVisita {
	
	private int idVisita;
	private int giorno;
	private Time orario;
	private String descrizione;
	private EntityMedico medico; 
	
	
	//costruttore con la PK
	public EntityVisita(int idVisita) {
		
		this.idVisita=idVisita;
		DBVisita visita = new DBVisita(idVisita); //carico dal DB con la PK
		this.giorno = visita.getGiorno();
		this.orario = visita.getOrario();
		this.descrizione = visita.getDescrizione();
		this.medico = new EntityMedico(visita.getMedico()); 
	}
	
	//costruttore copia da oggettoDB
	public EntityVisita(DBVisita visita) {
		
		this.idVisita=visita.getIdVisita();
		this.giorno = visita.getGiorno();
		this.orario = visita.getOrario();
		this.descrizione = visita.getDescrizione();
		this.medico = new EntityMedico(visita.getMedico()); 
	}
	
	
	public EntityVisita() {
		// TODO Auto-generated constructor stub
		super();
	}

//	public String[][] cercaDatiVisite(int id) {
//		DBVisita visita = new DBVisita(); 
//		DBMedico medico = new DBMedico(id); 
//		visita.setMedico(medico);
//		return visita.cercaDatiVisite();
//	}
	
//	public String[][] cercaDatiVisiteConMedico(String descrizione) {
//        DBVisita visita = new DBVisita();
//        visita.setDescrizione(descrizione);
//        return visita.cercaDatiVisiteConMedico();
//
//    }
	
	

	
	
	public int inserisciVisita() {

		
		
        DBVisita visita = new DBVisita();
        DBMedico medico = new DBMedico(this.medico.getIdMedico());
        System.out.println("ENTITYMEDICO ID " + this.medico.getIdMedico());
        System.out.println("DBMEDICO ID " + medico.getIdMedico());
        visita.setIdVisita(this.idVisita);
        visita.setMedico(medico); 
        visita.setGiorno(this.giorno);
        visita.setOrario(this.orario);
        visita.setDescrizione(this.descrizione);
        return visita.create();

    }
	
//	public int cercaVisita(Date data, Time orario, String descrizione) {
//		
//
//	  
//	    DBVisita visita = new DBVisita();
//	    visita.setGiorno(data.getDay());
//	    visita.setOrario(orario);
//	    visita.setDescrizione(descrizione);
//	    
//	    return visita.();
//
//
//		
//		
//	}
	
//	public int modificaVisita(int idVisita,String giorno, Time orario, String descrizione) {
//
//		  Map<String, Integer> map = new HashMap<String, Integer>();
//			map.put("Domenica", 1);
//			map.put("Lunedi", 2);
//			map.put("Martedi", 3);
//			map.put("Mercoledi", 4);
//			map.put("Giovedi", 5);
//			map.put("Venerdi", 6);
//			map.put("Sabato", 7);
//		  
//	        DBVisita visita = new DBVisita();
//	        visita.setGiorno(map.get(giorno));
//	        visita.setOrario(orario);
//	        visita.setDescrizione(descrizione);
//	        visita.setIdVisita(idVisita);
//	        return visita.modificaVisita();
//
//	}
	
	public int modificaVisita() {
		
		DBVisita visita = new DBVisita();
        visita.setGiorno(this.giorno);
        visita.setOrario(this.orario);
        visita.setDescrizione(this.descrizione);
        visita.setIdVisita(this.idVisita);
        return visita.update();
		
	}
	

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public EntityMedico getMedico() {
		return medico;
	}

	public void setMedico(EntityMedico medico) {
		this.medico = medico;
	}
	
	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public Time getOrario() {
		return orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	@Override
	public String toString() {
		return "EntityVisita [idVisita=" + idVisita + ", giorno=" + giorno + ", orario=" + orario + ", descrizione=" + descrizione + "]";
	}

	public boolean verificaDisponibilita() {
		// TODO Auto-generated method stub
		return false;
	}

	


	
}
