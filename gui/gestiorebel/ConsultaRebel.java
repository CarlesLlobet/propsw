package gui.gestiorebel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class ConsultaRebel extends JPanel{
	
	public ConsultaRebel(){
		setBackground(Color.CYAN);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
	}
}
