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
		//Agafem les dimensions de la pantalla, i creem una finestra de la meitat de mida i la centrem
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		double h = size.getHeight()/2;
		double w = size.getWidth()/2;
		int a = (int)w - (int)w/2;
		int b = (int)h - (int)h/2;
		setBounds(a, b, (int)w, (int)h);
	}
}
