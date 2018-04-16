package poblacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class pedirDatos extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel labelK, labelA, labelB, labelPJ, labelPA;
	public static JTextField textFieldK, textFieldA, textFieldB, textFieldPJ, textFieldPA, textFieldNombre;
	
	
	public pedirDatos() {
		super(new GridLayout(1, 1));
		
		VentanaPoblacion.panelTab = new JTabbedPane();
		
		
        
		//Create and populate the panel.
		JPanel panel1 = new JPanel(new SpringLayout());
		//panelTab1.add(panel1);
		
		JLabel labelK = new JLabel("k: ", JLabel.TRAILING);
		labelK.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelK);
		textFieldK = new JTextField(10);
		textFieldK.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelK.setLabelFor(textFieldK);
		panel1.add(textFieldK);
		
		JLabel labelA = new JLabel("\u03B1: ", JLabel.TRAILING);
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelA);
		textFieldA = new JTextField(10);
		textFieldA.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelA.setLabelFor(textFieldA);
		panel1.add(textFieldA);
		
		JLabel labelB = new JLabel("\u03B2: ", JLabel.TRAILING);
		labelB.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelB);
		textFieldB = new JTextField(10);
		textFieldB.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelB.setLabelFor(textFieldB);
		panel1.add(textFieldB);
		
		JLabel labelPJ = new JLabel("Poblacion Joven: ", JLabel.TRAILING);
		labelPJ.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelPJ);
		textFieldPJ = new JTextField(10);
		textFieldPJ.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelPJ.setLabelFor(textFieldPJ);
		panel1.add(textFieldPJ);
		
		JLabel labelPA = new JLabel("Poblacion Adulta: ", JLabel.TRAILING);
		labelPA.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelPA);
		textFieldPA = new JTextField(10);
		textFieldPA.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelPA.setLabelFor(textFieldPA);
		panel1.add(textFieldPA);
		
		JLabel labelNombre = new JLabel("Nombre: ", JLabel.TRAILING);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(labelNombre);
		textFieldNombre = new JTextField(10);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelNombre.setLabelFor(textFieldNombre);
		panel1.add(textFieldNombre);
		

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(panel1,
										6, 2, //rows, cols
										6, 6,        //initX, initY
										10, 10);       //xPad, yPad
		
		VentanaPoblacion.panelTab.addTab("Datos", panel1);
		
		VentanaPoblacion.panelTab.setMnemonicAt(0, KeyEvent.VK_1);
		
		add(VentanaPoblacion.panelTab);
		VentanaPoblacion.panelTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}	
}