package clases;

public class FiltroAceite implements Filtro {

	private double acumuladas;
	private long lastCheck;

	public FiltroAceite() {
		this.lastCheck = System.currentTimeMillis();
		this.acumuladas = 0;
	}

	public InfoMotor ejecutar(InfoMotor info) {
		double revoluciones = info.getRevoluciones();
		if (revoluciones > 5000000) {
			info.setCambiarAceite(true);
		}
		return info;
	}

	public double getAcumuladas() {
		return acumuladas;
	}

	public long getLastCheck() {
		return lastCheck;
	}
}
