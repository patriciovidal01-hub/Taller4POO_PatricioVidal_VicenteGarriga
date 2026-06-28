package Factory;
import Dominio.*;

public class CartaFactory {
	
	public static Carta crearCarta(String[] d) {
		
		switch(d[2]) {
		
		case("Pokemon"):
			return new Pokemon(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]), Integer.parseInt(d[4]));
		case("Item"):
			return new Item(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]));
		case("Supporter"):
			return new Supporter(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]));
		case("Energy"):
			return new Energy(d[0], Integer.parseInt(d[1]), d[3]);
		default:
			return null;
		}
	} 
	
}
