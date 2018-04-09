package EcuacionesConicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.MenuPrincipal;

public class ClaseConicas {
	
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaseConicas window = new ClaseConicas();
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
					ClaseConicas window = new ClaseConicas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClaseConicas() {
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