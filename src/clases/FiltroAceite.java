package clases;

public class FiltroAceite implements Filtro {

	private double acumuladas;
	private long lastCheck;

	public FiltroAceite() {
		this.lastCheck = System.currentTimeMillis();
		this.acumuladas = 0;
	}

	public double ejecutar(double revoluciones) {
		if (revoluciones > 5000000) {
			System.out.println("cambiar aceite");
		}
		return revoluciones;
	}

	public double getAcumuladas() {
		return acumuladas;
	}

	public long getLastCheck() {
		return lastCheck;
	}
}
