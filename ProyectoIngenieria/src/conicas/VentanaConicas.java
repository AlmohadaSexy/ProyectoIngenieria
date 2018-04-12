package conicas;


import java.awt.Dimension;
import java.awt.EventQueue;
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
		
		JButton boton1 = new JButton();
		boton1.setBounds(0, 0, 111, 111);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MenuPrincipal().open();
			}
		});
		frame.add(boton1);
	}
}