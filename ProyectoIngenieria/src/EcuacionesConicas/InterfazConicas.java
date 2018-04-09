package EcuacionesConicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazConicas {
	
	public static void main(String[] args) {
		JFrame ventanaConic = new JFrame ();
		
		JLabel titulo = new JLabel ("Ecuaciones Cónicas");
		ventanaConic.add(titulo);

		Dimension tamanoVentana = Toolkit.getDefaultToolkit().getScreenSize();
		double ancho = (tamanoVentana.getWidth())/3;
		double alto = (tamanoVentana.getHeight())/2;
		
		ventanaConic.setSize((int)ancho,(int)alto);
		ventanaConic.setLocationRelativeTo(null);
		ventanaConic.setVisible(true);
		ventanaConic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class VentanaConica extends JFrame{
	
	public VentanaConica() {
		setTitle("Ecuaciones Cónicas");
		JButton boton1 = new JButton("Sistemas de Ecuaciones");
		boton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boton1.setBounds(0, (alto / 3)*0, ancho, alturaVentana / 3 - 20);
		ventanaConica.add(boton1);

	}
}