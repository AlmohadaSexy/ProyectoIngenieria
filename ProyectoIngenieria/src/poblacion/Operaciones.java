package poblacion;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Operaciones {
	private static JPanel panel;	
	static JTable table;
	static String[] titulos = {"A\u00f1o", "Poblacion J", "Poblacion a", "Poblacion T", "Pjn/Pan", "Tn/Tn-1"};
	public static double[][]matrizFin;
	static double[][]matrizCons;
	static Object[][]matrizTabla = new Object[22][6];
	Operaciones() {

	}
	
	public static void addTab() {
		panel = new JPanel();
		VentanaPoblacion.panelTab.addTab("Resultados " + Variables.contOperaciones, panel);
		VentanaPoblacion.panelTab.setMnemonicAt(Variables.contOperaciones, KeyEvent.VK_2);
		
		for(int i = 0; i < matrizTabla.length - 1; i++) {
			matrizTabla[i+1][0] = i;
		}
		
		for(int i = 0; i < matrizTabla[0].length; i++) {
			matrizTabla[0][i] = titulos[i];
		}
		
		table = new JTable(new DefaultTableModel(matrizTabla,
				new String[] {"A\u00f1o", "Poblacion J", "Poblacion a", "Poblacion T", "Pjn/Pan", "Tn/Tn-1"})
		);
		
		panel.add(table);
		
		
	}
	
	public static double[][] multiply() {
	    double[][] c = new double[2][1];
	    
	    for (int i = 0; i < 2; i++) {
	        for (int j = 0; j < 1; j++) {
	            for (int k = 0; k < 2; k++) {
	                // aquí se multiplica la matriz
	                c[i][j] += matrizCons[i][k] * matrizFin[k][j];
	            }
	        }
	    }
	    return c;
	}
	
	public static void matrizFin(int pj, int pa){
		matrizFin = new double[2][1];
		matrizFin[0][0] = pj;
		matrizFin[1][0] = pa;
		
		
	}
	
	public static void matrizConstante(double k, double a, double b){
		matrizCons = new double[2][2];
		matrizCons[0][0] = 0;
		matrizCons[0][1] = k;
		matrizCons[1][0] = a;
		matrizCons[1][1] = b;
	}
	
	public static String matrizFinString() {
		return (int)matrizFin[0][0] + ", " + (int)matrizFin[1][0];
	}
	
	public static void iteraciones() {
		for(int i = 0; i <= 20; i++) {
			matrizTabla[i+1][1] = (int)matrizFin[0][0]; 
			matrizTabla[i+1][2] = (int)matrizFin[1][0];
			matrizTabla[i+1][3] = (int)matrizFin[0][0] + (int)matrizFin[1][0];
			double pj = (int)matrizFin[0][0];
			double pa = (int)matrizFin[1][0];
			matrizTabla[i+1][4] = pj / pa;
			
/*			double tn = (int)matrizTabla[i+1][3];
			
			if(i < 1) {
				double tn1 = (int)matrizTabla[i][3];
				matrizTabla[i+1][5] = tn / tn1;
			}
			matrizTabla[1][5] = null;
*/			
			
			matrizFin = multiply();
			System.out.println(matrizFinString());
			
		}
	}
}