package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class GalDraw extends JPanel{
	public GalDraw() {
		setBackground(Color.PINK);
		JLabel label = new JLabel("New label");
		label.setText(String.valueOf(Principal.getCont()));
		System.out.println("A PINTAAAR GALAXIA DRAW");
		add(label);
	}
	
}
