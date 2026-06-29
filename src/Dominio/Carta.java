package Dominio;
import Visitor.Visitable;

public abstract class Carta implements Visitable {

	String nombre;
	int rareza;
	String tipo;

	public Carta(String nombre, int rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getRareza() {
		return rareza;
	}

	public String getTipo() {
		return tipo;
	}
	
	
	
	
	
}
