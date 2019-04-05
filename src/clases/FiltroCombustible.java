package clases;

public class FiltroCombustible implements Filtro {
	private double revoluciones;
	private double litrosCombustible;

	public FiltroCombustible() {
		this.litrosCombustible = 0;
		this.revoluciones = 0;
	}

	public InfoMotor ejecutar(InfoMotor info) {
		revoluciones = info.getRevoluciones();
		double litros = info.getCombustible();
		litrosCombustible = (litros - revoluciones * revoluciones * 5 * 0.0000000001);
		info.setCombustible(litrosCombustible);
		if (info.getCombustible() == 0) {
			info.setRepostar(true);
		}
		return info;
	}
}