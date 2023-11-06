package exceptions;

public class CognomeNonValido extends Exception{
	
	public CognomeNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Cognome Non Valido!";
	}
	
}
