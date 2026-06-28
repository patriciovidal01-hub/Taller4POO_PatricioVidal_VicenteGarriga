package Logica;

import java.util.List;

import Dominio.Carta;

public interface Sistema {

	void leerArchivo();
	void crearCarta(String[] d);
	void eliminarCarta(Carta c);
	List<Carta> StrategyRareza(List<Carta> cartas);
	List<Carta> StrategyNombre(List<Carta> cartas);
	List<Carta> StrategyPoder(List<Carta> cartas);
}	
