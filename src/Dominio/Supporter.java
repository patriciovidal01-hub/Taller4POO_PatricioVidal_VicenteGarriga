package Dominio;

import Visitor.Visitor;

public class Supporter extends Carta {
	
	int efectoTurno;

	public Supporter(String nombre, int rareza, int efectoTurno) {
		super(nombre, rareza);
		this.efectoTurno = efectoTurno;
	}

	public String toString() {
		return "Supporter [efectoTurno=" + efectoTurno + "]";
	}

	public int getEfectoTurno() {
		return efectoTurno;
	}


	public int accept(Visitor v) {
		return v.visit(this);
	}
	
	
}
