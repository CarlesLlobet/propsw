package gui;
import gui.gestiorebel.ConsultaRebel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SessioRebel extends JPanelBg {
	public SessioRebel(String idcap, String idreb) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setImage("/images/bg.jpg");
        
        Box verticalBox = Box.createVerticalBox();
        add(verticalBox);
        
        Box horizontalBox = Box.createHorizontalBox();
        verticalBox.add(horizontalBox);
        
        JButton atras = new JButton("Atr\u00E1s");
        atras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadLogin();
        	}
        });
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalStrut.setPreferredSize(new Dimension(20, 40));
        horizontalStrut.setMinimumSize(new Dimension(20, 40));
        horizontalStrut.setMaximumSize(new Dimension(20, 40));
        horizontalBox.add(horizontalStrut);
        horizontalBox.add(atras);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox.add(verticalBox_1);
        
        ConsultaRebel cr = new ConsultaRebel();
        verticalBox_1.add(cr);
        cr.calcula(idcap, idreb);
	}

}
