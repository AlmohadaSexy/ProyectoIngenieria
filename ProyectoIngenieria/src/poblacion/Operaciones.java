package poblacion;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Operaciones {
	public static JPanel panel;
	public Operaciones() {
		
	}
	
	public static void addTab() {
		panel = new JPanel();
		VentanaPoblacion.panelTab.addTab("Operaciones " + Variables.contOperaciones, panel);
		VentanaPoblacion.panelTab.setMnemonicAt(Variables.contOperaciones, KeyEvent.VK_1);
	}
	
	
}
