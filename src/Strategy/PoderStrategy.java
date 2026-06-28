package Strategy;

import java.util.Comparator;
import java.util.List;

import Dominio.Carta;
import Visitor.PoderVisitor;

public class PoderStrategy implements Strategy, Comparator<Carta> {
	
	PoderVisitor v = new PoderVisitor();
	
	public List<Carta> ordenar(List<Carta> cartas) {

		cartas.sort(this);

		return cartas;
	}

	public int compare(Carta o1, Carta o2) {
		
		int poder1 = o1.accept(v);
		int poder2 = o2.accept(v);
		
		if (poder1 < poder2) {
			return 1;
		} else if (poder1 == poder2) {
			return 0;
		} else
			return -1;

	}

}
