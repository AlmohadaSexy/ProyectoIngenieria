package conicas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.MenuPrincipal;

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
		frame = new JFrame ("Ecuaciones C�nicas");

		Dimension tamanoVentana = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (tamanoVentana.getWidth())/3;
		double height = (tamanoVentana.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);	
		
		// Panel con FlowLayout que empieza a alinear componentes por la derecha.
	    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
	    panel2.add(new JButton("el boton"));

	    // El JFrame tiene un BorderLayout, colocamos el panel en el Sur (parte inferior).
	    frame.getContentPane().add(panel2, BorderLayout.SOUTH);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
}