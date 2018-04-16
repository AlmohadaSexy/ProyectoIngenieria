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
	static boolean doubleJustSeemsGood;
	
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
    	downRightPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
    	downRightPanel.setLayout(new BorderLayout());
    	this.addPanels(1, 2, 1, 1, downRightPanel); // row, col, height, width, component
        
    	downCenterPanel = new JPanel();
    	downCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
    	downCenterPanel.setLayout(new BorderLayout());
    	this.addPanels(1, 1, 1, 1, downCenterPanel); // row, col, height, width, component
        
    	downLeftPanel = new JPanel();
    	downLeftPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
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
    			
    			try	{
    				double k = Double.parseDouble(pedirDatos.textFieldK.getText());
    				double A = Double.parseDouble(pedirDatos.textFieldA.getText());
    				double B = Double.parseDouble(pedirDatos.textFieldB.getText());
    				double PA = Double.parseDouble(pedirDatos.textFieldPA.getText());
    				double PJ = Double.parseDouble(pedirDatos.textFieldPJ.getText());	
    				doubleJustSeemsGood = true;
    			} catch(Exception ee) {
    				JOptionPane.showMessageDialog(null, "No se puede convertir a Double");
    				doubleJustSeemsGood = false;
    			}
    			if(doubleJustSeemsGood && panelTab.getSelectedIndex() == 0) {
    				Operaciones.addTab();
        			panelTab.setSelectedIndex(Variables.contOperaciones);
        			Variables.contOperaciones++;
        			double k = Double.parseDouble(pedirDatos.textFieldK.getText());
    				double A = Double.parseDouble(pedirDatos.textFieldA.getText());
    				double B = Double.parseDouble(pedirDatos.textFieldB.getText());
    				double PJ = Double.parseDouble(pedirDatos.textFieldPJ.getText());
    				double PA = Double.parseDouble(pedirDatos.textFieldPA.getText());
        			Operaciones.matrizConstante(k, A, B);
        			System.out.println(Operaciones.matrizConstanteString());
        			Operaciones.matrizFin(PJ, PA);
        			System.out.println(Operaciones.matrizFinString());
        			Operaciones.iteraciones();
    			}
    		}
    	});
    	downLeftPanel.add(botonSubmit, BorderLayout.CENTER);
		
    	JButton botonClear = new JButton("Clear");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(panelTab.getSelectedIndex() == 0) {
    				pedirDatos.textFieldK.setText("");
    				pedirDatos.textFieldA.setText("");
        			pedirDatos.textFieldB.setText("");
        			pedirDatos.textFieldPA.setText("");
        			pedirDatos.textFieldPJ.setText("");
    			} else {
    				JOptionPane.showMessageDialog(null, "Vaya a la pestaña de Datos para borrarlo todo");
    			}
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