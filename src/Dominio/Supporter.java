package Dominio;

import Visitor.*;

/**
 * Tipo de carta que representa un apoyo que se puede utilizar en batalla.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Supporter extends Carta {

	/**
	 * Cantidad de efectos que puede ejecutar la carta por turno.
	 */
	private int efectoTurno;

	/**
	 * Inicializa la carta Supporter con su respectivo efectos por turnos.
	 * 
	 * @param nombre      Nombre de la carta.
	 * @param rareza      Rareza de la carta.
	 * @param tipo        Tipo de la carta.
	 * @param efectoTurno Cantidad de efectos por turnos que puede ejecutar la
	 *                    carta.
	 */
	public Supporter(String nombre, int rareza, String tipo, int efectoTurno) {
		super(nombre, rareza, tipo);
		this.efectoTurno = efectoTurno;
	}

	/**
	 * Devuelve un entero que representa la cantidad de efectos que puede ejecutar
	 * por turno.
	 * 
	 * @return entero de la cantidad de efectos por turno de la carta.
	 */

	public int getEfectoTurno() {
		return efectoTurno;
	}

	/**
	 * Modifica la cantidad de efectos por turno actual de la carta por una nueva
	 * cantidad de efectos por turno.
	 * 
	 * @param efectoTurno Nueva cantidad de efectos por turno de la carta.
	 */
	public void setEfectoTurno(int efectoTurno) {
		this.efectoTurno = efectoTurno;
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
