package Dominio;
import Visitor.Visitable;

public abstract class Carta implements Visitable {

	String nombre;
	int rareza;

	public Carta(String nombre, int rareza) {
		this.nombre = nombre;
		this.rareza = rareza;
	}

	public String toString() {
		return "Carta [nombre=" + nombre + ", rareza=" + rareza + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public int getRareza() {
		return rareza;
	}
	
	
	
	
}
