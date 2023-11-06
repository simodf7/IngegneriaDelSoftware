package entity;

import java.security.SecureRandom;

import java.nio.charset.Charset;
import java.util.Random;

import database.DBCodiceQr;

public class EntityCodiceQr {
	
	private String codice;
	private String stanza;
	private String piano;
	
	public EntityCodiceQr() {
		this.codice = getAlphaNumericString(20);
		this.stanza = generateRandomString(2); 
		Random random = new Random();
        this.piano = String.valueOf((random.nextInt(5) + 1)); // casting
	}
	
	
	public EntityCodiceQr(String codice) {
		
		DBCodiceQr codiceQR = new DBCodiceQr(codice);
		
		this.codice = codice;
		this.stanza = codiceQR.getStanza();
		this.piano = codiceQR.getPiano();
		
	}
	
	public EntityCodiceQr(DBCodiceQr codice) {
		
		this.codice = codice.getcodiceQR();
		this.stanza = codice.getStanza();
		this.piano = codice.getPiano();
	}
	
	
	public String getcodiceQR() {
		return codice;
	}
	public void setcodiceQR(String codice) {
		this.codice = codice;
	}
	
	public String getStanza() {
		return stanza;
	}
	public void setStanza(String stanza) {
		this.stanza = stanza;
	}
	
	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	private static String generateRandomString(int length) {
	    	final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		    SecureRandom random = new SecureRandom();
	
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(ALPHABET.length());
	            char randomChar = ALPHABET.charAt(randomIndex);
	            sb.append(randomChar);
	        }
	        return sb.toString();
	    }
	
	private static String getAlphaNumericString(int n){
	 
	  // length is bounded by 256 Character
	  byte[] array = new byte[256];
	  new Random().nextBytes(array);
	 
	  String randomString = new String(array, Charset.forName("UTF-8"));
	 
	  // Create a StringBuffer to store the result
	  StringBuffer r = new StringBuffer();
	 
	  // Append first 20 alphanumeric characters
	  // from the generated random String into the result
	  for (int k = 0; k < randomString.length(); k++) {
	 
		   char ch = randomString.charAt(k);
		 
		   if (((ch >= 'a' && ch <= 'z')
		    || (ch >= 'A' && ch <= 'Z')
		    || (ch >= '0' && ch <= '9'))
		    && (n > 0)) {
		 
		    r.append(ch);
		    n--;
		   	}
	}
	 
	  // return the resultant string
	  return r.toString();
	 }
	
	
	@Override
	public String toString() {
		return "EntityCodice [codiceQR=" + codice + ", stanza=" + stanza + ", piano=" + piano +"]";
	}

	
	
	
}
