package clases;


public class InfoMotor {

	private double revoluciones;
	private double combustible;
	private EstadoMotor estado;
	private boolean cambiarPastillas;
	private boolean repostar;
	private boolean cambiarAceite;
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
