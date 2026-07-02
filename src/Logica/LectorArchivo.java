package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase donde se lee el archivo deseado y se guarda en una lista de cadena de
 * textos.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class LectorArchivo {

	/**
	 * Inicializa la clase LectorArchivo con nada.
	 */
	private LectorArchivo() {
	}

	/**
	 * Lee el archivo ingresado y devuelve una lista de cadenas del archivo leído.
	 * 
	 * @param txt Archivo txt que se lee.
	 * @return Lista de cadenas de texto del archivo leído.
	 */
	public static List<String[]> leerArch(String txt) {

		List<String[]> datosExtraidos = new ArrayList<String[]>();

		File file = new File(txt);
		Scanner s;
		try {
			s = new Scanner(file);

			while (s.hasNextLine()) {
				String[] datos = s.nextLine().split(";");
				datosExtraidos.add(datos);
			}
			s.close();

		} catch (FileNotFoundException e) {

			System.out.println("No hay archivo");
		}

		return datosExtraidos;
	}
}
