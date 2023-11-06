package exceptions;

public class NomeNonValido extends Exception{
	
	public NomeNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Nome Non Valido!";
	}
	
}
