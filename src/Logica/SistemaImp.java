package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.Carta;
import Factory.CartaFactory;
import Strategy.Contexto;
import Strategy.NombreStrategy;
import Strategy.PoderStrategy;
import Strategy.RarezaStrategy;

public class SistemaImp implements Sistema{

	private static SistemaImp instance;
	
	private SistemaImp() {}
	
	List<Carta> cartas = new ArrayList<Carta>();
	Contexto context = new Contexto();
	
	public static SistemaImp getInstance() {
		if (instance == null) {
			instance = new SistemaImp();
		}
		return instance;
	}
	
	public void leerArchivo() {
		List<String[]> datos = LectorArchivo.leerArch("Sobres.txt");
		
		for(String[] d : datos) {
			Carta carta = CartaFactory.crearCarta(d);
			cartas.add(carta);
		}
		
	}
	
	public void crearCarta(String[] d) {
		Carta carta = CartaFactory.crearCarta(d);
		cartas.add(carta);
	}
	
	
	public List<Carta> getCartas() {
		List<Carta> copia = new ArrayList<>(cartas);
		return copia;
	}
	
	public List<Carta> StrategyPoder(List<Carta> cartas){
		context.setStrategy(new PoderStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	public List<Carta> StrategyNombre(List<Carta> cartas){
		context.setStrategy(new NombreStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	public List<Carta> StrategyRareza(List<Carta> cartas){
		context.setStrategy(new RarezaStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	
}
