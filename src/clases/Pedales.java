package clases;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Pedales extends JPanel {

	private static final long serialVersionUID = 1L;
	private Rectangle2D cuadroInyector;
	private Rectangle2D rellenoInyector;
	private RoundRectangle2D botonRepostar;
	private Arc2D visorCombustible;
	private Line2D segmentoLargo;
	private Line2D segmentoCorto;
	private GeneralPath aguja;
	private AffineTransform t;
	private double combustible;
	private double inyector;
	private InfoMotor vehiculo;

	public Pedales(InfoMotor vehiculo) {
		this.vehiculo = vehiculo;
		this.combustible = 0.0D;
		this.inyector = 0.0D;

		setSize(330, 170);
		this.visorCombustible = new Arc2D.Double(20.0D, 55.0D, 100.0D, 100.0D, 0.0D, 180.0D, 1);
		this.botonRepostar = new RoundRectangle2D.Double(20.0D, 120.0D, 100.0D, 25.0D, 10.0D, 10.0D);
		this.cuadroInyector = new Rectangle2D.Double(200.0D, 50.0D, 45.0D, 80.0D);
		this.rellenoInyector = new Rectangle2D.Double(200.0D, 50.0D, 45.0D, 80.0D);
		this.segmentoLargo = new Line2D.Double(-50.0D, 0.0D, -40.0D, 0.0D);
		this.segmentoCorto = new Line2D.Double(-50.0D, 0.0D, -45.0D, 0.0D);
		this.aguja = new GeneralPath();
		this.aguja.moveTo(5.0F, 0.0F);
		this.aguja.lineTo(0.0F, 5.0F);
		this.aguja.lineTo(-50.0F, 0.0F);
		this.aguja.lineTo(0.0F, -5.0F);
		this.aguja.closePath();
		this.t = new AffineTransform();
		setBackground(new Color(0, 0, 102));
		// addMouseListener(new CombustibleMouseAdapter(this, vehiculo));
		// addMouseMotionListener(new CombustibleMouseMotionAdapter(this, vehiculo));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.red);
		if (this.inyector > 0.0D) {
			this.rellenoInyector.setRect(200.0D, 130.0D - this.inyector * 80.0D / 100.0D, 45.0D,
					this.inyector * 80.0D / 100.0D);
			g2.fill(this.rellenoInyector);
		}
		this.vehiculo.getClass();
		if (vehiculo.getEstado() == EstadoMotor.APAGADO) { // TODO: hay que poner lo de getvelocidad
			g2.setPaint(Color.yellow);
		} else {
			g2.setPaint(new Color(30, 144, 255));
		}
		g2.fill(this.botonRepostar);
		g2.setFont(new Font("TimesRoman", 0, 16));
		g2.setPaint(Color.BLACK);
		g2.drawString("Repostar", 35, 140);
		g2.setPaint(Color.white);
		g2.draw(this.visorCombustible);
		g2.draw(this.cuadroInyector);
		g2.draw(this.cuadroInyector);
		g2.draw(this.botonRepostar);
		g2.drawString("Combustible", 25, 35);
		g2.drawString("Inyector", 200, 35);
		g2.drawString("R", 10, 108);
		g2.drawString("1/4", 21, 66);
		g2.drawString("1/2", 63, 51);
		g2.drawString("3/4", 102, 63);
		g2.drawString("1", 120, 108);
		g2.translate(70, 105);
		for (int angulo = 1; angulo <= 4; angulo++) {
			this.t.setToRotation(Math.toRadians(15.0D));
			g2.transform(this.t);
			g2.draw(this.segmentoCorto);
			this.t.setToRotation(Math.toRadians(15.0D));
			g2.transform(this.t);
			g2.draw(this.segmentoCorto);
			this.t.setToRotation(Math.toRadians(15.0D));
			g2.transform(this.t);
			g2.draw(this.segmentoLargo);
		}
		this.t.setToRotation(Math.toRadians(180.0D + this.combustible * 180.0D / 100.0D));
		g2.transform(this.t);
		g2.setPaint(Color.red);
		g2.fill(this.aguja);
	}

	public void repintar() {
		this.combustible = vehiculo.getCombustible();
		// this.inyector = this.vehiculo.getInyector();
		repaint();
	}
}
