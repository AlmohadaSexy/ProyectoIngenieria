package poblacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class VentanaPoblacion {
	private JFrame frame;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaPoblacion();
					//window.frame.setVisible(true);
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
					VentanaPoblacion window = new VentanaPoblacion();
					window.frame.setVisible(true);
					//window.frame.pack();
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
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel panel = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            panel.add(label);
            JTextField textField = new JTextField(10);
            label.setLabelFor(textField);
            panel.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad

        //Create and set up the window.
        JFrame frame = new JFrame("Crecimiento de la poblacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int)Variables.width, (int)Variables.height);
        frame.setLocationRelativeTo(null);
        
        //Set up the content pane.
        panel.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(panel);

        //Display the window.
        //frame.pack();
        frame.setVisible(true);
		
		
		/*frame = new JFrame("Crecimiento de Poblacion");
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		
		
		
		frame.setSize((int)Variables.width, (int)Variables.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		frame.add(new pedirDatos(), BorderLayout.CENTER);
		//frame.ADD(frame);*/
	}
	
}
