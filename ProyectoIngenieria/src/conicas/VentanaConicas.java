package conicas;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VentanaConicas {
	
	public static DistribucionFrame ventana;
	
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
    	
            public void run() {
                
                ventana = new DistribucionFrame();
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
                ventana.pack();
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
            }

        });
        

    }
    
    public static void open() {
    	
    	ventana = new DistribucionFrame();
    	ventana.pack();
    	ventana.setLocationRelativeTo(null);
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventana.setVisible(true);
    }
}