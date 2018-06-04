package conicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.MenuPrincipal;

@SuppressWarnings("serial")
public class DistribucionFrame extends JFrame implements ActionListener {

	// Definimos las variables

	private JPanel principal, info, panelDeEcuacion, secundario1, secundario2, botones;
	public static JTabbedPane tabs;
	private DefaultTableModel model1, model2;
	private JButton borrar, ayuda, subir, atras;
	private JTable tabla1, tabla2;
	public static JTextField valorA, valorH, valorB, valorC, valorA2, valorH2, valorB2, valorC2;
	public JLabel labelEcuacion, ecuacion1, ecuacion2;
	public JScrollPane scrollpane;
	public JSplitPane splitPane;
	public Color marfil, marfil2;
	public String ecuacionNum1, ecuacionNum2;

	// Creamos el frame principal

	DistribucionFrame() {
		super("Ecuaciones Cónicas");

		// Poner el panel principal que contiene todo

		principal = new JPanel();
		principal.setLayout(new BorderLayout());
		add(principal);

		// Crear los panel de tabs

		tabs = new JTabbedPane();
		tabs.setPreferredSize(new Dimension(500, 500));
		tabs.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
		

		// Creamos los strings que contengan a las variables

		String[] nombresColum = { "Tipo de constante", "Valor asignado" };

		final Object[][] datos1 = { { "Tipo de constante", " Valor asignado" }, { "a", valorA }, { "h", valorH },
				{ "b", valorB }, { "c", valorC }

		};

		final Object[][] datos2 = { { "Tipo de constante", " Valor asignado" }, { "a", valorA2 }, { "h", valorH2 },
				{ "b", valorB2 }, { "c", valorC2 }

		};

		// Introducimos los strings en las tablas por defecto

		model1 = new DefaultTableModel(datos1, nombresColum) {

			public boolean isCellEditable(int row, int column) {
				return column != 0 && row != 0;
			}
		};

		model2 = new DefaultTableModel(datos2, nombresColum) {

			public boolean isCellEditable(int row, int column) {
				return column != 0 && row != 0;
			}
		};

		// Establecemos el color de cada tabla

		marfil = new Color(255, 255, 208);
		marfil2 = new Color(255, 230, 208);

		// Creamos las tablas

		tabla1 = new JTable(model1);
		tabla1.setPreferredScrollableViewportSize(new Dimension(0, 0));
		tabla1.setBackground(marfil);
		tabla1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabla1.getColumnModel().getColumn(1).setPreferredWidth(100);

		tabla2 = new JTable(model2);
		tabla2.setPreferredScrollableViewportSize(new Dimension(0, 0));
		tabla2.setBackground(marfil2);
		tabla2.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabla2.getColumnModel().getColumn(1).setPreferredWidth(100);

		// Creamos el JPanel que contendra las tablas y el enunciado
		info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));

		// Creamos los JLabel para el enunciado

		labelEcuacion = new JLabel(
				"<html><div><center>Introduce, en la tabla a continuacion, los datos <br> para completar las dos ecuaciones:<br> "
						+ "aX^2 + 2hXY + bY^2 + c = 0 </center></div></html>");
		labelEcuacion.setFont(new Font("Tahoma", Font.ITALIC, 13));
		labelEcuacion.setHorizontalAlignment(SwingConstants.CENTER);

		// Creamos un JPanel que contenga al JLabel anterior

		panelDeEcuacion = new JPanel();
		panelDeEcuacion.add(labelEcuacion);

		// Añadimos el JPanel anterior al JPanel 'info'

		info.add(panelDeEcuacion);

		// Creamos dos JPanels más que contendrán cada tabla

		secundario1 = new JPanel();
		secundario1.setBorder(BorderFactory.createTitledBorder("Datos Primera Ecuación: "));
		secundario1.add(tabla1);

		secundario2 = new JPanel();
		secundario2.setBorder(BorderFactory.createTitledBorder("Datos Segunda Ecuación: "));
		secundario2.add(tabla2);

		// Añadimos el JPanel 'info' que contiene todo a una tab

		tabs.addTab("Introduce los datos: ", info);

		// Añadimos los dos JPanels que contiene las tablas a 'info'

		info.add(secundario1);
		info.add(secundario2);

		// Creamos otro JPanel para los botones en 'principal'

		botones = new JPanel();
		botones.setLayout(new BoxLayout(botones, BoxLayout.LINE_AXIS));

		// Creamos los botones que luego pondremos en el JPanel 'botones'

		borrar = new JButton("Clear");
		borrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ayuda = new JButton("Help");
		ayuda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subir = new JButton("Submit");
		subir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		atras = new JButton("Back");
		atras.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// Establecemos un margen para el JPanel 'botones' y añadimos los botones al mismo JPanel

		botones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		botones.add(Box.createHorizontalGlue());
		botones.add(borrar);

		botones.add(Box.createRigidArea(new Dimension(7, 0)));
		botones.add(ayuda);

		botones.add(Box.createRigidArea(new Dimension(7, 0)));
		botones.add(subir);

		botones.add(Box.createRigidArea(new Dimension(7, 0)));
		botones.add(atras);

		// Configuramos la distribucion de cada JPanel en el JPanel 'principal'

		principal.add(tabs, BorderLayout.CENTER);
		principal.add(botones, BorderLayout.SOUTH);

		// Inicializamos los botones

		borrar.setActionCommand("Borrar");
		borrar.addActionListener(this);

		ayuda.setActionCommand("Ayudar");
		ayuda.addActionListener(this);

		subir.setActionCommand("Subir");
		subir.addActionListener(this);

		atras.setActionCommand("Atrás");
		atras.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		// Definimos la acción de cada boton

		if (e.getActionCommand().equals("Borrar")) {

			for (int i = 1; i < tabla1.getRowCount(); i++) {
				tabla1.setValueAt("", i, 1);

			}

			for (int i = 1; i < tabla2.getRowCount(); i++) {
				tabla2.setValueAt("", i, 1);

			}

			return;
		}

		if (e.getActionCommand().equals("Ayudar")) {

			VentanaAyuda ventanaAyuda = new VentanaAyuda();
			ventanaAyuda.open();

		}

		if (e.getActionCommand().equals("Subir")) {

			if (tabla1.isEditing() || tabla2.isEditing()) {

				tabla1.getCellEditor().stopCellEditing();
				tabla2.getCellEditor().stopCellEditing();

			}

			try {

				double valA = Double.parseDouble((String) tabla1.getValueAt(1, 1));
				double valH = Double.parseDouble((String) tabla1.getValueAt(2, 1));
				double valB = Double.parseDouble((String) tabla1.getValueAt(3, 1));
				double valC = Double.parseDouble((String) tabla1.getValueAt(4, 1));
				double valA2 = Double.parseDouble((String) tabla2.getValueAt(1, 1));
				double valH2 = Double.parseDouble((String) tabla2.getValueAt(2, 1));
				double valB2 = Double.parseDouble((String) tabla2.getValueAt(3, 1));
				double valC2 = Double.parseDouble((String) tabla2.getValueAt(4, 1));
				
				
				ecuacionNum1 = "'" + valA + "X^2 + " + valH + "XY + " + valB + "Y^2 + " + valC + " = 0 '";
				ecuacionNum2 = "'" + valA2 + "X^2 + " + valH2 + "XY + " + valB2 + "Y^2 + " + valC2 + " = 0 '";

				// Panel de confirmación de las ecuaciones
				int reply = JOptionPane.showConfirmDialog(null, "¿Son estas las ecuaciones que querías: " + ecuacionNum1
						+ " y " + ecuacionNum2.toString() + " ?", "¿Confirmamos?", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					
					TabGraficador var = new TabGraficador(valA, valH, valB, valC, valA2, valH2, valB2, valC2);
					tabs.addTab("Representación gráfica: ", var);
					tabs.setSelectedIndex(1);
					
				}

			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "No es posible convertirlo a Double");
			}
		}

		if (e.getActionCommand().equals("Atrás")) {

			dispose();
			new MenuPrincipal().open();
		}

	}

}