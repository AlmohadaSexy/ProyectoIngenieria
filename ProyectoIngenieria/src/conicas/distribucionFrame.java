package conicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.MenuPrincipal;
import sistema.VentanaSistema;


@SuppressWarnings("serial")
public class distribucionFrame extends JFrame implements ActionListener{
    
    distribucionFrame(){
        
        //poner el panel principal que contiene todo
        JPanel principal = new JPanel ();
        principal.setLayout(new BorderLayout());
        add (principal);
        
        //crear los panel de tabs
        JTabbedPane  tabs = new JTabbedPane  ();
        tabs.setPreferredSize(new Dimension (400,450));
        tabs.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        
        
        //añadir tabs
        JPanel info = new JPanel ();
        info.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        info.setBackground(Color.WHITE);
        tabs.addTab("General", info);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        /*JTextField nombreFichero = new JTextField ("nombre.txt");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 0.0;
        info.add(nombreFichero, c);
        
        JButton boton = new JButton ("nombre.txt");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 0.0;
        info.add(boton, c);*/
        
        
        //crear el panel de botones
        JPanel botones = new JPanel ();
        botones.setLayout(new BoxLayout(botones,BoxLayout.LINE_AXIS));
               
        // añadir botones al panel de botones
        JButton borrar = new JButton ("Clear");
        JButton ayuda = new JButton ("Help");
        JButton subir = new JButton ("Submit");
        JButton atras = new JButton ("Back");
        
        //poner margen al panel de botones
        botones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        botones.add (Box.createHorizontalGlue());
        botones.add(borrar);
        botones.add(Box.createRigidArea(new Dimension (5,0)));
        botones.add(ayuda);
        botones.add(Box.createRigidArea(new Dimension (5,0)));
        botones.add(subir);
        botones.add(Box.createRigidArea(new Dimension (5,0)));
        botones.add (atras);
        
        principal.add(tabs,BorderLayout.CENTER);
        principal.add (botones, BorderLayout.SOUTH);
        atras.addActionListener(this);

}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		new MenuPrincipal().open();
		
	}
	
}