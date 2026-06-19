package Dominio;

import Visitor.Visitor;

public class Item extends Carta {

	int bonificacion;

	public Item(String nombre, int rareza, int bonificacion) {
		super(nombre, rareza);
		this.bonificacion = bonificacion;
	}

	public String toString() {
		return "Item [bonificacion=" + bonificacion + "]";
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public int accept(Visitor v) {
		return v.visit(this);
		
	}

}
