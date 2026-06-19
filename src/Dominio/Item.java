package Dominio;

public class Item extends Carta {
	
	int bonificacion;

	public Item(String nombre, int rareza, int bonificacion) {
		super(nombre, rareza);
		this.bonificacion = bonificacion;
	}

	@Override
	public String toString() {
		return "Item [bonificacion=" + bonificacion + "]";
	}
	
	
	
}
