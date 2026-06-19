package Strategy;

import java.util.Comparator;
import java.util.List;

import Dominio.Carta;

public class RarezaStrategy implements Strategy, Comparator<Carta> {

	public List<Carta> ordenar(List<Carta> cartas) {

		cartas.sort(this);

		return cartas;

	}

	public int compare(Carta o1, Carta o2) {

		if (o1.getRareza() < o2.getRareza()) {
			return 1;
		} else if (o1.getRareza() == o2.getRareza()) {
			return 0;
		} else
			return -1;

	}
}
