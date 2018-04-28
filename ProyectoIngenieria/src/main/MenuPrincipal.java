package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import conicas.VentanaConicas;
import poblacion.*;
import sistema.*;

public class MenuPrincipal{
	
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuPrincipal() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("MenuPrincipal");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double anchuraPantalla = (screenSize.getWidth())/3;
		double alturaPantalla = (screenSize.getHeight()/2);
		
		frame.setSize((int) anchuraPantalla, (int) alturaPantalla);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		//frame.setContentPane(panel);
		
		int alturaVentana = frame.getHeight();
		int anchuraVentana = frame.getWidth();
		
		JButton btn1 = new JButton("Sistemas de Ecuaciones");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn1.setToolTipText("Resuelve un sistema de 3 ecuaciones con 3 incognitas.");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaSistema().open();
			}
		});
		btn1.setBounds(0, (alturaVentana / 3)*0, anchuraVentana, alturaVentana / 3 - 20);
		frame.add(btn1);
		
		JButton btn2 = new JButton("Ecuaciones Conicas");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn2.setToolTipText("Resolucion y representacion grafica de ecuaciones conicas.");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaConicas().open();
			}
		});
		
		btn2.setBounds(0, (alturaVentana / 3)*1 -10 , anchuraVentana, alturaVentana / 3 -20);
		frame.add(btn2);
		
		
		
		JButton btn3 = new JButton("Crecimiento de Poblaciones");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn3.setToolTipText("Calcular el crecimiento de una poblacion en x años.");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new mainPoblacion().open();
			}
		});
		btn3.setBounds(0, (alturaVentana / 3)*2 - 20, anchuraVentana, alturaVentana / 3 - 20);
		frame.add(btn3);
		
	}
}