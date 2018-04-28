package poblacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class VentanaPoblacion extends JFrame {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	pedirDatos upperPanel;
	JPanel downRightPanel, downLeftPanel, downCenterPanel;
	public static JTabbedPane panelTab;
	static boolean doubleJustSeemsGood;
	double k, A, B;
	int anos, PA, PJ;
	/**
	 * 
	 */
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
        panelTab.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	this.addPanels(0, 0, 1, 1, upperPanel); // row, col, height, width, component

    	JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.LINE_AXIS));
        
    	
    	JButton botonAtras = new JButton("Atras");
    	botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonAtras.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mainPoblacion.close();
    		}
    	});
    	panelBotones.add(botonAtras, BorderLayout.CENTER);
        
    	JButton botonSubmit = new JButton("Submit");
    	botonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonSubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try	{
    				k = Double.parseDouble(pedirDatos.textFieldK.getText());
    				A = Double.parseDouble(pedirDatos.textFieldA.getText());
    				B = Double.parseDouble(pedirDatos.textFieldB.getText());
    				PA = Integer.parseInt(pedirDatos.textFieldPA.getText());
    				PJ = Integer.parseInt(pedirDatos.textFieldPJ.getText());	
    				Operaciones.Nombre = String.valueOf(pedirDatos.textFieldNombre.getText());
    				doubleJustSeemsGood = true;
    			} catch(Exception ee) {
    				JOptionPane.showMessageDialog(null, "No se puede convertir a Double");
    				doubleJustSeemsGood = false;
    			}
    			if(doubleJustSeemsGood && panelTab.getSelectedIndex() == 0) {
    				
        			Operaciones.matrizConstante(k, A, B);
        			Operaciones.matrizFin(PJ, PA);
        			Operaciones.iteraciones();
        			try {
						Operaciones.addTab();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
        			panelTab.setSelectedIndex(Variables.contOperaciones);
        			Variables.contOperaciones++;
    			} else if (panelTab.getSelectedIndex() != 0){
    				JOptionPane.showMessageDialog(null, "Vaya a la primera TAB para poder calcular el resul0tado");
    			}
    		}
    	});
    	panelBotones.add(botonSubmit, BorderLayout.CENTER);
		
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
        			pedirDatos.textFieldNombre.setText("");
    			} else {
    				JOptionPane.showMessageDialog(null, "Vaya a la pestaña de Datos para borrarlo todo");
    			}
    		}
    	});
    	panelBotones.add(botonClear, BorderLayout.CENTER);
    	
    	
    	panelBotones.setBorder(
                BorderFactory.createEmptyBorder(0, 10, 5, 10));
        
    	panelBotones.add(Box.createHorizontalGlue());
    	panelBotones.add(botonSubmit);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonClear);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonAtras);
        
        this.addPanels(1, 0, 1, 1, panelBotones);
	}
	/**
	 * 
	 * Este metodo se usa para organizar los elementos dentro del frame
	 * 
	 * @param row Fila en la que se encuentra
	 * @param col Columna en la que se encuentra
	 * @param height Numero de filas que ocupa
	 * @param width Numero de columnas que ocupa
	 * @param com Componente que añades a la ventana
	 * 
	 * @author IgnacioT
	 */
	private void addPanels(int row, int col, int height, int width, Component com) {
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		gbl.setConstraints(com, gbc);
		this.getContentPane().add(com);
	}
}