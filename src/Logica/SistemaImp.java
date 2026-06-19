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
	
	public void crearCarta() {
		List<String[]> datos = LectorArchivo.leerArch("Sobres.txt");
		
		for(String[] d : datos) {
			Carta carta = CartaFactory.crearCarta(d);
			cartas.add(carta);
		}
		
	}
	
	
	public void probandoProbando() {
		
		for(Carta c : cartas) {
			System.out.println(c);
		}
		
	}
	
	public List<Carta> getCartas() {
		List<Carta> copia = new ArrayList<>(cartas);
		return copia;
	}
	
	public List<Carta> Strategy3(List<Carta> cartas){
		context.setStrategy(new PoderStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	public List<Carta> Strategy2(List<Carta> cartas){
		context.setStrategy(new NombreStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	public List<Carta> Strategy1(List<Carta> cartas){
		context.setStrategy(new RarezaStrategy());
		context.ordenar(cartas);
		return cartas;
	}
	
	
}
