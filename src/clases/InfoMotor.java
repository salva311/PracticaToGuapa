package clases;


public class InfoMotor {

	private double revoluciones;
	private double combustible;
	private EstadoMotor estado;
	private boolean cambiarPastillas;
	private boolean repostar;
	private boolean cambiarAceite;
	
	public InfoMotor() {
		this.revoluciones = 0.0;
		this.combustible = 75.0;
		this.estado = EstadoMotor.APAGADO;
		this.cambiarPastillas = false;
		this.cambiarAceite = false;
		this.repostar = false;
	}
	
	public InfoMotor(InfoMotor m) {
		this.revoluciones = m.revoluciones;
		this.combustible = m.combustible;
		this.estado = m.estado;
		this.cambiarAceite = m.cambiarAceite;
		this.cambiarPastillas = m.cambiarPastillas;
		this.repostar = m.repostar;
	}
	
	protected double getRevoluciones() {
		return revoluciones;
	}
	protected double getCombustible() {
		return combustible;
	}
	protected EstadoMotor getEstado() {
		return estado;
	}
	protected boolean isCambiarPastillas() {
		return cambiarPastillas;
	}
	protected boolean isRepostar() {
		return repostar;
	}
	protected boolean isCambiarAceite() {
		return cambiarAceite;
	}
	protected void setRevoluciones(double revoluciones) {
		this.revoluciones = revoluciones;
	}
	protected void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	protected void setEstado(EstadoMotor estado) {
		this.estado = estado;
	}
	protected void setCambiarPastillas(boolean cambiarPastillas) {
		this.cambiarPastillas = cambiarPastillas;
	}
	protected void setRepostar(boolean repostar) {
		this.repostar = repostar;
	}
	protected void setCambiarAceite(boolean cambiarAceite) {
		this.cambiarAceite = cambiarAceite;
	}

}
