package gui.gestioexode;

import gui.JPanelBg;
import gui.graf.GrafStarWarsPanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;


public class ConsultaExode extends JPanelBg{
	
	public ConsultaExode(){
		setImage("/images/bg.jpg");
		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		//graphComponent = new GrafStarWarsPanel();
		
	}

}
