package clases;

public class FiltroRozamiento implements Filtro {
	private double revoluciones;
 public double ejecutar(int rev, EstadoMotor estado) {
	 if (rev > 0) revoluciones -= 10;
		return revoluciones;
	}
}
