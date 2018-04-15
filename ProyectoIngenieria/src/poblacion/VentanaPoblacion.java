package poblacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import main.MenuPrincipal;

public class VentanaPoblacion {
	public static JFrame framePoblacion;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPoblacion window = new VentanaPoblacion();
//					window.frame.setVisible(true);
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
//					VentanaPoblacion window = new VentanaPoblacion();
					VentanaPoblacion.framePoblacion.setVisible(true);
//					window.frame.pack();
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
		
		pedirDatos panel = new pedirDatos();
		
		BorderLayout layout = new BorderLayout();
		BoxLayout layout2 = new BoxLayout(framePoblacion, 0);
//		Create and set up the window.
        framePoblacion = new JFrame("Crecimiento de la poblacion");
        framePoblacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePoblacion.setSize((int)Variables.width, (int)Variables.height);
        framePoblacion.setLocationRelativeTo(null);
//		framePoblacion.setLayout(layout);
//		panel.setBounds(0, 0, (int)Variables.width, (int)Variables.height*2/3);
//      panel.setLayout(layout);
        
//		Set up the content pane.
//		panel.setOpaque(true);  //content panes must be opaque
//      panel.setBounds(0, 0, (int)Variables.width, (int)Variables.height*2/3);
        framePoblacion.setContentPane(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(layout);
        
        JButton boton = new JButton("Back");
//		framePoblacion.add(boton);
//		boton.setBounds(50, 50, 500, 5);
		boton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPoblacion.framePoblacion.dispose();
				new MenuPrincipal().open();
			}
		});
		panel2.add(boton, BorderLayout.PAGE_END);
		
		
		framePoblacion.add(panel2, BorderLayout.PAGE_END);
		
		
		
///*
		JButton boton2 = new JButton("Back2");
        framePoblacion.add(boton2);
		boton2.setBounds(50, 50, 5, 5);
		boton2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPoblacion.framePoblacion.dispose();
				new MenuPrincipal().open();
			}
		});
		
		panel2.add(boton2, BorderLayout.PAGE_START);
//*/
	
//		Display the window.
//		framePoblacion.pack();
        framePoblacion.setVisible(true);
        
		
/*		frame = new JFrame("Crecimiento de Poblacion");
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		
		
		
		frame.setSize((int)Variables.width, (int)Variables.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		frame.add(new pedirDatos(), BorderLayout.CENTER);
		//frame.ADD(frame);
*/
	}
	
}
