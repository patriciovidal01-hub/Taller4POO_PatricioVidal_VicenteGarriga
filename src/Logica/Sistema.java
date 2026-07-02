package Logica;

import java.util.List;

import Dominio.Carta;

/**
 * Interfaz que otorga los métodos de control de datos.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public interface Sistema {

	/**
	 * Método que lee un txt y agrega las cartas del txt.
	 */
	void leerArchivo();

	/**
	 * Método encargado de la creación de cartas y su agregado en la lista de
	 * cartas.
	 * 
	 * @param d Cadena de textos con los atributos de la carta.
	 */
	void crearCarta(String[] d);

	/**
	 * Método encargado de la eliminación de una carta específica de la lista de
	 * cartas.
	 *
	 * @param c Carta a eliminar de la lista de cartas.
	 */
	void eliminarCarta(Carta c);

	/**
	 * Método encargado de reescribir el archivo Sobres.txt con información
	 * proporcionada por la lista de cartas.
	 */
	void reescribirArchivo();

	/**
	 * Método que devuelve una copia de la lista de cartas.
	 *
	 * @return la copia de la lista de cartas.
	 */
	List<Carta> getCartas();

	/**
	 * Método que ordena la lista de cartas en base a su poder de mayor a menor.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	List<Carta> strategyPoder(List<Carta> cartas);

	/**
	 * Método que ordena la lista de cartas en base a su nombre alfabéticamente.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	List<Carta> strategyNombre(List<Carta> cartas);

	/**
	 * Método que ordena la lista de cartas en base a su rareza de mayor a menor.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	List<Carta> strategyRareza(List<Carta> cartas);

}
