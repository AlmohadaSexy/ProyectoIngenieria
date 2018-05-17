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
	JPanel panelBotones, panelPrincipal;
	public static JTabbedPane panelTab;
	static boolean doubleJustSeemsGood;
	double k, A, B;
	int PA, PJ;
	
	/**
	 * 
	 */
	public VentanaPoblacion() {
    	this.setTitle("Ventana de Poblacion");
    	this.setSize(Variables.width, Variables.height);
    	this.setResizable(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);
    	
    	//Creamos los 3 paneles, el principal, y los dos que van a ir dentro
    	panelPrincipal = new JPanel();
    	upperPanel = new pedirDatos();
    	upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	panelBotones = new JPanel();
        
    	JButton botonAtras = new JButton("Atras");
    	botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonAtras.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mainPoblacion.close();
    		}
    	});
        
    	JButton botonSubmit = new JButton("Aceptar");
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
    				panelTab.setSelectedIndex(0);
    				JOptionPane.showMessageDialog(null, "Debe estar en la primera TAB para enviar los datos.");
    			}
    		}
    	});
		
    	JButton botonClear = new JButton("Cerrar TAB y limpiar");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			pedirDatos.textFieldK.setText("");
    			pedirDatos.textFieldA.setText("");
        		pedirDatos.textFieldB.setText("");
        		pedirDatos.textFieldPA.setText("");
        		pedirDatos.textFieldPJ.setText("");
        		pedirDatos.textFieldNombre.setText("");
    			panelTab.removeTabAt(panelTab.getSelectedIndex());
    			panelTab.setSelectedIndex(0);
    		}
    	});

    	//Ponemos el layout al panelBotones y añadimos los respectivos botones
    	panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.LINE_AXIS));
    	panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
    	panelBotones.add(Box.createHorizontalGlue());
    	panelBotones.add(botonSubmit);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonClear);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonAtras);
        
        //Ponemos el layout al panel principal y añadimos upperPanel y panelBotones
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(upperPanel);
        panelPrincipal.add(panelBotones, BorderLayout.PAGE_END);
        this.add(panelPrincipal);
	}
}