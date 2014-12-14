package gui.gestiorebel;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ConsultaRebel extends JPanel{
	
	
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JList list;
	private String data[] = {"NO", "HAY", "INFO", "TODAVIA"};

	
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
		
		lblNewLabel = new JLabel("Nom Rebel:");
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
		
		comboBox = new JComboBox();
		horizontalBox.add(comboBox);
		comboBox.addItem("Selecciona exodo");
		comboBox.addItem("Exodo 1");
		comboBox.addItem("Exodo 2");
		comboBox.setMaximumSize(new Dimension(32767, 23));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		JLabel lblCaminoAsignado = new JLabel("Camino asignado:");
		lblCaminoAsignado.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(lblCaminoAsignado);
		lblCaminoAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
		list = new JList(data);
		verticalBox_1.add(list);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		Principal.getCc().getCapita().getRebels().keySet();
	}
		
	
	public void refresh(String idReb){
		comboBox.setSelectedIndex(0);
		ArrayList<String> rebels = Principal.getCc().arrayListRebelsOrd();
		System.out.println("REBELS EXISTENTS");
		for (String r : rebels){
			System.out.println("r: " +r + " NOM: " + Principal.getCc().getRebel(r).getNom());
		}
		
		
	}
	
	public void reset(){
		lblNewLabel.setText("Nom Rebel:");
		comboBox.setSelectedIndex(0);
		list = new JList(data);
	}
}
