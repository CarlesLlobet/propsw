package gui.gestioexode;

import gui.JPanelBg;
import gui.Principal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class GestioExode extends JPanelBg{
	private JComboBox<String> accio;
	private JComboBox<String> pickexode;
	private JButton button;
	private JButton eliminar;
	
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel = new JPanel(); 
	
	private ModificarExode cme = new ModificarExode();
	private ConsultaExode conse = new ConsultaExode();

	public GestioExode() {
		setImage("/images/bg.jpg");
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		accio = new JComboBox<String>();
		horizontalBox.add(accio);
		accio.setMaximumSize(new Dimension(150, 20));
		accio.setMinimumSize(new Dimension(150, 20));

		panel.setBackground(new Color(0,0,0,0));
        panel.setLayout(card);
		panel.add(cme,"creamod");
		panel.add(conse,"consex");
		card.show(panel,"creamod");
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		//preparem el contingut del primer combobox
		accio.addItem("Crear éxodo");
		accio.addItem("Modificar éxodo");
		accio.addItem("Consultar éxodo");
		accio.addItem("Eliminar éxodo");
		
		//preparamos el comportamiento segun la selección
		
		accio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
	                int val = accio.getSelectedIndex();
	                switch(val){
	                	case 0: //crear
	                		cme.reset();
	                		panel.setVisible(true);
	                		pickexode.setVisible(false);
	                		card.show(panel,"creamod");
	                		eliminar.setVisible(false);
	                		break;
	                	case 1: // modificar
	                		int val2 = pickexode.getSelectedIndex();
	                		pickexode.setVisible(true);
	                		panel.setVisible(true);
	                		if(val2 > 0){
	                			//s es un id valid
	                			String s = pickexode.getSelectedItem().toString();
	                			cme.actualitza(s);
	                		}
	                		else cme.reset();
	                		card.show(panel,"creamod");	            
	                		eliminar.setVisible(false);
	                		break;
	                	case 2: //consultar
	                		panel.setVisible(true);
	                		pickexode.setVisible(true);
	                		int val3 = pickexode.getSelectedIndex();
	                		if(val3 > 0){
	                			//s es un id valid
	                			String s = pickexode.getSelectedItem().toString();
	                			conse.actualitza(s);
	                		}
	                		else conse.reset();
	                		card.show(panel,"consex");
	                		eliminar.setVisible(false);
	                		break;
	                	case 3: //eliminar
	                		eliminar.setVisible(true);
	                		panel.setVisible(false);
	                		pickexode.setVisible(true);
	                		pickexode.setSelectedIndex(0);
	                		break;
	                }
	                revalidate();
                }
            }
		});
		
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
			
			Component horizontalGlue_5 = Box.createHorizontalGlue();
			horizontalBox_3.add(horizontalGlue_5);
		
			
			pickexode = new JComboBox<String>();
			horizontalBox_3.add(pickexode);
			pickexode.setMinimumSize(new Dimension(120, 20));
			pickexode.setMaximumSize(new Dimension(120, 20));
			
			Component horizontalGlue_6 = Box.createHorizontalGlue();
			horizontalBox_3.add(horizontalGlue_6);
			pickexode.setVisible(false);
		
		pickexode.addItem("Escoge éxodo");
		pickexode.addItem("Exodo 1");
		pickexode.addItem("Exodo 2");
		pickexode.addItem("Exodo 3");
		pickexode.addItem("Exodo 4");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(verticalBox_1);
		
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		horizontalBox_2.add(panel);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);
		
		eliminar = new JButton("Eliminar");
		eliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(eliminar);
		
		
		eliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (accio.getSelectedIndex() == 0) {
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione una opción válida");
        		}
        		else if (pickexode.getSelectedIndex() == 0 && pickexode.isVisible()) {
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione una éxodo");
        		}
        		else {
        			System.out.println("do something");
        		}
        	}	
        });
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(0.5f);
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(20, 40));
		horizontalStrut_1.setMinimumSize(new Dimension(20, 40));
		horizontalStrut_1.setMaximumSize(new Dimension(20, 40));
		horizontalBox_1.add(horizontalStrut_1);
		
		button = new JButton("Atr\u00E1s");
		button.setAlignmentX(0.5f);
		horizontalBox_1.add(button);
		 button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		deleteView();
	        		Principal.loadMenuCapita();
	        	}
	        });
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
	}
	
	public void config(){
		//Aquesta funcio ens serveix per a establir a quin objecte s'ha de fer focus al carregar la vista
		accio.requestFocusInWindow();
		//Aprofitem per associar la tecla intro amb un boto
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
	}
}
