// Patricio Javier Vidal Veas 22.330.827-9
// Vicente Antonio Garriga Muñoz 22.380.392-k

package Logica;

public class Main {

	static Sistema sistem = SistemaImp.getInstance();
	static Ventana ventana = new Ventana();
	
	public static void main(String[] args) {

		sistem.crearCarta();
		sistem.probandoProbando();
		ventana.crearVentana();

	}
}
