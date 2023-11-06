package exceptions;

public class EmailNonValida extends Exception{
	
	public EmailNonValida() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Email Non Valida!";
	}
	
}
