package poblacion;

import java.awt.*;

import main.MenuPrincipal;

public class mainPoblacion {
	public mainPoblacion() {
	}
	public VentanaPoblacion ventana = new VentanaPoblacion();
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					framePoblacion.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Este metodo abre esta ventana
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana.ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Este metodo cierra framePoblacion y abre menuPrincipal
	 */
	public void close() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana.ventana.dispose();
					new MenuPrincipal().open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}