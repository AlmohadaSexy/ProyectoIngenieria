package poblacion;

import javax.swing.*;

import main.MenuPrincipal;

import java.awt.*;
import java.awt.event.*;

public class VentanaPoblacion extends JFrame {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	pedirDatos upperPanel;
	JPanel downRightPanel, downLeftPanel, downCenterPanel;
	public static JTabbedPane panelTab;

	public VentanaPoblacion() {
    	this.setTitle("Ventana de Poblacion");
    	this.setSize(Variables.width, Variables.height);
    	this.setResizable(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.getContentPane().setBackground(Color.BLACK);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
        
    	// Setting Frame Layout
    	gbl = new GridBagLayout();
    	gbl.columnWidths = new int[] {200/3};
    	gbl.rowHeights = new int[] {Variables.height - 100};
    	gbl.columnWeights = new double[] {1};
    	gbl.rowWeights = new double[] {1};
        
    	gbc = new GridBagConstraints();
    	this.setLayout(gbl);

    	gbc.fill = GridBagConstraints.BOTH;
    	gbc.weightx = 1.0;
    	gbc.weighty = 1.0;

    	// Add Panels
    	upperPanel = new pedirDatos();
        
    	this.addPanels(0, 0, 1, 3, upperPanel); // row, col, height, width, component
        
    	downRightPanel = new JPanel();
    	downRightPanel.setLayout(new BorderLayout());
    	this.addPanels(1, 2, 1, 1, downRightPanel); // row, col, height, width, component
        
    	downCenterPanel = new JPanel();
    	downCenterPanel.setLayout(new BorderLayout());
    	this.addPanels(1, 1, 1, 1, downCenterPanel); // row, col, height, width, component
        
    	downLeftPanel = new JPanel();
    	downLeftPanel.setLayout(new BorderLayout());
    	this.addPanels(1, 0, 1, 1, downLeftPanel); // row, col, height, width, component
        
        
    	JButton botonAtras = new JButton("Atras");
    	botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonAtras.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mainPoblacion.close();
    		}
    	});
    	downRightPanel.add(botonAtras, BorderLayout.CENTER);
        
    	JButton botonSubmit = new JButton("Submit");
    	botonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonSubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Operaciones.addTab();
    			panelTab.setSelectedIndex(Variables.contOperaciones);
    			Variables.contOperaciones++;
    		}
    	});
    	downLeftPanel.add(botonSubmit, BorderLayout.CENTER);
		
    	JButton botonClear = new JButton("Clear");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mainPoblacion.close();
    		}
    	});
    	downCenterPanel.add(botonClear, BorderLayout.CENTER);
	}

	private void addPanels(int row, int col, int height, int width, Component com) {
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		gbl.setConstraints(com, gbc);
		this.getContentPane().add(com);
	}
}