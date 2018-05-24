package sistema;

/**
 * 
 * @author Jorge Moreno
 *
 */



public class ResolucionSistema {
	
	/**
	 * Con la finalidad de optimizar codigo, esta clase devuelve los pasos que se han seguido para resolver el sistema.
	 * Se usan en la clase VentanaSistema.
	 */
	
	public String toString() {
		return "<p><strong>1</strong>. Para resolver el sistema se ha usado el metodo de Cramer. "
				+ "El <em>primer paso</em> es hallar el determinante de la matriz de coeficientes:</p>\n" + 
				"<table style=\"height: 154px; border-color: black;\" width=\"310\">\n" + 
				"<tbody>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"</tbody>\n" + 
				"</table>\n" + 
				"<p>&nbsp;<strong>Dicho determinante es(DetM): %s</strong></p>\n" + 
				"<p>&nbsp;</p>\n" + 
				"<p><strong>2.</strong>&nbsp;A continuacion, debemos de <em>sustituir la "
				+ "primera columna</em> del sistema por la <em>columna de terminos independientes</em>. Hallamos el "
				+ "determinante de esta matriz y guardamos el resultado:</p>\n" + 
				"<table style=\"height: 154px; border-color: black;\" width=\"310\">\n" + 
				"<tbody>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"</tbody>\n" + 
				"</table>\n" + 
				"<p><strong>Determinante Matriz X(MX) = %s</strong></p>\n" + 
				"<p>&nbsp;</p>\n" + 
				"<p><strong>3.</strong>&nbsp;El tercer paso es similar al paso anterior. Sin embargo, ahora vamos a <em>sustituir "
				+ "la segunda columna</em> del sistema por la <em>columna de terminos independientes</em>. Una vez hecho esto, calculamos "
				+ "el nuevo determinante y lo guardamos:&nbsp;</p>\n" + 
				"<table style=\"height: 154px; border-color: black;\" width=\"310\">\n" + 
				"<tbody>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"</tbody>\n" + 
				"</table>\n" + 
				"<p><strong>Determinante Matriz Y(MY) = %s</strong></p>\n" + 
				"<p><strong>4.</strong> Realizamos el mismo proceso, esta vez <em>sustituyendo la ultima columna del sistema</em> por la"
				+ " <em>columna de terminos independientes</em>:</p>\n" + 
				"<table style=\"height: 154px; border-color: black;\" width=\"310\">\n" + 
				"<tbody>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"<tr>\n" + 
				"<td style=\"width: 95px;\">%s</td>\n" + 
				"<td style=\"width: 96px;\">%s</td>\n" + 
				"<td style=\"width: 97px;\">%s</td>\n" + 
				"</tr>\n" + 
				"</tbody>\n" + 
				"</table>\n" + 
				"<p><strong>Determinante Matriz Z(MZ) = %s</strong></p>\n" + 
				"<p><strong>5.</strong> Finalmente debemos dividir cada uno de los tres determinantes obtenidos con "
				+ "el primero de todos, el de la matriz de coeficientes. Esta division nos dara el "
				+ "resultado de las variables X, Y, Z de nuestro sistema:</p>\n" + 
				"<p>X = MX / DetM ; Y = MY / DetM; Z = MZ / DetM</p>";
	}
	
}
