package exceptions;

public class UsernameNonValido extends Exception{
	
	public UsernameNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Username Non Valido!";
	}
	
}
