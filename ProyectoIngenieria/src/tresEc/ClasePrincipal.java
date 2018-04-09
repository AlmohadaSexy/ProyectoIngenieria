package tresEc;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class ClasePrincipal {

	public static void main(String[] args) {
		JFrame ventanaEc = new JFrame();
		
		JLabel inicial = new JLabel("Hola");

		
		ventanaEc.add(inicial);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth())/3;
		double height = (screenSize.getHeight())/2;
		
		ventanaEc.setSize((int)width, (int)height);
		ventanaEc.setLocationRelativeTo(null);
		ventanaEc.setVisible(true);
	}

}
