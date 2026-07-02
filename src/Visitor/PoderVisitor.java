package Visitor;

import Dominio.*;

/**
 * Clase encargada de calcular el poder de cada clase.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 * 
 */
public class PoderVisitor implements Visitor {

	/**
	 * Método encargado de visitar un Pokemon y retornar un entero.
	 * 
	 * @param x un Pokemon cualquiera.
	 * 
	 * @return el poder calculado, 0 si la cantidad de energías es 0.
	 */
	public int visit(Pokemon x) {
		if (x.getCantEnergia() == 0) {
			return 0;
		}
		double calculo = ((double) x.getDaño() / x.getCantEnergia()) * 100;
		return (int) calculo;
	}

	/**
	 * Método encargado de visitar un Item y retornar un entero.
	 * 
	 * @param x un Item cualquiera.
	 * @return el poder calculado.
	 */
	public int visit(Item x) {
		int poder = x.getBonificacion() * 20;
		return poder;

	}

	/**
	 * Método encargado de visitar un Supporter y retornar un entero.
	 * 
	 * @param x un Supporter cualquiera.
	 * @return el poder calculado.
	 */
	public int visit(Supporter x) {

		int poder = x.getEfectoTurno() * 50;
		return poder;

	}

	/**
	 * Método encargado de visitar una Energy y retornar un entero.
	 * 
	 * @param x un Energy cualquiera.
	 * @return el poder calculado.
	 */
	public int visit(Energy x) {
		int poder = 1;
		return poder;
	}

}
