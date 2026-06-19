package Strategy;

public class Contexto {
	
	private Strategy estrategia;
	
	public void setStrategy(Strategy s) {
		this.estrategia = s;
	}
	
	public void ordenar() {
		this.estrategia.ordenar();
	}
	
}
