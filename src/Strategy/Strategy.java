package Strategy;

import java.util.List;
import Dominio.*;

/**
 * Interfaz encargada de otorgar el método ordenar a cada estrategia.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public interface Strategy {

	/**
	 * Método que ordena una lista de Carta de cierta manera y devuelve la lista
	 * ordenada.
	 * 
	 * @param cartas Lista de cartas.
	 * @return Lista de cartas ordenadas.
	 */
	List<Carta> ordenar(List<Carta> cartas);
}
