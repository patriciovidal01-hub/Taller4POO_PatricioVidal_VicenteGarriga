package Strategy;

import java.util.Comparator;
import java.util.List;
import Dominio.*;

public class NombreStrategy implements Strategy, Comparator<Carta> {

	public List<Carta> ordenar(List<Carta> cartas) {

		cartas.sort(this);

		return cartas;

	}

	public int compare(Carta o1, Carta o2) {

		return o1.getNombre().compareTo(o2.getNombre());

	}
}
