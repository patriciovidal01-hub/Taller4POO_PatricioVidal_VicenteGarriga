package Logica;

import java.util.List;

import Dominio.Carta;

public interface Sistema {

	void crearCarta();
	void probandoProbando();
	List<Carta> StrategyRareza(List<Carta> cartas);
	List<Carta> StrategyNombre(List<Carta> cartas);
	List<Carta> StrategyPoder(List<Carta> cartas);
}	
