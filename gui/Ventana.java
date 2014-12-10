package gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class Ventana extends JFrame {

	/**
	 * Create the frame.
	 */
	public Ventana(){
		//setMinimumSize(new Dimension(600, 600));
		getContentPane().setMinimumSize(new Dimension(600, 600));
		//Agafem les dimensions de la pantalla, i creem una finestra de la meitat de mida i la centrem
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		double h = size.getHeight()/1.3;
		double w = size.getWidth()/1.3;
		setSize((int)w,(int)h);
		setLocationRelativeTo(null);
	}
}
