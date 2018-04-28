package poblacion;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	static String[][] arrArchivo;
	
	Operaciones() {

	}
	
	/**
	 * Este metodo es el que se llama desde la clase mainPoblacion.</br>
	 * Su cometido es añadir una tab al frame, rellenar alguna que otra columna de la matriz de la tabla que añade.</br>
	 * Tambien crea la tabla con todos los datos dentro, ya que despues de crearla no se pueden cambiar los datos de dentros.</br></br>
	 * 
	 * Desde aqui se llama a <code>read()</code>, <code>reorder()</code> y <code>write()</code>. Aunque solo llama a los dos primeros si existe el Archivo <code>Resultados.txt</code>
	 * 
	 * 
	 * @author IgnacioT
	 */
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
		
		for(int i = 0; i < matrizTabla.length; i++) {
			for(int j = 0; j < matrizTabla[0].length; j++) {
				StringBuilder sb = new StringBuilder(String.valueOf(matrizTabla[i][j]));
				if(i != 0) {
					sb.setLength(4);
				}
				matrizTabla[i][j] = sb;
			}
		}
		matrizTabla[1][5] = null;
		
		table = new JTable(new DefaultTableModel(matrizTabla,
				new String[] {"A\u00f1o", "Poblacion J", "Poblacion a", "Poblacion T", "Pjn/Pan", "Tn/Tn-1"})
		);
		
		//table.setPreferredSize(new Dimension(VentanaPoblacion.panelTab.getHeight(), VentanaPoblacion.panelTab.getWidth()));
		//table.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
		
		panel.add(table, BorderLayout.CENTER);
		
		File file = new File("Resultados.txt");
		if(file.exists()) {
			read();
			reorder();
		}else {
			arrArchivo = new String[1][2];
			arrArchivo[0][0] = Nombre;
			arrArchivo[0][1] = String.valueOf(matrizTabla[21][3]);
		}
		write();
	}
	
	/**
	 * A este metodo se le llama cada vez que quieres hacer una iteracion: saca una matriz 2x1 dadas las matrices 2x2 y 2x1
	 * @author IgnacioT
	 */

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
	
	/**
	 * Este metodo crea la matriz de la derecha 2x1</br>
	 * 
	 * Es llamada desde mainPoblacion y rellena una matriz estática
	 * 
	 * @param pj Poblacion Joven
	 * @param pa Poblacion Adulta
	 * @author IgnacioT
	 */
	public static void matrizFin(int pj, int pa){
		matrizFin = new double[2][1];
		matrizFin[0][0] = pj;
		matrizFin[1][0] = pa;
		
		
	}
	
	/**
	 * Este metodo crea la matriz constante de la izquierda 2x2.</br>
	 * 
	 * Es llamada desde mainPoblacion y rellena una matriz estática
	 * 
	 * @param k Valor de k
	 * @param a Valor de alpha
	 * @param b Valor de beta
	 * @author IgnacioT
	 */
	public static void matrizConstante(double k, double a, double b){
		matrizCons = new double[2][2];
		matrizCons[0][0] = 0;
		matrizCons[0][1] = k;
		matrizCons[1][0] = a;
		matrizCons[1][1] = b;
	}
	
	/**
	 * Este metodo rellena la matriz tabla mientras se van haciendo las iteraciones por lo que matamos dos pajaros de un tiro.</br>
	 * 
	 * Tambien multiplica la matriz final con el metodo multiply()
	 * @author IgnacioT
	 */
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
	
	/**
	 * read() solo es llamado si existe archivo para leer</br>
	 * 
	 * Lee los datos de Resultados.txt y los añade al arrArchivo para reordenarlos con reorder()</br>
	 * 
	 * Utiliza elementos difereciadores tales como '|', ',' y ':' para poder leer lo que hay entre medias
	 * 
	 * @author IgnacioT
	 */
	
	public static int aux1, aux2, aux3;
	@SuppressWarnings("resource")
	private static void read() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("Resultados.txt"));
		int numLineas = 0;
		while(in.readLine() != null) {
			numLineas++;
		}
		
		
		String dato = null;
		arrArchivo = new String[numLineas+1][2];
		BufferedReader archivo = new BufferedReader(new FileReader("Resultados.txt"));
		for(int i = 0; i < numLineas; i++) {
			dato = archivo.readLine();
			int datoLong = dato.length();
			
			
			//Marcamos los auxiliares para poder separar el string
			for(int k = 0; k < datoLong; k++) {
				if(dato.charAt(k)=='|') {
					aux1 = k + 2;
				}
				if(dato.charAt(k)==',') {
					aux2 = k;
				}
				if(dato.charAt(k)==':') {
					aux3 = k + 2;
				}
			}
			
			for(int j = 0; j < 2; j++) {
				if(j == 0) {
					String nombre = "";
					for(int k = aux1; k < aux2; k++) {
						 nombre += dato.charAt(k);
					}
					arrArchivo[i][j] = nombre;
				}
				if(j == 1) {
					String poblacion = "";
					for(int k = aux3; k < datoLong; k++) {
						 poblacion += dato.charAt(k);
					}
					arrArchivo[i][j] = poblacion;
				}
			}
		}
		arrArchivo[numLineas][0] = Nombre;
		arrArchivo[numLineas][1] = String.valueOf(matrizTabla[21][3]);
	}
	
	/**
	 * Este metodo tiene un for que se repite tantas veces como lineas tenga el array arrArchivo.</br>
	 * 
	 * Reemplaza la linea siguiente con la anterior si la siguiente es mayor a la anterior
	 * 
	 * @author IgnacioT
	 */
	private static void reorder() {
		String aux1, aux2;
		int izq, der;
		for(int k = 0; k < arrArchivo.length; k++) {
			for(int i = 0; i < arrArchivo.length - 1; i++){
				try {
					izq = Integer.parseInt(arrArchivo[i][1]);
					der = Integer.parseInt(arrArchivo[i + 1][1]);
				}catch(NumberFormatException e){
					String s = arrArchivo[i + 1][1];
					s.replaceAll("\\s+","");
					double aux3 = Double.parseDouble(s);
					der = (int) aux3;
				
					String t = arrArchivo[i][1];
					t.replaceAll("\\s+","");
					double aux4 = Double.parseDouble(t);
					izq = (int) aux4;
				}
				if(izq < der){
					aux1 = arrArchivo[i][0];
					arrArchivo[i][0] = arrArchivo[i + 1][0];
					arrArchivo[i + 1][0] = aux1;					
					
					aux2 = arrArchivo[i][1];	
					arrArchivo[i][1] = arrArchivo[i + 1][1];
					arrArchivo[i + 1][1] = aux2;
				}
			}
		}
	}
	
	/**
	 * Escribe todo el arrArchivo en el archivo Resultados.txt con el formato para poder leerlo otra vez
	 * 
	 * @author IgnacioT
	 */
	private static void write() throws IOException {
		int rank = 1;
		PrintWriter writer = new PrintWriter("Resultados.txt");
		
		for(int i = 0; i < arrArchivo.length; i++) {
			writer.print(rank + " | " + arrArchivo[i][0] + ", Poblacion: " + arrArchivo[i][1]);
			writer.println();
			rank++;
		}
		
		writer.close();
		
	}
	
}