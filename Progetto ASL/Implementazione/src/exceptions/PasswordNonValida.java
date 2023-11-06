package exceptions;

public class PasswordNonValida extends Exception{
	
	public PasswordNonValida() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Password Non Valida!";
	}
	
}
