package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.Carta;
import Factory.CartaFactory;

public class SistemaImp implements Sistema{

	private static SistemaImp instance;
	
	private SistemaImp() {}
	
	List<Carta> cartas = new ArrayList<Carta>();
	
	
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
	
}
