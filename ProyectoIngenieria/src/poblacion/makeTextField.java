package poblacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class makeTextField {

	public static JPanel makeTextField(String text) {
		//new GridLayout(1, 2);
		
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		//panel.setLayout(layout);
		JLabel label = new JLabel("Introduzca el dato: ");
		JTextField filler = new JTextField("Introduzca los datos: ", 1);
		label.setLabelFor(filler);
		panel.add(label);
	    panel.add(filler);
		filler.setHorizontalAlignment(JLabel.EAST);
		
		//layout.putConstraint(SpringLayout.EAST, panel, 5, SpringLayout.EAST, label);
		//layout.putConstraint(SpringLayout.EAST, panel, 50, SpringLayout.EAST, filler);
		//filler.set;

		//filler.setSize(new Dimension((int) Variables.width, (int) filler.getSize().getHeight()));
		
		
		//filler.setBounds((int) Variables.width/2, /*label.getVerticalAlignment()*/ 60, (int) 500, (int) filler.getSize().getHeight());
		
		
		
	    
	    return panel;
    }
}