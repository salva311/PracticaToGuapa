package clases;

public class FiltroPastilla implements Filtro {

	private long lastCheck;
	private double acumuladas;

	public FiltroPastilla() {
		this.lastCheck = System.currentTimeMillis();
		this.acumuladas = 0;
	}

	public InfoMotor ejecutar(InfoMotor info) {
		double rev = info.getRevoluciones();
		if (rev > 5000000) {
			info.setCambiarPastillas(true);
		}
		return info;
	}

	public long getLastCheck() {
		return lastCheck;
	}

	public double getAcumuladas() {
		return acumuladas;
	}
}
