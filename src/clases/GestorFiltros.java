package clases;

import java.util.LinkedList;

	public class GestorFiltros {
		
	private LinkedList<Filtro> lista;
	private InfoMotor info;
	
	public InfoMotor GestorFiltros(InfoMotor info) {
		this.lista = new LinkedList<Filtro>();
		this.info = info;
	}
	public void añadirFiltro(Filtro filtro) {
		lista.add(filtro);
	}
	
	public void ejecutarFiltros() {
		for (Filtro filtro : lista) {
			filtro.ejecutar(info);
		}
	}

}
