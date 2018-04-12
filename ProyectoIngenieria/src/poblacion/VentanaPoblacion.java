package poblacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;

public class VentanaPoblacion {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPoblacion window = new VentanaPoblacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPoblacion window = new VentanaPoblacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaPoblacion() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame("Crecimiento de Poblacion");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth())/3;
		double height = (screenSize.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//frame.add(pedirDatos.field1);
		frame.add(pedirDatos.field2);
		frame.add(pedirDatos.field3);
		frame.add(pedirDatos.field4);
		
	}
}