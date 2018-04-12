package poblacion;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class pedirDatos{
	static JTextPane field1 = new JTextPane();
	//field1.setBounds(21, 120, 381, 46);
	static JTextPane field2 = new JTextPane();
	static JTextPane field3 = new JTextPane();
	static JTextPane field4 = new JTextPane();
	Object[] message = {
		"Valor de E", field1,
	    "Valor de Dh", field2,
	    "Valor de Re", field3,
	    "Numero de iteraciones", field4,
	};
}
