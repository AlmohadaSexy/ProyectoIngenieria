package conicas;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;

public class VentanaConicas {
	
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConicas window = new VentanaConicas();
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
					VentanaConicas window = new VentanaConicas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaConicas() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame ("Ecuaciones Cónicas");

		Dimension tamanoVentana = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (tamanoVentana.getWidth())/3;
		double height = (tamanoVentana.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);	
	}
}