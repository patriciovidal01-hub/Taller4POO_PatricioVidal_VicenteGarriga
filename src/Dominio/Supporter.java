package Dominio;

public class Supporter extends Carta {
	
	int efectoTurno;

	public Supporter(String nombre, int rareza, int efectoTurno) {
		super(nombre, rareza);
		this.efectoTurno = efectoTurno;
	}

	@Override
	public String toString() {
		return "Supporter [efectoTurno=" + efectoTurno + "]";
	}
	
	
}
