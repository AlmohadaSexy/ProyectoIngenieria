package poblacion;

import javax.swing.*;

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
	pedirDatos upperPanel;
	JPanel panelBotones, panelPrincipal;
	public  JTabbedPane panelTab;
	boolean doubleJustSeemsGood;
	double k, A, B;
	int PA, PJ;
	String Nombre;
	public JButton botonSubmit;
	JButton botonClear, botonAtras, botonRank;
	Operaciones operaciones;
	Variables v = new Variables();
	
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
    				operaciones.setNombre(Nombre);
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
							Operaciones.arrArchivo = new String[1][2];
							Operaciones.arrArchivo[0][0] = Nombre;
							Operaciones.arrArchivo[0][1] = String.valueOf(operaciones.matrizTabla[21][3]);
						} 
						operaciones.write();
						botonRank.setEnabled(true);
						//operaciones.setNumLineas(operaciones.getNumLineas());
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
		
    	botonClear = new JButton("Cerrar TAB y limpiar");
    	botonClear.setFont(new Font("Tahoma", Font.PLAIN, 26));
    	botonClear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			upperPanel.clear();
    			
    			panelTab.removeTabAt(panelTab.getSelectedIndex());
    			panelTab.setSelectedIndex(0);
    		}
    	});
    	
    	botonRank = new JButton("Ver Ranking");
    	botonRank.setFont(new Font("Tahoma", Font.PLAIN, 26));
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
    	//Ponemos el layout al panelBotones y añadimos los respectivos botones
    	panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.LINE_AXIS));
    	panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
    	panelBotones.add(Box.createHorizontalGlue());
    	panelBotones.add(botonSubmit);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonClear);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonAtras);
        panelBotones.add(Box.createRigidArea(new Dimension (5,0)));
        panelBotones.add(botonRank);

        //Ponemos el layout al panel principal y añadimos upperPanel y panelBotones
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(upperPanel);
        panelPrincipal.add(panelBotones, BorderLayout.PAGE_END);
        ventana.add(panelPrincipal);
        
        ventana.setMinimumSize(new Dimension(panelPrincipal.getHeight(), panelBotones.getWidth() + 200));
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
		String[] strARR = new String[operaciones.numLineas];
		for(int i = 0; i < operaciones.numLineas; i++) {
			strARR[i] = in.readLine();
			label = new JLabel(strARR[i]);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 26));
			panel1.add(label);
		}
		JButton buttonBack = new JButton("Atras");
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		buttonBack.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			ventana.setVisible(true);
    		}
    	});
		panel2.add(buttonBack);
		panelp.add(panel1);
		panelp.add(panel2, BorderLayout.PAGE_END);
		
	}
	
}