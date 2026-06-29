package Dominio;

import Visitor.Visitor;

public class Energy extends Carta {
	String elemento;

	public Energy(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}
	
	
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int accept(Visitor v) {
		return v.visit(this);
		
	}
	
	
	
}
