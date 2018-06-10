package conicas;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VentanaConicas {
	
	public static DistribucionFrame ventana;
    
    public static void open() {
    	
    	ventana = new DistribucionFrame();
    	ventana.pack();
    	ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventana.setVisible(true);
    }
}