package poblacion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class VentanaPoblacion extends JFrame {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	pedirDatos upperPanel;
	JPanel panelBotones, panelPrincipal;
	public  JTabbedPane panelTab;
	boolean doubleJustSeemsGood;
	double k, A, B;
	int PA, PJ;
	String Nombre;
	public JButton botonSubmit;
	JButton botonClear, botonAtras;
	Operaciones operaciones;
	/**
	 * @param operaciones 
	 * @param botonSubmit 
	 * @param doubleJustSeemsGood 
	 * @param  
	 * 
	 */
	public VentanaPoblacion(/*Operaciones operaciones, JButton botonSubmit, boolean doubleJustSeemsGood*/) {
    	this.setTitle("Ventana de Poblacion");
    	this.setSize(Variables.width, Variables.height);
    	this.setResizable(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.setLocationRelativeTo(null);
//    	this.operaciones = operaciones;
//    	this.botonSubmit = botonSubmit;
//    	this.doubleJustSeemsGood = doubleJustSeemsGood;
    	
    	operaciones = new Operaciones ();
    	
    	//Creamos los 3 paneles, el principal, y los dos que van a ir dentro
    	panelPrincipal = new JPanel();
    	panelTab = new JTabbedPane();
    	upperPanel = new pedirDatos(panelTab);
    	upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	panelBotones = new JPanel();
        
    	botonAtras = new JButton("Atras");
    	botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonAtras.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			mainPoblacion.close();
    		}
    	});
        
        botonSubmit = new JButton("Aceptar");
    	botonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonSubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			boolean ok = doubleJustSeemsGood;
    			try	{
    				k = upperPanel.getK();
    				A = upperPanel.getA();
    				B = upperPanel.getB();
    				PA = upperPanel.getPA();
    				PJ = upperPanel.getPJ();	
    				Nombre = upperPanel.getNombre();
    				ok = true;
    			} catch(Exception ee) {
    				JOptionPane.showMessageDialog(null, "No se puede convertir a Double");
    				ok = false;
    			}
    			final boolean doubleJustSeemsGood = ok;
    			if(doubleJustSeemsGood && panelTab.getSelectedIndex() == 0) {
    				
        			operaciones.matrizConstante(k, A, B);
        			operaciones.matrizFin(PJ, PA);
        			operaciones.iteraciones();
        			try {
						operaciones.addTab();
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
		
    	botonClear = new JButton("Cerrar TAB y limpiar");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			upperPanel.clear();
    			
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
        
//        panelTab.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//		    	if (panelTab.getSelectedIndex() == 0) {
//		    		botonSubmit.setEnabled(true);
//		    	} else {
//		    		botonSubmit.setEnabled(false);
//		    	}
//		    }
//		});
	}

	public void tamano() {
		setMinimumSize(Operaciones.table.getSize());
	}
}