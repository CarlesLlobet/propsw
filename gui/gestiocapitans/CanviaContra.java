package gui.gestiocapitans;

import gui.Principal;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.Font;

public class CanviaContra extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	public CanviaContra() {
		setBackground(new Color(0,0,0,0));
		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a nueva:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut);
		
		passwordField = new JPasswordField();
		passwordField.setMaximumSize(new Dimension(100, 23));
		horizontalBox.add(passwordField);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Repite la contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox_1.add(lblNewLabel_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setMaximumSize(new Dimension(100, 23));
		horizontalBox_1.add(passwordField_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a vieja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox_2.add(lblNewLabel_2);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setMaximumSize(new Dimension(100, 23));
		horizontalBox_2.add(passwordField_2);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		System.out.println("CAMBIA CONTRA");
	}
	
}