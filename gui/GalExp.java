package gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class GalExp extends JPanel{
	public GalExp() {
		setBackground(Color.ORANGE);
		
		JLabel label = new JLabel("New label");
		label.setText(String.valueOf(Principal.getCont()));
		System.out.println("A PINTAAAR EXPORTAR GALAXIA");
		add(label);
	}

}
