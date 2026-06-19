package Factory;
import Dominio.*;

public class CartaFactory {
	
	public static Carta crearCarta(String[] d) {
		
		if(d[2].equals("Pokemon")) return new Pokemon(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]), Integer.parseInt(d[4]));
		if(d[2].equals("Item")) return new Item(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]));
		if(d[2].equals("Supporter")) return new Supporter(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[3]));
		if(d[2].equals("Energy")) return new Energy(d[0], Integer.parseInt(d[1]), d[3]);
		return null;
	} 
	
}
