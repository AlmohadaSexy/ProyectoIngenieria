package conicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabGraficador extends JPanel{


	private double valA, valH, valB, valC, valA2, valH2, valB2, valC2;
	public TabGraficador(double valA, double valH, double valB, double valC, double valA2,
			double valH2, double valB2, double valC2) {
		
		//Inicializamos las variables
		this.valA = valA;
		this.valH = valH;
		this.valB = valB;
		this.valC = valC;
		this.valA2 = valA2;
		this.valH2 = valH2;
		this.valB2 = valB2;
		this.valC2 = valC2;
		
		init();
	}

	public void init() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	//Dibujamos el eje de coordenadas
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		
		//Las coordenadas comienzan desde la esquina superior izquierda
		g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
		g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
		
		
		paintSQRFunc(g, -this.getWidth() / 2, this.getWidth() / 2, -this.getHeight() / 2,
				this.getHeight() / 2);

				
	}

	//Operación que diferencia el tipo de ecuación
	public double tipoConica(double valorA, double valorH, double valorB, double valorC) {
		
		double tipoConica = valorH*valorH - 4*valorA*valorB;		
		return tipoConica;
	}
	
	//f(xy) = valA*X^2 + valH*XY + valB*Y^2 + valC = 0 

	/*Este es el graficador, que funciona creando cuatro puntos. Los
	 * 
	 * dos primeros serán el mismo, pero uno positivo y otro negativo
	 * 
	 * y los dos siguientes serán la continuación de los anteriores
	 * 
	 * */
	
	public void paintSQRFunc(Graphics g, double x1, double x2, double y1, double y2) {
		
		//Elipse, circulo o punto/recta
		if(tipoConica(valA, valH, valB, valC) < 0) {

			for(double i = x1; i < x2; i++) {
				g.setColor(Color.red);
					
				double py = (-valH*i + Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double ny = (-valH*i - Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double xp = i + 1;
				double py2 = (-valH*xp + Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));
				double ny2 = (-valH*xp - Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));
				
				//Evita que se creen bucles innecesarios
				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}
		
		//Elipse, circulo o punto/recta
		if(tipoConica(valA2, valH2, valB2, valC2) < 0) {
	
			for(double i = x1; i < x2; i++) {
				g.setColor(Color.yellow);
				
				double py = (-valH2*i + Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double ny = (-valH2*i - Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double xp = i + 1;
				double py2 = (-valH2*xp + Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));
				double ny2 = (-valH2*xp - Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));
				
				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}

		//Parábola, 2 lineas paralelas, 1/ninguna linea
		if(tipoConica(valA, valH, valB, valC) == 0) {
							
			for(double i = x1; i < x2; i++) {
				g.setColor(Color.green);
					
				double py = (-valH*i + Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double ny = (-valH*i - Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double xp = i + 1;
				double py2 = (-valH*xp + Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));
				double ny2 = (-valH*xp - Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));

				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}
		//Parábola, 2 lineas paralelas, 1/ninguna linea
		if(tipoConica(valA2, valH2, valB2, valC2) == 0) {
		
			for(double i = x1; i < x2; i++) {
				g.setColor(Color.orange);
				
				double py = (-valH2*i + Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double ny = (-valH2*i - Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double xp = i + 1;
				double py2 = (-valH2*xp + Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));
				double ny2 = (-valH2*xp - Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));

				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}

		//Hipérbola o 2 lineas intersectadas
		if(tipoConica(valA, valH, valB, valC) > 0) {

			for(double i = x1; i < x2; i++) {
				g.setColor(Color.blue);
					
				double py = (-valH*i + Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double ny = (-valH*i - Math.sqrt(((valH*i)*(valH*i)) - 4*valB*(valA*i*i + valC)));
				double xp = i + 1;
				double py2 = (-valH*xp + Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));
				double ny2 = (-valH*xp - Math.sqrt(((valH*xp)*(valH*xp)) - 4*valB*(valA*xp*xp + valC)));

				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}
		
		//Hipérbola o 2 lineas intersectadas
		if(tipoConica(valA2, valH2, valB2, valC2) > 0) {

			for(double i = x1; i < x2; i++) {
				g.setColor(Color.magenta);
				
				double py = (-valH2*i + Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double ny = (-valH2*i - Math.sqrt(((valH2*i)*(valH2*i)) - 4*valB2*(valA2*i*i + valC2)));
				double xp = i + 1;
				double py2 = (-valH2*xp + Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));
				double ny2 = (-valH2*xp - Math.sqrt(((valH2*xp)*(valH2*xp)) - 4*valB2*(valA2*xp*xp + valC2)));

				if(!Double.isNaN(i) && !Double.isNaN(xp) && !Double.isNaN(py) && !Double.isNaN(ny) && !Double.isNaN(py2) && !Double.isNaN(ny2)){
					g.drawLine((int) coord_x(i), (int) coord_y(py), (int) coord_x(xp), (int) coord_y(py2));
					g.drawLine((int) coord_x(i), (int) coord_y(ny), (int) coord_x(xp), (int) coord_y(ny2));
				
				}
			}
		}	
	}
	
	//Hay que sumarle la mitad del ancho mas el numero para que coincida
	private double coord_x(double x){
		
        double real_x = x+this.getWidth()/2;
        return real_x;
    }
    private double coord_y(double y){
    	
        double real_y = -y+this.getHeight()/2;
        return (real_y);
    }
}

