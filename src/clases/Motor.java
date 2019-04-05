package clases;

public class Motor {
	private InfoMotor info;
	
	public Motor(EstadoMotor estado) {
		this.info = new InfoMotor();
		this.info.setEstado(estado);
	}
	
	public InfoMotor getInfo() {
		return this.info;
	}
	
	public void setInfo(InfoMotor info) {
		this.info = null;
		this.info = info;
	}
}
