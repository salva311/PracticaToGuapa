package clases;

public class ControladorCoche extends Thread {
	
	private Interfaz GUI;
	private Pedales targetInput;
	private Salpicadero targetDisplay;
	
	private Motor motor;
	
	private GestorFiltros gFiltros;
	
	private EstadoMotor estado;
	
	public ControladorCoche(Motor m) {
		
		// Estado Inicial
		this.estado = EstadoMotor.APAGADO;
		
		// Interaccion con el humano
		this.GUI = new Interfaz();
		this.targetInput = this.GUI.getPedales();
		this.targetDisplay = this.GUI.getSalpicadero();
		
		// Motor
		this.motor = new Motor(this.estado);
		
		// Gestor de filtros
		this.gFiltros = new GestorFiltros(this.motor);		
	}
	
	@Override
	public void run() {
		// Lee de los controles
		this.estado = this.targetInput.getEstado();
		
		// Lee del Motor
		double rpm = motor.getRevoluiones();
		
		// Invoca jestor de filtros
		this.gFiltros.ejecutar(rpm, this.estado);
		
		// Actualiza Display
		this.targetDisplay.actualizaInformacion(this.motor);
	}
	
	public void encender() {
		this.GUI.setVisible(true);
		this.start();
	}

}
