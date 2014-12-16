package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Scrollable;

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
	}
}
