package Dominio;

import Visitor.Visitor;

public class Supporter extends Carta {
	
	int efectoTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectoTurno) {
		super(nombre, rareza, tipo);
		this.efectoTurno = efectoTurno;
	}

	public String toString() {
		return "Supporter [efectoTurno=" + efectoTurno + "]";
	}

	public int getEfectoTurno() {
		return efectoTurno;
	}
	
	

	public void setEfectoTurno(int efectoTurno) {
		this.efectoTurno = efectoTurno;
	}

	public int accept(Visitor v) {
		return v.visit(this);
	}
	
	
}
