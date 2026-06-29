package Dominio;

import Visitor.Visitor;

public class Item extends Carta {

	int bonificacion;

	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}
	
	
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public int accept(Visitor v) {
		return v.visit(this);
		
	}

}
