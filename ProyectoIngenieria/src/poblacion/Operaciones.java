package poblacion;

import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Operaciones {
	private static JPanel panel;	
	static JTable table;
	static String[] titulos = {"A\u00f1o", "P J", "P A", "P T", "PJn/PAn", "Tn/Tn-1"};
	public static double[][]matrizFin;
	static double[][]matrizCons;
	
	static Object[][]matrizTabla = new Object[22][6];
	static double[] totals = new double[22];
	
	static int cont = 1;
	
	public static String Nombre;
	
	Operaciones() {

	}
	
	public static void addTab() throws IOException {
		panel = new JPanel();
		VentanaPoblacion.panelTab.addTab("Resultados " + Nombre, panel);
		VentanaPoblacion.panelTab.setMnemonicAt(Variables.contOperaciones, KeyEvent.VK_2);
		
		for(int i = 0; i < matrizTabla.length - 1; i++) {
			matrizTabla[i+1][0] = i;
		}
		
		for(int i = 0; i < matrizTabla[0].length; i++) {
			matrizTabla[0][i] = titulos[i];
		}
		
		for (int i = 1; i <= 20; i++) {
			matrizTabla[i+1][5] = totals[i+1] / totals[i];
		}
		
		matrizTabla[1][5] = null;
		table = new JTable(new DefaultTableModel(matrizTabla,
				new String[] {"A\u00f1o", "Poblacion J", "Poblacion a", "Poblacion T", "Pjn/Pan", "Tn/Tn-1"})
		);
		
		panel.add(table);
		
		write();
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
	
	public static void iteraciones() {
		for(int i = 0; i <= 20; i++) {
			//Poblacion J
			matrizTabla[i+1][1] = (int)matrizFin[0][0]; 
			
			//Poblacion A
			matrizTabla[i+1][2] = (int)matrizFin[1][0];
			
			//Poblacion T
			matrizTabla[i+1][3] = (int)matrizFin[0][0] + (int)matrizFin[1][0];
			totals[i+1] = (int)matrizFin[0][0] + (int)matrizFin[1][0];
			
			//Poblacionj/poblaciona
			double pj = (int)matrizFin[0][0];
			double pa = (int)matrizFin[1][0];
			matrizTabla[i+1][4] = pj / pa;
			
			matrizFin = multiply();
		}
	}
	
	public static void write() throws IOException {
		
		PrintWriter writer = new PrintWriter("Resultados_" + Nombre + ".txt");
		StringBuilder sb;
		cont++;
		writer.print(Nombre);
		writer.println();
		writer.println();
		for(int i = 0; i < matrizTabla.length; i++) {
			for(int j = 0; j < matrizTabla[0].length; j++) {
				sb = new StringBuilder(String.valueOf(matrizTabla[i][j]));
				
				if(i != 0) {
					sb.setLength(4);
				}
				writer.print(sb.toString());
				writer.print("\t | \t");
			}
			writer.println();
			writer.println("__________________________________________________________________________________________");
		}
		writer.close();
		
	}
}