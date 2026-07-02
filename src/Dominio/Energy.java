package Dominio;

import Visitor.*;

/**
 * Tipo de carta que representa la energia que requieren los pokemons para
 * luchar.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Energy extends Carta {

	/**
	 * Elemento de la energia.
	 */
	private String elemento;

	/**
	 * Inicializa la carta Energy con su elemento respectivo.
	 * 
	 * @param nombre   Nombre de la carta.
	 * @param rareza   Rareza de la carta.
	 * @param tipo     Tipo de la carta.
	 * @param elemento Elemento de la carta.
	 */
	public Energy(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}

	/**
	 * Devuelve una cadena de texto con el elemento de la carta.
	 * 
	 * @return el nombre del elemento de la carta.
	 */
	public String getElemento() {
		return elemento;
	}

	/**
	 * Modifica el elemento actual de la carta por un nuevo elemento.
	 * 
	 * @param elemento Nuevo elemento de la carta.
	 */
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	/**
	 * Metodo que pide un Visitor encargado de calcular el poder de la carta
	 * mediante el metodo visit cuyo parametro es la misma carta.
	 * 
	 * @param v un visitor encargado de calcular el poder de la carta.
	 * @return un entero que representa el poder de la carta.
	 */
	public int accept(Visitor v) {
		return v.visit(this);

	}

}
