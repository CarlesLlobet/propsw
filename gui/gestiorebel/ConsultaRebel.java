package gui.gestiorebel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;

public class ConsultaRebel extends JPanel{
	
	public ConsultaRebel(){
		setBackground(new Color(0,0,0,0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel.add(verticalBox_1);
		
		JLabel lblNewLabel = new JLabel("Nom Rebel:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u00C9xodo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNewLabel_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut);
		
		JComboBox comboBox = new JComboBox();
		horizontalBox.add(comboBox);
		comboBox.setMaximumSize(new Dimension(32767, 23));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		JLabel lblCaminoAsignado = new JLabel("Camino asignado:");
		lblCaminoAsignado.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(lblCaminoAsignado);
		lblCaminoAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
		String data[] = {"UNO","dos"," tres"};
		JList list = new JList(data);
		verticalBox_1.add(list);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		String data[] = {"UNO", "DOS", "TRES", "CUATRO ", "CINCO"};
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
	}
	
	public void refresh(String idReb){
		
	}
}
