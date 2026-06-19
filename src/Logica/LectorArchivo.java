package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorArchivo {
	
	public static List<String[]> leerArch(String txt){
		
		List<String[]> datosExtraidos = new ArrayList<String[]>();
		
		File file = new File(txt);
		Scanner s;
		try {
			s = new Scanner(file);
			
			while(s.hasNextLine()) {
				String[] datos = s.nextLine().split(";");
				datosExtraidos.add(datos);
			}
			
			
		} catch (FileNotFoundException e) {

			System.out.println("No hay archivo");
		}
		
		return datosExtraidos;
	}
}
