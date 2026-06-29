package Dominio;

import Visitor.Visitor;

public class Pokemon extends Carta {

	int daño;
	int cantEnergia;

	public Pokemon(String nombre, int rareza, String tipo, int daño, int cantEnergia) {
		super(nombre, rareza, tipo);
		this.daño = daño;
		this.cantEnergia = cantEnergia;
	}

	public int getDaño() {
		return daño;
	}
	
	

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public void setCantEnergia(int cantEnergia) {
		this.cantEnergia = cantEnergia;
	}

	public int getCantEnergia() {
		return cantEnergia;
	}


	public int accept(Visitor v) {
		return v.visit(this);
	}

}
