package Dominio;

import Visitor.Visitor;

public class Energy extends Carta {
	String elemento;

	public Energy(String nombre, int rareza, String elemento) {
		super(nombre, rareza);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public int accept(Visitor v) {
		return v.visit(this);
		
	}
	
	
	
}
