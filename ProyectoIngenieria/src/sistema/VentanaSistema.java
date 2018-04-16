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
		frame.setLocationRelativeTo(null);
		
		
		
		
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
		 * CREACION DE TABS
		 * 
		 * 
		 */
		

        
		tabbedPane.addTab("Enunciado", panelPestana1); // Se crea una nueva tab y se agrega el panel de esta
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

         
        
        tabbedPane.addTab("Resolucion", panelPestana2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
       
        
    	
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
		
		JLabel intro = new JLabel("Por favor introduce las variables del sistema de ecuaciones en los siguientes campos:");
		
		panelPestana1.add(intro);
	
		
		


		
		String[] colHeadings = {"X","Y","Z", "="};
		int numFilas = 3 ;
		DefaultTableModel model = new DefaultTableModel(numFilas, colHeadings.length); // Se crea un modelo para poder hacer uso de los datos
		model.setColumnIdentifiers(colHeadings);
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);

		//scrollPane.setViewportView(table);
		//table.setFillsViewportHeight(true);
		
		
		
		panelPestana1.setOpaque(true);
		panelPestana1.add(scrollPane);
		
		
		
		
		
		
		panelInferiorGeneral.add(botonVolver);
		panelGeneral.add(tabbedPane); // Se agrega al panel principal
		
		frame.add(panelInferiorGeneral, BorderLayout.SOUTH);
        frame.add(panelGeneral, BorderLayout.WEST); // Se agrega el panel general al conjunto entero, el frame
        frame.pack();
        frame.setVisible(true);
        


	}
}