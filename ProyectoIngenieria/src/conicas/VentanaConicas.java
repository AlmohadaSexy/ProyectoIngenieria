package conicas;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class VentanaConicas {
	private static distribucionFrame ventana;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);

                ventana
                        = new distribucionFrame();
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Display the window.
                ventana.pack();
                ventana.setVisible(true);
            }

        });
        

    }
    
    public static void open() {
    	ventana.setLocationRelativeTo(null);
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventana.pack();
    	ventana.setVisible(true);
    }
}