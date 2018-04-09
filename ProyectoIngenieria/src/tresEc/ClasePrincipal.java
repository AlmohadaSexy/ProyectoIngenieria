package tresEc;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class ClasePrincipal {

	public static void main(String[] args) {
		JFrame ventanaEc = new JFrame();
		
		JLabel inicial = new JLabel("Hola");
		
		JButton botonPrueba = new JButton("Boton1");
		botonPrueba.setBounds(130,100,100, 40); 
		ventanaEc.add(botonPrueba);
		ventanaEc.add(inicial);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth())/3;
		double height = (screenSize.getHeight())/2;
		
		ventanaEc.setSize((int)width, (int)height);
		ventanaEc.setLocationRelativeTo(null);
		ventanaEc.setVisible(true);
		
		ventanaEc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
