package gui.gestiorebel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.BorderLayout;

public class ModificaRebel extends JPanel{
	public ModificaRebel(){
		setBackground(Color.GRAY);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		Panel panel = new Panel();
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(verticalBox_1);
		
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
		horizontalBox.add(horizontalStrut);
		
		JLabel lblNomrebel = new JLabel("NOM_REBEL");
		lblNomrebel.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox.add(lblNomrebel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);
		
		JButton btnCambiar = new JButton("Cambiar");
		horizontalBox.add(btnCambiar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_1);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);
		
		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_2);
		
		JLabel lblCaminoAsignado = new JLabel("Camino Asignado");
		lblCaminoAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
		verticalBox_2.add(lblCaminoAsignado);
		lblCaminoAsignado.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JList list = new JList();
		verticalBox_2.add(list);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_2);
		
		JLabel lblAadirBase = new JLabel("A\u00F1adir base:");
		lblAadirBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		horizontalBox_1.add(lblAadirBase);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumSize(new Dimension(32767, 23));
		horizontalBox_1.add(comboBox);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_4);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		horizontalBox_1.add(btnNewButton);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
	}
}
