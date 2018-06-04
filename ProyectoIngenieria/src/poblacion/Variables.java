package poblacion;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * 
 * Aqui se encuentran todas las variables que se usan en todo el programa.
 * 
 * @author IgnacioT
 *
 */
public class Variables {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int width =  (int) ((screenSize.getWidth())*2/5);
	public int height =  (int) ((screenSize.getHeight())/2);
	
	public int contLineas;
}
                                                                                                                                                                                                                                                                                                                                           