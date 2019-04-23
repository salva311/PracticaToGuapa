package clases;

public class ControladorCoche extends Thread {
	
	private Interfaz GUI;
	private Pedales targetInput;
	private Salpicadero targetDisplay;
	
	private Motor motor;
	
	private GestorFiltros gFiltros;
	
	public ControladorCoche(Motor m) {
		
		// Interaccion con el humano
		this.GUI = new Interfaz();
		this.targetInput = this.GUI.getPedales();
		this.targetDisplay = this.GUI.getSalpicadero();
		
		// Motor
		this.motor = new Motor(EstadoMotor.APAGADO);
		
		// Gestor de filtros
		this.gFiltros = new GestorFiltros(this.motor);		
	}
	
	@Override
	public void run() {
		// Lee de los controles
		this.motor.cambiarEstado(this.targetInput.getEstado());
		
		// Saca la informacion del motor
		InfoMotor im = this.motor.getInfo();
		
		// Invoca jestor de filtros
		im = this.gFiltros.ejecutar(im);
		
		// Actualiza motor
		this.motor.setInfo(im);
		
		// Actualiza Display
		this.targetDisplay.actualizaInformacion(im);
	}
	
	public void encender() {
		this.GUI.setVisible(true);
		this.start();
	}
}
