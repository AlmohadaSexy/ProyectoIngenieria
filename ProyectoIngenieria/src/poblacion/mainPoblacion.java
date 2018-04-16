package poblacion;

import java.awt.*;

import main.MenuPrincipal;

public class mainPoblacion {
	
	public static VentanaPoblacion framePoblacion = new VentanaPoblacion();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framePoblacion.setVisible(true);
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
					framePoblacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void close() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framePoblacion.dispose();
					new MenuPrincipal().open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}