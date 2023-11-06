package exceptions;

public class CfNonValido extends Exception{
	
	public CfNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Codice Fiscale Non Valido!";
	}
	
}
