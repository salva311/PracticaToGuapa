package clases;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Coche extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		InfoMotor a = new InfoMotor();
		frame.setLayout(new GridLayout(1,2));
		Pedales p = new Pedales(a);
		Salpicadero b = new Salpicadero(a);
		b.repaint();
		frame.add(p);
		frame.add(b);
		frame.setSize(370*2, 380);
		frame.setVisible(true);
		b.repintar();
		
	}

}
