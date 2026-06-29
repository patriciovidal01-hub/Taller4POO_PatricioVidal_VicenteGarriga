package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Dominio.*;
import Factory.*;
import Strategy.*;


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
	
	public void eliminarCarta(Carta c) {
		cartas.remove(c);
	}
	
	public void reescribirArchivo() {
		
		File arch = new File("Sobres.txt");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arch));) {
			
			for(Carta c: cartas) {
				switch(c.getTipo()) {
				
				case("Pokemon"):
					Pokemon c1 = (Pokemon) c;
					bw.write(c1.getNombre() + ";" + c1.getRareza() + ";" + c1.getTipo() + ";" + c1.getDaño() + ";" + c1.getCantEnergia());
					break;
				
				case("Item"):
					Item c2 = (Item) c;
					bw.write(c2.getNombre() + ";" + c2.getRareza() + ";" + c2.getTipo() + ";" + c2.getBonificacion());
					break;
				
				case("Supporter"):
					Supporter c3 = (Supporter) c;
					bw.write(c3.getNombre() + ";" + c3.getRareza() + ";" + c3.getTipo() + ";" + c3.getEfectoTurno());
					break;
				
				case("Energy"):
					Energy c4 = (Energy) c;
					bw.write(c4.getNombre() + ";" + c4.getRareza() + ";" + c4.getTipo() + ";" + c4.getElemento());
					
					break;
				}
				bw.newLine();
			}
		} catch(Exception e) {
			System.out.println("Archivo no encontrado");
		}
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
