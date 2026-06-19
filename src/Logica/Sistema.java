package Logica;

import java.util.List;

import Dominio.Carta;

public interface Sistema {

	void crearCarta();
	void probandoProbando();
	List<Carta> Strategy1(List<Carta> cartas);
	List<Carta> Strategy2(List<Carta> cartas);
	List<Carta> Strategy3(List<Carta> cartas);
}	
