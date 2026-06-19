package Strategy;

import java.util.Comparator;
import java.util.List;

import Dominio.Carta;
import Visitor.PoderVisitor;

public class PoderStrategy implements Strategy, Comparator<Carta> {
	
	public List<Carta> ordenar(List<Carta> cartas) {

		cartas.sort(this);

		return cartas;
	}

	public int compare(Carta o1, Carta o2) {
		
		PoderVisitor v = new PoderVisitor();
		
		if (o1.accept(v) < o2.accept(v)) {
			return 1;
		} else if (o1.accept(v) < o2.accept(v)) {
			return 0;
		} else
			return -1;

	}

}
