package Dominio;

public class Energy extends Carta {
	String elemento;

	public Energy(String nombre, int rareza, String elemento) {
		super(nombre, rareza);
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return "Energy [elemento=" + elemento + "]";
	}
	
	
	
}
