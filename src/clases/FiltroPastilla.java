package clases;

public class FiltroPastilla implements Filtro {

	private long lastCheck;
	private double acumuladas;
	
	public FiltroPastilla() {
		this.lastCheck = System.currentTimeMillis();
		this.acumuladas = 0;
	}

	public double ejecutar(double revoluciones) {
		if (revoluciones > 5000000) {
			System.out.println("cambiar pastillas");
		}
		return revoluciones;
	}
}
