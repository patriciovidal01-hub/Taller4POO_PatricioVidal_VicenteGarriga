package Dominio;

import Visitor.Visitor;

public class Pokemon extends Carta {

	int daño;
	int cantEnergia;

	public Pokemon(String nombre, int rareza, int daño, int cantEnergia) {
		super(nombre, rareza);
		this.daño = daño;
		this.cantEnergia = cantEnergia;
	}

	@Override
	public String toString() {
		return "Pokemon [daño=" + daño + ", cantEnergia=" + cantEnergia + "]";
	}

	public int getDaño() {
		return daño;
	}

	public int getCantEnergia() {
		return cantEnergia;
	}


	public int accept(Visitor v) {
		return v.visit(this);
	}

}
