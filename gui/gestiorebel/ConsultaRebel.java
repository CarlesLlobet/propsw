package gui.gestiorebel;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConsultaRebel extends JPanel{
	
	
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JList<String> list;
	private DefaultListModel<String> m;
	private String rebel;
	
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
		
		lblNewLabel = new JLabel("Nombre Rebel:");
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
		
		comboBox = new JComboBox<String>();
		horizontalBox.add(comboBox);
		comboBox.addItem("Selecciona éxodo");
		comboBox.setMaximumSize(new Dimension(32767, 23));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		JLabel lblCaminoAsignado = new JLabel("Camino asignado:");
		lblCaminoAsignado.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(lblCaminoAsignado);
		lblCaminoAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
		list = new JList<String>();
		list.setVisible(true);
		m = new DefaultListModel<String>();
		list.setModel(m);
		list.setMinimumSize(new Dimension(50,100));
		verticalBox_1.add(list);
		
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		Principal.getCc().getCapita().getRebels().keySet();

		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED){
					int val = comboBox.getSelectedIndex();
					if (val > 0){
						if (rebel!= null){
							ArrayList<Integer> c = Principal.getEc().getCaminsExode(comboBox.getSelectedItem().toString()).get(rebel);
								if(c!= null){
								for(Integer i : c){
									System.out.println("Elemento i: " + i.toString());
									String s = i.toString();
									m.addElement(s);
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(Principal.getWindow(), "Seleccione un rebelde");
						}
					}
				}
			}
		});
	}
		
	
	public void refresh(String idReb){
		System.out.println("REFRESH");
		rebel = idReb;
		comboBox.removeAllItems();
		comboBox.addItem("Selecciona éxodo");
		comboBox.setSelectedIndex(0);
		try {
			lblNewLabel.setText("Nom Rebel: " + Principal.getCc().getCapita().getRebels().get(idReb).getNom());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> exodes= Principal.getCc().arrayListExodesOrdReb(idReb);
		for (String s : exodes){
			comboBox.addItem(s);
		}	
		m.removeAllElements();
	}
	
	public void reset(){
		System.out.println("RESET");
		rebel = null;
		lblNewLabel.setText("Nom Rebel:");
		comboBox.setSelectedIndex(0); 
		m.removeAllElements();
		
	}
}
