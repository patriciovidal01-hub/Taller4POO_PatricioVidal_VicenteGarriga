package Factory;
import Dominio.*;

/**
 * Clase encargada de la creación de los diferentes tipos de cartas.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class CartaFactory {
	
	/**
	 * Inicializa la clase CartaFactory con nada.
	 */
	private CartaFactory() {}
	
	/**
	 * Método encargado de la creación de cartas a partir de su tipo.
	 * @param d Arreglo de cadenas de texto que contienen los atributos de la carta.
	 * @return una carta inicializada con los atributos de las cadenas de texto. 
	 */
	public static Carta crearCarta(String[] d) {
		
		switch(d[2]) {
		
		case("Pokemon"):
			return new Pokemon(d[0], Integer.parseInt(d[1]), d[2], Integer.parseInt(d[3]), Integer.parseInt(d[4]));
		case("Item"):
			return new Item(d[0], Integer.parseInt(d[1]), d[2], Integer.parseInt(d[3]));
		case("Supporter"):
			return new Supporter(d[0], Integer.parseInt(d[1]), d[2], Integer.parseInt(d[3]));
		case("Energy"):
			return new Energy(d[0], Integer.parseInt(d[1]), d[2] , d[3]);
		default:
			return null;
		}
	} 
	
}
