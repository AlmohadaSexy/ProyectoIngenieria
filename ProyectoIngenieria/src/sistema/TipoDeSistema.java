package sistema;

public class TipoDeSistema { // Esta clase muestra el tipo de sistema que se ha introducido.
	private boolean sistema = true; // Leyenda: true - puede resolverse, false - no puede resolverse. Cambia segun los valores introducidos.
	
	public String getTipoSistema(double m1, double m2, double m3, double m4, double m5, double m6, double m7, double m8, double m9, double b1, 
			double b2, double b3) {
		
		// Calculamos el rango de la matriz de coeficientes
		int n = 3; // Num de incognitas
		int rga = 1; // Asumimos que siempre habra algun valor distinto de 0
		double deta1 = (m5 * m1) - (m4 * m2);
		double deta2 = ((m9*m5*m1)+(m4*m8*m3)+(m2*m6*m7))-((m7*m5*m3)+(m4*m2*m9)+(m8*m6*m1));
		
		
		if(m1==0 && m4==0 && m7==0) {
			n -= 1;
		} if(m2==0 && m5==0 && m8==0) {
			n-=1;
		} if(m3==0 && m6==0 && m9==0) {
			n -= 1;
		}
		
		
		
		if(deta1!=0 ) {
			rga = 2;
			if(deta2 != 0) {
				rga = 3;
			}
		}
		
		// Calculamos el rango de la matriz ampliada
		
		int rgamp = 1;
		double detamp1 = (m5 * m1) - (m4 * m2), detamp2 = (b3*m6) - (m9*b2), detamp5 = (b2*m2)-(m5*b1);
		double detamp3 = ((m9*m5*m1)+(m4*m8*m3)+(m2*m6*m7))-((m7*m5*m3)+(m4*m2*m9)+(m8*m6*m1));
		double detamp4 = ((b3*m6*m2)+(m5*m9*b1)+(m3*b2*m8))-((m8*m6*b1)+(m5*m3*b3)+(m9*b2*m2));
		
		if(detamp1 != 0 || detamp2 != 0 || detamp5 != 0) {
			rgamp = 2;
			if(detamp3 != 0 && detamp4 != 0) {
				rgamp = 3;
			}
		}
		
		
		// Comparacion de rangos entre matriz de coeficientes y ampliada para ver de que tipo se trata

		System.out.println("Rango matriz coeficientes:"+rga+"\nRango matriz ampliada: "+rgamp); // Se imprimen los rangos como comprobacion
		if (rga == rgamp) {
			if(rga == n) {
				return "Se trata de un Sistema Compatible Determinado.";
			} else {
				sistema = false;
				return "Se trata de un Sistema Compatible Indeterminado.";
			}			
		} else {
			sistema = false;
			return "Se trata de un Sistema Incompatible. No tiene soluciones.";
		}
		
	}
	
	public boolean sistemaCout() {
		return this.sistema;
	}
}
