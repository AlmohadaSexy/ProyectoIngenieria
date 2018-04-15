package poblacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import main.MenuPrincipal;
import sistema.VentanaSistema;


public class pedirDatos extends JPanel{
	private static final long serialVersionUID = 1L;

	public static JTabbedPane tabbedPanePoblacion;
	
	public pedirDatos() {
		super(new GridLayout(1, 1));
		
		tabbedPanePoblacion = new JTabbedPane();
		
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
        int numPairs = labels.length;
        
        //Create and populate the panel.
        JPanel panel1 = new JPanel(new SpringLayout());
        //panelTab1.add(panel1);
        for (int i = 0; i < numPairs; i++) {
            JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            label.setFont(new Font("Tahoma", Font.PLAIN, 22));
            panel1.add(label);
            JTextField textField = new JTextField(10);
            textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
            label.setLabelFor(textField);
            panel1.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel1,
                                 		numPairs, 2, //rows, cols
                                 		6, 6,        //initX, initY
                                 		10, 10);       //xPad, yPad
		
		tabbedPanePoblacion.addTab("Datos", panel1);
		
		tabbedPanePoblacion.setMnemonicAt(0, KeyEvent.VK_1);
		
		add(tabbedPanePoblacion);
		tabbedPanePoblacion.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
}

