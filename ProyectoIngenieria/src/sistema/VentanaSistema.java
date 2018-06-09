package sistema;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit;

import main.MenuPrincipal;

/**
 * 
 * @author Jorge Moreno
 *
 */


public class VentanaSistema extends JPanel{
	private JFrame frame;
	private TipoDeSistema sistemaTipo;
	private JPanel panelPestana2 = new JPanel();
	private JPanel subPanelPestana2 = new JPanel();
	
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSistema window = new VentanaSistema();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaSistema() {
		super(new BorderLayout());
		initialize();
	}
	
	
	/**
	 * Este metodo resuelve el sistema y muestra los pasos seguidos para esto. Los parametros introducidos corresponden a los distintos terminos
	 * de la matriz de coeficientes del sistema introducido por el usuario en el componente JTable.
	 * 
	 * @param m1 - Valor de la primera columna y primera fila.
	 * @param m2 - Segunda columna y primera fila.
	 * @param m3 - Tercera columna y primera fila.
	 * @param m4 - Primera columna y segunda fila.
	 * @param m5 - Segunda columna y segunda fila.
	 * @param m6 - Tercera columna y segunda fila.
	 * @param m7 - Primera columna y tercera fila.
	 * @param m8 - Segunda columna y tercera fila.
	 * @param m9 - Tercera columna y tercera fila.
	 * @param b1 - Cuarta columna y primera fila.
	 * @param b2 - Cuarta columna y segunda fila.
	 * @param b3 - Cuarta columna y tercera fila.
	 */
	
	public void resolverSistema (double m1, double m2, double m3, double m4, double m5, double m6, 
			double m7, double m8, double m9, double b1, double b2, double b3) {
		subPanelPestana2.setLayout(new BoxLayout(subPanelPestana2, BoxLayout.PAGE_AXIS));

		double deta = ((m9*m5*m1)+(m4*m8*m3)+(m2*m6*m7))-((m7*m5*m3)+(m4*m2*m9)+(m8*m6*m1));
		
		double detx = ((m9*m5*b1)+(b2*m8*m3)+(m2*m6*b3))-((b3*m5*m3)+(b2*m2*m9)+(m8*m6*b1));
		
		double dety = ((m9*b2*m1)+(b1*m6*m7)+(m4*b3*m3))-((m7*b2*m3)+(m4*b1*m9)+(b3*m6*m1));
		
		double detz = ((b3*m5*m1)+(m2*b2*m7)+(m4*m8*b1))-((m7*m5*b1)+(m4*m2*b3)+(m8*b2*m1));
		
		if(sistemaTipo.sistemaCout()) {
			double resultx = detx/deta; double resulty = dety/deta; double resultz = detz/deta;
			JLabel resultado = new JLabel("Los resultados del sistema son: | X "+resultx+"| Y "+resulty+"| Z "+resultz+"|");
			subPanelPestana2.add(resultado);
	
			// PASOS PARA LA RESOLUCION DEL PROBLEMA
			JEditorPane editorPane = new JEditorPane();
	        editorPane.setEditable(false);
	        editorPane.setEditorKit(new HTMLEditorKit());

	        JScrollPane editorScrollPane = new JScrollPane(editorPane);
	        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        editorScrollPane.setPreferredSize(new Dimension(750, 370));
	        frame.setSize(1150,550);
	        frame.setLocationRelativeTo(null);
	        editorScrollPane.setMinimumSize(new Dimension(10, 10));
	        editorScrollPane.setVisible(true);
       
			
			String resol = String.format(new ResolucionSistema().toString(), m1, m2, m3, m4, m5, m6, m7, m8, m9, 
					deta, b1, m2, m3, b2, m5, m6, b3, m8, m9, detx, m1, 
					b1, m3, m4, b2, m6, m7, b3, m9, dety, m1, m2, b1, m4, m5, b2, m7, m8, b3, detz);
	        editorPane.setText(resol);
	       
	       
			subPanelPestana2.add(editorScrollPane);
			panelPestana2.add(subPanelPestana2);
		} else {
			JLabel prueba = new JLabel ("Prueba con un sistema que tenga una unica solucion existente.");
			subPanelPestana2.add(prueba);
			panelPestana2.add(subPanelPestana2);
		}
	}
	

	public void initialize() {
		
		/***
		 * 
		 * 
		 * VENTANA PRINCIPAL
		 * 
		 * 
		 */
		
		
		frame = new JFrame("Sistema de 3 Ecuaciones");

		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth())/3;
		double height = (screenSize.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		/***
		 * 
		 * 
		 * DEFINICION DE PANELES
		 * 
		 * 
		 */
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
        
        
        JPanel panelPestana1 = new JPanel(); // Panel dentro de la tab
        
        JPanel panelGeneral = new JPanel(); // Panel dentro del frame principal
        
        JPanel panelInferiorGeneral = new JPanel();

		
	
		
		/***
		 * 
		 * 
		 * CREACION DE LA PRIMERA TAB DEL SISTEMA
		 * 
		 * 
		 */
		

        
		tabbedPane.addTab("Enunciado", panelPestana1); // Se crea una nueva tab y se agrega el panel de esta
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

         
        

    	
		/***
		 * 
		 * 
		 * CREACION DE COMPONENTES
		 * 
		 * 
		 */
        
		
        JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(0, 0, 888, 888);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPrincipal().open();
				frame.dispose();
			}
		});
		
		
		
		
		
		
		JLabel intro = new JLabel(
				"<html><p>Por favor introduce las variables<br> del sistema de ecuaciones<br> en los siguientes campos:</p></html>");
		
		panelPestana1.add(intro);
	
		
		


		
		String[] colHeadings = {"X","Y","Z", "="};
		int numFilas = 3 ;
		DefaultTableModel model = new DefaultTableModel(numFilas, colHeadings.length); // Se crea un modelo para poder hacer uso de los datos
		model.setColumnIdentifiers(colHeadings);
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);		
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		
		
		panelPestana1.setOpaque(true);
		panelPestana1.add(scrollPane);
		
		
		
		JButton botonResolver = new JButton("Resolver");
		botonResolver.setBounds(0, 0, 888, 888);
		botonResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.isEditing()) {
				    table.getCellEditor().stopCellEditing();
				} try {

				panelPestana2.removeAll(); // Para limpiar el panel y poder hacer nuevos sistemas sin cerrar la ventana
				subPanelPestana2.removeAll();
				sistemaTipo = new TipoDeSistema();
				JLabel tipoSistema = new JLabel(sistemaTipo.getTipoSistema(Double.valueOf((String)table.getValueAt(0, 0)), 
						 Double.valueOf((String)table.getValueAt(0, 1)), 
						 Double.valueOf((String)table.getValueAt(0, 2)), Double.valueOf((String)table.getValueAt(1, 0)), 
						 Double.valueOf((String)table.getValueAt(1, 1)), Double.valueOf((String)table.getValueAt(1, 2)), 
						 Double.valueOf((String)table.getValueAt(2, 0)), Double.valueOf((String)table.getValueAt(2, 1)), 
						 Double.valueOf((String)table.getValueAt(2, 2)), Double.valueOf((String)table.getValueAt(0, 3)), 
						 Double.valueOf((String)table.getValueAt(1, 3)), Double.valueOf((String)table.getValueAt(2, 3))));

				subPanelPestana2.add(tipoSistema);

				resolverSistema((Double.valueOf((String)table.getValueAt(0, 0))), 
							Double.valueOf((String)table.getValueAt(0, 1)), 
							Double.valueOf((String)table.getValueAt(0, 2)), Double.valueOf((String)table.getValueAt(1, 0)), 
							Double.valueOf((String)table.getValueAt(1, 1)), Double.valueOf((String)table.getValueAt(1, 2)), 
							Double.valueOf((String)table.getValueAt(2, 0)), Double.valueOf((String)table.getValueAt(2, 1)), 
							Double.valueOf((String)table.getValueAt(2, 2)), Double.valueOf((String)table.getValueAt(0, 3)), 
							Double.valueOf((String)table.getValueAt(1, 3)), Double.valueOf((String)table.getValueAt(2, 3)));

				tabbedPane.addTab("Resolucion", panelPestana2);
				tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
				tabbedPane.setSelectedIndex(1);

				 } catch  (NullPointerException a) {
					 JOptionPane.showMessageDialog(frame, "Debes rellenar todas las casillas.", "Casillas Vacias", JOptionPane.ERROR_MESSAGE);

				 } catch  (NumberFormatException a) {
					 JOptionPane.showMessageDialog(frame, "No has introducido numeros en todas las casillas.", "Error al Introducir Datos", 
							 JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(0, 0, 888, 888);
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < table.getRowCount(); i++)
				      for(int j = 0; j < table.getColumnCount(); j++) {
				          table.setValueAt("", i, j);
				      }
			}
		});
		
	
		/***
		 * 
		 * 
		 * ORDENACION GENERAL DE COMPONENTES
		 * 
		 * 
		 */
		
		
		panelPestana1.add(botonResolver);
		panelPestana1.add(botonLimpiar);

		
		panelInferiorGeneral.add(botonVolver);
		panelGeneral.add(tabbedPane); // Se agrega al panel principal
		
		
		
		frame.add(panelInferiorGeneral, BorderLayout.SOUTH);
        frame.add(panelGeneral, BorderLayout.WEST); // Se agrega el panel general al conjunto entero, el frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        
       
        frame.setMinimumSize(panelPestana1.getSize());
        
        // Para cambiar dimensiones de ventana al seleccionar los distintos tabs. Se hace resize correctamente.
     		tabbedPane.addChangeListener(new ChangeListener() {
     		    public void stateChanged(ChangeEvent e) {
     		    		if (tabbedPane.getSelectedIndex() == 0) {
     		    			frame.setSize(1130, 200);
     		    			frame.setMinimumSize(panelPestana1.getSize());
     		    		} else {
     		    			frame.setSize(1150, 550);
     		    			frame.setMinimumSize(panelPestana2.getSize());
     		    		}
     		    }
     		});


	}
}