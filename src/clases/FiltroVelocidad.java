package clases;

public class FiltroVelocidad  {

	public double ejecutar(int revoluciones, EstadoMotor estadoMotor) {

		if (EstadoMotor.ACELERANDO == estadoMotor)
			revoluciones += 100;
		if (EstadoMotor.FRENANDO == estadoMotor) {
			if (revoluciones > 101) {
				revoluciones -= 100;
			} else
				revoluciones = 0;
		}
		return revoluciones;
	}
}
