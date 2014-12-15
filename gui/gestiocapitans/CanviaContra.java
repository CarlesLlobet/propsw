package gui.gestiocapitans;

import gui.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class CanviaContra extends JPanel {
	private JPasswordField newpass1;
	private JPasswordField newpass2;
	private JPasswordField oldpass;
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
		
		newpass1 = new JPasswordField();
		newpass1.setMaximumSize(new Dimension(100, 23));
		horizontalBox.add(newpass1);
		
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
		
		newpass2 = new JPasswordField();
		newpass2.setMaximumSize(new Dimension(100, 23));
		horizontalBox_1.add(newpass2);
		
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
		
		oldpass = new JPasswordField();
		oldpass.setMaximumSize(new Dimension(100, 23));
		horizontalBox_2.add(oldpass);
		
		JButton testButton = new JButton();
		testButton.setText("Test");
		testButton.setMaximumSize(new Dimension(100, 23));
		horizontalBox_2.add(testButton);
		testButton.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("Cambiamos contraseña");
					canviaContra();
			}
		});
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
	}
	
	private void canviaContra(){
		String current = Principal.getCc().getCapita().getPassword();
				
		String s1 = String.valueOf(newpass1.getPassword());
		String s2 = String.valueOf(newpass2.getPassword());
		String old = String.valueOf(oldpass.getPassword());
		
		System.out.println("new: " + s1 + " new: "+ s2 + " old: " + old);		
		System.out.println("current: "+ current);

		if (old.equals(current)){
			if (s1.equals("") || s2.equals("")){
				JOptionPane.showMessageDialog(Principal.getWindow(),"La nueva contraseña no puede ser vacía");
			}else if (s1.equals(s2)) {
				Principal.getCc().canviContra(s1);
				JOptionPane.showMessageDialog(Principal.getWindow(),"Contraseña cambiada.");
				reset();
			}else {
				JOptionPane.showMessageDialog(Principal.getWindow(),"Las contraseñas no coinciden");
			}
		}
		else {
			JOptionPane.showMessageDialog(Principal.getWindow(),"Contraseña incorrecta");
		}
	}
	
	public void config(){
		
	}	
	public void reset(){
		newpass1.setText("");
		newpass2.setText("");
		oldpass.setText("");
	}
}
