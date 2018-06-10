package conicas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class VentanaAyuda extends JFrame {
	
	private JLabel labelHiper = new JLabel("h^2 > ab: Hip�rbola");
	private JLabel labelPara = new JLabel("h^2 = ab: Par�bola");
	private JLabel labelElipse = new JLabel("h^2 < ab: Elipse");
	private JLabel labelCirc = new JLabel("a = b y h = 0: Circunferencia");
	private JLabel labelCol1 = new JLabel("Elipse 1� ecuaci�n: Color negro ");
	private JLabel labelCol2 = new JLabel("Par�bola 1� ecuaci�n: Color verde ");
	private JLabel labelCol3 = new JLabel("Hiperbola 1� ecuaci�n: Color azul ");
	private JLabel labelCol4 = new JLabel("Elipse 2� ecuaci�n: Color amarillo ");
	private JLabel labelCol5 = new JLabel("Par�bola 2� ecuaci�n: Color naranja ");
	private JLabel labelCol6 = new JLabel("Hiperbola 2� ecuaci�n: Color rosa ");
	
	public VentanaAyuda() {
		super("Tipos:");
		
		//Asignamos un color para cada ecuaci�n
		labelCol1.setForeground(Color.red); 
		labelCol2.setForeground(Color.green); 
		labelCol3.setForeground(Color.blue); 
		labelCol4.setForeground(Color.yellow); 
		labelCol5.setForeground(Color.orange); 
		labelCol6.setForeground(Color.magenta); 

		Container c = getContentPane();
		
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		c.add(labelHiper);
		c.add(labelPara);
		c.add(labelElipse);
		c.add(labelCirc);
		c.add(labelCol1);
		c.add(labelCol2);
		c.add(labelCol3);
		c.add(labelCol4);
		c.add(labelCol5);
		c.add(labelCol6);

		//Al llamar a un metodo de la misma clase vale con poner this. o nada
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void open() {
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(250, 200);
		setVisible(true);
		
	}

}
