package gui.gestiorebel;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificaRebel extends JPanel{
	private JTextField textField;
	private JLabel lblNomrebel;
	public ModificaRebel(){
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBackground(new Color(0,0,0,0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,0));
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(verticalBox_1);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.GRAY);
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		JLabel lblNewLabel = new JLabel("Nombre del Rebelde:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut);
		
		lblNomrebel = new JLabel("Nombre");
		lblNomrebel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horizontalBox.add(lblNomrebel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_1);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre");
		lblNuevoNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNuevoNombre);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_2);
		
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(120, 20));
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		add(horizontalGlue_5);		
	}
	
	public void canvia(String s){
		Principal.getCc().getCapita().getRebels().get(s).setNom(textField.getText());
		lblNomrebel.setText(textField.getText());
	}
	
	public void refresh(String idReb){
		try {
			lblNomrebel.setText(Principal.getCc().getCapita().getRebels().get(idReb).getNom());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset(){
		lblNomrebel.setText("");
		textField.setText("");
	}
}
