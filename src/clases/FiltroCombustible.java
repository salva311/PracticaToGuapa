package clases;

public class FiltroCombustible implements Filtro {
	private double revoluciones;
	private int litrosCombustible;

	public FiltroCombustible() {
		this.litrosCombustible = 0;
		this.revoluciones = 0;
	}

	public double ejecutar(double revoluciones) {
		litrosCombustible = (int) (litrosCombustible - revoluciones * revoluciones * 5 * 0.0000000001);
		return revoluciones;
	}

	public void repostar(int litros) {
		litrosCombustible += litros;
	}

	public double getRev() {
		return revoluciones;
	}
}