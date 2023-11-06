package exceptions;

public class TelefonoNonValido extends Exception{
	
	public TelefonoNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Numero di telefono Non Valido!";
	}
	
}
