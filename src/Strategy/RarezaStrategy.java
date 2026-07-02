package Strategy;

import java.util.Comparator;
import java.util.List;

import Dominio.Carta;

/**
 * Clase encargada de comparar listas de Cartas respecto a su rareza.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class RarezaStrategy implements Strategy, Comparator<Carta> {

	/**
	 * Método que ordena una lista de Carta respecto a la rareza de cada carta y
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
	 * @return 1 si la rareza de la primera carta es menor a la segunda, 0 si la
	 *         rareza de la primera carta es igual a la segunda y -1 si la rareza de
	 *         la primera carta es mayor a la segunda.
	 */
	public int compare(Carta o1, Carta o2) {

		if (o1.getRareza() < o2.getRareza()) {
			return 1;
		} else if (o1.getRareza() == o2.getRareza()) {
			return 0;
		} else
			return -1;

	}
}
