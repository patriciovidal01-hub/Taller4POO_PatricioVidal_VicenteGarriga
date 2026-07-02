package Dominio;

import Visitor.*;

/**
 * Tipo de carta que representa un item que se puede ocupar en batalla.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Item extends Carta {

	/**
	 * Bonificación que otorga la carta.
	 */
	private int bonificacion;

	/**
	 * Inicializa la carta Item con su respectiva bonificación. 
	 * @param nombre       Nombre de la carta.
	 * @param rareza       Rareza de la carta.
	 * @param tipo         Tipo de la carta.
	 * @param bonificacion Bonificación asociada a la carta.
	 */
	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	/**
	 * Devuelve un entero que representa la bonificación que otorga la carta.
	 * 
	 * @return entero de la bonificacion de la carta.
	 */
	public int getBonificacion() {
		return bonificacion;
	}

	/**
	 * Modifica la bonificación actual de la carta por una nueva bonificación.
	 * 
	 * @param bonificacion Nueva bonificación de la carta.
	 */
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	/**
	 * Método que pide un Visitor encargado de calcular el poder de la carta
	 * mediante el método visit cuyo parámetro es la misma carta.
	 * 
	 * @param v un visitor encargado de calcular el poder de la carta.
	 * @return un entero que representa el poder de la carta.
	 */
	public int accept(Visitor v) {
		return v.visit(this);

	}

}
