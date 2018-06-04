package conicas;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class VentanaAyuda extends JFrame {
	
	private JLabel labelHiper = new JLabel("h^2 > ab: Hipérbola");
	private JLabel labelPara = new JLabel("h^2 = ab: Parábola");
	private JLabel labelElipse = new JLabel("h^2 < ab: Elipse");
	private JLabel labelCirc = new JLabel("a = b y h = 0: Circunferencia");
	
	public VentanaAyuda() {
		super("Tipos:");
		
		Container c = getContentPane();
		
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		c.add(labelHiper);
		c.add(labelPara);
		c.add(labelElipse);
		c.add(labelCirc);
		
		//Al llamar a un metodo de la misma clase vale con poner this. o nada
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void open() {
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(220, 120);
		setVisible(true);
		
	}

}
