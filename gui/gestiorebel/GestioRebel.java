package gui.gestiorebel;

import gui.CreaNom;
import gui.JPanelBg;
import gui.Principal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GestioRebel extends JPanelBg{
	private JComboBox<String> accio;
	private JComboBox<String> pickrebel;
	private JButton button;
	private JButton Boton;
	
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel; 
	
	
	private ConsultaRebel cr = new ConsultaRebel();
	private ModificaRebel mr = new ModificaRebel();
	private CreaNom cn = new CreaNom();
	
	public GestioRebel() {
		setImage("/images/bg.jpg");
		setLayout(new BorderLayout(0, 0));
		
		//Cargamos la vista de la consulta de rebeldes por defecto
		panel = new JPanel();
		panel.setLayout(card);
		panel.add(cr,"consulta");
		panel.add(cn,"crea");
		panel.add(mr,"modify");
		card.show(panel, "draw");
		
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);

		accio = new JComboBox<String>();
		horizontalBox_2.add(accio);
		accio.setMaximumSize(new Dimension(150, 20));
		accio.setMinimumSize(new Dimension(150, 20));
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);
		
		//preparem el contingut del primer combobox
		accio.addItem("Consultar rebeldes");
		accio.addItem("Modificar rebelde");
		accio.addItem("Crear rebelde");
		accio.addItem("Eliminar rebelde");
		

		
		
					
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_5);
		
			pickrebel = new JComboBox<String>();
			horizontalBox_3.add(pickrebel);
			pickrebel.setMinimumSize(new Dimension(120, 20));
			pickrebel.setMaximumSize(new Dimension(120, 20));
			
			pickrebel.addItem("Escoge rebelde");
			pickrebel.addItem("Rebelde 1");
			pickrebel.addItem("Rebelde 2");
			pickrebel.addItem("Rebelde 3");
			pickrebel.addItem("Rebelde 4");
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_6);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		horizontalBox.add(panel);
		
	
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		Boton = new JButton("Ok");
		Boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(Boton);
		Boton.setVisible(false);
		
		
		

					
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		

		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(0.5f);
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(20, 40));
		horizontalStrut_1.setMinimumSize(new Dimension(20, 40));
		horizontalStrut_1.setMaximumSize(new Dimension(20, 40));
		horizontalBox_1.add(horizontalStrut_1);

		
		
		//LOGICA DE LA VISTA 
		//Comportamiento JComboBox
		accio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
	                int val = accio.getSelectedIndex();
	                switch(val){
	                case 0:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(true);
	                	Boton.setVisible(false);
	                	card.show(panel,"consulta");
	                	break;
	                case 1:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(true);
	                	Boton.setVisible(false);
	                	card.show(panel, "modify");
	                	break;
	                case 2:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(false);
	                	Boton.setVisible(true);
	                	Boton.setText("Crea");
	                	card.show(panel, "crea");
	                	break;
	                case 3: 
	                	panel.setVisible(false);
	                	pickrebel.setVisible(true);
	                	Boton.setVisible(true);
	                	Boton.setText("Esborra");
	                default:	                	
	                	break;
	                }
                }
                revalidate();
            }
		});
		
		//Comportamiento del botón Acceder
		
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    		/*if (pickrebel.getSelectedIndex() == 0 && pickrebel.isVisible()){
		    			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione un rebelde");
		    		}
		    		else {
		    			System.out.println("do something");
		    		}*/
			}	
		});		
		
		//Comportamiento del botón Atrás
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
		JRootPane rootPane = SwingUtilities.getRootPane(Boton); 
		rootPane.setDefaultButton(Boton);
	}
}