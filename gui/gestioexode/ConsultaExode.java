package gui.gestioexode;

import gui.JPanelBg;
import gui.Principal;
import gui.graf.GrafStarWarsPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import propsw.Rebel;


public class ConsultaExode extends JPanel{
	
	private String idExode;
	private JComboBox<String> rebelsCombo;
	
	public void actualitza(String idExode){
		this.idExode = idExode;
		rebelsCombo.removeAllItems();
		rebelsCombo.addItem("Escoge rebelde");
		ArrayList<Integer> rebels = new ArrayList<Integer>(Principal.getEc().getRebelsExode(idExode).values());
		int i = 1;
		for(Integer r : rebels){
			System.out.println("Rebelde " + r);
			rebelsCombo.addItem(r);
			++i;
		}
	}
	
	
	public void reset(){
		
	}
	
	
	public ConsultaExode(){
		
		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		GrafStarWarsPanel graphComponent = new GrafStarWarsPanel();
		graphComponent.setMaximumSize(new Dimension(600, 350));
		graphComponent.setMinimumSize(new Dimension(400, 250));
		verticalBox.add(graphComponent);
		
		JLabel labelInfo = new JLabel("Los cuellos de botella se indican con aristas en rojo");
		labelInfo.setForeground(Color.RED);
		verticalBox.add(labelInfo);
		
		Box horizontalBox0 = Box.createHorizontalBox();
		horizontalBox0.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox0);
		
		JTextField textoFlow = new JTextField("Flow: ");
		textoFlow.setMinimumSize(new Dimension(50,15));
		horizontalBox0.add(textoFlow);
		
		JTextField textoCoste= new JTextField("Coste: ");
		textoCoste.setMinimumSize(new Dimension(50,15));
		horizontalBox0.add(textoCoste);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JLabel labelRebelCombo = new JLabel("Rebel");
		horizontalBox.add(labelRebelCombo);
		
		rebelsCombo = new JComboBox<String>();
		
		
		
		Box horizontalBox2 = Box.createHorizontalBox();
		horizontalBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox2);
		
		JLabel labelCamiList = new JLabel("Detalle camino");
		horizontalBox2.add(labelCamiList);
		
		JList<String> listaBasesCamino = new JList<String>();
		listaBasesCamino.setMinimumSize(new Dimension(50,100));
		horizontalBox2.add(listaBasesCamino);
		
		
		rebelsCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String idRebel = arg0.getItem().toString();
				System.out.println("idRebel :"+idRebel);
				
				
			}
		});
		
		
		
		
	}

}
