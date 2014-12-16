package gui;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	/**
	 * Create the frame.
	 */
	public Ventana(){
		getContentPane().setMinimumSize(new Dimension(600, 600));
		//Creamos una ventana según el tamaño de la pantalla y la centramos
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		//setResizable(false);
		
		double h = size.getHeight()/1.3;
		double w = size.getWidth()/1.3;
		setSize((int)w,(int)h);
		setLocationRelativeTo(null);
		setTitle("JarJarBeans");
		
		URL iconURL = getClass().getResource("/images/vader.png");
		ImageIcon icon = new ImageIcon(iconURL);
		this.setIconImage(icon.getImage());
	}
}
