package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class GalImp extends JPanel{
	public GalImp() {
		setBackground(Color.BLUE);
		JLabel label = new JLabel("New label");
		label.setText(String.valueOf(Principal.getCont()));
		System.out.println("A PINTAAAR IMPORT GALAXIA");
		add(label);
	}

}
