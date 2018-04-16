package poblacion;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Operaciones {
	public static JPanel panel;
	
	public static double[][]matrizFin;
	static double[][]matrizCons;
	//public static double[][]matrizIni;
	
	Operaciones() {

	}
	
	public static void addTab() {
		panel = new JPanel();
		VentanaPoblacion.panelTab.addTab("Operaciones " + Variables.contOperaciones, panel);
		VentanaPoblacion.panelTab.setMnemonicAt(Variables.contOperaciones, KeyEvent.VK_1);
	}
	
	public static double[][] multiply(/*double[][] matrizCons, double[][] matrizIni*/) {
	    double[][] c = new double[2][1];
	    
	    // se comprueba si las matrices se pueden multiplicar
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
	
	public static void matrizFin(double pj, double pa){
		Operaciones.matrizFin = new double [2][1];
		Operaciones.matrizFin[0][0] = pj;
		Operaciones.matrizFin[1][0] = pa;
		
	}
	
	public static void matrizConstante(double k, double a, double b){
		matrizCons = new double[2][2];
		matrizCons[0][0] = 0;
		matrizCons[0][1] = k;
		matrizCons[1][0] = a;
		matrizCons[1][1] = b;
		
	}
	
	public static String matrizConstanteString() {
		return matrizCons[0][0] + ", " + matrizCons[0][1] + ", " + matrizCons[1][0] + ", " + matrizCons[1][1];
	}
/*	public static void matrizFin(){
		matrizFin = multiply(matrizCons, matrizIni);
	}
*/	
	public static String matrizFinString() {
		return matrizFin[0][0] + ", " + matrizFin[1][0];
	}
	
	public static void iteraciones() {
//		matrizFin();
//		System.out.println(matrizFinString());
		for(int i = 0; i < 50; i++) {
			Operaciones.matrizFin = multiply();
			System.out.println(matrizFinString());
		}
	}
}