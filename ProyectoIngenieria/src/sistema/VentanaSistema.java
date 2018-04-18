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
import javax.swing.table.DefaultTableModel;

import main.MenuPrincipal;


public class VentanaSistema extends JPanel{

	private JFrame frame;


	public static void main(String[] args) {
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
		
	
	
	public String tipoDeSistema(int m1, int m2, int m3, int m4, int m5, int m6, int m7, int m8, int m9, int b1, int b2, int b3) {
		
		// Calculamos el rango de la matriz de coeficientes
		int n = 3; // Num de incognitas
		int rga = 1; // Asumimos que siempre habra algun valor distinto de 0
		int deta1 = (m5 * m1) - (m4 * m2);
		int deta2 = ((m9*m5*m1)+(m4*m8*m3)+(m2*m6*m7))-((m7*m5*m3)+(m4*m2*m9)+(m8*m6*m1));
		
		
		if(m1==0 && m4==0 && m7==0) {
			n -= 1;
		} if(m2==0 && m5==0 && m8==0) {
			n-=1;
		} if(m3==0 && m6==0 && m9==0) {
			n -= 1;
		}
		
		
		
		if(deta1!=0 ) {
			rga = 2;
			if(deta2 != 0) {
				rga = 3;
			}
		}
		
		// Calculamos el rango de la matriz ampliada
		
		int rgamp = 1;
		int detamp1 = (m5 * m1) - (m4 * m2), detamp2 = (b3*m6) - (m9*b2), detamp5 = (b2*m2)-(m5*b1);
		int detamp3 = ((m9*m5*m1)+(m4*m8*m3)+(m2*m6*m7))-((m7*m5*m3)+(m4*m2*m9)+(m8*m6*m1));
		int detamp4 = ((b3*m6*m2)+(m5*m9*b1)+(m3*b2*m8))-((m8*m6*b1)+(m5*m3*b3)+(m9*b2*m2));
		
		if(detamp1 != 0 || detamp2 != 0 || detamp5 != 0) {
			rgamp = 2;
			if(detamp3 != 0 && detamp4 != 0) {
				rgamp = 3;
			}
		}
		
		
		// Comparacion de rangos entre matriz de coeficientes y ampliada para ver de que tipo se trata

		System.out.println("Rango matriz coeficientes:"+rga+"\nRango matriz ampliada: "+rgamp); // Se imprimen los rangos como comprobacion
		if (rga == rgamp) {
			if(rga == n) {
				return "Se trata de un Sistema Compatible Determinado.";
			} else {
				return "Se trata de un Sistema Compatible Indeterminado.";
			}			
		} else {
			return "Se trata de un Sistema Incompatible. No tiene soluciones.";
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
        JPanel panelPestana2 = new JPanel();
        
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
				frame.dispose();
				new MenuPrincipal().open();
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
		//scrollPane.setViewportView(table);
		//table.setFillsViewportHeight(true);
		
		
		
		panelPestana1.setOpaque(true);
		panelPestana1.add(scrollPane);
		
		JButton botonResolver = new JButton("Resolver");
		botonResolver.setBounds(0, 0, 888, 888);
		botonResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.addTab("Resolucion", panelPestana2);
				 tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
				 tabbedPane.setSelectedIndex(1);
				 panelPestana2.removeAll(); // Para limpiar el panel y poder hacer nuevos sistemas sin cerrar la ventana
				 JLabel tipoSistema = new JLabel(tipoDeSistema(Integer.valueOf((String)table.getValueAt(0, 0)), 
						 	Integer.valueOf((String)table.getValueAt(0, 1)), 
							Integer.valueOf((String)table.getValueAt(0, 2)), Integer.valueOf((String)table.getValueAt(1, 0)), 
							Integer.valueOf((String)table.getValueAt(1, 1)), Integer.valueOf((String)table.getValueAt(1, 2)), 
							Integer.valueOf((String)table.getValueAt(2, 0)), Integer.valueOf((String)table.getValueAt(2, 1)), 
							Integer.valueOf((String)table.getValueAt(2, 2)), Integer.valueOf((String)table.getValueAt(0, 3)), 
							Integer.valueOf((String)table.getValueAt(1, 3)), Integer.valueOf((String)table.getValueAt(2, 3))));
				 panelPestana2.add(tipoSistema);
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
        frame.setVisible(true);
        


	}
}