package Dominio;

public class Pokemon extends Carta {
	
	int daño;
	int cantEnergia;
	
	public Pokemon(String nombre, int rareza, int daño, int cantEnergia) {
		super(nombre, rareza);
		this.daño = daño;
		this.cantEnergia = cantEnergia;
	}

	@Override
	public String toString() {
		return "Pokemon [daño=" + daño + ", cantEnergia=" + cantEnergia + "]";
	}
	
	
	
}
