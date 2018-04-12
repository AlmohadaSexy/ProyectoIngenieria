package poblacion;

import java.awt.Component;
import javax.swing.*;
import java.awt.*;

public class makeTextField {

	public static JPanel makeTextField(String text) {
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		JLabel label = new JLabel("Introduzca el dato: ");
		JTextField filler = new JTextField("Introduzca los datos: ", 15);
		//filler.setHorizontalAlignment(JLabel.CENTER);
		//layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, label);
		//layout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, filler);
		
		SpringUtilities.makeGrid(panel, 
								2, 1, 
								5, 5, 
								5, 5);
		
		panel.add(label);
	    panel.add(filler);
	    
	    return panel;
    }
}