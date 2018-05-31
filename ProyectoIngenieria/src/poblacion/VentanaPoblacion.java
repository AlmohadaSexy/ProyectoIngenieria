package poblacion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.MenuPrincipal;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VentanaPoblacion {


	JFrame ventana;
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
	 * 
	 * 
	 */
	public VentanaPoblacion() {
		ventana = new JFrame();
		ventana.setTitle("Ventana de Poblacion");
    	//this.setSize(Variables.width, Variables.height);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
    	
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
    			ventana.dispose();
    			MenuPrincipal menu = new MenuPrincipal();
    			menu.open();
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
    				
        			operaciones.rellenarMatrices(A, k, B, PA, PJ);
        			operaciones.iteraciones();
        			operaciones.operations();
					addTab(Nombre, operaciones.getTablePanel());
					File file = new File("Resultados.txt");
					try{
						if(file.exists()) {
					
						operaciones.read();
						operaciones.reorder();
					}else {
						operaciones.arrArchivo = new String[1][2];
						operaciones.arrArchivo[0][0] = Nombre;
						operaciones.arrArchivo[0][1] = String.valueOf(operaciones.matrizTabla[21][3]);
						operaciones.write();
					}
					} catch(Exception ee) {
						
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
        ventana.setSize(new Dimension(panelPrincipal.getHeight() , botonSubmit.getWidth() + botonClear.getWidth() + botonAtras.getWidth() + 15));
        //Ponemos el layout al panel principal y añadimos upperPanel y panelBotones
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(upperPanel);
        panelPrincipal.add(panelBotones, BorderLayout.PAGE_END);
        ventana.add(panelPrincipal);
        //this.setSize();
        tamano();
        panelTab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
		    	if (panelTab.getSelectedIndex() == 0) {
		    		botonSubmit.setEnabled(true);
		    		tamano();
		    	} else {
		    		botonSubmit.setEnabled(false);
		    		tamano();
		    	}
		    }
		});
        
        ventana.setMinimumSize(new Dimension(panelPrincipal.getHeight(), panelBotones.getWidth() + 200));
	}
	
	public void tamano() {
		
		
		//if(Variables.width <= panelBotones.getWidth()) {
			System.out.println(Variables.width);
			System.out.println(panelBotones.getWidth());
			System.out.println(panelPrincipal.getHeight());
		//}
		ventana.setMinimumSize(new Dimension(panelPrincipal.getHeight(), panelBotones.getWidth() + 100));
		
	}
	
	public void addTab(String Nombre, JPanel panel) {
		panelTab.addTab("Resultados " + Nombre, panel);
		panelTab.setMnemonicAt(Variables.contOperaciones, KeyEvent.VK_2);
	}
	
}