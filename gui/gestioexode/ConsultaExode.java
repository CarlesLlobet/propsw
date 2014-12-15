package gui.gestioexode;


import gui.Principal;
import gui.graf.GrafStarWarsPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class ConsultaExode extends JPanel{
	
	private String idExode;
	private JComboBox<String> rebelsCombo;
	private JTextField textoFlow;
	private JTextField textoCoste;
	private GrafStarWarsPanel graphComponent;
	private JList<String> listaBasesCamino;
	private DefaultListModel<String> listModel;
	
	public void actualitza(String idExode) throws IOException{
		this.idExode = idExode;
		rebelsCombo.removeAllItems();
		rebelsCombo.addItem("Escoge rebelde");
		ArrayList<Integer> rebels = new ArrayList<Integer>(Principal.getEc().getRebelsExode(idExode).values());
		for(Integer r : rebels){
			System.out.println("Rebelde " + r);
			rebelsCombo.addItem(r+"");
		}
		textoFlow.setText("Flow: "+Principal.getEc().getFlowExode(idExode));
		textoCoste.setText("Coste: "+Principal.getEc().getCostExode(idExode));
		graphComponent.setGraf(Principal.getEc().getGrafResidual(idExode));
		graphComponent.paintTheGraf();
		
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
		
		graphComponent = new GrafStarWarsPanel();
		graphComponent.setMaximumSize(new Dimension(600, 350));
		graphComponent.setMinimumSize(new Dimension(400, 250));
		verticalBox.add(graphComponent);
		
		JLabel labelInfo = new JLabel("Los cuellos de botella se indican con aristas en rojo");
		labelInfo.setForeground(Color.RED);
		verticalBox.add(labelInfo);
		
		Box horizontalBox0 = Box.createHorizontalBox();
		horizontalBox0.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox0);
		
		textoFlow = new JTextField("Flow: ");
		textoFlow.setMinimumSize(new Dimension(50,15));
		horizontalBox0.add(textoFlow);
		
		textoCoste= new JTextField("Coste: ");
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
		
		listaBasesCamino = new JList<String>();
		listModel = new DefaultListModel<String>();
		listaBasesCamino.setModel(listModel);
		listaBasesCamino.setMinimumSize(new Dimension(50,100));
		horizontalBox2.add(listaBasesCamino);
		
		
		rebelsCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String idRebel = arg0.getItem().toString();
				System.out.println("idRebel :"+idRebel);
				ArrayList<Integer> basesCami = Principal.getEc().getCaminsExode(idExode).get(idRebel);
				listaBasesCamino.removeAll();
				for (Integer integer : basesCami) {
					listModel.addElement(integer+"");
				}
			}
		});
		
		
		
		
	}

}
