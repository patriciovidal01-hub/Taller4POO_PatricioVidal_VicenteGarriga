package Dominio;

import Visitor.*;

/**
 * Tipo de carta que representa el pokemon que lucha.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Pokemon extends Carta {

	/**
	 * Daño que inflige el pokemon en batalla.
	 */
	private int daño;
	/**
	 * Cantidad de energías que requiere el pokemon para infligir daño.
	 */
	private int cantEnergia;

	/**
	 * Inicializa la carta Pokemon con su respectivo daño y cantidad de energías que
	 * necesita.
	 * 
	 * @param nombre      Nombre de la carta.
	 * @param rareza      Rareza de la carta.
	 * @param tipo        Tipo de la carta.
	 * @param daño        Daño que inflige el pokemon.
	 * @param cantEnergia Cantidad de energías que necesita para infligir daño.
	 */
	public Pokemon(String nombre, int rareza, String tipo, int daño, int cantEnergia) {
		super(nombre, rareza, tipo);
		this.daño = daño;
		this.cantEnergia = cantEnergia;
	}

	/**
	 * Devuelve un entero que representa el daño que inflige la carta.
	 * 
	 * @return entero del daño que inflige la carta.
	 */
	public int getDaño() {
		return daño;
	}

	/**
	 * Modifica el daño actual de la carta por un nuevo daño.
	 * 
	 * @param daño Nuevo daño de la carta.
	 */
	public void setDaño(int daño) {
		this.daño = daño;
	}

	/**
	 * Devuelve un entero que representa la cantidad de energías que necesita la
	 * carta.
	 * 
	 * @return entero de la cantidad de energías.
	 */
	public int getCantEnergia() {
		return cantEnergia;
	}

	/**
	 * Modifica la cantidad de energías actual de la carta por una cantidad de
	 * energía.
	 * 
	 * @param cantEnergia Nueva cantidad de energías.
	 */
	public void setCantEnergia(int cantEnergia) {
		this.cantEnergia = cantEnergia;
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
