package Strategy;

import java.util.List;

import Dominio.Carta;

public class Contexto {

	private Strategy estrategia;

	public void setStrategy(Strategy s) {
		this.estrategia = s;
	}

	public void ordenar(List<Carta> cartas) {
		this.estrategia.ordenar(cartas);
	}

}
