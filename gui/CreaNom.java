package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreaNom extends JPanel{
	private JTextField textField;
	
	public CreaNom() {
		setMaximumSize(new Dimension(32767, 20));
				//Fondo transparente para el panel
				setBackground(new Color(0,0,0,0));
				System.out.println("A PINTAAAR IMPORT GALAXIA");
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				
				Box horizontalBox = Box.createHorizontalBox();
				add(horizontalBox);
				
				Component horizontalGlue = Box.createHorizontalGlue();
				horizontalBox.add(horizontalGlue);
				
				JLabel lblNom = new JLabel("Nom:");
				lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
				horizontalBox.add(lblNom);
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(20);
				horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
				horizontalBox.add(horizontalStrut_1);
				
				textField = new JTextField();
				textField.setMaximumSize(new Dimension(150, 20));
				horizontalBox.add(textField);
				textField.setColumns(10);
				
				Component horizontalGlue_1 = Box.createHorizontalGlue();
				horizontalBox.add(horizontalGlue_1);
	}
	
	//Devuelve el nombre introducido por el usuario
	public String getNom(){
			return textField.getText();
	}
	
	//Restaura el valor del campo
	public void reset(){
			textField.setText("");
	}
}