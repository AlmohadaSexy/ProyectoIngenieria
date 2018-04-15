package poblacion;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Variables {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static double width = (screenSize.getWidth())/2;
	public static double height = (screenSize.getHeight())/2;
}
