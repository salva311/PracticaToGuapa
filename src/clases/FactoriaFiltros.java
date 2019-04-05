package clases;

public interface FactoriaFiltros {
	public static Filtro crearFiltro(FiltroTP tipo) {
		if (tipo==FiltroTP.ACEITE) {
			FiltroAceite filtro = new FiltroAceite();
			return filtro;
		}
		if (tipo==FiltroTP.ROZAMIENTO) {
			FiltroRozamiento filtro = new FiltroRozamiento();
			return filtro;
		}
		
		if (tipo==FiltroTP.COMBUSTIBLE) {
			FiltroCombustible filtro = new FiltroCombustible();
			return filtro;
		}
		
		if (tipo==FiltroTP.PASTILLAS) {
			FiltroPastilla filtro = new FiltroPastilla();
			return filtro;
		}
		return null;
		}
}