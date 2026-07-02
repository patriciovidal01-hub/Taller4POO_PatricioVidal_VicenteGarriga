package Visitor;
import Dominio.*;
/**
 * Interfaz encargada de otorgar los métodos visit dependiendo del tipo de
 * carta.
 *
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public interface Visitor {
	/**
	 * Método encargado de visitar un Pokemon y retornar un entero.
	 * @param x un Pokemon cualquiera.
	 * @return un entero.
	 */
	int visit(Pokemon x);
	/**
	 * Método encargado de visitar un Item y retornar un entero.
	 * @param x un Item cualquiera.
	 * @return un entero.
	 */
	int visit(Item x);
	/**
	 * Método encargado de visitar un Supporter y retornar un entero.
	 * @param x un Supporter cualquiera.
	 * @return un entero.
	 */
	int visit(Supporter x);
	/**
	 * Método encargado de visitar un Energy y retornar un entero.
	 * @param x un Energy cualquiera.
	 * @return un entero.
	 */
	int visit(Energy x);
}
