package clases;

public class ControladorCoche {
	
	private Interfaz GUI;
	private Pedales targetInput;
	private Salpicadero targetDisplay;
	
	private GestorFiltros gFiltros;
	
	private EstadoMotor estado;
	
	public ControladorCoche() {
		
		// Estado Inicial
		this.estado = EstadoMotor.APAGADO;
		
		// Interaccion con el humano
		this.GUI = new Interfaz();
		this.targetInput = this.GUI.getPedales();
		this.targetDisplay = this.GUI.getSalpicadero();
		
		// Gestor de filtros
		this.gFiltros = new GestorFiltros();
		
		
	}

}
