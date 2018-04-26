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
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width =  (int) ((screenSize.getWidth())/3);
	public static int height =  (int) ((screenSize.getHeight())/2);
	
	public static int contLineas;
	public static int contOperaciones = 1;
}
                                                                                                                                                                                                                                                                                                                                           