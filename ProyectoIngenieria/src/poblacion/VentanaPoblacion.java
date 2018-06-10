package poblacion;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.MenuPrincipal;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VentanaPoblacion {


	JFrame ventana;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	PedirDatos pedirDatos;
	JPanel panelBotones, panelPrincipal;
	public  JTabbedPane panelTab;
	boolean doubleJustSeemsGood;
	double k, A, B;
	int PA, PJ;
	String nombre;
	public JButton botonSubmit;
	JButton botonClear, botonAtras, botonRank, botonCerrarTab;
	Operaciones operaciones;
	Variables v = new Variables();
	
	/**
	 * Este metodo abre esta ventana
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Este metodo cierra ventana y abre MenuPrincipal
	 */
	public void close() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana.dispose();
					new MenuPrincipal().open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 * 
	 */
	public VentanaPoblacion() {
		ventana = new JFrame();
		ventana.setTitle("Ventana de Poblacion");
    	ventana.setSize(v.width, v.height);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
    	
    	operaciones = new Operaciones ();
    	
    	//Creamos los 3 paneles, el principal, y los dos que van a ir dentro
    	panelPrincipal = new JPanel();
    	panelTab = new JTabbedPane();
    	pedirDatos = new PedirDatos(panelTab);
    	pedirDatos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	panelBotones = new JPanel();
        
    	botonAtras = new JButton("Atras");
    	botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	botonAtras.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ventana.dispose();
    			MenuPrincipal menu = new MenuPrincipal();
    			menu.open();
    		}
    	});
        
        botonSubmit = new JButton("Aceptar");
    	botonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	botonSubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			boolean ok = doubleJustSeemsGood;
    			try	{
    				k = pedirDatos.getK();
    				A = pedirDatos.getA();
    				B = pedirDatos.getB();
    				PA = pedirDatos.getPA();
    				PJ = pedirDatos.getPJ();	
    				nombre = pedirDatos.getNombre();
    				operaciones.setNombre(nombre);
    				ok = true;
    			} catch(NumberFormatException eee) {
    				JOptionPane.showMessageDialog(null, "Usa un formato correcto");
    				ok = false;
    			}
    			final boolean doubleJustSeemsGood = ok;
    			if(doubleJustSeemsGood && panelTab.getSelectedIndex() == 0) {
        			operaciones.rellenarMatrices(A, k, B, PA, PJ);
        			operaciones.iteraciones();
        			operaciones.operations();
					addTab(nombre, operaciones.getTablePanel());
					File file = new File("Resultados.txt");
					try{
						if(file.exists()) {
							operaciones.read();
							operaciones.reorder();
						}else {
							Operaciones.arrArchivo = new String[1][2];
							Operaciones.arrArchivo[0][0] = nombre;
							String aux = String.valueOf(operaciones.matrizTabla[21][3]);
							String poblacion = "";
							for (int i = 0; i < aux.length(); i++) {
								if(aux.charAt(i) != 0) {
									poblacion += aux.charAt(i);
								}
							}
							Operaciones.arrArchivo[0][1] = poblacion;
						} 
						operaciones.write();
						botonRank.setEnabled(true);
					} catch(Exception ee) {
						
					}
					
					operaciones.numLineas++;
        			panelTab.setSelectedIndex(panelTab.getTabCount() - 1);
    			} else if (panelTab.getSelectedIndex() != 0){
    				panelTab.setSelectedIndex(0);
    				JOptionPane.showMessageDialog(null, "Debe estar en la primera TAB para enviar los datos.");
    			}
    			
    		}

			
    	});
		
    	botonClear = new JButton("Limpiar");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			pedirDatos.clear();
    		}
    	});
    	
    	botonCerrarTab = new JButton("Cerrar TAB");
    	botonCerrarTab.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	botonCerrarTab.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(panelTab.getSelectedIndex() != 0) {
    				panelTab.removeTabAt(panelTab.getSelectedIndex());
    			}
    			panelTab.setSelectedIndex(0);
    		}
    	});
    	botonCerrarTab.setEnabled(false);
    	
    	botonRank = new JButton("Ver Ranking");
    	botonRank.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	botonRank.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ventana.dispose();
    			try {
    				if(Operaciones.arrArchivo == null) {
        			 	operaciones.read();
        			}
					ranking();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    		}
    	});
    	File file = new File("Resultados.txt");
    	if(file.exists() == false) {
    		botonRank.setEnabled(false);
    	}   
    	panelTab.addChangeListener(new ChangeListener() {
 		    public void stateChanged(ChangeEvent e) {
 		    	if (panelTab.getSelectedIndex() == 0) {
 		    		botonCerrarTab.setEnabled(false);
 		    		botonClear.setEnabled(true);
 		    	} else {
 		    		botonCerrarTab.setEnabled(true);
 		    		botonClear.setEnabled(false);
 		    	}
 		    }
    	});
    	//Ponemos el layout al panelBotones y añadimos los respectivos botones
    	panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.LINE_AXIS));
    	panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
    	panelBotones.add(Box.createHorizontalGlue());
    	panelBotones.add(botonSubmit);
    	panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonCerrarTab);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonClear);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonAtras);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonRank);

        //Ponemos el layout al panel principal y añadimos upperPanel y panelBotones
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(pedirDatos);
        panelPrincipal.add(panelBotones, BorderLayout.PAGE_END);
        ventana.add(panelPrincipal);
	}
	
	public void addTab(String Nombre, JPanel panel) {
		panelTab.addTab("Resultados " + Nombre, panel);
		panelTab.setMnemonicAt(panelTab.getTabCount() - 1, KeyEvent.VK_2);
	}
	
	@SuppressWarnings("resource")
	private void ranking() throws IOException {
		
		JFrame frame = new JFrame("Ranking");
		frame.setSize(v.width, v.height * 4 / 3);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panelp = new JPanel();
		frame.setContentPane(panelp);
		panel1.removeAll();
		panelp.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(operaciones.numLineas + 1,1));
		JLabel label;
		BufferedReader in = new BufferedReader(new FileReader("Resultados.txt"));
		String[] strArr = new String[operaciones.numLineas];
		for(int i = 0; i < operaciones.numLineas; i++) {
			strArr[i] = in.readLine();
			label = new JLabel(strArr[i]);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panel1.add(label);
		}
		JButton buttonBack = new JButton("Atras");
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonBack.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			ventana.setVisible(true);
    		}
    	});
		panel2.add(buttonBack);
		panelp.add(panel1, BorderLayout.CENTER);
		panelp.add(panel2, BorderLayout.PAGE_END);
		
	}
	
}