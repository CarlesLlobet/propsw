package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class ModificarGalaxia extends JPanel{
	public ModificarGalaxia() {
		setBackground(Color.CYAN);
		JLabel label = new JLabel("New label");
		label.setText(String.valueOf(Principal.getCont()));
		System.out.println("A PINTAAAR MODIFICAR GALAXIA");
		add(label);
	}

}
