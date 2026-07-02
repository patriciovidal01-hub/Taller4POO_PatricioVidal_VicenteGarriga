package Strategy;

import java.util.Comparator;
import java.util.List;
import Dominio.*;

/**
 * Clase encargada de comparar listas de Cartas respecto a su nombre.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class NombreStrategy implements Strategy, Comparator<Carta> {

	/**
	 * Método que ordena una lista de Carta respecto al nombre y devuelve la lista
	 * ordenada alfabéticamente.
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
	 * @return -1 si la primera carta es menor alfabeticamente a la segunda, 0 si la
	 *         primera carta es igual a la segunda alfabeticamente y 1 si la primera
	 *         carta es mayor alfabeticamente a la segunda.
	 */
	public int compare(Carta o1, Carta o2) {

		return o1.getNombre().compareToIgnoreCase(o2.getNombre());

	}
}
