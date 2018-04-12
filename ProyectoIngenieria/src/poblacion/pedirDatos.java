package poblacion;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class pedirDatos extends JPanel{
	public pedirDatos() {
		super(new GridLayout(1, 1));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent panel1 = makeTextField.makeTextField("hola");
		JComponent panel2 = makeTextField.makeTextField("Hola");
		JComponent panel3 = makeTextField.makeTextField("Hola");
		tabbedPane.addTab("Tab 1", panel1);
		tabbedPane.addTab("Tab 2", panel2);
		tabbedPane.addTab("Tab 3", panel3);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
}

