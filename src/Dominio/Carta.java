package Dominio;

public abstract class Carta {
	
	String nombre;
	int rareza;
	public Carta(String nombre, int rareza) {
		this.nombre = nombre;
		this.rareza = rareza;
	}
	public String toString() {
		return "Carta [nombre=" + nombre + ", rareza=" + rareza + "]";
	}
		
	
}
