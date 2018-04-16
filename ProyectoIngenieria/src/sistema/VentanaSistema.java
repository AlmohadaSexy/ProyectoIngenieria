package sistema;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;


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
		//super(new GridLayout(1, 1));
		super(new BorderLayout());
		initialize();
	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	

	
	public void initialize() {
		frame = new JFrame("Sistema de 3 Ecuaciones");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth())/3;
		double height = (screenSize.getHeight())/2;
		
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		// Creacion de panel de tabs
		JTabbedPane tabbedPane = new JTabbedPane();
        
        
        JPanel panelPestana = new JPanel(); // Panel dentro de las tab
        JPanel panelGeneral = new JPanel(); // Panel dentro del frame principal
        
		tabbedPane.addTab("Enunciado", panelPestana); // Se crea una nueva tab y se agrega el panel de esta
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        
        tabbedPane.addTab("Resolucion", new JButton("Hola2"));
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
       
        panelGeneral.add(tabbedPane); // Se agrega al panel principal el de las tabs
        frame.add(panelGeneral, BorderLayout.CENTER);
		
   
        frame.setVisible(true);
        


	}
}