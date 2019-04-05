package clases;

public class FiltroRozamiento implements Filtro {
	
 public InfoMotor ejecutar(InfoMotor info) {
	 double rev = info.getRevoluciones();
	 if (rev > 0) info.setRevoluciones(rev-10);
		return info;
	}
}
