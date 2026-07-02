// Patricio Javier Vidal Veas 22.330.827-9
// Vicente Antonio Garriga Muñoz 22.380.392-k

package Logica;
/**
 * Clase principal donde se desarrolla el programa.
 * 
 * @author Patricio Vidal
 * @author Vicente Garriga
 */
public class Main {

	
	/**
	 * Atributo Sistema.
	 */
	private static Sistema sistem = SistemaImp.getInstance();
	
	/**
	 * Atributo Ventana.
	 */
	private static Ventana ventana = new Ventana();
	
	/**
	 * Método principal donde se leen los archivos y se crea la GUI.
	 * @param args Arreglo de argumentos de la línea de comando.
	 */
	public static void main(String[] args) {
		
		sistem.leerArchivo();
		ventana.crearVentana();
		

	}
}
