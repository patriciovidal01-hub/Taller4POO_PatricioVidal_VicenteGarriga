package Logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import Dominio.*;
import Factory.*;
import Strategy.*;

/**
 * Clase encargada del manejo de datos del programa.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class SistemaImp implements Sistema {

	/**
	 * Atributo de SistemaImp.
	 */
	private static SistemaImp instance;

	/**
	 * Inicializa la clase SistemaImp con nada.
	 */
	private SistemaImp() {
	}

	/**
	 * Lista de cartas.
	 */
	private List<Carta> cartas = new ArrayList<Carta>();

	/**
	 * Atributo de Contexto.
	 */
	private Contexto context = new Contexto();

	/**
	 * Método que devuelve una solo instancia de SistemaImp.
	 * 
	 * @return instancia de SistemaImp.
	 */
	public static SistemaImp getInstance() {
		if (instance == null) {
			instance = new SistemaImp();
		}
		return instance;
	}

	/**
	 * Método que lee Sobres.txt y agrega las cartas del txt.
	 */
	public void leerArchivo() {
		List<String[]> datos = LectorArchivo.leerArch("Sobres.txt");

		for (String[] d : datos) {
			Carta carta = CartaFactory.crearCarta(d);
			cartas.add(carta);
		}

	}

	/**
	 * Método encargado de la creación de cartas y su agregado en la lista de
	 * cartas.
	 * 
	 * @param d Cadena de textos con los atributos de la carta.
	 */
	public void crearCarta(String[] d) {
		Carta carta = CartaFactory.crearCarta(d);
		cartas.add(carta);
	}

	/**
	 * Método encargado de la eliminación de una carta específica de la lista de
	 * cartas.
	 *
	 * @param c Carta a eliminar de la lista de cartas.
	 */
	public void eliminarCarta(Carta c) {
		cartas.remove(c);
	}

	/**
	 * Método encargado de reescribir el archivo Sobres.txt con información
	 * proporcionada por la lista de cartas.
	 */
	public void reescribirArchivo() {

		File arch = new File("Sobres.txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arch));) {

			for (Carta c : cartas) {
				switch (c.getTipo()) {

				case ("Pokemon"):
					Pokemon c1 = (Pokemon) c;
					bw.write(c1.getNombre() + ";" + c1.getRareza() + ";" + c1.getTipo() + ";" + c1.getDaño() + ";"
							+ c1.getCantEnergia());
					break;

				case ("Item"):
					Item c2 = (Item) c;
					bw.write(c2.getNombre() + ";" + c2.getRareza() + ";" + c2.getTipo() + ";" + c2.getBonificacion());
					break;

				case ("Supporter"):
					Supporter c3 = (Supporter) c;
					bw.write(c3.getNombre() + ";" + c3.getRareza() + ";" + c3.getTipo() + ";" + c3.getEfectoTurno());
					break;

				case ("Energy"):
					Energy c4 = (Energy) c;
					bw.write(c4.getNombre() + ";" + c4.getRareza() + ";" + c4.getTipo() + ";" + c4.getElemento());

					break;
				}
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
	}

	/**
	 * Método que devuelve una copia de la lista de cartas.
	 *
	 * @return la copia de la lista de cartas.
	 */
	public List<Carta> getCartas() {
		List<Carta> copia = new ArrayList<>(cartas);
		return copia;
	}

	/**
	 * Método que ordena la lista de cartas en base a su poder de mayor a menor.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	public List<Carta> strategyPoder(List<Carta> cartas) {
		context.setStrategy(new PoderStrategy());
		context.ordenar(cartas);
		return cartas;
	}

	/**
	 * Método que ordena la lista de cartas en base a su nombre alfabéticamente.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	public List<Carta> strategyNombre(List<Carta> cartas) {
		context.setStrategy(new NombreStrategy());
		context.ordenar(cartas);
		return cartas;
	}

	/**
	 * Método que ordena la lista de cartas en base a su rareza de mayor a menor.
	 * 
	 * @param cartas Lista de cartas a ordenar.
	 * @return Lista de cartas ordenada.
	 */
	public List<Carta> strategyRareza(List<Carta> cartas) {
		context.setStrategy(new RarezaStrategy());
		context.ordenar(cartas);
		return cartas;
	}

}
