package Dominio;

import Visitor.*;

/**
 * Representa una clase abstracta que define atributos compartidos por todas las
 * cartas del juego Pokemon TCG.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public abstract class Carta implements Visitable {

	/**
	 * Nombre de la carta.
	 */
	private String nombre;
	/**
	 * Rareza de la carta.
	 */
	private int rareza;
	/**
	 * Tipo de carta.
	 */
	private String tipo;

	/**
	 * Inicializa la Carta con los atributos respectivos.
	 * @param nombre Nombre de la carta.
	 * @param rareza Rareza de la carta.
	 * @param tipo   Tipo de la carta.
	 */
	public Carta(String nombre, int rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	/**
	 * Devuelve la cadena de texto del nombre de la carta.
	 * 
	 * @return el nombre de la carta.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve un entero que representa la rareza de la carta.
	 * 
	 * @return la rareza de la carta.
	 */
	public int getRareza() {
		return rareza;
	}

	/**
	 * Devuelve una cadena de texto del tipo de la carta.
	 * 
	 * @return el tipo de la carta.
	 */
	public String getTipo() {
		return tipo;
	}

}
