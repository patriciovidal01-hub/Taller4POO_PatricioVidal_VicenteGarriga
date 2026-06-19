package Logica;

public class SistemaImp implements Sistema{

	private static SistemaImp instance;
	
	private SistemaImp() {}
	
	public static SistemaImp getInstance() {
		if (instance == null) {
			instance = new SistemaImp();
		}
		return instance;
	}
	
}
