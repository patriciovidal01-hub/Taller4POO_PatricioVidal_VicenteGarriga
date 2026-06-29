package Logica;

import java.util.List;

import Dominio.Carta;

public interface Sistema {

	void leerArchivo();
	List<Carta> getCartas();
	void crearCarta(String[] d);
	void eliminarCarta(Carta c);
	List<Carta> StrategyRareza(List<Carta> cartas);
	List<Carta> StrategyNombre(List<Carta> cartas);
	List<Carta> StrategyPoder(List<Carta> cartas);
	void reescribirArchivo();
}	
