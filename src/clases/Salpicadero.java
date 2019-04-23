package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Salpicadero extends JPanel {

	private static final long serialVersionUID = 1L;
	private double velocidad; // Km/h
	private double distancia;
	private Ellipse2D velocimetro;
	private Line2D segmentoCorto;
	private Line2D segmentoLargo;
	private Rectangle2D cuadroDistancia;
	private GeneralPath aguja;
	private AffineTransform t;
	private InfoMotor coche;
	private double lastCheck = 0;
	private Graphics g;

	public Salpicadero(InfoMotor coche)
	  {
	    this.coche = coche;
//	    this.velocidad = 0.0D;
	    this.velocidad = 50.0D;
	    this.distancia = 0.0D;
	    
	    setSize(400, 400);
	    setBackground(new Color(0, 0, 0));
	    this.velocimetro = new Ellipse2D.Double(-135.0D, -135.0D, 270.0D, 270.0D);
	    this.segmentoCorto = new Line2D.Double(-135.0D, 0.0D, -127.0D, 0.0D);
	    this.segmentoLargo = new Line2D.Double(-135.0D, 0.0D, -119.0D, 0.0D);
	    this.cuadroDistancia = new Rectangle2D.Double(148.0D, 230.0D, 50.0D, 20.0D);
//	    Declara aguja y construye perimertro
	    this.aguja = new GeneralPath();
	    this.aguja.moveTo(10.0F, 0.0F); // Centro de la aguja
	    this.aguja.lineTo(0.0F, 10.0F);
	    this.aguja.lineTo(-130.0F, 0.0F);
	    this.aguja.lineTo(0.0F, -10.0F);
	    this.aguja.closePath();

	    this.t = new AffineTransform();
	  }

	public void paintComponent(Graphics g) {
		String kilometros = String.valueOf(Math.rint(this.distancia * 10.0D) / 10.0D);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.white);
		g2.setFont(new Font("TimesRoman", 0, 20));
		g2.drawString("0", 31, 245);
		g2.drawString("20", 12, 200);
		g2.drawString("40", 12, 146);
		g2.drawString("60", 28, 103);
		g2.drawString("80", 61, 62);
		g2.drawString("100", 102, 36);
		g2.drawString("120", 156, 26);
		g2.drawString("140", 206, 35);
		g2.drawString("160", 251, 58);
		g2.drawString("180", 284, 95);
		g2.drawString("200", 302, 143);
		g2.drawString("220", 301, 195);
		g2.drawString("240", 283, 243);
		g2.drawString("KM/H", 147, 200);
		g2.drawString(kilometros, 197 - g2.getFontMetrics().stringWidth(kilometros), 248);
		g2.drawString("km", 205, 250);
		g2.draw(this.cuadroDistancia);
		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.draw(this.velocimetro);
		this.t.setToRotation(Math.toRadians(-30.0D));
		g2.transform(this.t);
		
//		Dibuja segmento al rededor de la circumferencia
		g2.draw(this.segmentoLargo);
		for (double angulo = 1.0D; angulo <= 12.0D; angulo += 1.0D) {
			this.t.setToRotation(Math.toRadians(10.0D));
			g2.transform(this.t);
			g2.draw(this.segmentoCorto);
			this.t.setToRotation(Math.toRadians(10.0D));
			g2.transform(this.t);
			g2.draw(this.segmentoLargo);
		}
		this.t.setToRotation(Math.toRadians(120.0D + this.velocidad));
		g2.transform(this.t);
		
		// Pintar Aguja
		g2.setPaint(Color.yellow);
		AffineTransform at = new AffineTransform();
//		Regla de 3
//		gradosAguja			x km/h
//		---------------  = ----------------
//			2pi				380 km/h
		
		at.rotate(0.8*Math.PI);
		this.aguja.transform(at);
		g2.fill(this.aguja);
	}
	
	public void pintar() {
		this.paintComponent(g);
	}
	
	public double getVelocidad() {
		double velocidad = 0;
		velocidad = 2 * Math.PI * 0.15 * 60 / 1000 * coche.getRevoluciones();
		return velocidad;
	}
	
	public double getDistancia() {
		double tiempo = 1;
		lastCheck  = System.currentTimeMillis();
		double velocidad = 0;
		velocidad = 2 * Math.PI * 0.15 * 60 / 1000 * coche.getRevoluciones();
		tiempo += lastCheck;
		return velocidad/tiempo;
	}

	public void repintar() {
//		this.velocidad = this.getVelocidad();
		this.distancia = this.getDistancia();
		repaint();
	}
}
