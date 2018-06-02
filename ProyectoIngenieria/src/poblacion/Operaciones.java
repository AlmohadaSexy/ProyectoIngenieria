package poblacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Operaciones {
	static JTable table;
	String[] titulos = {"A\u00f1o", "P J", "P A", "P T", "PJn/PAn", "Tn/Tn-1"};
	public double[][]matrizFin;
	double[][]matrizCons;
	Object[][]matrizTabla = new Object[22][6];
	double[] totals = new double[22];
	static int cont = 1;
	public String Nombre;
	static String[][] arrArchivo;
	VentanaPoblacion salida;
	private Dimension TableSize;
	public int numLineas = 0;
	Operaciones() {

	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	/**
	 * Este metodo es el que se llama desde la clase mainPoblacion.</br>
	 * 
	 * Crea la tabla con todos los datos dentro, ya que despues de crearla no se pueden cambiar los datos de dentros.</br></br>
	 * 
	 * Desde aqui se llama a <code>read()</code>, <code>reorder()</code> y <code>write()</code>. Aunque solo llama a los dos primeros si existe el Archivo <code>Resultados.txt</code>
	 * 
	 * 
	 * @author IgnacioT
	 */
	public void operations() {
		
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
					sb.setLength(7);
				}
				matrizTabla[i][j] = sb;
			}
		}
		matrizTabla[1][5] = null;
	}
	
	/**
	 * A este metodo se le llama cada vez que quieres hacer una iteracion: saca una matriz 2x1 dadas las matrices 2x2 y 2x1
	 * @author IgnacioT
	 */

	public double[][] multiply() {
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
	public void matrizFin(int pj, int pa){
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
	public void matrizConstante(double k, double a, double b){
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
	public void iteraciones() {
		for(int i = 0; i <= 20; i++) {
			aLaTabla(i);
			matrizFin = multiply();
		}
	}
	
	private void aLaTabla(int i) {
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
	public void read() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("Resultados.txt"));
		numLineas = 0;
		while(in.readLine() != null) {
			numLineas++;
		}
		
		
		String dato = null;
		arrArchivo = new String[numLineas+1][2];
		BufferedReader archivo = new BufferedReader(new FileReader("Resultados.txt"));
		for(int i = 1; i <= numLineas; i++) {
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
						if(dato.charAt(k) == '0' || dato.charAt(k) == '1' || dato.charAt(k) == '2' || dato.charAt(k) == '3' || dato.charAt(k) == '4' || dato.charAt(k) == '5' ||
								dato.charAt(k) == '6' || dato.charAt(k) == '7' || dato.charAt(k) == '8' || dato.charAt(k) == '9') {
							poblacion += dato.charAt(k);
						}
					}
					arrArchivo[i][j] = poblacion;
				}
				
			}
		}
		arrArchivo[0][0] = Nombre;
		arrArchivo[0][1] = String.valueOf(matrizTabla[21][3]);
		
	}
	
	/**
	 * Este metodo tiene un for que se repite tantas veces como lineas tenga el array arrArchivo.</br>
	 * 
	 * Reemplaza la linea siguiente con la anterior si la siguiente es mayor a la anterior
	 * 
	 * @author IgnacioT
	 * @throws IOException 
	 */
	public void reorder() throws IOException {
		String aux1, aux2;
		int izq, der;
		String[][] auxArr = arrArchivo; 
		for(int k = 0; k < auxArr.length; k++) {
			for(int i = 0; i < auxArr.length - 1; i++){
				try {
					izq = Integer.parseInt(auxArr[i][1]);
					der = Integer.parseInt(auxArr[i + 1][1]);
				}catch(NumberFormatException e){
					String s = auxArr[i + 1][1];
					s.replaceAll("\\s+","");
					double aux3 = Double.parseDouble(s);
					der = (int) aux3;
				
					String t = auxArr[i][1];
					t.replaceAll("\\s+","");
					double aux4 = Double.parseDouble(t);
					izq = (int) aux4;
				}
				if(izq < der){
					aux1 = auxArr[i][0];
					auxArr[i][0] = auxArr[i + 1][0];
					auxArr[i + 1][0] = aux1;					
					
					aux2 = auxArr[i][1];	
					auxArr[i][1] = auxArr[i + 1][1];
					auxArr[i + 1][1] = aux2;
				}
			}
		}
		arrArchivo = auxArr;
	}
	
	/**
	 * Escribe todo el arrArchivo en el archivo Resultados.txt con el formato para poder leerlo otra vez
	 * 
	 * @author IgnacioT
	 */
	public void write() throws IOException {
		int rank = 1;
		PrintWriter writer = new PrintWriter("Resultados.txt");
		
		for(int i = 0; i < arrArchivo.length; i++) {
			writer.print(rank + " | " + arrArchivo[i][0] + ", Poblacion: " + arrArchivo[i][1]);
			writer.println();
			rank++;
		}
		writer.close();
	}
	
	public void rellenarMatrices(double A, double k, double B, int PA, int PJ) {
		matrizConstante(k, A, B);
		matrizFin(PJ, PA);
	}
	
	@SuppressWarnings("serial")
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		table = new JTable(new DefaultTableModel(matrizTabla, new String [] {"A\u00f1o", "Poblacion J", "Poblacion a", "Poblacion T", "Pjn/Pan", "Tn/Tn-1"}){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
				    return false;
				}
			});
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		panel.add(table, BorderLayout.CENTER);
		setTableSize(panel.getSize());
		return panel;
	}
	public void setTableSize(Dimension dimension) {
		this.TableSize = dimension;
	}
	public Dimension getTableSize() {
		return TableSize;
	}
}