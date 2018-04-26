package conicas;


import java.awt.BorderLayout;
import java.awt.Color;
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

		/* Dimension tamanoVentana = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (tamanoVentana.getWidth())/3;
		double height = (tamanoVentana.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);	*/
		
		// Panel con FlowLayout que empieza a alinear componentes por la derecha.
	    //JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
	    //panel2.setPreferredSize(new Dimension(200,400));
	    frame.add(panel2);
	    
	    //creo los paneles de botones y tabs
	    JPanel tabs = new JPanel();
	    tabs.setPreferredSize(new Dimension (400, 450));
	    tabs.setBackground(Color.red);
	    
	    JPanel botones = new JPanel();
	    botones.setLayout(new BoxLayout (botones, BoxLayout.LINE_AXIS)); //Para que vaya de izquierda a derecha
	    botones.setBackground(Color.green);
	    
	    JButton aceptar = new JButton ("Aceptar");
	    JButton cancelar = new JButton ("Cancelar");
	    JButton aplicar = new JButton ("Aplicar");
	    botones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    botones.add(aceptar);
	    botones.add(cancelar);
	    botones.add(aplicar);
	    
	    /*
	    panel2.add(tabs, BorderLayout.CENTER);
	    panel2.add(botones, BorderLayout.SOUTH);
	    
	    panel2.add(new JButton("el boton"));

	    // El JFrame tiene un BorderLayout, colocamos el panel en el Sur (parte inferior).
	    frame.getContentPane().add(panel2, BorderLayout.SOUTH);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	    frame.pack();
	    frame.setVisible(true);
	}
}