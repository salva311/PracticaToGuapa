package clases;

public class FiltroRozamiento implements Filtro {
	
 public double ejecutar(double revoluciones) {
	 if (revoluciones > 0) revoluciones -= 10;
		return revoluciones;
	}
}
