package Exceptions;

public class UsuarioNoExisteException extends Exception {

	
	public UsuarioNoExisteException() {
		super("El usuario que acaba de ingresa no existe, por favor registrese");
	}
}
