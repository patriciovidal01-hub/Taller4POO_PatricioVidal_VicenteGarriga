package Strategy;

import java.util.Comparator;
import java.util.List;

import Dominio.Carta;
import Visitor.PoderVisitor;

/**
 * Clase encargada de comparar listas de Cartas respecto a su poder.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class PoderStrategy implements Strategy, Comparator<Carta> {

	/**
	 * Atributo de Poder Visitor.
	 */
	private PoderVisitor v = new PoderVisitor();

	/**
	 * Método que ordena una lista de Carta respecto al poder de cada carta y
	 * devuelve la lista ordenada de mayor a menor.
	 * 
	 * @param cartas Lista de cartas.
	 * @return Lista de cartas ordenadas.
	 */
	public List<Carta> ordenar(List<Carta> cartas) {

		cartas.sort(this);

		return cartas;
	}

	/**
	 * Método de comparación de 2 Cartas.
	 * 
	 * @param o1 primera Carta a comparar.
	 * @param o2 segunda Carta a comparar.
	 * @return 1 si el poder de la primera carta es menor a la segunda, 0 si el
	 *         poder de la primera carta es igual a la segunda y -1 si el poder de la
	 *         primera carta es mayor a la segunda.
	 */
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
