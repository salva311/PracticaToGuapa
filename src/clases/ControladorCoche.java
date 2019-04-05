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
		InfoMotor im = this.genInfoMotor();
		
		// Invoca jestor de filtros
		im = this.gFiltros.ejecutar(im);
		
		// Actualiza Display
		this.targetDisplay.actualizaInformacion(im);
	}
	
	private InfoMotor genInfoMotor() {
		InfoMotor im = new InfoMotor();
		
		im.setEstado(this.motor.getEstado());
		im.setCombustible(this.motor.getLitros());
		im.setRevoluciones(this.motor.getRevoluiones());
		
		return im;
	}
	
	public void encender() {
		this.GUI.setVisible(true);
		this.start();
	}
}
