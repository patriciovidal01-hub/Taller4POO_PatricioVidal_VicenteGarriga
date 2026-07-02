package Strategy;

import java.util.List;

import Dominio.Carta;

/**
 * Clase encargada de mantener la estrategia actual y cambiarla a conveniencia,
 * <br>
 * aparte de ejecutar el método ordenar dependiendo de la estrategia actual.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Contexto {

	/**
	 * Estrategia actual que tiene la clase.
	 */
	private Strategy estrategia;

	/**
	 * Modifica la estrategia actual de la clase por una nueva estrategia.
	 * 
	 * @param s La nueva estrategia.
	 */
	public void setStrategy(Strategy s) {
		this.estrategia = s;
	}

	/**
	 * Método que llama al mtodo ordenar de la estrategia actual.
	 * 
	 * @param cartas Lista de cartas.
	 */
	public void ordenar(List<Carta> cartas) {
		this.estrategia.ordenar(cartas);
	}

}
