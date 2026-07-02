package Visitor;
/**
 * Interfaz encargada de otorgar el método accept a todas las clases Carta.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */	
public interface Visitable {
	/**
	 * Método que pide un Visitor encargado de calcular el poder de la carta
	 * mediante el método visit cuyo parámetro es la misma carta.
	 * @param v un visitor encargado de calcular el poder de la carta.
	 * @return un entero que representa el poder de la carta.
	 */
	int accept(Visitor v);
}
